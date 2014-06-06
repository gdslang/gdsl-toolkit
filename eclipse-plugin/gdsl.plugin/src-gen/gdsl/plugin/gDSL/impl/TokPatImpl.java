/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.TokPat;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tok Pat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.TokPatImpl#getTokPat <em>Tok Pat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokPatImpl extends DecodePatImpl implements TokPat
{
  /**
   * The default value of the '{@link #getTokPat() <em>Tok Pat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokPat()
   * @generated
   * @ordered
   */
  protected static final String TOK_PAT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTokPat() <em>Tok Pat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokPat()
   * @generated
   * @ordered
   */
  protected String tokPat = TOK_PAT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TokPatImpl()
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
    return GDSLPackage.Literals.TOK_PAT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTokPat()
  {
    return tokPat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTokPat(String newTokPat)
  {
    String oldTokPat = tokPat;
    tokPat = newTokPat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TOK_PAT__TOK_PAT, oldTokPat, tokPat));
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
      case GDSLPackage.TOK_PAT__TOK_PAT:
        return getTokPat();
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
      case GDSLPackage.TOK_PAT__TOK_PAT:
        setTokPat((String)newValue);
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
      case GDSLPackage.TOK_PAT__TOK_PAT:
        setTokPat(TOK_PAT_EDEFAULT);
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
      case GDSLPackage.TOK_PAT__TOK_PAT:
        return TOK_PAT_EDEFAULT == null ? tokPat != null : !TOK_PAT_EDEFAULT.equals(tokPat);
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
    result.append(" (tokPat: ");
    result.append(tokPat);
    result.append(')');
    return result.toString();
  }

} //TokPatImpl
