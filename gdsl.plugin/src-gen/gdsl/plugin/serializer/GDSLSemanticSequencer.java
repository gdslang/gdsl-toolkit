package gdsl.plugin.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import gdsl.plugin.gDSL.DeclExport;
import gdsl.plugin.gDSL.DeclGranularity;
import gdsl.plugin.gDSL.DeclType;
import gdsl.plugin.gDSL.DeclVal;
import gdsl.plugin.gDSL.Export;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Model;
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
			case GDSLPackage.EXPORT:
				if(context == grammarAccess.getExportRule()) {
					sequence_Export(context, (Export) semanticObject); 
					return; 
				}
				else break;
			case GDSLPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
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
	 *     (name='granularity' granularity=Integer)
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
		feeder.accept(grammarAccess.getDeclGranularityAccess().getGranularityIntegerParserRuleCall_2_0(), semanticObject.getGranularity());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DeclType(EObject context, DeclType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GDSLPackage.Literals.DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GDSLPackage.Literals.DECL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attr+=ID*)
	 */
	protected void sequence_DeclVal(EObject context, DeclVal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Qid (attrName+=ID attrName+=ID*)?)
	 */
	protected void sequence_Export(EObject context, Export semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (decl+=Decl decl+=Decl*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
