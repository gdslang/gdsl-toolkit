package gdsl.plugin.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

/**
 * Constant definitions for plug-in preferences
 */
public class GDSLPluginPreferences {
	public static final String P_COMPILER_PATH = "compilerPathPreference";
	
	public static String getCompilerPath() {
		return getPreferenceStore().get(P_COMPILER_PATH, "");
	}
	
	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode("gdsl.plugin");
	}
}
