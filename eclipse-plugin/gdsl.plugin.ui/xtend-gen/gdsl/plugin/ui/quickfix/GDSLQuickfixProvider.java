package gdsl.plugin.ui.quickfix;

import gdsl.plugin.validation.GDSLValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class GDSLQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(GDSLValidator.UPPERCASE_CONS)
  public void capitalizeCons(final Issue issue, final IssueResolutionAcceptor acceptor) {
    String[] _data = issue.getData();
    String _get = _data[0];
    String _plus = ("Capitalize first letter of \"" + _get);
    String _plus_1 = (_plus + "\".");
    final IModification _function = new IModification() {
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        Integer _offset = issue.getOffset();
        final String firstLetter = xtextDocument.get((_offset).intValue(), 1);
        Integer _offset_1 = issue.getOffset();
        String _upperCase = firstLetter.toUpperCase();
        xtextDocument.replace((_offset_1).intValue(), 1, _upperCase);
      }
    };
    acceptor.accept(issue, 
      "Capitalize constructor", _plus_1, 
      "", _function);
  }
  
  @Fix(GDSLValidator.PATTERN_MISPLACEMENT)
  public void patternMisplacement(final Issue issue, final IssueResolutionAcceptor acceptor) {
    String[] _data = issue.getData();
    String _get = _data[0];
    String _plus = ("Capitalize \"" + _get);
    String _plus_1 = (_plus + "\" to make it a constructor.");
    String[] _data_1 = issue.getData();
    String _get_1 = _data_1[0];
    String _plus_2 = ("Capitalize \"" + _get_1);
    String _plus_3 = (_plus_2 + "\" to make it a constructor.");
    final IModification _function = new IModification() {
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        String _get = xtextDocument.get();
        String[] _data = issue.getData();
        String _get_1 = _data[0];
        Integer _offset = issue.getOffset();
        final int consOffset = _get.lastIndexOf(_get_1, (_offset).intValue());
        final String firstLetter = xtextDocument.get(consOffset, 1);
        String _upperCase = firstLetter.toUpperCase();
        xtextDocument.replace(consOffset, 1, _upperCase);
      }
    };
    acceptor.accept(issue, _plus_1, _plus_3, 
      "", _function);
    String[] _data_2 = issue.getData();
    String _get_2 = _data_2[1];
    String _plus_4 = ("Remove pattern \"" + _get_2);
    String _plus_5 = (_plus_4 + "\".");
    String[] _data_3 = issue.getData();
    String _get_3 = _data_3[1];
    String _plus_6 = ("Remove pattern \"" + _get_3);
    String _plus_7 = (_plus_6 + "\".");
    final IModification _function_1 = new IModification() {
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        Integer _offset = issue.getOffset();
        Integer _length = issue.getLength();
        xtextDocument.replace((_offset).intValue(), (_length).intValue(), "");
      }
    };
    acceptor.accept(issue, _plus_5, _plus_7, 
      "", _function_1);
  }
}
