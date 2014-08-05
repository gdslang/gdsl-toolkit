package gdsl.plugin.preferences.plugin;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class GdslCompilerPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	private StringFieldEditor compilerInvocation;
	private BooleanFieldEditor enableTypechecker;
	private IntegerFieldEditor typeCheckerIterations;
	
	public GdslCompilerPreferencePage() {
		super(org.eclipse.jface.preference.FieldEditorPreferencePage.FLAT);
		IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, GDSLPluginPreferences.PLUGIN_SCOPE);
		setPreferenceStore(store);
		setDescription("Settings for the external GDSL Compiler");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		compilerInvocation = new StringFieldEditor(GDSLPluginPreferences.P_COMPILER_INVOCATION, "Compiler Invocation", getFieldEditorParent());
		enableTypechecker = new BooleanFieldEditor(GDSLPluginPreferences.P_USE_TYPECHECKER, "Enable typechecker", getFieldEditorParent());
		typeCheckerIterations = new IntegerFieldEditor(GDSLPluginPreferences.P_ITERATION_TYPECHECKER, "Iterations in type checker", getFieldEditorParent());
		
		addField(compilerInvocation);
		addField(enableTypechecker);
		addField(typeCheckerIterations);
	}
	
	@Override
	protected void performDefaults(){
		IEclipsePreferences store = GDSLPluginPreferences.getPreferenceStore();
		store.put(GDSLPluginPreferences.P_COMPILER_INVOCATION, GDSLPluginPreferences.D_COMPILER_INVOCATION);
		store.putBoolean(GDSLPluginPreferences.P_USE_TYPECHECKER, GDSLPluginPreferences.D_USE_TYPECHECKER);
		store.putInt(GDSLPluginPreferences.P_ITERATION_TYPECHECKER, GDSLPluginPreferences.D_ITERATION_TYPECHEKCER);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}