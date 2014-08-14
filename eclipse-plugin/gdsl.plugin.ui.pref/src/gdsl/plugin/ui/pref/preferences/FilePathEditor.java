package gdsl.plugin.ui.pref.preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;

public class FilePathEditor extends ListEditor {

	private final String[] extensions;
	private String lastPath;

	public FilePathEditor(String name, String labelText, String[] extensions, Composite parent){
		init(name, labelText);
		this.extensions = extensions;
		createControl(parent);
	}
	
	@Override
	protected String createList(String[] items) {
        StringBuffer files = new StringBuffer("");//$NON-NLS-1$

        for(String item : items){
        	files.append(item);
        	files.append(File.pathSeparator);
        }
       return files.toString();
	}

	@Override
	protected String getNewInputObject() {
		
        FileDialog dialog = new FileDialog(getShell(), SWT.SHEET);
        if (lastPath != null) {
            if (new File(lastPath).exists()) {
				dialog.setFilterPath(lastPath);
			}
        }
        dialog.setFilterExtensions(extensions);
        String file = dialog.open();
        if (file != null) {
            file = file.trim();
            if (file.length() == 0) {
				return null;
			}
            lastPath = (new File(file)).getParent();
        }
        return file;
	}

	@Override
	protected String[] parseString(String stringList) {
        StringTokenizer st = new StringTokenizer(stringList, File.pathSeparator
                + "\n\r");//$NON-NLS-1$
        ArrayList<Object> v = new ArrayList<Object>();
        while (st.hasMoreElements()) {
            v.add(st.nextElement());
        }
        return (String[]) v.toArray(new String[v.size()]);
    }

}
