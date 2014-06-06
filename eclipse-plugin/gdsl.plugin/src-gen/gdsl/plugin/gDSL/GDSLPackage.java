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
   * The feature id for the '<em><b>Exp</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__EXP = DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dec Pat</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__DEC_PAT = DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Exps</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL__EXPS = DECL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Decl Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_VAL_FEATURE_COUNT = DECL_FEATURE_COUNT + 4;

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
   * Returns the meta object for the attribute '{@link gdsl.plugin.gDSL.DeclVal#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exp</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getExp()
   * @see #getDeclVal()
   * @generated
   */
  EAttribute getDeclVal_Exp();

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
   * Returns the meta object for the attribute list '{@link gdsl.plugin.gDSL.DeclVal#getExps <em>Exps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Exps</em>'.
   * @see gdsl.plugin.gDSL.DeclVal#getExps()
   * @see #getDeclVal()
   * @generated
   */
  EAttribute getDeclVal_Exps();

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
     * The meta object literal for the '<em><b>Exp</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_VAL__EXP = eINSTANCE.getDeclVal_Exp();

    /**
     * The meta object literal for the '<em><b>Dec Pat</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL_VAL__DEC_PAT = eINSTANCE.getDeclVal_DecPat();

    /**
     * The meta object literal for the '<em><b>Exps</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL_VAL__EXPS = eINSTANCE.getDeclVal_Exps();

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

  }

} //GDSLPackage
