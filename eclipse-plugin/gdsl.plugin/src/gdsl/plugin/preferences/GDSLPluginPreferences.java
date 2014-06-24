package gdsl.plugin.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

/**
 * Constant definitions for plug-in preferences
 */
public class GDSLPluginPreferences {
	public static final String P_COMPILER_CALL = "compilerCallPreference";
	public static final String P_COMPILER_PATH = "compilerPathPreference";
	public static final String P_COMPILE_ARGUMENTS = "compileArgumentsPreference";
	public static final String P_RUNTIME_FOLDER = "runtimeFolderPreference";
	public static final String P_COMPILE_FILES = "compileFilesPreference";
	
	public static String getCompilerCall() {
		return getPreferenceStore().get(P_COMPILER_CALL, "");
	}
	
	public static String getCompilerPath() {
		return getPreferenceStore().get(P_COMPILER_PATH, "");
	}
	
	public static String getCompileArguments() {
		return getPreferenceStore().get(P_COMPILE_ARGUMENTS, "");
	}
	
	public static String getRuntimeFolder() {
		return getPreferenceStore().get(P_RUNTIME_FOLDER, "");
	}
	
	public static String getCompileFiles() {
		return getPreferenceStore().get(P_COMPILE_FILES, "");
	}
	
	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode("gdsl.plugin");
	}
}
