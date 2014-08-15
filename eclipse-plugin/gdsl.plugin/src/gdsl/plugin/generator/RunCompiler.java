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

public class RunCompiler {

	public static void compileAndSetMarkers(String command, IPath projectPath){
		String[] compilerResult = compile(command);
		GDSLError[] errors = parseErrors(compilerResult);
		Assert.isNotNull(errors);
		clearMarkers(projectPath);
		setMarkers(errors);
	}

	private static String[] compile(String command){
		List<String> output = new LinkedList<String>();
		Process p;
		try{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String line = "";
			while((line = reader.readLine())!= null){
				output.add(line + "\n");
			}
		}catch(Exception e){
			return null;
		}
		return output.toArray(new String[]{});
	}
	
	private static GDSLError[] parseErrors(String[] compilerResult){
		if(null == compilerResult) return null;
		List<GDSLError> result = new LinkedList<GDSLError>();
		for(String s : compilerResult){
			if(s.matches("\\[.+:\\d+\\.\\d+\\] Error: .*\\n?")){
				result.add(new GDSLError(s));
			}
		}
		return result.toArray(new GDSLError[]{});
	}
	
	private static void clearMarkers(IPath path){
		IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(path);
		try{
			for(IResource r : container.members()){
				if("ml".equals(r.getFileExtension())){
					r.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				}
				if(r.getType() == IResource.FOLDER){
					clearMarkers(r.getLocation());
				}
			}
		}catch(CoreException e){
		}
	}
	
	private static void setMarkers(GDSLError[] errors){
		for(GDSLError e : errors){
			final IResource resource = e.resource;
			IMarker marker;
			try {
				marker = resource.createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.LINE_NUMBER, e.line);
				marker.setAttribute(IMarker.CHAR_START, e.charStart);
				marker.setAttribute(IMarker.CHAR_END, e.charEnd);
				marker.setAttribute(IMarker.MESSAGE, e.message);
			} catch (CoreException e1) {
			}
		}
	}
	
	private static class GDSLError{
		private final IResource resource;
		private final int line;
		private final int charStart;
		private final int charEnd;
		private final String message;
		
		public GDSLError(String errorMessage){
			String[] split = errorMessage.split(Pattern.quote(" Error: "));
			Assert.isTrue(2 == split.length);
			message = split[1];
			final String location = split[0].substring(split[0].indexOf("[")+1, split[0].lastIndexOf("]"));
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
