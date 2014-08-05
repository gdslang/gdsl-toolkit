package gdsl.plugin.preferences;

import gdsl.plugin.preferences.plugin.GDSLPluginPreferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IEclipsePreferences store = GDSLPluginPreferences.getPreferenceStore();
		store.put(GDSLPluginPreferences.P_COMPILER_INVOCATION, GDSLPluginPreferences.D_COMPILER_INVOCATION);
		store.putBoolean(GDSLPluginPreferences.P_USE_TYPECHECKER, GDSLPluginPreferences.D_USE_TYPECHECKER);
		store.putInt(GDSLPluginPreferences.P_ITERATION_TYPECHECKER, GDSLPluginPreferences.D_ITERATION_TYPECHEKCER);
	}

//	public static IEclipsePreferences getPreferenceStore() {
//		return DefaultScope.INSTANCE.getNode("gdsl.plugin");
//	}
}
