/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.DeclVal;
import gdsl.plugin.gDSL.GDSLPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decl Val</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclValImpl#getAttr <em>Attr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclValImpl extends DeclImpl implements DeclVal
{
  /**
   * The cached value of the '{@link #getAttr() <em>Attr</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttr()
   * @generated
   * @ordered
   */
  protected EList<String> attr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclValImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GDSLPackage.Literals.DECL_VAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAttr()
  {
    if (attr == null)
    {
      attr = new EDataTypeEList<String>(String.class, this, GDSLPackage.DECL_VAL__ATTR);
    }
    return attr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_VAL__ATTR:
        return getAttr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_VAL__ATTR:
        getAttr().clear();
        getAttr().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_VAL__ATTR:
        getAttr().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_VAL__ATTR:
        return attr != null && !attr.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (attr: ");
    result.append(attr);
    result.append(')');
    return result.toString();
  }

} //DeclValImpl
