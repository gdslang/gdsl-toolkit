package gdsl.plugin.validation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * A class to work with the GDSL compiler
 * 
 * @author Daniel Endress
 * 
 */
public class GDSLCompilerTools {

	/**
	 * Compiles using the given command
	 * 
	 * @param command
	 *            The command running the compiler
	 * @param projectPath
	 *            The path to the current project
	 */
	public static void compileAndSetMarkers(final String command, final IPath projectPath) {
		final String[] compilerResult = compile(command);
		final GDSLError[] errors = parseErrors(compilerResult);
		Assert.isNotNull(errors);
		clearMarkers(projectPath);
		setMarkers(errors);
	}

	/**
	 * Compiles using the given command
	 * 
	 * @param command
	 *            The compile command
	 * @return All error lines the compiler returns
	 */
	private static String[] compile(final String command) {
		final List<String> output = new LinkedList<String>();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			final BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String line = "";
			while ((line = errorReader.readLine()) != null) {
				output.add(line);
			}
		} catch (final Exception e) {
			return null;
		}
		return output.toArray(new String[] {});
	}

	/**
	 * Parses the error lines of the compiler and creates GDSLErrors for each
	 * error
	 * 
	 * @param compilerResult
	 *            The error lines of the compiler
	 * @return A GDSLError instance for every error
	 */
	private static GDSLError[] parseErrors(final String[] compilerResult) {
		if (null == compilerResult) {
			return null;
		}
		final List<GDSLError> result = new LinkedList<GDSLError>();
		for (final String s : compilerResult) {
			if (s.matches("\\[.+:\\d+\\.\\d+(-\\d+(\\.\\d+)?)?\\] Error: .*\\n?")) {
				for (final String sPart : s.split(Pattern.quote("["))) {
					if (sPart.matches(".+:\\d+\\.\\d+(-\\d+(\\.\\d+)?)?\\] Error: .*\\n?")) {
						result.add(new GDSLError(sPart));
					}
				}
			}
		}
		return result.toArray(new GDSLError[] {});
	}

	/**
	 * Deletes all markers from every .ml file under the specified path
	 * 
	 * @param path
	 *            The path to delete markers from
	 */
	public static void clearMarkers(final IPath path) {
		final IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(path);
		try {
			for (final IResource r : container.members()) {
				if ("ml".equals(r.getFileExtension())) {
					r.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				}
				if (r.getType() == IResource.FOLDER) {
					clearMarkers(r.getLocation());
				}
			}
		} catch (final CoreException e) {
		}
	}

	/**
	 * Sets markers for the given GDSLErrors
	 * 
	 * @param errors
	 *            The GDSL errors
	 */
	private static void setMarkers(final GDSLError[] errors) {
		for (final GDSLError e : errors) {
			final IResource resource = e.resource;
			try {
				final IMarker marker = resource.createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.LINE_NUMBER, e.line);
				marker.setAttribute(IMarker.CHAR_START, e.charStart);
				marker.setAttribute(IMarker.CHAR_END, e.charEnd);
				marker.setAttribute(IMarker.MESSAGE, e.message);
			} catch (final CoreException e1) {
			}
		}
	}

	/**
	 * A helper class for handling errors returned by the GDSL compiler
	 * 
	 * @author Daniel Endress
	 * 
	 */
	private static class GDSLError {
		private final IResource resource;
		private final String message;
		private final int line;
		private final int charStart;
		private final int charEnd;

		/**
		 * Creates a new GDSLError object with the given compiler error message
		 * 
		 * @param errorMessage
		 *            The error message returned by the GDSL compiler
		 */
		public GDSLError(final String errorMessage) {
			String[] split = errorMessage.split(Pattern.quote("] Error: "));
			Assert.isTrue(2 == split.length); // [file:loc] , errormsg
			message = split[1].trim(); // message = errormsg

			split = split[0].split(Pattern.quote(":"));
			Assert.isTrue(2 == split.length); // split = file , loc
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			split[0] = new Path(split[0]).makeRelativeTo(root.getLocation()).toString();
			resource = root.findMember(split[0]); // resource = file

			Assert.isTrue(resource instanceof IFile);
			final int[] loc = parseLocation((IFile) resource, split[1]);
			Assert.isTrue(3 == loc.length);
			line = loc[0];
			charStart = loc[1];
			charEnd = loc[2];
		}

		/**
		 * Parse the information of a location given by the gdsl compiler
		 * 
		 * @param resource
		 *            The file the location refers to
		 * @param s
		 *            The string containing the location information to parse
		 * @return An integer array with three cells. The first one (index = 0)
		 *         contains the starting line, the other two (index = 1,2)
		 *         contain the start and end offset of the location
		 */
		private int[] parseLocation(final IFile resource, final String s) {
			try {
				final IDocumentProvider provider = new TextFileDocumentProvider();
				provider.connect(resource);
				final IDocument document = provider.getDocument(resource);

				final int[] result = new int[] { 0, 0, 0 };
				final String[] split = s.split(Pattern.quote("-"));
				Assert.isTrue(0 < split.length);
				final String[] startSplit = split[0].split(Pattern.quote("."));
				Assert.isTrue(2 == startSplit.length);

				result[0] = Integer.parseInt(startSplit[0]);

				int offset = document.getLineOffset(result[0] - 1);
				result[1] = offset + Integer.parseInt(startSplit[1]) - 1;

				if (1 == split.length) {
					result[2] = result[1] + 1;
				} else if (2 == split.length) {
					final String[] endSplit = split[1].split(Pattern.quote("."));
					if (1 == endSplit.length) {
						result[2] = offset + Integer.parseInt(endSplit[0]) - 1;
					} else if (2 == endSplit.length) {
						offset = document.getLineOffset(Integer.parseInt(endSplit[0]) - 1);
						result[2] = offset + Integer.parseInt(endSplit[1]) - 1;
					}
				}
				return result;
			} catch (final CoreException e) {
				return new int[] { 0, 0, 0 };
			} catch (final BadLocationException e) {
				return new int[] { 0, 0, 0 };
			}
		}
	}
}
