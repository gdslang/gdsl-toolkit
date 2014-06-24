/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gdsl.plugin.gDSL.GDSLFactory
 * @model kind="package"
 * @generated
 */
public interface GDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.plugin.gdsl/GDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GDSLPackage eINSTANCE = gdsl.plugin.gDSL.impl.GDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ModelImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DECL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclImpl <em>Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDecl()
   * @generated
   */
  int DECL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__NAME = 0;

  /**
   * The number of structural features of the '<em>Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclGranularityImpl <em>Decl Granularity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclGranularityImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclGranularity()
   * @generated
   */
  int DECL_GRANULARITY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_GRANULARITY__NAME = DECL__NAME;

  /**
   * The feature id for the '<em><b>Granularity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_GRANULARITY__GRANULARITY = DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decl Granularity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_GRANULARITY_FEATURE_COUNT = DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclExportImpl <em>Decl Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclExportImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclExport()
   * @generated
   */
  int DECL_EXPORT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT__NAME = DECL__NAME;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT__EXPORTS = DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decl Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT_FEATURE_COUNT = DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclTypeImpl <em>Decl Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclTypeImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclType()
   * @generated
   */
  int DECL_TYPE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_TYPE__NAME = DECL__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_TYPE__VALUE = DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attr Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_TYPE__ATTR_NAME = DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Decl Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_TYPE_FEATURE_COUNT = DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclValImpl <em>Decl Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclValImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclVal()
   * @generated
   */
  int DECL_VAL = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__NAME = DECL__NAME;

  /**
   * The feature id for the '<em><b>Attr</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__ATTR = DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__EXP = DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mid</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__MID = DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Dec Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__DEC_PAT = DECL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__EXPS = DECL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Decl Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL_FEATURE_COUNT = DECL_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ExportImpl <em>Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ExportImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExport()
   * @generated
   */
  int EXPORT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT__NAME = 0;

  /**
   * The feature id for the '<em><b>Attr Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT__ATTR_NAME = 1;

  /**
   * The number of structural features of the '<em>Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ConDeclsImpl <em>Con Decls</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ConDeclsImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getConDecls()
   * @generated
   */
  int CON_DECLS = 7;

  /**
   * The feature id for the '<em><b>Con Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CON_DECLS__CON_DECLS = 0;

  /**
   * The number of structural features of the '<em>Con Decls</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CON_DECLS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ConDeclImpl <em>Con Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ConDeclImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getConDecl()
   * @generated
   */
  int CON_DECL = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CON_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Ty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CON_DECL__TY = 1;

  /**
   * The number of structural features of the '<em>Con Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CON_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyImpl <em>Ty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTy()
   * @generated
   */
  int TY = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__VALUE = 0;

  /**
   * The feature id for the '<em><b>Ty Bind</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__TY_BIND = 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Ty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyElementImpl <em>Ty Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyElementImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyElement()
   * @generated
   */
  int TY_ELEMENT = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_ELEMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Ty Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyBindImpl <em>Ty Bind</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyBindImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyBind()
   * @generated
   */
  int TY_BIND = 11;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_BIND__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_BIND__VALUE = 1;

  /**
   * The number of structural features of the '<em>Ty Bind</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_BIND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DecodePatImpl <em>Decode Pat</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DecodePatImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDecodePat()
   * @generated
   */
  int DECODE_PAT = 12;

  /**
   * The number of structural features of the '<em>Decode Pat</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECODE_PAT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.BitPatImpl <em>Bit Pat</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.BitPatImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getBitPat()
   * @generated
   */
  int BIT_PAT = 13;

  /**
   * The feature id for the '<em><b>Bitpat</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_PAT__BITPAT = DECODE_PAT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bit Pat</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_PAT_FEATURE_COUNT = DECODE_PAT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TokPatImpl <em>Tok Pat</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TokPatImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTokPat()
   * @generated
   */
  int TOK_PAT = 14;

  /**
   * The feature id for the '<em><b>Tok Pat</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOK_PAT__TOK_PAT = DECODE_PAT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tok Pat</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOK_PAT_FEATURE_COUNT = DECODE_PAT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ValueDeclImpl <em>Value Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ValueDeclImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getValueDecl()
   * @generated
   */
  int VALUE_DECL = 28;

  /**
   * The number of structural features of the '<em>Value Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DECL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ExpImpl <em>Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExp()
   * @generated
   */
  int EXP = 15;

  /**
   * The feature id for the '<em><b>Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP__CASE_EXP = VALUE_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP__MID = VALUE_DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP_FEATURE_COUNT = VALUE_DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.CaseExpImpl <em>Case Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.CaseExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCaseExp()
   * @generated
   */
  int CASE_EXP = 16;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__CLOSED_EXP = 0;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__CASES = 1;

  /**
   * The number of structural features of the '<em>Case Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ClosedExpImpl <em>Closed Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ClosedExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getClosedExp()
   * @generated
   */
  int CLOSED_EXP = 17;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__CLOSED_EXP = CASE_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__CASES = CASE_EXP__CASES;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__IF_CASE_EXP = CASE_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__THEN_CASE_EXP = CASE_EXP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__ELSE_CASE_EXP = CASE_EXP_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__DO_EXP = CASE_EXP_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Closed Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP_FEATURE_COUNT = CASE_EXP_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.MonadicExpImpl <em>Monadic Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.MonadicExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getMonadicExp()
   * @generated
   */
  int MONADIC_EXP = 18;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONADIC_EXP__EXP = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONADIC_EXP__NAME = 1;

  /**
   * The number of structural features of the '<em>Monadic Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONADIC_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.CasesImpl <em>Cases</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.CasesImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCases()
   * @generated
   */
  int CASES = 19;

  /**
   * The feature id for the '<em><b>Pat</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASES__PAT = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASES__EXP = 1;

  /**
   * The number of structural features of the '<em>Cases</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.OrElseExpImpl <em>Or Else Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.OrElseExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getOrElseExp()
   * @generated
   */
  int OR_ELSE_EXP = 20;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__CLOSED_EXP = CLOSED_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__CASES = CLOSED_EXP__CASES;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__IF_CASE_EXP = CLOSED_EXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__THEN_CASE_EXP = CLOSED_EXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__ELSE_CASE_EXP = CLOSED_EXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__DO_EXP = CLOSED_EXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__LEFT = CLOSED_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__RIGHT = CLOSED_EXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Else Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP_FEATURE_COUNT = CLOSED_EXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.AndAlsoExpImpl <em>And Also Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.AndAlsoExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAndAlsoExp()
   * @generated
   */
  int AND_ALSO_EXP = 21;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__CLOSED_EXP = OR_ELSE_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__CASES = OR_ELSE_EXP__CASES;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__IF_CASE_EXP = OR_ELSE_EXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__THEN_CASE_EXP = OR_ELSE_EXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__ELSE_CASE_EXP = OR_ELSE_EXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__DO_EXP = OR_ELSE_EXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__LEFT = OR_ELSE_EXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__RIGHT = OR_ELSE_EXP__RIGHT;

  /**
   * The number of structural features of the '<em>And Also Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP_FEATURE_COUNT = OR_ELSE_EXP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.RExpImpl <em>RExp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.RExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getRExp()
   * @generated
   */
  int REXP = 22;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__CLOSED_EXP = AND_ALSO_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__CASES = AND_ALSO_EXP__CASES;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__IF_CASE_EXP = AND_ALSO_EXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__THEN_CASE_EXP = AND_ALSO_EXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__ELSE_CASE_EXP = AND_ALSO_EXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__DO_EXP = AND_ALSO_EXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__LEFT = AND_ALSO_EXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__RIGHT = AND_ALSO_EXP__RIGHT;

  /**
   * The feature id for the '<em><b>Aexp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__AEXP = AND_ALSO_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__SYM = AND_ALSO_EXP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__AEXPS = AND_ALSO_EXP_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>RExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP_FEATURE_COUNT = AND_ALSO_EXP_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.AExpImpl <em>AExp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.AExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAExp()
   * @generated
   */
  int AEXP = 23;

  /**
   * The feature id for the '<em><b>Mexp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__MEXP = 0;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__SIGN = 1;

  /**
   * The feature id for the '<em><b>Mexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__MEXPS = 2;

  /**
   * The number of structural features of the '<em>AExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.MExpImpl <em>MExp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.MExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getMExp()
   * @generated
   */
  int MEXP = 24;

  /**
   * The feature id for the '<em><b>Applyexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__APPLYEXPS = 0;

  /**
   * The number of structural features of the '<em>MExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ApplyExpImpl <em>Apply Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ApplyExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getApplyExp()
   * @generated
   */
  int APPLY_EXP = 25;

  /**
   * The feature id for the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__NEG = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__EXP = 1;

  /**
   * The number of structural features of the '<em>Apply Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.AtomicExpImpl <em>Atomic Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.AtomicExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAtomicExp()
   * @generated
   */
  int ATOMIC_EXP = 26;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__ID = 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__FIELDS = 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__EXP = 2;

  /**
   * The feature id for the '<em><b>Exps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__EXPS = 3;

  /**
   * The feature id for the '<em><b>Val Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__VAL_DECL = 4;

  /**
   * The number of structural features of the '<em>Atomic Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.FieldImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getField()
   * @generated
   */
  int FIELD = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__NAME = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__EXP = 1;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see gdsl.plugin.gDSL.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Model#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decl</em>'.
   * @see gdsl.plugin.gDSL.Model#getDecl()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Decl();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl</em>'.
   * @see gdsl.plugin.gDSL.Decl
   * @generated
   */
  EClass getDecl();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Decl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Decl#getName()
   * @see #getDecl()
   * @generated
   */
  EAttribute getDecl_Name();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DeclGranularity <em>Decl Granularity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl Granularity</em>'.
   * @see gdsl.plugin.gDSL.DeclGranularity
   * @generated
   */
  EClass getDeclGranularity();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.DeclGranularity#getGranularity <em>Granularity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Granularity</em>'.
   * @see gdsl.plugin.gDSL.DeclGranularity#getGranularity()
   * @see #getDeclGranularity()
   * @generated
   */
  EAttribute getDeclGranularity_Granularity();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DeclExport <em>Decl Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl Export</em>'.
   * @see gdsl.plugin.gDSL.DeclExport
   * @generated
   */
  EClass getDeclExport();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.DeclExport#getExports <em>Exports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exports</em>'.
   * @see gdsl.plugin.gDSL.DeclExport#getExports()
   * @see #getDeclExport()
   * @generated
   */
  EReference getDeclExport_Exports();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DeclType <em>Decl Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl Type</em>'.
   * @see gdsl.plugin.gDSL.DeclType
   * @generated
   */
  EClass getDeclType();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.DeclType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see gdsl.plugin.gDSL.DeclType#getValue()
   * @see #getDeclType()
   * @generated
   */
  EReference getDeclType_Value();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.DeclType#getAttrName <em>Attr Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attr Name</em>'.
   * @see gdsl.plugin.gDSL.DeclType#getAttrName()
   * @see #getDeclType()
   * @generated
   */
  EAttribute getDeclType_AttrName();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DeclVal <em>Decl Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl Val</em>'.
   * @see gdsl.plugin.gDSL.DeclVal
   * @generated
   */
  EClass getDeclVal();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.DeclVal#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attr</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getAttr()
   * @see #getDeclVal()
   * @generated
   */
  EAttribute getDeclVal_Attr();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.DeclVal#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getExp()
   * @see #getDeclVal()
   * @generated
   */
  EReference getDeclVal_Exp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.DeclVal#getMid <em>Mid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mid</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getMid()
   * @see #getDeclVal()
   * @generated
   */
  EAttribute getDeclVal_Mid();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.DeclVal#getDecPat <em>Dec Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dec Pat</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getDecPat()
   * @see #getDeclVal()
   * @generated
   */
  EReference getDeclVal_DecPat();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.DeclVal#getExps <em>Exps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exps</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getExps()
   * @see #getDeclVal()
   * @generated
   */
  EReference getDeclVal_Exps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Export</em>'.
   * @see gdsl.plugin.gDSL.Export
   * @generated
   */
  EClass getExport();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Export#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Export#getName()
   * @see #getExport()
   * @generated
   */
  EAttribute getExport_Name();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Export#getAttrName <em>Attr Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attr Name</em>'.
   * @see gdsl.plugin.gDSL.Export#getAttrName()
   * @see #getExport()
   * @generated
   */
  EAttribute getExport_AttrName();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.ConDecls <em>Con Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Con Decls</em>'.
   * @see gdsl.plugin.gDSL.ConDecls
   * @generated
   */
  EClass getConDecls();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.ConDecls#getConDecls <em>Con Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Con Decls</em>'.
   * @see gdsl.plugin.gDSL.ConDecls#getConDecls()
   * @see #getConDecls()
   * @generated
   */
  EReference getConDecls_ConDecls();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.ConDecl <em>Con Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Con Decl</em>'.
   * @see gdsl.plugin.gDSL.ConDecl
   * @generated
   */
  EClass getConDecl();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.ConDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.ConDecl#getName()
   * @see #getConDecl()
   * @generated
   */
  EAttribute getConDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ConDecl#getTy <em>Ty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ty</em>'.
   * @see gdsl.plugin.gDSL.ConDecl#getTy()
   * @see #getConDecl()
   * @generated
   */
  EReference getConDecl_Ty();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Ty <em>Ty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ty</em>'.
   * @see gdsl.plugin.gDSL.Ty
   * @generated
   */
  EClass getTy();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Ty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see gdsl.plugin.gDSL.Ty#getValue()
   * @see #getTy()
   * @generated
   */
  EAttribute getTy_Value();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Ty#getTyBind <em>Ty Bind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ty Bind</em>'.
   * @see gdsl.plugin.gDSL.Ty#getTyBind()
   * @see #getTy()
   * @generated
   */
  EReference getTy_TyBind();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Ty#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see gdsl.plugin.gDSL.Ty#getElements()
   * @see #getTy()
   * @generated
   */
  EReference getTy_Elements();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.TyElement <em>Ty Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ty Element</em>'.
   * @see gdsl.plugin.gDSL.TyElement
   * @generated
   */
  EClass getTyElement();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.TyElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.TyElement#getName()
   * @see #getTyElement()
   * @generated
   */
  EAttribute getTyElement_Name();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.TyElement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see gdsl.plugin.gDSL.TyElement#getValue()
   * @see #getTyElement()
   * @generated
   */
  EReference getTyElement_Value();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.TyBind <em>Ty Bind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ty Bind</em>'.
   * @see gdsl.plugin.gDSL.TyBind
   * @generated
   */
  EClass getTyBind();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.TyBind#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see gdsl.plugin.gDSL.TyBind#getKey()
   * @see #getTyBind()
   * @generated
   */
  EAttribute getTyBind_Key();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.TyBind#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see gdsl.plugin.gDSL.TyBind#getValue()
   * @see #getTyBind()
   * @generated
   */
  EReference getTyBind_Value();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DecodePat <em>Decode Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decode Pat</em>'.
   * @see gdsl.plugin.gDSL.DecodePat
   * @generated
   */
  EClass getDecodePat();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.BitPat <em>Bit Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bit Pat</em>'.
   * @see gdsl.plugin.gDSL.BitPat
   * @generated
   */
  EClass getBitPat();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.BitPat#getBitpat <em>Bitpat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Bitpat</em>'.
   * @see gdsl.plugin.gDSL.BitPat#getBitpat()
   * @see #getBitPat()
   * @generated
   */
  EAttribute getBitPat_Bitpat();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.TokPat <em>Tok Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tok Pat</em>'.
   * @see gdsl.plugin.gDSL.TokPat
   * @generated
   */
  EClass getTokPat();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.TokPat#getTokPat <em>Tok Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tok Pat</em>'.
   * @see gdsl.plugin.gDSL.TokPat#getTokPat()
   * @see #getTokPat()
   * @generated
   */
  EAttribute getTokPat_TokPat();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Exp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.Exp
   * @generated
   */
  EClass getExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Exp#getCaseExp <em>Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Case Exp</em>'.
   * @see gdsl.plugin.gDSL.Exp#getCaseExp()
   * @see #getExp()
   * @generated
   */
  EReference getExp_CaseExp();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Exp#getMid <em>Mid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mid</em>'.
   * @see gdsl.plugin.gDSL.Exp#getMid()
   * @see #getExp()
   * @generated
   */
  EAttribute getExp_Mid();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.CaseExp <em>Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Exp</em>'.
   * @see gdsl.plugin.gDSL.CaseExp
   * @generated
   */
  EClass getCaseExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.CaseExp#getClosedExp <em>Closed Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Closed Exp</em>'.
   * @see gdsl.plugin.gDSL.CaseExp#getClosedExp()
   * @see #getCaseExp()
   * @generated
   */
  EReference getCaseExp_ClosedExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.CaseExp#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cases</em>'.
   * @see gdsl.plugin.gDSL.CaseExp#getCases()
   * @see #getCaseExp()
   * @generated
   */
  EReference getCaseExp_Cases();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.ClosedExp <em>Closed Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closed Exp</em>'.
   * @see gdsl.plugin.gDSL.ClosedExp
   * @generated
   */
  EClass getClosedExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ClosedExp#getIfCaseExp <em>If Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Case Exp</em>'.
   * @see gdsl.plugin.gDSL.ClosedExp#getIfCaseExp()
   * @see #getClosedExp()
   * @generated
   */
  EReference getClosedExp_IfCaseExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ClosedExp#getThenCaseExp <em>Then Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Case Exp</em>'.
   * @see gdsl.plugin.gDSL.ClosedExp#getThenCaseExp()
   * @see #getClosedExp()
   * @generated
   */
  EReference getClosedExp_ThenCaseExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ClosedExp#getElseCaseExp <em>Else Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Case Exp</em>'.
   * @see gdsl.plugin.gDSL.ClosedExp#getElseCaseExp()
   * @see #getClosedExp()
   * @generated
   */
  EReference getClosedExp_ElseCaseExp();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.ClosedExp#getDoExp <em>Do Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Do Exp</em>'.
   * @see gdsl.plugin.gDSL.ClosedExp#getDoExp()
   * @see #getClosedExp()
   * @generated
   */
  EReference getClosedExp_DoExp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.MonadicExp <em>Monadic Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Monadic Exp</em>'.
   * @see gdsl.plugin.gDSL.MonadicExp
   * @generated
   */
  EClass getMonadicExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.MonadicExp#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.MonadicExp#getExp()
   * @see #getMonadicExp()
   * @generated
   */
  EReference getMonadicExp_Exp();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.MonadicExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.MonadicExp#getName()
   * @see #getMonadicExp()
   * @generated
   */
  EAttribute getMonadicExp_Name();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Cases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cases</em>'.
   * @see gdsl.plugin.gDSL.Cases
   * @generated
   */
  EClass getCases();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Cases#getPat <em>Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Pat</em>'.
   * @see gdsl.plugin.gDSL.Cases#getPat()
   * @see #getCases()
   * @generated
   */
  EAttribute getCases_Pat();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Cases#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.Cases#getExp()
   * @see #getCases()
   * @generated
   */
  EReference getCases_Exp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.OrElseExp <em>Or Else Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Else Exp</em>'.
   * @see gdsl.plugin.gDSL.OrElseExp
   * @generated
   */
  EClass getOrElseExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.OrElseExp#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gdsl.plugin.gDSL.OrElseExp#getLeft()
   * @see #getOrElseExp()
   * @generated
   */
  EReference getOrElseExp_Left();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.OrElseExp#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see gdsl.plugin.gDSL.OrElseExp#getRight()
   * @see #getOrElseExp()
   * @generated
   */
  EReference getOrElseExp_Right();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.AndAlsoExp <em>And Also Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Also Exp</em>'.
   * @see gdsl.plugin.gDSL.AndAlsoExp
   * @generated
   */
  EClass getAndAlsoExp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.RExp <em>RExp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RExp</em>'.
   * @see gdsl.plugin.gDSL.RExp
   * @generated
   */
  EClass getRExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.RExp#getAexp <em>Aexp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Aexp</em>'.
   * @see gdsl.plugin.gDSL.RExp#getAexp()
   * @see #getRExp()
   * @generated
   */
  EReference getRExp_Aexp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.RExp#getSym <em>Sym</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sym</em>'.
   * @see gdsl.plugin.gDSL.RExp#getSym()
   * @see #getRExp()
   * @generated
   */
  EAttribute getRExp_Sym();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.RExp#getAexps <em>Aexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Aexps</em>'.
   * @see gdsl.plugin.gDSL.RExp#getAexps()
   * @see #getRExp()
   * @generated
   */
  EReference getRExp_Aexps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.AExp <em>AExp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExp</em>'.
   * @see gdsl.plugin.gDSL.AExp
   * @generated
   */
  EClass getAExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.AExp#getMexp <em>Mexp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mexp</em>'.
   * @see gdsl.plugin.gDSL.AExp#getMexp()
   * @see #getAExp()
   * @generated
   */
  EReference getAExp_Mexp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.AExp#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sign</em>'.
   * @see gdsl.plugin.gDSL.AExp#getSign()
   * @see #getAExp()
   * @generated
   */
  EAttribute getAExp_Sign();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.AExp#getMexps <em>Mexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mexps</em>'.
   * @see gdsl.plugin.gDSL.AExp#getMexps()
   * @see #getAExp()
   * @generated
   */
  EReference getAExp_Mexps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.MExp <em>MExp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MExp</em>'.
   * @see gdsl.plugin.gDSL.MExp
   * @generated
   */
  EClass getMExp();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.MExp#getApplyexps <em>Applyexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Applyexps</em>'.
   * @see gdsl.plugin.gDSL.MExp#getApplyexps()
   * @see #getMExp()
   * @generated
   */
  EReference getMExp_Applyexps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.ApplyExp <em>Apply Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Apply Exp</em>'.
   * @see gdsl.plugin.gDSL.ApplyExp
   * @generated
   */
  EClass getApplyExp();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.ApplyExp#isNeg <em>Neg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neg</em>'.
   * @see gdsl.plugin.gDSL.ApplyExp#isNeg()
   * @see #getApplyExp()
   * @generated
   */
  EAttribute getApplyExp_Neg();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ApplyExp#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.ApplyExp#getExp()
   * @see #getApplyExp()
   * @generated
   */
  EReference getApplyExp_Exp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.AtomicExp <em>Atomic Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Exp</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp
   * @generated
   */
  EClass getAtomicExp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.AtomicExp#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getId()
   * @see #getAtomicExp()
   * @generated
   */
  EAttribute getAtomicExp_Id();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.AtomicExp#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getFields()
   * @see #getAtomicExp()
   * @generated
   */
  EReference getAtomicExp_Fields();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.AtomicExp#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getExp()
   * @see #getAtomicExp()
   * @generated
   */
  EReference getAtomicExp_Exp();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.AtomicExp#getExps <em>Exps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exps</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getExps()
   * @see #getAtomicExp()
   * @generated
   */
  EReference getAtomicExp_Exps();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.AtomicExp#getValDecl <em>Val Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Val Decl</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getValDecl()
   * @see #getAtomicExp()
   * @generated
   */
  EReference getAtomicExp_ValDecl();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see gdsl.plugin.gDSL.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Field#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Field#getName()
   * @see #getField()
   * @generated
   */
  EAttribute getField_Name();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Field#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.Field#getExp()
   * @see #getField()
   * @generated
   */
  EReference getField_Exp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.ValueDecl <em>Value Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Decl</em>'.
   * @see gdsl.plugin.gDSL.ValueDecl
   * @generated
   */
  EClass getValueDecl();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GDSLFactory getGDSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ModelImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DECL = eINSTANCE.getModel_Decl();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclImpl <em>Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDecl()
     * @generated
     */
    EClass DECL = eINSTANCE.getDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL__NAME = eINSTANCE.getDecl_Name();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclGranularityImpl <em>Decl Granularity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclGranularityImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclGranularity()
     * @generated
     */
    EClass DECL_GRANULARITY = eINSTANCE.getDeclGranularity();

    /**
     * The meta object literal for the '<em><b>Granularity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_GRANULARITY__GRANULARITY = eINSTANCE.getDeclGranularity_Granularity();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclExportImpl <em>Decl Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclExportImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclExport()
     * @generated
     */
    EClass DECL_EXPORT = eINSTANCE.getDeclExport();

    /**
     * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_EXPORT__EXPORTS = eINSTANCE.getDeclExport_Exports();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclTypeImpl <em>Decl Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclTypeImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclType()
     * @generated
     */
    EClass DECL_TYPE = eINSTANCE.getDeclType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_TYPE__VALUE = eINSTANCE.getDeclType_Value();

    /**
     * The meta object literal for the '<em><b>Attr Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_TYPE__ATTR_NAME = eINSTANCE.getDeclType_AttrName();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclValImpl <em>Decl Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclValImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclVal()
     * @generated
     */
    EClass DECL_VAL = eINSTANCE.getDeclVal();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_VAL__ATTR = eINSTANCE.getDeclVal_Attr();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_VAL__EXP = eINSTANCE.getDeclVal_Exp();

    /**
     * The meta object literal for the '<em><b>Mid</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_VAL__MID = eINSTANCE.getDeclVal_Mid();

    /**
     * The meta object literal for the '<em><b>Dec Pat</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_VAL__DEC_PAT = eINSTANCE.getDeclVal_DecPat();

    /**
     * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_VAL__EXPS = eINSTANCE.getDeclVal_Exps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ExportImpl <em>Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ExportImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExport()
     * @generated
     */
    EClass EXPORT = eINSTANCE.getExport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPORT__NAME = eINSTANCE.getExport_Name();

    /**
     * The meta object literal for the '<em><b>Attr Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPORT__ATTR_NAME = eINSTANCE.getExport_AttrName();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ConDeclsImpl <em>Con Decls</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ConDeclsImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getConDecls()
     * @generated
     */
    EClass CON_DECLS = eINSTANCE.getConDecls();

    /**
     * The meta object literal for the '<em><b>Con Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CON_DECLS__CON_DECLS = eINSTANCE.getConDecls_ConDecls();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ConDeclImpl <em>Con Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ConDeclImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getConDecl()
     * @generated
     */
    EClass CON_DECL = eINSTANCE.getConDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CON_DECL__NAME = eINSTANCE.getConDecl_Name();

    /**
     * The meta object literal for the '<em><b>Ty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CON_DECL__TY = eINSTANCE.getConDecl_Ty();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TyImpl <em>Ty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TyImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTy()
     * @generated
     */
    EClass TY = eINSTANCE.getTy();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TY__VALUE = eINSTANCE.getTy_Value();

    /**
     * The meta object literal for the '<em><b>Ty Bind</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__TY_BIND = eINSTANCE.getTy_TyBind();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__ELEMENTS = eINSTANCE.getTy_Elements();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TyElementImpl <em>Ty Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TyElementImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyElement()
     * @generated
     */
    EClass TY_ELEMENT = eINSTANCE.getTyElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TY_ELEMENT__NAME = eINSTANCE.getTyElement_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY_ELEMENT__VALUE = eINSTANCE.getTyElement_Value();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TyBindImpl <em>Ty Bind</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TyBindImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyBind()
     * @generated
     */
    EClass TY_BIND = eINSTANCE.getTyBind();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TY_BIND__KEY = eINSTANCE.getTyBind_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY_BIND__VALUE = eINSTANCE.getTyBind_Value();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DecodePatImpl <em>Decode Pat</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DecodePatImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDecodePat()
     * @generated
     */
    EClass DECODE_PAT = eINSTANCE.getDecodePat();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.BitPatImpl <em>Bit Pat</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.BitPatImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getBitPat()
     * @generated
     */
    EClass BIT_PAT = eINSTANCE.getBitPat();

    /**
     * The meta object literal for the '<em><b>Bitpat</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_PAT__BITPAT = eINSTANCE.getBitPat_Bitpat();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TokPatImpl <em>Tok Pat</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TokPatImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTokPat()
     * @generated
     */
    EClass TOK_PAT = eINSTANCE.getTokPat();

    /**
     * The meta object literal for the '<em><b>Tok Pat</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOK_PAT__TOK_PAT = eINSTANCE.getTokPat_TokPat();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ExpImpl <em>Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExp()
     * @generated
     */
    EClass EXP = eINSTANCE.getExp();

    /**
     * The meta object literal for the '<em><b>Case Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXP__CASE_EXP = eINSTANCE.getExp_CaseExp();

    /**
     * The meta object literal for the '<em><b>Mid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXP__MID = eINSTANCE.getExp_Mid();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.CaseExpImpl <em>Case Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.CaseExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCaseExp()
     * @generated
     */
    EClass CASE_EXP = eINSTANCE.getCaseExp();

    /**
     * The meta object literal for the '<em><b>Closed Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXP__CLOSED_EXP = eINSTANCE.getCaseExp_ClosedExp();

    /**
     * The meta object literal for the '<em><b>Cases</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXP__CASES = eINSTANCE.getCaseExp_Cases();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ClosedExpImpl <em>Closed Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ClosedExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getClosedExp()
     * @generated
     */
    EClass CLOSED_EXP = eINSTANCE.getClosedExp();

    /**
     * The meta object literal for the '<em><b>If Case Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOSED_EXP__IF_CASE_EXP = eINSTANCE.getClosedExp_IfCaseExp();

    /**
     * The meta object literal for the '<em><b>Then Case Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOSED_EXP__THEN_CASE_EXP = eINSTANCE.getClosedExp_ThenCaseExp();

    /**
     * The meta object literal for the '<em><b>Else Case Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOSED_EXP__ELSE_CASE_EXP = eINSTANCE.getClosedExp_ElseCaseExp();

    /**
     * The meta object literal for the '<em><b>Do Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOSED_EXP__DO_EXP = eINSTANCE.getClosedExp_DoExp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.MonadicExpImpl <em>Monadic Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.MonadicExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getMonadicExp()
     * @generated
     */
    EClass MONADIC_EXP = eINSTANCE.getMonadicExp();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONADIC_EXP__EXP = eINSTANCE.getMonadicExp_Exp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONADIC_EXP__NAME = eINSTANCE.getMonadicExp_Name();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.CasesImpl <em>Cases</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.CasesImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCases()
     * @generated
     */
    EClass CASES = eINSTANCE.getCases();

    /**
     * The meta object literal for the '<em><b>Pat</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASES__PAT = eINSTANCE.getCases_Pat();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASES__EXP = eINSTANCE.getCases_Exp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.OrElseExpImpl <em>Or Else Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.OrElseExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getOrElseExp()
     * @generated
     */
    EClass OR_ELSE_EXP = eINSTANCE.getOrElseExp();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_ELSE_EXP__LEFT = eINSTANCE.getOrElseExp_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_ELSE_EXP__RIGHT = eINSTANCE.getOrElseExp_Right();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.AndAlsoExpImpl <em>And Also Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.AndAlsoExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAndAlsoExp()
     * @generated
     */
    EClass AND_ALSO_EXP = eINSTANCE.getAndAlsoExp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.RExpImpl <em>RExp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.RExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getRExp()
     * @generated
     */
    EClass REXP = eINSTANCE.getRExp();

    /**
     * The meta object literal for the '<em><b>Aexp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REXP__AEXP = eINSTANCE.getRExp_Aexp();

    /**
     * The meta object literal for the '<em><b>Sym</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REXP__SYM = eINSTANCE.getRExp_Sym();

    /**
     * The meta object literal for the '<em><b>Aexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REXP__AEXPS = eINSTANCE.getRExp_Aexps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.AExpImpl <em>AExp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.AExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAExp()
     * @generated
     */
    EClass AEXP = eINSTANCE.getAExp();

    /**
     * The meta object literal for the '<em><b>Mexp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXP__MEXP = eINSTANCE.getAExp_Mexp();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AEXP__SIGN = eINSTANCE.getAExp_Sign();

    /**
     * The meta object literal for the '<em><b>Mexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXP__MEXPS = eINSTANCE.getAExp_Mexps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.MExpImpl <em>MExp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.MExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getMExp()
     * @generated
     */
    EClass MEXP = eINSTANCE.getMExp();

    /**
     * The meta object literal for the '<em><b>Applyexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEXP__APPLYEXPS = eINSTANCE.getMExp_Applyexps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ApplyExpImpl <em>Apply Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ApplyExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getApplyExp()
     * @generated
     */
    EClass APPLY_EXP = eINSTANCE.getApplyExp();

    /**
     * The meta object literal for the '<em><b>Neg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute APPLY_EXP__NEG = eINSTANCE.getApplyExp_Neg();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLY_EXP__EXP = eINSTANCE.getApplyExp_Exp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.AtomicExpImpl <em>Atomic Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.AtomicExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAtomicExp()
     * @generated
     */
    EClass ATOMIC_EXP = eINSTANCE.getAtomicExp();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOMIC_EXP__ID = eINSTANCE.getAtomicExp_Id();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EXP__FIELDS = eINSTANCE.getAtomicExp_Fields();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EXP__EXP = eINSTANCE.getAtomicExp_Exp();

    /**
     * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EXP__EXPS = eINSTANCE.getAtomicExp_Exps();

    /**
     * The meta object literal for the '<em><b>Val Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EXP__VAL_DECL = eINSTANCE.getAtomicExp_ValDecl();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.FieldImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD__NAME = eINSTANCE.getField_Name();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD__EXP = eINSTANCE.getField_Exp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ValueDeclImpl <em>Value Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ValueDeclImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getValueDecl()
     * @generated
     */
    EClass VALUE_DECL = eINSTANCE.getValueDecl();

  }

} //GDSLPackage
