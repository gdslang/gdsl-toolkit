package gdsl.plugin.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
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
		IEclipsePreferences store = getPreferenceStore();
		store.put(GDSLPluginPreferences.P_COMPILER_CALL, "/usr/bin/sml");
		store.put(GDSLPluginPreferences.P_COMPILE_ARGUMENTS, "-o gdsl-x86-rreil");
	}

	public static IEclipsePreferences getPreferenceStore() {
		return DefaultScope.INSTANCE.getNode("gdsl.plugin");
	}
}
