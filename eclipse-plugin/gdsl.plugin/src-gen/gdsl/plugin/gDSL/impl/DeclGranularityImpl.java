/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.DeclGranularity;
import gdsl.plugin.gDSL.GDSLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decl Granularity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclGranularityImpl#getGranularity <em>Granularity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclGranularityImpl extends DeclImpl implements DeclGranularity
{
  /**
   * The default value of the '{@link #getGranularity() <em>Granularity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGranularity()
   * @generated
   * @ordered
   */
  protected static final String GRANULARITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGranularity() <em>Granularity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGranularity()
   * @generated
   * @ordered
   */
  protected String granularity = GRANULARITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclGranularityImpl()
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
    return GDSLPackage.Literals.DECL_GRANULARITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGranularity()
  {
    return granularity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGranularity(String newGranularity)
  {
    String oldGranularity = granularity;
    granularity = newGranularity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_GRANULARITY__GRANULARITY, oldGranularity, granularity));
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
      case GDSLPackage.DECL_GRANULARITY__GRANULARITY:
        return getGranularity();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_GRANULARITY__GRANULARITY:
        setGranularity((String)newValue);
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
      case GDSLPackage.DECL_GRANULARITY__GRANULARITY:
        setGranularity(GRANULARITY_EDEFAULT);
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
      case GDSLPackage.DECL_GRANULARITY__GRANULARITY:
        return GRANULARITY_EDEFAULT == null ? granularity != null : !GRANULARITY_EDEFAULT.equals(granularity);
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
    result.append(" (granularity: ");
    result.append(granularity);
    result.append(')');
    return result.toString();
  }

} //DeclGranularityImpl
