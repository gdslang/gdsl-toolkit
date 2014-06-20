/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.GDSLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ExpImpl#getCaseExp <em>Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ExpImpl#getMid <em>Mid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpImpl extends MinimalEObjectImpl.Container implements Exp
{
  /**
   * The cached value of the '{@link #getCaseExp() <em>Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCaseExp()
   * @generated
   * @ordered
   */
  protected CaseExp caseExp;

  /**
   * The default value of the '{@link #getMid() <em>Mid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMid()
   * @generated
   * @ordered
   */
  protected static final String MID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMid() <em>Mid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMid()
   * @generated
   * @ordered
   */
  protected String mid = MID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpImpl()
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
    return GDSLPackage.Literals.EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExp getCaseExp()
  {
    return caseExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCaseExp(CaseExp newCaseExp, NotificationChain msgs)
  {
    CaseExp oldCaseExp = caseExp;
    caseExp = newCaseExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.EXP__CASE_EXP, oldCaseExp, newCaseExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCaseExp(CaseExp newCaseExp)
  {
    if (newCaseExp != caseExp)
    {
      NotificationChain msgs = null;
      if (caseExp != null)
        msgs = ((InternalEObject)caseExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.EXP__CASE_EXP, null, msgs);
      if (newCaseExp != null)
        msgs = ((InternalEObject)newCaseExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.EXP__CASE_EXP, null, msgs);
      msgs = basicSetCaseExp(newCaseExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.EXP__CASE_EXP, newCaseExp, newCaseExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMid()
  {
    return mid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMid(String newMid)
  {
    String oldMid = mid;
    mid = newMid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.EXP__MID, oldMid, mid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GDSLPackage.EXP__CASE_EXP:
        return basicSetCaseExp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GDSLPackage.EXP__CASE_EXP:
        return getCaseExp();
      case GDSLPackage.EXP__MID:
        return getMid();
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
      case GDSLPackage.EXP__CASE_EXP:
        setCaseExp((CaseExp)newValue);
        return;
      case GDSLPackage.EXP__MID:
        setMid((String)newValue);
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
      case GDSLPackage.EXP__CASE_EXP:
        setCaseExp((CaseExp)null);
        return;
      case GDSLPackage.EXP__MID:
        setMid(MID_EDEFAULT);
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
      case GDSLPackage.EXP__CASE_EXP:
        return caseExp != null;
      case GDSLPackage.EXP__MID:
        return MID_EDEFAULT == null ? mid != null : !MID_EDEFAULT.equals(mid);
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
    result.append(" (mid: ");
    result.append(mid);
    result.append(')');
    return result.toString();
  }

} //ExpImpl
