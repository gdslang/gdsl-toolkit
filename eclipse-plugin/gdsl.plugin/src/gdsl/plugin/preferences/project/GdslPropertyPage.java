package gdsl.plugin.preferences.project;

import gdsl.plugin.preferences.plugin.GDSLPluginPreferences;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

public class GdslPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage {
	
	private Text txtOutputName;
	private Button btnCheckPrefix;
	private Text txtPrefix;
	private Text txtRuntimePath;

	@Override
	protected Control createContents(Composite parent) {
		Composite pageComponent = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        pageComponent.setLayout(layout);
        GridData data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.horizontalAlignment = GridData.FILL;
        pageComponent.setLayoutData(data);
        
        createFields(pageComponent);

		return pageComponent;
	}
	
	protected void createFields(Composite parent){
		parent.setLayout(new GridLayout(3, false));
		
		Label lblOutputName = new Label(parent, SWT.NONE);
		lblOutputName.setText("Output-Name:");
		lblOutputName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		
		txtOutputName = new Text(parent, SWT.BORDER);
		txtOutputName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		
		btnCheckPrefix = new Button(parent, SWT.CHECK);
		btnCheckPrefix.setText("Prefix for emitted declarations:");
		btnCheckPrefix.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		btnCheckPrefix.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e){
				txtPrefix.setEnabled(btnCheckPrefix.getSelection());
			}
		});
		
		txtPrefix = new Text(parent, SWT.BORDER);
		txtPrefix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		txtPrefix.setEnabled(btnCheckPrefix.getSelection());
		
		Label lblRuntimePath = new Label(parent, SWT.NONE);
		lblRuntimePath.setText("Path to runtime templates:");
		lblRuntimePath.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		
		txtRuntimePath = new Text(parent, SWT.BORDER);
		txtRuntimePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button searchRuntimePath = new Button(parent, SWT.PUSH);
		searchRuntimePath.setText("...");
		searchRuntimePath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		searchRuntimePath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e){
				queryRuntimePath();
			}
		});

		IEclipsePreferences projectNode = getProjectNode();
		if(null != projectNode){
			txtOutputName.setText(projectNode.get(GDSLPluginPreferences.P_OUTPUT_NAME, GDSLPluginPreferences.D_OUTPUT_NAME));
			btnCheckPrefix.setSelection(projectNode.getBoolean(GDSLPluginPreferences.P_HAS_PREFIX, GDSLPluginPreferences.D_HAS_PREFIX));
			txtPrefix.setText(projectNode.get(GDSLPluginPreferences.P_PREFIX, GDSLPluginPreferences.D_PREFIX));
			txtRuntimePath.setText(projectNode.get(GDSLPluginPreferences.P_RUNTIME_TEMPLATES, GDSLPluginPreferences.D_RUNTIME_TEMPLATES));
		}
	
	}

	private void queryRuntimePath(){
		final DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN | SWT.SHEET);
		dialog.setText("Select the path to runtime templates");

		final String currentRuntimePath = txtRuntimePath.getText();
		if ((new File(currentRuntimePath)).exists()) {
			dialog.setFilterPath(currentRuntimePath);
		}

		final String path = dialog.open();
		txtRuntimePath.setText(path);

	}
	
	@Override
	protected void performApply(){
		IEclipsePreferences projectNode = getProjectNode();
		if (projectNode != null) {
			projectNode.put(GDSLPluginPreferences.P_OUTPUT_NAME, txtOutputName.getText());
			projectNode.putBoolean(GDSLPluginPreferences.P_HAS_PREFIX, btnCheckPrefix.getSelection());
			projectNode.put(GDSLPluginPreferences.P_PREFIX, txtPrefix.getText());
			projectNode.put(GDSLPluginPreferences.P_RUNTIME_TEMPLATES, txtRuntimePath.getText());
		}

		try {
			projectNode.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private IEclipsePreferences getProjectNode(){
		Object adapter = getElement().getAdapter(IProject.class);
		if(adapter instanceof IProject){
			IProject project = (IProject)adapter;
			IScopeContext projectScope = new ProjectScope(project);
			IEclipsePreferences projectNode = projectScope.getNode(GDSLPluginPreferences.PLUGIN_SCOPE);
			return projectNode;
		}
		return null;
	}
}
