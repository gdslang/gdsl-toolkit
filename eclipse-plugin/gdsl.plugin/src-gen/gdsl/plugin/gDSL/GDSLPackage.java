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
   * The number of structural features of the '<em>Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.DeclExportImpl <em>Decl Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.DeclExportImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclExport()
   * @generated
   */
  int DECL_EXPORT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT__NAME = DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ty Vars</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT__TY_VARS = DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT__TYPE = DECL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Decl Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_EXPORT_FEATURE_COUNT = DECL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TypeImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getType()
   * @generated
   */
  int TYPE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ty Vars</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TY_VARS = DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Con Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__CON_DECL = DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__VALUE = DECL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = DECL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ValImpl <em>Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ValImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getVal()
   * @generated
   */
  int VAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__NAME = DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attr</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__ATTR = DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__EXP = DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mid</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__MID = DECL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Dec Pat</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__DEC_PAT = DECL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Exps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL__EXPS = DECL_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_FEATURE_COUNT = DECL_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyVarsImpl <em>Ty Vars</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyVarsImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyVars()
   * @generated
   */
  int TY_VARS = 5;

  /**
   * The feature id for the '<em><b>Attr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_VARS__ATTR = 0;

  /**
   * The number of structural features of the '<em>Ty Vars</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_VARS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ConDeclImpl <em>Con Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ConDeclImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getConDecl()
   * @generated
   */
  int CON_DECL = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
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
  int TY = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__VALUE = 0;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__TYPE_REF = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__TYPE = 2;

  /**
   * The feature id for the '<em><b>Ty Bind</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__TY_BIND = 3;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__ELEMENTS = 4;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__PARAM = 5;

  /**
   * The feature id for the '<em><b>Res Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__RES_TYPE = 6;

  /**
   * The feature id for the '<em><b>R</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__R = 7;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__IN = 8;

  /**
   * The feature id for the '<em><b>Out</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY__OUT = 9;

  /**
   * The number of structural features of the '<em>Ty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyBindImpl <em>Ty Bind</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyBindImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyBind()
   * @generated
   */
  int TY_BIND = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TY_BIND__NAME = 0;

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
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.TyElementImpl <em>Ty Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.TyElementImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyElement()
   * @generated
   */
  int TY_ELEMENT = 9;

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
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ExpImpl <em>Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExp()
   * @generated
   */
  int EXP = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP__NAME = 0;

  /**
   * The feature id for the '<em><b>Mid</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP__MID = 1;

  /**
   * The feature id for the '<em><b>Case Exps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP__CASE_EXPS = 2;

  /**
   * The number of structural features of the '<em>Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.CaseExpImpl <em>Case Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.CaseExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCaseExp()
   * @generated
   */
  int CASE_EXP = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__NAME = 0;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__CLOSED_EXP = 1;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__PAT = 2;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP__EXP = 3;

  /**
   * The number of structural features of the '<em>Case Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXP_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ClosedExpImpl <em>Closed Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ClosedExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getClosedExp()
   * @generated
   */
  int CLOSED_EXP = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__NAME = CASE_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__CLOSED_EXP = CASE_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__PAT = CASE_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_EXP__EXP = CASE_EXP__EXP;

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
  int MONADIC_EXP = 13;

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
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.OrElseExpImpl <em>Or Else Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.OrElseExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getOrElseExp()
   * @generated
   */
  int OR_ELSE_EXP = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__NAME = CLOSED_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__CLOSED_EXP = CLOSED_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__PAT = CLOSED_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_ELSE_EXP__EXP = CLOSED_EXP__EXP;

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
  int AND_ALSO_EXP = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__NAME = OR_ELSE_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__CLOSED_EXP = OR_ELSE_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__PAT = OR_ELSE_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_ALSO_EXP__EXP = OR_ELSE_EXP__EXP;

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
  int REXP = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__NAME = AND_ALSO_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__CLOSED_EXP = AND_ALSO_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__PAT = AND_ALSO_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP__EXP = AND_ALSO_EXP__EXP;

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
   * The number of structural features of the '<em>RExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REXP_FEATURE_COUNT = AND_ALSO_EXP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.AExpImpl <em>AExp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.AExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAExp()
   * @generated
   */
  int AEXP = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__NAME = REXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__CLOSED_EXP = REXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__PAT = REXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__EXP = REXP__EXP;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__IF_CASE_EXP = REXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__THEN_CASE_EXP = REXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__ELSE_CASE_EXP = REXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__DO_EXP = REXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__LEFT = REXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__RIGHT = REXP__RIGHT;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__SYM = REXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP__AEXPS = REXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXP_FEATURE_COUNT = REXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.MExpImpl <em>MExp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.MExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getMExp()
   * @generated
   */
  int MEXP = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__NAME = AEXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__CLOSED_EXP = AEXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__PAT = AEXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__EXP = AEXP__EXP;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__IF_CASE_EXP = AEXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__THEN_CASE_EXP = AEXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__ELSE_CASE_EXP = AEXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__DO_EXP = AEXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__LEFT = AEXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__RIGHT = AEXP__RIGHT;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__SYM = AEXP__SYM;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__AEXPS = AEXP__AEXPS;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__SIGN = AEXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP__MEXPS = AEXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MExp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXP_FEATURE_COUNT = AEXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.SelectExpImpl <em>Select Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.SelectExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getSelectExp()
   * @generated
   */
  int SELECT_EXP = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__NAME = MEXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__CLOSED_EXP = MEXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__PAT = MEXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__EXP = MEXP__EXP;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__IF_CASE_EXP = MEXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__THEN_CASE_EXP = MEXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__ELSE_CASE_EXP = MEXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__DO_EXP = MEXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__LEFT = MEXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__RIGHT = MEXP__RIGHT;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__SYM = MEXP__SYM;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__AEXPS = MEXP__AEXPS;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__SIGN = MEXP__SIGN;

  /**
   * The feature id for the '<em><b>Mexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__MEXPS = MEXP__MEXPS;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__SYMBOL = MEXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Applyexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP__APPLYEXPS = MEXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Select Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_EXP_FEATURE_COUNT = MEXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ApplyExpImpl <em>Apply Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ApplyExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getApplyExp()
   * @generated
   */
  int APPLY_EXP = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__NAME = SELECT_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__CLOSED_EXP = SELECT_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__PAT = SELECT_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__EXP = SELECT_EXP__EXP;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__IF_CASE_EXP = SELECT_EXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__THEN_CASE_EXP = SELECT_EXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__ELSE_CASE_EXP = SELECT_EXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__DO_EXP = SELECT_EXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__LEFT = SELECT_EXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__RIGHT = SELECT_EXP__RIGHT;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__SYM = SELECT_EXP__SYM;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__AEXPS = SELECT_EXP__AEXPS;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__SIGN = SELECT_EXP__SIGN;

  /**
   * The feature id for the '<em><b>Mexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__MEXPS = SELECT_EXP__MEXPS;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__SYMBOL = SELECT_EXP__SYMBOL;

  /**
   * The feature id for the '<em><b>Applyexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__APPLYEXPS = SELECT_EXP__APPLYEXPS;

  /**
   * The feature id for the '<em><b>Atomic Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__ATOMIC_EXP = SELECT_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP__ARGS = SELECT_EXP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Apply Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLY_EXP_FEATURE_COUNT = SELECT_EXP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ArgsImpl <em>Args</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ArgsImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getArgs()
   * @generated
   */
  int ARGS = 21;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGS__ARGS = 0;

  /**
   * The number of structural features of the '<em>Args</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.AtomicExpImpl <em>Atomic Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.AtomicExpImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAtomicExp()
   * @generated
   */
  int ATOMIC_EXP = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__NAME = APPLY_EXP__NAME;

  /**
   * The feature id for the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__CLOSED_EXP = APPLY_EXP__CLOSED_EXP;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__PAT = APPLY_EXP__PAT;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__EXP = APPLY_EXP__EXP;

  /**
   * The feature id for the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__IF_CASE_EXP = APPLY_EXP__IF_CASE_EXP;

  /**
   * The feature id for the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__THEN_CASE_EXP = APPLY_EXP__THEN_CASE_EXP;

  /**
   * The feature id for the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__ELSE_CASE_EXP = APPLY_EXP__ELSE_CASE_EXP;

  /**
   * The feature id for the '<em><b>Do Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__DO_EXP = APPLY_EXP__DO_EXP;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__LEFT = APPLY_EXP__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__RIGHT = APPLY_EXP__RIGHT;

  /**
   * The feature id for the '<em><b>Sym</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__SYM = APPLY_EXP__SYM;

  /**
   * The feature id for the '<em><b>Aexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__AEXPS = APPLY_EXP__AEXPS;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__SIGN = APPLY_EXP__SIGN;

  /**
   * The feature id for the '<em><b>Mexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__MEXPS = APPLY_EXP__MEXPS;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__SYMBOL = APPLY_EXP__SYMBOL;

  /**
   * The feature id for the '<em><b>Applyexps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__APPLYEXPS = APPLY_EXP__APPLYEXPS;

  /**
   * The feature id for the '<em><b>Atomic Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__ATOMIC_EXP = APPLY_EXP__ATOMIC_EXP;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__ARGS = APPLY_EXP__ARGS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__ID = APPLY_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__FIELDS = APPLY_EXP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__EXPR = APPLY_EXP_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Exps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__EXPS = APPLY_EXP_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Val Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP__VAL_DECL = APPLY_EXP_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Atomic Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EXP_FEATURE_COUNT = APPLY_EXP_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.FieldImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getField()
   * @generated
   */
  int FIELD = 23;

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
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.ValueDeclImpl <em>Value Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.ValueDeclImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getValueDecl()
   * @generated
   */
  int VALUE_DECL = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DECL__IDS = 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DECL__EXP = 2;

  /**
   * The number of structural features of the '<em>Value Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DECL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.PATImpl <em>PAT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.PATImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getPAT()
   * @generated
   */
  int PAT = 25;

  /**
   * The feature id for the '<em><b>Uscore</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT__USCORE = 0;

  /**
   * The feature id for the '<em><b>Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT__INT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT__ID = 2;

  /**
   * The feature id for the '<em><b>Pat</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT__PAT = 3;

  /**
   * The feature id for the '<em><b>Bitpat</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT__BITPAT = 4;

  /**
   * The number of structural features of the '<em>PAT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link gdsl.plugin.gDSL.impl.CONSImpl <em>CONS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gdsl.plugin.gDSL.impl.CONSImpl
   * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCONS()
   * @generated
   */
  int CONS = 26;

  /**
   * The feature id for the '<em><b>Con Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONS__CON_NAME = 0;

  /**
   * The number of structural features of the '<em>CONS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONS_FEATURE_COUNT = 1;


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
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.DeclExport <em>Decl Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl Export</em>'.
   * @see gdsl.plugin.gDSL.DeclExport
   * @generated
   */
  EClass getDeclExport();

  /**
   * Returns the meta object for the reference '{@link gdsl.plugin.gDSL.DeclExport#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.DeclExport#getName()
   * @see #getDeclExport()
   * @generated
   */
  EReference getDeclExport_Name();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.DeclExport#getTyVars <em>Ty Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ty Vars</em>'.
   * @see gdsl.plugin.gDSL.DeclExport#getTyVars()
   * @see #getDeclExport()
   * @generated
   */
  EReference getDeclExport_TyVars();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.DeclExport#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see gdsl.plugin.gDSL.DeclExport#getType()
   * @see #getDeclExport()
   * @generated
   */
  EReference getDeclExport_Type();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see gdsl.plugin.gDSL.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Type#getName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Name();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Type#getTyVars <em>Ty Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ty Vars</em>'.
   * @see gdsl.plugin.gDSL.Type#getTyVars()
   * @see #getType()
   * @generated
   */
  EReference getType_TyVars();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Type#getConDecl <em>Con Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Con Decl</em>'.
   * @see gdsl.plugin.gDSL.Type#getConDecl()
   * @see #getType()
   * @generated
   */
  EReference getType_ConDecl();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Type#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see gdsl.plugin.gDSL.Type#getValue()
   * @see #getType()
   * @generated
   */
  EReference getType_Value();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Val <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Val</em>'.
   * @see gdsl.plugin.gDSL.Val
   * @generated
   */
  EClass getVal();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Val#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Val#getName()
   * @see #getVal()
   * @generated
   */
  EAttribute getVal_Name();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Val#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attr</em>'.
   * @see gdsl.plugin.gDSL.Val#getAttr()
   * @see #getVal()
   * @generated
   */
  EAttribute getVal_Attr();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Val#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.Val#getExp()
   * @see #getVal()
   * @generated
   */
  EReference getVal_Exp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Val#getMid <em>Mid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mid</em>'.
   * @see gdsl.plugin.gDSL.Val#getMid()
   * @see #getVal()
   * @generated
   */
  EAttribute getVal_Mid();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Val#getDecPat <em>Dec Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Dec Pat</em>'.
   * @see gdsl.plugin.gDSL.Val#getDecPat()
   * @see #getVal()
   * @generated
   */
  EAttribute getVal_DecPat();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Val#getExps <em>Exps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exps</em>'.
   * @see gdsl.plugin.gDSL.Val#getExps()
   * @see #getVal()
   * @generated
   */
  EReference getVal_Exps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.TyVars <em>Ty Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ty Vars</em>'.
   * @see gdsl.plugin.gDSL.TyVars
   * @generated
   */
  EClass getTyVars();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.TyVars#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attr</em>'.
   * @see gdsl.plugin.gDSL.TyVars#getAttr()
   * @see #getTyVars()
   * @generated
   */
  EReference getTyVars_Attr();

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
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ConDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.ConDecl#getName()
   * @see #getConDecl()
   * @generated
   */
  EReference getConDecl_Name();

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
   * Returns the meta object for the reference '{@link gdsl.plugin.gDSL.Ty#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type Ref</em>'.
   * @see gdsl.plugin.gDSL.Ty#getTypeRef()
   * @see #getTy()
   * @generated
   */
  EReference getTy_TypeRef();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.Ty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see gdsl.plugin.gDSL.Ty#getType()
   * @see #getTy()
   * @generated
   */
  EAttribute getTy_Type();

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
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Ty#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see gdsl.plugin.gDSL.Ty#getParam()
   * @see #getTy()
   * @generated
   */
  EReference getTy_Param();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Ty#getResType <em>Res Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Res Type</em>'.
   * @see gdsl.plugin.gDSL.Ty#getResType()
   * @see #getTy()
   * @generated
   */
  EReference getTy_ResType();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Ty#getR <em>R</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>R</em>'.
   * @see gdsl.plugin.gDSL.Ty#getR()
   * @see #getTy()
   * @generated
   */
  EReference getTy_R();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Ty#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>In</em>'.
   * @see gdsl.plugin.gDSL.Ty#getIn()
   * @see #getTy()
   * @generated
   */
  EReference getTy_In();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Ty#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Out</em>'.
   * @see gdsl.plugin.gDSL.Ty#getOut()
   * @see #getTy()
   * @generated
   */
  EReference getTy_Out();

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
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.TyBind#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.TyBind#getName()
   * @see #getTyBind()
   * @generated
   */
  EAttribute getTyBind_Name();

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
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Exp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.Exp
   * @generated
   */
  EClass getExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.Exp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.Exp#getName()
   * @see #getExp()
   * @generated
   */
  EReference getExp_Name();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.Exp#getMid <em>Mid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mid</em>'.
   * @see gdsl.plugin.gDSL.Exp#getMid()
   * @see #getExp()
   * @generated
   */
  EAttribute getExp_Mid();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Exp#getCaseExps <em>Case Exps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case Exps</em>'.
   * @see gdsl.plugin.gDSL.Exp#getCaseExps()
   * @see #getExp()
   * @generated
   */
  EReference getExp_CaseExps();

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
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.CaseExp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.CaseExp#getName()
   * @see #getCaseExp()
   * @generated
   */
  EAttribute getCaseExp_Name();

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
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.CaseExp#getPat <em>Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pat</em>'.
   * @see gdsl.plugin.gDSL.CaseExp#getPat()
   * @see #getCaseExp()
   * @generated
   */
  EReference getCaseExp_Pat();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.CaseExp#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.CaseExp#getExp()
   * @see #getCaseExp()
   * @generated
   */
  EReference getCaseExp_Exp();

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
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.AExp <em>AExp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExp</em>'.
   * @see gdsl.plugin.gDSL.AExp
   * @generated
   */
  EClass getAExp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.AExp#getSym <em>Sym</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sym</em>'.
   * @see gdsl.plugin.gDSL.AExp#getSym()
   * @see #getAExp()
   * @generated
   */
  EAttribute getAExp_Sym();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.AExp#getAexps <em>Aexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Aexps</em>'.
   * @see gdsl.plugin.gDSL.AExp#getAexps()
   * @see #getAExp()
   * @generated
   */
  EReference getAExp_Aexps();

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
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.MExp#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sign</em>'.
   * @see gdsl.plugin.gDSL.MExp#getSign()
   * @see #getMExp()
   * @generated
   */
  EAttribute getMExp_Sign();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.MExp#getMexps <em>Mexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mexps</em>'.
   * @see gdsl.plugin.gDSL.MExp#getMexps()
   * @see #getMExp()
   * @generated
   */
  EReference getMExp_Mexps();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.SelectExp <em>Select Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Select Exp</em>'.
   * @see gdsl.plugin.gDSL.SelectExp
   * @generated
   */
  EClass getSelectExp();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.SelectExp#getSymbol <em>Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Symbol</em>'.
   * @see gdsl.plugin.gDSL.SelectExp#getSymbol()
   * @see #getSelectExp()
   * @generated
   */
  EAttribute getSelectExp_Symbol();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.SelectExp#getApplyexps <em>Applyexps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Applyexps</em>'.
   * @see gdsl.plugin.gDSL.SelectExp#getApplyexps()
   * @see #getSelectExp()
   * @generated
   */
  EReference getSelectExp_Applyexps();

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
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ApplyExp#getAtomicExp <em>Atomic Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Atomic Exp</em>'.
   * @see gdsl.plugin.gDSL.ApplyExp#getAtomicExp()
   * @see #getApplyExp()
   * @generated
   */
  EReference getApplyExp_AtomicExp();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ApplyExp#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see gdsl.plugin.gDSL.ApplyExp#getArgs()
   * @see #getApplyExp()
   * @generated
   */
  EReference getApplyExp_Args();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.Args <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Args</em>'.
   * @see gdsl.plugin.gDSL.Args
   * @generated
   */
  EClass getArgs();

  /**
   * Returns the meta object for the containment reference list '{@link gdsl.plugin.gDSL.Args#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see gdsl.plugin.gDSL.Args#getArgs()
   * @see #getArgs()
   * @generated
   */
  EReference getArgs_Args();

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
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.AtomicExp#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see gdsl.plugin.gDSL.AtomicExp#getExpr()
   * @see #getAtomicExp()
   * @generated
   */
  EReference getAtomicExp_Expr();

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
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.ValueDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gdsl.plugin.gDSL.ValueDecl#getName()
   * @see #getValueDecl()
   * @generated
   */
  EAttribute getValueDecl_Name();

  /**
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.ValueDecl#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see gdsl.plugin.gDSL.ValueDecl#getIds()
   * @see #getValueDecl()
   * @generated
   */
  EAttribute getValueDecl_Ids();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.ValueDecl#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.ValueDecl#getExp()
   * @see #getValueDecl()
   * @generated
   */
  EReference getValueDecl_Exp();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.PAT <em>PAT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PAT</em>'.
   * @see gdsl.plugin.gDSL.PAT
   * @generated
   */
  EClass getPAT();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.PAT#getUscore <em>Uscore</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uscore</em>'.
   * @see gdsl.plugin.gDSL.PAT#getUscore()
   * @see #getPAT()
   * @generated
   */
  EAttribute getPAT_Uscore();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.PAT#getInt <em>Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int</em>'.
   * @see gdsl.plugin.gDSL.PAT#getInt()
   * @see #getPAT()
   * @generated
   */
  EAttribute getPAT_Int();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.PAT#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see gdsl.plugin.gDSL.PAT#getId()
   * @see #getPAT()
   * @generated
   */
  EAttribute getPAT_Id();

  /**
   * Returns the meta object for the containment reference '{@link gdsl.plugin.gDSL.PAT#getPat <em>Pat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pat</em>'.
   * @see gdsl.plugin.gDSL.PAT#getPat()
   * @see #getPAT()
   * @generated
   */
  EReference getPAT_Pat();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.PAT#getBitpat <em>Bitpat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bitpat</em>'.
   * @see gdsl.plugin.gDSL.PAT#getBitpat()
   * @see #getPAT()
   * @generated
   */
  EAttribute getPAT_Bitpat();

  /**
   * Returns the meta object for class '{@link gdsl.plugin.gDSL.CONS <em>CONS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CONS</em>'.
   * @see gdsl.plugin.gDSL.CONS
   * @generated
   */
  EClass getCONS();

  /**
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.CONS#getConName <em>Con Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Con Name</em>'.
   * @see gdsl.plugin.gDSL.CONS#getConName()
   * @see #getCONS()
   * @generated
   */
  EAttribute getCONS_ConName();

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
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.DeclExportImpl <em>Decl Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.DeclExportImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getDeclExport()
     * @generated
     */
    EClass DECL_EXPORT = eINSTANCE.getDeclExport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_EXPORT__NAME = eINSTANCE.getDeclExport_Name();

    /**
     * The meta object literal for the '<em><b>Ty Vars</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_EXPORT__TY_VARS = eINSTANCE.getDeclExport_TyVars();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_EXPORT__TYPE = eINSTANCE.getDeclExport_Type();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TypeImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '<em><b>Ty Vars</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__TY_VARS = eINSTANCE.getType_TyVars();

    /**
     * The meta object literal for the '<em><b>Con Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__CON_DECL = eINSTANCE.getType_ConDecl();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__VALUE = eINSTANCE.getType_Value();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ValImpl <em>Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ValImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getVal()
     * @generated
     */
    EClass VAL = eINSTANCE.getVal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAL__NAME = eINSTANCE.getVal_Name();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAL__ATTR = eINSTANCE.getVal_Attr();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAL__EXP = eINSTANCE.getVal_Exp();

    /**
     * The meta object literal for the '<em><b>Mid</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAL__MID = eINSTANCE.getVal_Mid();

    /**
     * The meta object literal for the '<em><b>Dec Pat</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAL__DEC_PAT = eINSTANCE.getVal_DecPat();

    /**
     * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAL__EXPS = eINSTANCE.getVal_Exps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.TyVarsImpl <em>Ty Vars</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.TyVarsImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getTyVars()
     * @generated
     */
    EClass TY_VARS = eINSTANCE.getTyVars();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY_VARS__ATTR = eINSTANCE.getTyVars_Attr();

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
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CON_DECL__NAME = eINSTANCE.getConDecl_Name();

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
     * The meta object literal for the '<em><b>Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__TYPE_REF = eINSTANCE.getTy_TypeRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TY__TYPE = eINSTANCE.getTy_Type();

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
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__PARAM = eINSTANCE.getTy_Param();

    /**
     * The meta object literal for the '<em><b>Res Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__RES_TYPE = eINSTANCE.getTy_ResType();

    /**
     * The meta object literal for the '<em><b>R</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__R = eINSTANCE.getTy_R();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__IN = eINSTANCE.getTy_In();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY__OUT = eINSTANCE.getTy_Out();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TY_BIND__NAME = eINSTANCE.getTyBind_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TY_BIND__VALUE = eINSTANCE.getTyBind_Value();

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
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ExpImpl <em>Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getExp()
     * @generated
     */
    EClass EXP = eINSTANCE.getExp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXP__NAME = eINSTANCE.getExp_Name();

    /**
     * The meta object literal for the '<em><b>Mid</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXP__MID = eINSTANCE.getExp_Mid();

    /**
     * The meta object literal for the '<em><b>Case Exps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXP__CASE_EXPS = eINSTANCE.getExp_CaseExps();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_EXP__NAME = eINSTANCE.getCaseExp_Name();

    /**
     * The meta object literal for the '<em><b>Closed Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXP__CLOSED_EXP = eINSTANCE.getCaseExp_ClosedExp();

    /**
     * The meta object literal for the '<em><b>Pat</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXP__PAT = eINSTANCE.getCaseExp_Pat();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXP__EXP = eINSTANCE.getCaseExp_Exp();

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
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.AExpImpl <em>AExp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.AExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getAExp()
     * @generated
     */
    EClass AEXP = eINSTANCE.getAExp();

    /**
     * The meta object literal for the '<em><b>Sym</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AEXP__SYM = eINSTANCE.getAExp_Sym();

    /**
     * The meta object literal for the '<em><b>Aexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AEXP__AEXPS = eINSTANCE.getAExp_Aexps();

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
     * The meta object literal for the '<em><b>Sign</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEXP__SIGN = eINSTANCE.getMExp_Sign();

    /**
     * The meta object literal for the '<em><b>Mexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEXP__MEXPS = eINSTANCE.getMExp_Mexps();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.SelectExpImpl <em>Select Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.SelectExpImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getSelectExp()
     * @generated
     */
    EClass SELECT_EXP = eINSTANCE.getSelectExp();

    /**
     * The meta object literal for the '<em><b>Symbol</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SELECT_EXP__SYMBOL = eINSTANCE.getSelectExp_Symbol();

    /**
     * The meta object literal for the '<em><b>Applyexps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECT_EXP__APPLYEXPS = eINSTANCE.getSelectExp_Applyexps();

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
     * The meta object literal for the '<em><b>Atomic Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLY_EXP__ATOMIC_EXP = eINSTANCE.getApplyExp_AtomicExp();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLY_EXP__ARGS = eINSTANCE.getApplyExp_Args();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.ArgsImpl <em>Args</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.ArgsImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getArgs()
     * @generated
     */
    EClass ARGS = eINSTANCE.getArgs();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGS__ARGS = eINSTANCE.getArgs_Args();

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
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EXP__EXPR = eINSTANCE.getAtomicExp_Expr();

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

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_DECL__NAME = eINSTANCE.getValueDecl_Name();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_DECL__IDS = eINSTANCE.getValueDecl_Ids();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_DECL__EXP = eINSTANCE.getValueDecl_Exp();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.PATImpl <em>PAT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.PATImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getPAT()
     * @generated
     */
    EClass PAT = eINSTANCE.getPAT();

    /**
     * The meta object literal for the '<em><b>Uscore</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAT__USCORE = eINSTANCE.getPAT_Uscore();

    /**
     * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAT__INT = eINSTANCE.getPAT_Int();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAT__ID = eINSTANCE.getPAT_Id();

    /**
     * The meta object literal for the '<em><b>Pat</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAT__PAT = eINSTANCE.getPAT_Pat();

    /**
     * The meta object literal for the '<em><b>Bitpat</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAT__BITPAT = eINSTANCE.getPAT_Bitpat();

    /**
     * The meta object literal for the '{@link gdsl.plugin.gDSL.impl.CONSImpl <em>CONS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gdsl.plugin.gDSL.impl.CONSImpl
     * @see gdsl.plugin.gDSL.impl.GDSLPackageImpl#getCONS()
     * @generated
     */
    EClass CONS = eINSTANCE.getCONS();

    /**
     * The meta object literal for the '<em><b>Con Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONS__CON_NAME = eINSTANCE.getCONS_ConName();

  }

} //GDSLPackage
