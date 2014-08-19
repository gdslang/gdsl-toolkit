package gdsl.plugin.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import gdsl.plugin.gDSL.AndAlsoExp;
import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.AtomicExp;
import gdsl.plugin.gDSL.CONS;
import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.ClosedExp;
import gdsl.plugin.gDSL.ConDecl;
import gdsl.plugin.gDSL.DeclExport;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.Field;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Model;
import gdsl.plugin.gDSL.MonadicExp;
import gdsl.plugin.gDSL.OrElseExp;
import gdsl.plugin.gDSL.PAT;
import gdsl.plugin.gDSL.Ty;
import gdsl.plugin.gDSL.TyBind;
import gdsl.plugin.gDSL.TyElement;
import gdsl.plugin.gDSL.TyVars;
import gdsl.plugin.gDSL.Type;
import gdsl.plugin.gDSL.Val;
import gdsl.plugin.gDSL.ValueDecl;
import gdsl.plugin.services.GDSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class GDSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GDSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == GDSLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
				if(context == grammarAccess.getAndAlsoExpRule() ||
				   context == grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0() ||
				   context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule() ||
				   context == grammarAccess.getOrElseExpRule() ||
				   context == grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0() ||
				   context == grammarAccess.getRExpRule()) {
					sequence_AExp_ApplyExp_MExp_RExp_SelectExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAExpRule()) {
					sequence_AExp_ApplyExp_MExp_SelectExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getApplyExpRule()) {
					sequence_ApplyExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMExpRule()) {
					sequence_ApplyExp_MExp_SelectExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSelectExpRule()) {
					sequence_ApplyExp_SelectExp(context, (ApplyExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.ATOMIC_EXP:
				if(context == grammarAccess.getAndAlsoExpRule() ||
				   context == grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0() ||
				   context == grammarAccess.getCaseExpRule() ||
				   context == grammarAccess.getClosedExpRule() ||
				   context == grammarAccess.getOrElseExpRule() ||
				   context == grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0() ||
				   context == grammarAccess.getRExpRule()) {
					sequence_AExp_AtomicExp_MExp_RExp_SelectExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAExpRule()) {
					sequence_AExp_AtomicExp_MExp_SelectExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getApplyExpRule() ||
				   context == grammarAccess.getAtomicExpRule()) {
					sequence_AtomicExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMExpRule()) {
					sequence_AtomicExp_MExp_SelectExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSelectExpRule()) {
					sequence_AtomicExp_SelectExp(context, (AtomicExp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CONS:
				if(context == grammarAccess.getCONSRule()) {
					sequence_CONS(context, (CONS) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.CASE_EXP:
				if(context == grammarAccess.getCaseExpRule()) {
					sequence_CaseExp(context, (CaseExp) semanticObject); 
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
			case GDSLPackage.DECL_EXPORT:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclExportRule()) {
					sequence_DeclExport(context, (DeclExport) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.EXP:
				if(context == grammarAccess.getExpRule()) {
					sequence_Exp(context, (Exp) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.FIELD:
				if(context == grammarAccess.getFieldRule()) {
					sequence_Field(context, (Field) semanticObject); 
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
			case GDSLPackage.PAT:
				if(context == grammarAccess.getPATRule()) {
					sequence_PAT(context, (PAT) semanticObject); 
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
			case GDSLPackage.TY_VARS:
				if(context == grammarAccess.getTyVarsRule()) {
					sequence_TyVars(context, (TyVars) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.TYPE:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclTypeRule()) {
					sequence_DeclType(context, (Type) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTyVarRule()) {
					sequence_TyVar(context, (Type) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.VAL:
				if(context == grammarAccess.getDeclRule() ||
				   context == grammarAccess.getDeclValRule()) {
					sequence_DeclVal(context, (Val) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.VALUE_DECL:
				if(context == grammarAccess.getValueDeclRule()) {
					sequence_ValueDecl(context, (ValueDecl) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         atomicExp+=AtomicExp+ 
	 *         applyexps+=ApplyExp* 
	 *         ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)* 
	 *         ((sign+='+' | sign+='-') mexps+=MExp)* 
	 *         (sym+=SYM aexps+=AExp)*
	 *     )
	 */
	protected void sequence_AExp_ApplyExp_MExp_RExp_SelectExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (atomicExp+=AtomicExp+ applyexps+=ApplyExp* ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)* ((sign+='+' | sign+='-') mexps+=MExp)*)
	 */
	protected void sequence_AExp_ApplyExp_MExp_SelectExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((id+=ID | id+=S) exps+=Exp ((id+=ID | id+=S) exps+=Exp)*)? 
	 *         applyexps+=ApplyExp* 
	 *         ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)* 
	 *         ((sign+='+' | sign+='-') mexps+=MExp)* 
	 *         (sym+=SYM aexps+=AExp)*
	 *     )
	 */
	protected void sequence_AExp_AtomicExp_MExp_RExp_SelectExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((id+=ID | id+=S) exps+=Exp ((id+=ID | id+=S) exps+=Exp)*)? 
	 *         applyexps+=ApplyExp* 
	 *         ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)* 
	 *         ((sign+='+' | sign+='-') mexps+=MExp)*
	 *     )
	 */
	protected void sequence_AExp_AtomicExp_MExp_SelectExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AndAlsoExp_AndAlsoExp_1_0 name='and' right+=RExp)
	 */
	protected void sequence_AndAlsoExp(EObject context, AndAlsoExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     atomicExp+=AtomicExp+
	 */
	protected void sequence_ApplyExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (atomicExp+=AtomicExp+ applyexps+=ApplyExp* ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)*)
	 */
	protected void sequence_ApplyExp_MExp_SelectExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (atomicExp+=AtomicExp+ applyexps+=ApplyExp*)
	 */
	protected void sequence_ApplyExp_SelectExp(EObject context, ApplyExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((id+=ID | id+=S) exps+=Exp ((id+=ID | id+=S) exps+=Exp)*)?)
	 */
	protected void sequence_AtomicExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((id+=ID | id+=S) exps+=Exp ((id+=ID | id+=S) exps+=Exp)*)? applyexps+=ApplyExp* ((symbol+='*' | symbol+='%') applyexps+=ApplyExp)*)
	 */
	protected void sequence_AtomicExp_MExp_SelectExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((id+=ID | id+=S) exps+=Exp ((id+=ID | id+=S) exps+=Exp)*)? applyexps+=ApplyExp*)
	 */
	protected void sequence_AtomicExp_SelectExp(EObject context, AtomicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conName=ID | conName=S)
	 */
	protected void sequence_CONS(EObject context, CONS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='case' closedExp=ClosedExp pat+=PAT exp+=Exp (pat+=PAT exp+=Exp)*)
	 */
	protected void sequence_CaseExp(EObject context, CaseExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name='if' ifCaseExp=CaseExp thenCaseExp=CaseExp elseCaseExp=CaseExp) | (name='do' doExp+=MonadicExp doExp+=MonadicExp*))
	 */
	protected void sequence_ClosedExp(EObject context, ClosedExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CONS ty=Ty?)
	 */
	protected void sequence_ConDecl(EObject context, ConDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=[Val|ID] tyVars=TyVars? type=Ty)
	 */
	protected void sequence_DeclExport(EObject context, DeclExport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID | name=S) ((conDecl+=ConDecl conDecl+=ConDecl*) | value=Ty | (tyVars=TyVars conDecl+=ConDecl conDecl+=ConDecl*)))
	 */
	protected void sequence_DeclType(EObject context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((name=ID | name=S | name=SYM) (attr+=ID | attr+=S)* exp=Exp) | 
	 *         ((mid+=MID (attr+=ID | attr+=S))* exp=Exp) | 
	 *         ((name=ID | name=S) decPat+=DECODEPAT* (exp=Exp | (exps+=Exp exps+=Exp)+))
	 *     )
	 */
	protected void sequence_DeclVal(EObject context, Val semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CaseExp | (mid+=MID caseExps+=CaseExp)+)
	 */
	protected void sequence_Exp(EObject context, Exp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((name=ID | name=S) exp=Exp) | name=ID | name=S)
	 */
	protected void sequence_Field(EObject context, Field semanticObject) {
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
	 *     (exp=Exp | ((name=ID | name=S) exp=Exp))
	 */
	protected void sequence_MonadicExp(EObject context, MonadicExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=OrElseExp_OrElseExp_1_0 name='or' right+=AndAlsoExp)
	 */
	protected void sequence_OrElseExp(EObject context, OrElseExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (uscore=USCORE | int=INTEGER | ((id=ID | id=S) pat=PAT?) | bitpat=BITPAT)
	 */
	protected void sequence_PAT(EObject context, PAT semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID | name=S) value=Ty?)
	 */
	protected void sequence_TyBind(EObject context, TyBind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID | name=S) value=Ty)
	 */
	protected void sequence_TyElement(EObject context, TyElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID | name=S)
	 */
	protected void sequence_TyVar(EObject context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attr+=TyVar attr+=TyVar*)
	 */
	protected void sequence_TyVars(EObject context, TyVars semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((elements+=TyElement elements+=TyElement*)?)
	 */
	protected void sequence_Ty(EObject context, Ty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID | name=S | name=SYM) (ids+=ID | ids+=S)* exp=Exp)
	 */
	protected void sequence_ValueDecl(EObject context, ValueDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
