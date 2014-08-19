package gdsl.plugin.serializer;

import com.google.inject.Inject;
import gdsl.plugin.services.GDSLGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class GDSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected GDSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model_SemicolonKeyword_1_0_q;
	protected AbstractElementAlias match_Ty_LeftParenthesisRightParenthesisKeyword_5_1_or___LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_3__;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GDSLGrammarAccess) access;
		match_Model_SemicolonKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getSemicolonKeyword_1_0());
		match_Ty_LeftParenthesisRightParenthesisKeyword_5_1_or___LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_3__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3())), new TokenAlias(false, false, grammarAccess.getTyAccess().getLeftParenthesisRightParenthesisKeyword_5_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getDOTRule())
			return getDOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getGREATERRule())
			return getGREATERToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLESSRule())
			return getLESSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSRule())
			return getSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal DOT:'.';
	 */
	protected String getDOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal GREATER: '>';
	 */
	protected String getGREATERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ">";
	}
	
	/**
	 * terminal LESS: '<';
	 */
	protected String getLESSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "<";
	}
	
	/**
	 * terminal S: 'S';
	 */
	protected String getSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "S";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Model_SemicolonKeyword_1_0_q.equals(syntax))
				emit_Model_SemicolonKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ty_LeftParenthesisRightParenthesisKeyword_5_1_or___LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_3__.equals(syntax))
				emit_Ty_LeftParenthesisRightParenthesisKeyword_5_1_or___LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Model_SemicolonKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}') | '()'
	 */
	protected void emit_Ty_LeftParenthesisRightParenthesisKeyword_5_1_or___LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
