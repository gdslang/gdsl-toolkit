package gdsl.plugin.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

/**
 * Constant definitions for plug-in preferences
 */
public class GDSLPluginPreferences {
	public static final String PLUGIN_SCOPE = "gdsl.plugin";

	// Attributes of the preference page
	public static final String P_ENABLE_COMPILER = "enableCompiler";
	public static final String P_COMPILER_INVOCATION = "compilerInvocation";
	public static final String P_USE_TYPECHECKER = "useTypechecker";
	public static final String P_ITERATION_TYPECHECKER = "iterationTypechecker";

	// Default values for the preference page
	public static final boolean D_ENABLE_COMPILER = false;
	public static final String D_COMPILER_INVOCATION = "./build/gdslc";
	public static final boolean D_USE_TYPECHECKER = true;
	public static final int D_ITERATION_TYPECHEKCER = 8;

	public static boolean getCompilerEnablement() {
		return getPreferenceStore().getBoolean(P_ENABLE_COMPILER, D_ENABLE_COMPILER);
	}

	public static String getCompilerInvocation() {
		return getPreferenceStore().get(P_COMPILER_INVOCATION, D_COMPILER_INVOCATION);
	}

	public static boolean isTypeCheckerEnabled() {
		return getPreferenceStore().getBoolean(P_USE_TYPECHECKER, D_USE_TYPECHECKER);
	}

	public static int getTypeCheckerIteration() {
		return getPreferenceStore().getInt(P_ITERATION_TYPECHECKER, D_ITERATION_TYPECHEKCER);
	}

	/**
	 * Get the preference store for the current eclipse instance
	 * 
	 * @return The preference store for the current eclipse instance
	 */
	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(PLUGIN_SCOPE);
	}

}
