package gdsl.plugin.ui.pref.preferences;

import gdsl.plugin.preferences.GDSLPluginPreferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringButtonFieldEditor;
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

public class GdslPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	private final String[] FILE_EXTENSIONS = {"*.ml", "*"};

	public GdslPreferencePage() {
		super(org.eclipse.jface.preference.FieldEditorPreferencePage.FLAT);
		IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, "gdsl.plugin");
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
		final FileFieldEditor compilerCall = new FileFieldEditor(GDSLPluginPreferences.P_COMPILER_CALL, "Compiler call", true, StringButtonFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		final FileFieldEditor compilerPath = new FileFieldEditor(GDSLPluginPreferences.P_COMPILER_PATH, "SML Load", true, StringButtonFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		final StringFieldEditor compileArguments = new StringFieldEditor(GDSLPluginPreferences.P_COMPILE_ARGUMENTS, "Arguments", getFieldEditorParent());
		final DirectoryFieldEditor runtimeEnvironment = new DirectoryFieldEditor(GDSLPluginPreferences.P_RUNTIME_FOLDER, "Codegen Folder", getFieldEditorParent());
		final FilePathEditor compileFiles = new FilePathEditor(GDSLPluginPreferences.P_COMPILE_FILES, "Files to compile", FILE_EXTENSIONS, getFieldEditorParent());
		
		addField(compilerCall);
		addField(compilerPath);
		addField(compileArguments);
		addField(runtimeEnvironment);
		addField(compileFiles);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}