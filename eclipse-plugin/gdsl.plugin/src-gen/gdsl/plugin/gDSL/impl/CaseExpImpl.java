/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.Cases;
import gdsl.plugin.gDSL.ClosedExp;
import gdsl.plugin.gDSL.GDSLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getClosedExp <em>Closed Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getCases <em>Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseExpImpl extends MinimalEObjectImpl.Container implements CaseExp
{
  /**
   * The cached value of the '{@link #getClosedExp() <em>Closed Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClosedExp()
   * @generated
   * @ordered
   */
  protected ClosedExp closedExp;

  /**
   * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCases()
   * @generated
   * @ordered
   */
  protected Cases cases;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CaseExpImpl()
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
    return GDSLPackage.Literals.CASE_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClosedExp getClosedExp()
  {
    return closedExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClosedExp(ClosedExp newClosedExp, NotificationChain msgs)
  {
    ClosedExp oldClosedExp = closedExp;
    closedExp = newClosedExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.CASE_EXP__CLOSED_EXP, oldClosedExp, newClosedExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClosedExp(ClosedExp newClosedExp)
  {
    if (newClosedExp != closedExp)
    {
      NotificationChain msgs = null;
      if (closedExp != null)
        msgs = ((InternalEObject)closedExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CASE_EXP__CLOSED_EXP, null, msgs);
      if (newClosedExp != null)
        msgs = ((InternalEObject)newClosedExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CASE_EXP__CLOSED_EXP, null, msgs);
      msgs = basicSetClosedExp(newClosedExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CASE_EXP__CLOSED_EXP, newClosedExp, newClosedExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cases getCases()
  {
    return cases;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCases(Cases newCases, NotificationChain msgs)
  {
    Cases oldCases = cases;
    cases = newCases;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.CASE_EXP__CASES, oldCases, newCases);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCases(Cases newCases)
  {
    if (newCases != cases)
    {
      NotificationChain msgs = null;
      if (cases != null)
        msgs = ((InternalEObject)cases).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CASE_EXP__CASES, null, msgs);
      if (newCases != null)
        msgs = ((InternalEObject)newCases).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CASE_EXP__CASES, null, msgs);
      msgs = basicSetCases(newCases, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CASE_EXP__CASES, newCases, newCases));
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
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        return basicSetClosedExp(null, msgs);
      case GDSLPackage.CASE_EXP__CASES:
        return basicSetCases(null, msgs);
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
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        return getClosedExp();
      case GDSLPackage.CASE_EXP__CASES:
        return getCases();
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
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        setClosedExp((ClosedExp)newValue);
        return;
      case GDSLPackage.CASE_EXP__CASES:
        setCases((Cases)newValue);
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
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        setClosedExp((ClosedExp)null);
        return;
      case GDSLPackage.CASE_EXP__CASES:
        setCases((Cases)null);
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
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        return closedExp != null;
      case GDSLPackage.CASE_EXP__CASES:
        return cases != null;
    }
    return super.eIsSet(featureID);
  }

} //CaseExpImpl
