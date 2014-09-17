package gdsl.plugin.ui.quickfix

import gdsl.plugin.validation.GDSLValidator
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 * 
 * @author Daniel Endress
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class GDSLQuickfixProvider extends DefaultQuickfixProvider {

	/**
	 * Capitalize a constructor
	 */
	@Fix(GDSLValidator::UPPERCASE_CONS)
	def capitalizeCons(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue,
			'Capitalize constructor',
			'Capitalize first letter of "' + issue.data.get(0) + '".',
			'',
			[ context |
				val xtextDocument = context.xtextDocument
				val firstLetter = xtextDocument.get(issue.offset, 1)
				xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
			])
	}
	
	/**
	 * Capitalize a constructor or remove the pattern
	 */
	@Fix(GDSLValidator::PATTERN_MISPLACEMENT)
	def patternMisplacement(Issue issue, IssueResolutionAcceptor acceptor){
		acceptor.accept(issue,
			'Capitalize "' + issue.data.get(0) + '" to make it a constructor.',
			'Capitalize "' + issue.data.get(0) + '" to make it a constructor.',
			'',
			[context |
				val xtextDocument = context.xtextDocument
				val consOffset = xtextDocument.get.lastIndexOf(issue.data.get(0), issue.offset)
				val firstLetter = xtextDocument.get(consOffset, 1)
				xtextDocument.replace(consOffset, 1, firstLetter.toUpperCase)
			]
		)
		acceptor.accept(issue,
			'Remove pattern "' + issue.data.get(1) + '".',
			'Remove pattern "' + issue.data.get(1) + '".',
			'',
			[context |
				val xtextDocument = context.xtextDocument
				xtextDocument.replace(issue.offset, issue.length, '')
			]
		)
	}
	
}
