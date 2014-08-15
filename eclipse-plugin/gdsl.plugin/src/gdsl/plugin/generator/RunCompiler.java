package gdsl.plugin.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * A class to work with the GDSL compiler
 * 
 * @author Daniel Endress
 * 
 */
public class RunCompiler {

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
			final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.add(line + "\n");
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
			if (s.matches("\\[.+:\\d+\\.\\d+\\] Error: .*\\n?")) {
				result.add(new GDSLError(s));
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
	private static void clearMarkers(final IPath path) {
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
			IMarker marker;
			try {
				marker = resource.createMarker(IMarker.PROBLEM);
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
		private final int line;
		private final int charStart;
		private final int charEnd;
		private final String message;

		/**
		 * Creates a new GDSLError object with the given compiler error message
		 * 
		 * @param errorMessage
		 *            The error message returned by the GDSL compiler
		 */
		public GDSLError(final String errorMessage) {
			String[] split = errorMessage.split(Pattern.quote(" Error: "));
			Assert.isTrue(2 == split.length);
			message = split[1];
			final String location = split[0].substring(split[0].indexOf("[") + 1, split[0].lastIndexOf("]"));
			split = location.split(Pattern.quote(":"));
			Assert.isTrue(2 == split.length);
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			split[0] = new Path(split[0]).makeRelativeTo(root.getLocation()).toString();
			resource = root.findMember(split[0]);
			split = split[1].split(Pattern.quote("."));
			Assert.isTrue(2 == split.length);
			line = Integer.parseInt(split[0]);
			final int character = Integer.parseInt(split[1]) - 1;
			charStart = character;
			charEnd = character + 1;
		}
	}
}
