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
	protected AbstractElementAlias match_AtomicExp___ConUseParserRuleCall_3_1_or_LitParserRuleCall_0_1_or_StringParserRuleCall_1_1___or___DollarSignKeyword_5_1_QidParserRuleCall_5_2___or___LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__;
	protected AbstractElementAlias match_Model_SemicolonKeyword_1_0_q;
	protected AbstractElementAlias match_ValueDecl_NameParserRuleCall_2_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GDSLGrammarAccess) access;
		match_AtomicExp___ConUseParserRuleCall_3_1_or_LitParserRuleCall_0_1_or_StringParserRuleCall_1_1___or___DollarSignKeyword_5_1_QidParserRuleCall_5_2___or___LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__ = new AlternativeAlias(false, false, new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getConUseParserRuleCall_3_1()), new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getLitParserRuleCall_0_1()), new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getStringParserRuleCall_1_1())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getQidParserRuleCall_5_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_7_3())));
		match_Model_SemicolonKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getSemicolonKeyword_1_0());
		match_ValueDecl_NameParserRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getValueDeclAccess().getNameParserRuleCall_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getConUseRule())
			return getConUseToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDOTRule())
			return getDOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLitRule())
			return getLitToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNameRule())
			return getNameToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPIPERule())
			return getPIPEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getQidRule())
			return getQidToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getStringRule())
			return getStringToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ConUse: CONS;
	 */
	protected String getConUseToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal DOT: '.';
	 */
	protected String getDOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * Lit: Int | "'" BITSTR? "'";
	 */
	protected String getLitToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "0";
	}
	
	/**
	 * Name: ID;
	 */
	protected String getNameToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal PIPE: '|';
	 */
	protected String getPIPEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * Qid: ID;
	 */
	protected String getQidToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * String:
	 * 	'"' STRCHAR* '"'
	 * ;
	 */
	protected String getStringToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AtomicExp___ConUseParserRuleCall_3_1_or_LitParserRuleCall_0_1_or_StringParserRuleCall_1_1___or___DollarSignKeyword_5_1_QidParserRuleCall_5_2___or___LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__.equals(syntax))
				emit_AtomicExp___ConUseParserRuleCall_3_1_or_LitParserRuleCall_0_1_or_StringParserRuleCall_1_1___or___DollarSignKeyword_5_1_QidParserRuleCall_5_2___or___LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Model_SemicolonKeyword_1_0_q.equals(syntax))
				emit_Model_SemicolonKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ValueDecl_NameParserRuleCall_2_a.equals(syntax))
				emit_ValueDecl_NameParserRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     (String | ConUse | Lit) | ('$' Qid) | ('{' '}')
	 */
	protected void emit_AtomicExp___ConUseParserRuleCall_3_1_or_LitParserRuleCall_0_1_or_StringParserRuleCall_1_1___or___DollarSignKeyword_5_1_QidParserRuleCall_5_2___or___LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
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
	 *     Name*
	 */
	protected void emit_ValueDecl_NameParserRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
