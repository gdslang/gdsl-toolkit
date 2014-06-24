package gdsl.plugin.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import gdsl.plugin.gDSL.AExp;
import gdsl.plugin.gDSL.AndAlsoExp;
import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.AtomicExp;
import gdsl.plugin.gDSL.BitPat;
import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.Cases;
import gdsl.plugin.gDSL.ClosedExp;
import gdsl.plugin.gDSL.ConDecl;
import gdsl.plugin.gDSL.ConDecls;
import gdsl.plugin.gDSL.DeclExport;
import gdsl.plugin.gDSL.DeclGranularity;
import gdsl.plugin.gDSL.DeclType;
import gdsl.plugin.gDSL.DeclVal;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.Export;
import gdsl.plugin.gDSL.Field;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.MExp;
import gdsl.plugin.gDSL.Model;
import gdsl.plugin.gDSL.MonadicExp;
import gdsl.plugin.gDSL.OrElseExp;
import gdsl.plugin.gDSL.RExp;
import gdsl.plugin.gDSL.TokPat;
import gdsl.plugin.gDSL.Ty;
import gdsl.plugin.gDSL.TyBind;
import gdsl.plugin.gDSL.TyElement;
import gdsl.plugin.services.GDSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class GDSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GDSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == GDSLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case GDSLPackage.AEXP:
				if(context == grammarAccess.getAExpRule()) {
					sequence_AExp(context, (AExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.AND_ALSO_EXP:
				if(context == grammarAccess.getAndAlsoExpRule() ||
				   context == grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0() ||
				   context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule() ||
				   context == grammarAccess.getOrElseExpRule() ||
				   context == grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0()) {
					sequence_AndAlsoExp(context, (AndAlsoExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.APPLY_EXP:
				if(context == grammarAccess.getApplyExpRule()) {
					sequence_ApplyExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.ATOMIC_EXP:
				if(context == grammarAccess.getAtomicExpRule()) {
					sequence_AtomicExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.BIT_PAT:
				if(context == grammarAccess.getBitPatRule() ||
				   context == grammarAccess.getDecodePatRule()) {
					sequence_BitPat(context, (BitPat) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CASE_EXP:
				if(context == grammarAccess.getCaseExpRule()) {
					sequence_CaseExp(context, (CaseExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CASES:
				if(context == grammarAccess.getCasesRule()) {
					sequence_Cases(context, (Cases) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CLOSED_EXP:
				if(context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule()) {
					sequence_ClosedExp(context, (ClosedExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CON_DECL:
				if(context == grammarAccess.getConDeclRule()) {
					sequence_ConDecl(context, (ConDecl) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CON_DECLS:
				if(context == grammarAccess.getConDeclsRule()) {
					sequence_ConDecls(context, (ConDecls) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.DECL_EXPORT:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclExportRule()) {
					sequence_DeclExport(context, (DeclExport) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.DECL_GRANULARITY:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclGranularityRule()) {
					sequence_DeclGranularity(context, (DeclGranularity) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.DECL_TYPE:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclTypeRule()) {
					sequence_DeclType(context, (DeclType) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.DECL_VAL:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclValRule()) {
					sequence_DeclVal(context, (DeclVal) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.EXP:
				if(context == grammarAccess.getExpRule() ||
				   context == grammarAccess.getValueDeclRule()) {
					sequence_Exp(context, (Exp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.EXPORT:
				if(context == grammarAccess.getExportRule()) {
					sequence_Export(context, (Export) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.FIELD:
				if(context == grammarAccess.getFieldRule()) {
					sequence_Field(context, (Field) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.MEXP:
				if(context == grammarAccess.getMExpRule()) {
					sequence_MExp(context, (MExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.MONADIC_EXP:
				if(context == grammarAccess.getMonadicExpRule()) {
					sequence_MonadicExp(context, (MonadicExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.OR_ELSE_EXP:
				if(context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule() ||
				   context == grammarAccess.getOrElseExpRule() ||
				   context == grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0()) {
					sequence_OrElseExp(context, (OrElseExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.REXP:
				if(context == grammarAccess.getAndAlsoExpRule() ||
				   context == grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0() ||
				   context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule() ||
				   context == grammarAccess.getOrElseExpRule() ||
				   context == grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0() ||
				   context == grammarAccess.getRExpRule()) {
					sequence_RExp(context, (RExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.TOK_PAT:
				if(context == grammarAccess.getDecodePatRule() ||
				   context == grammarAccess.getTokPatRule()) {
					sequence_TokPat(context, (TokPat) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.TY:
				if(context == grammarAccess.getTyRule()) {
					sequence_Ty(context, (Ty) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.TY_BIND:
				if(context == grammarAccess.getTyBindRule()) {
					sequence_TyBind(context, (TyBind) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.TY_ELEMENT:
				if(context == grammarAccess.getTyElementRule()) {
					sequence_TyElement(context, (TyElement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (mexp=MExp ((sign+='+' | sign+='-') mexps+=MExp)*)
	 */
	protected void sequence_AExp(EObject context, AExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AndAlsoExp_AndAlsoExp_1_0 right+=RExp)
	 */
	protected void sequence_AndAlsoExp(EObject context, AndAlsoExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (neg?='~'? exp=AtomicExp)
	 */
	protected void sequence_ApplyExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((id+=Name exps+=Exp (id+=Name exps+=Exp)*)?)
	 */
	protected void sequence_AtomicExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bitpat+=PrimBitPat bitpat+=PrimBitPat*)
	 */
	protected void sequence_BitPat(EObject context, BitPat semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (closedExp=ClosedExp cases=Cases)
	 */
	protected void sequence_CaseExp(EObject context, CaseExp semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.CASE_EXP__CLOSED_EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.CASE_EXP__CLOSED_EXP));
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.CASE_EXP__CASES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.CASE_EXP__CASES));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0(), semanticObject.getClosedExp());
		feeder.accept(grammarAccess.getCaseExpAccess().getCasesCasesParserRuleCall_1_3_0(), semanticObject.getCases());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (pat+=Pat exp+=Exp (pat+=Pat exp+=Exp)*)
	 */
	protected void sequence_Cases(EObject context, Cases semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ifCaseExp=CaseExp thenCaseExp=CaseExp elseCaseExp=CaseExp) | (doExp+=MonadicExp doExp+=MonadicExp*))
	 */
	protected void sequence_ClosedExp(EObject context, ClosedExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ConBind ty=Ty?)
	 */
	protected void sequence_ConDecl(EObject context, ConDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conDecls+=ConDecl conDecls+=ConDecl*)
	 */
	protected void sequence_ConDecls(EObject context, ConDecls semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='export' exports+=Export*)
	 */
	protected void sequence_DeclExport(EObject context, DeclExport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='granularity' granularity=Int)
	 */
	protected void sequence_DeclGranularity(EObject context, DeclGranularity semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.DECL__NAME));
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.DECL_GRANULARITY__GRANULARITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.DECL_GRANULARITY__GRANULARITY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0(), semanticObject.getGranularity());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name (value=ConDecls | value=Ty | (attrName+=Name attrName+=Name* value=ConDecls)))
	 */
	protected void sequence_DeclType(EObject context, DeclType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((name=Name | name=SYM) attr+=Name* exp=Exp) | 
	 *         ((mid+=MIXID attr+=Name)* exp=Exp) | 
	 *         (name=Name (decPat+=DecodePat decPat+=DecodePat*)? (exp=Exp | (exps+=Exp exps+=Exp)+))
	 *     )
	 */
	protected void sequence_DeclVal(EObject context, DeclVal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (caseExp=CaseExp | (mid=MIXID caseExp=CaseExp))
	 */
	protected void sequence_Exp(EObject context, Exp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Qid (attrName+=Name attrName+=Name*)?)
	 */
	protected void sequence_Export(EObject context, Export semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=Name exp=Exp) | name=Name)
	 */
	protected void sequence_Field(EObject context, Field semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (applyexps+=ApplyExp applyexps+=ApplyExp*)
	 */
	protected void sequence_MExp(EObject context, MExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (decl+=Decl decl+=Decl*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp=Exp | (name=Name exp=Exp))
	 */
	protected void sequence_MonadicExp(EObject context, MonadicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=OrElseExp_OrElseExp_1_0 right+=AndAlsoExp)
	 */
	protected void sequence_OrElseExp(EObject context, OrElseExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (aexp=AExp (sym+=SYM aexps+=AExp)*)
	 */
	protected void sequence_RExp(EObject context, RExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tokPat=Int | tokPat=Qid)
	 */
	protected void sequence_TokPat(EObject context, TokPat semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (key=Qid value=Ty?)
	 */
	protected void sequence_TyBind(EObject context, TyBind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name value=Ty)
	 */
	protected void sequence_TyElement(EObject context, TyElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.TY_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.TY_ELEMENT__NAME));
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.TY_ELEMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.TY_ELEMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=Int | value=Int | (value=Qid (tyBind+=TyBind tyBind+=TyBind*)?) | (elements+=TyElement elements+=TyElement*))
	 */
	protected void sequence_Ty(EObject context, Ty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
