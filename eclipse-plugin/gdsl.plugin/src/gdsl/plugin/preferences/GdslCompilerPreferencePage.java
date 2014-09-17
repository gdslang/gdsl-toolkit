package gdsl.plugin.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

/**
 * A preference page for global compiler settings
 * 
 * @author Daniel Endress
 * 
 */
public class GdslCompilerPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button btnEnableCompilerValidation;
	private Label lblCompilerInvocation;
	private Text txtCompilerInvocation;
	private Group grpTypeChecker;
	private Button btnEnableTypechecker;
	private Label lblIterations;
	private Spinner spinnerIterations;

	public void init(final IWorkbench workbench) {
	}

	@Override
	protected Control createContents(final Composite parent) {
		final Composite pageComponent = new Composite(parent, SWT.NULL);
		final GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		pageComponent.setLayout(layout);
		final GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		pageComponent.setLayoutData(data);

		createFields(pageComponent);

		return pageComponent;
	}

	/**
	 * Create all the graphical elements
	 * 
	 * @param parent
	 *            The parent composite
	 */
	private void createFields(final Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		btnEnableCompilerValidation = new Button(parent, SWT.CHECK);
		btnEnableCompilerValidation.setText("Enable gdsl compiler validation");
		btnEnableCompilerValidation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		btnEnableCompilerValidation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				setEnablements();
			}
		});

		lblCompilerInvocation = new Label(parent, SWT.NONE);
		lblCompilerInvocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblCompilerInvocation.setText("Compiler Invocation");

		txtCompilerInvocation = new Text(parent, SWT.BORDER);
		txtCompilerInvocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		grpTypeChecker = new Group(parent, SWT.NONE);
		grpTypeChecker.setText("Typechecker");
		grpTypeChecker.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpTypeChecker.setLayout(new GridLayout(2, false));

		btnEnableTypechecker = new Button(grpTypeChecker, SWT.CHECK);
		btnEnableTypechecker.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnEnableTypechecker.setText("Enable typechecker");
		btnEnableTypechecker.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				setEnablements();
			}
		});

		lblIterations = new Label(grpTypeChecker, SWT.NONE);
		lblIterations.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblIterations.setText("Iterations in type checker");

		spinnerIterations = new Spinner(grpTypeChecker, SWT.NONE);
		final GridData spinnerGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		spinnerGridData.minimumWidth = 64;
		spinnerIterations.setLayoutData(spinnerGridData);
		spinnerIterations.setMinimum(2);
		spinnerIterations.setMaximum(2147483647);
		spinnerIterations.setIncrement(1);

		initializeElements();
	}

	/**
	 * Initialize all settings
	 */
	private void initializeElements() {
		final IEclipsePreferences store = GDSLPluginPreferences.getPreferenceStore();
		if (null != store) {
			btnEnableCompilerValidation.setSelection(store.getBoolean(GDSLPluginPreferences.P_ENABLE_COMPILER,
					GDSLPluginPreferences.D_ENABLE_COMPILER));
			txtCompilerInvocation.setText(store.get(GDSLPluginPreferences.P_COMPILER_INVOCATION,
					GDSLPluginPreferences.D_COMPILER_INVOCATION));
			btnEnableTypechecker.setSelection(store.getBoolean(GDSLPluginPreferences.P_USE_TYPECHECKER,
					GDSLPluginPreferences.D_USE_TYPECHECKER));
			spinnerIterations.setSelection(store.getInt(GDSLPluginPreferences.P_ITERATION_TYPECHECKER,
					GDSLPluginPreferences.D_ITERATION_TYPECHEKCER));
		}
		setEnablements();
	}

	@Override
	protected void performApply() {
		final IEclipsePreferences store = GDSLPluginPreferences.getPreferenceStore();
		if (store != null) {
			store.putBoolean(GDSLPluginPreferences.P_ENABLE_COMPILER, btnEnableCompilerValidation.getSelection());
			store.put(GDSLPluginPreferences.P_COMPILER_INVOCATION, txtCompilerInvocation.getText());
			store.putBoolean(GDSLPluginPreferences.P_USE_TYPECHECKER, btnEnableTypechecker.getSelection());
			store.putInt(GDSLPluginPreferences.P_ITERATION_TYPECHECKER, spinnerIterations.getSelection());
		}

		try {
			store.flush();
		} catch (final BackingStoreException e) {
		}
	}

	@Override
	protected void performDefaults() {
		btnEnableCompilerValidation.setSelection(GDSLPluginPreferences.D_ENABLE_COMPILER);
		txtCompilerInvocation.setText(GDSLPluginPreferences.D_COMPILER_INVOCATION);
		btnEnableTypechecker.setSelection(GDSLPluginPreferences.D_USE_TYPECHECKER);
		spinnerIterations.setSelection(GDSLPluginPreferences.D_ITERATION_TYPECHEKCER);
		setEnablements();
	}

	/**
	 * Set the enablement status according to current settings
	 */
	private void setEnablements() {
		final boolean enabled = btnEnableCompilerValidation.getSelection();
		final boolean enableTypeChecker = btnEnableTypechecker.getSelection();
		lblCompilerInvocation.setEnabled(enabled);
		txtCompilerInvocation.setEnabled(enabled);
		grpTypeChecker.setEnabled(enabled);
		btnEnableTypechecker.setEnabled(enabled);
		lblIterations.setEnabled(enabled && enableTypeChecker);
		spinnerIterations.setEnabled(enabled && enableTypeChecker);

	}

}
