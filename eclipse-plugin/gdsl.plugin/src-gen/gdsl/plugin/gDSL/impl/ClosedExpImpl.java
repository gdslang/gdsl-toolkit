/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.ClosedExp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.MonadicExp;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Closed Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ClosedExpImpl#getIfCaseExp <em>If Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ClosedExpImpl#getThenCaseExp <em>Then Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ClosedExpImpl#getElseCaseExp <em>Else Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ClosedExpImpl#getDoExp <em>Do Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClosedExpImpl extends CaseExpImpl implements ClosedExp
{
  /**
   * The cached value of the '{@link #getIfCaseExp() <em>If Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfCaseExp()
   * @generated
   * @ordered
   */
  protected CaseExp ifCaseExp;

  /**
   * The cached value of the '{@link #getThenCaseExp() <em>Then Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenCaseExp()
   * @generated
   * @ordered
   */
  protected CaseExp thenCaseExp;

  /**
   * The cached value of the '{@link #getElseCaseExp() <em>Else Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseCaseExp()
   * @generated
   * @ordered
   */
  protected CaseExp elseCaseExp;

  /**
   * The cached value of the '{@link #getDoExp() <em>Do Exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoExp()
   * @generated
   * @ordered
   */
  protected EList<MonadicExp> doExp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClosedExpImpl()
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
    return GDSLPackage.Literals.CLOSED_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExp getIfCaseExp()
  {
    return ifCaseExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfCaseExp(CaseExp newIfCaseExp, NotificationChain msgs)
  {
    CaseExp oldIfCaseExp = ifCaseExp;
    ifCaseExp = newIfCaseExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__IF_CASE_EXP, oldIfCaseExp, newIfCaseExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfCaseExp(CaseExp newIfCaseExp)
  {
    if (newIfCaseExp != ifCaseExp)
    {
      NotificationChain msgs = null;
      if (ifCaseExp != null)
        msgs = ((InternalEObject)ifCaseExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__IF_CASE_EXP, null, msgs);
      if (newIfCaseExp != null)
        msgs = ((InternalEObject)newIfCaseExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__IF_CASE_EXP, null, msgs);
      msgs = basicSetIfCaseExp(newIfCaseExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__IF_CASE_EXP, newIfCaseExp, newIfCaseExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExp getThenCaseExp()
  {
    return thenCaseExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenCaseExp(CaseExp newThenCaseExp, NotificationChain msgs)
  {
    CaseExp oldThenCaseExp = thenCaseExp;
    thenCaseExp = newThenCaseExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__THEN_CASE_EXP, oldThenCaseExp, newThenCaseExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenCaseExp(CaseExp newThenCaseExp)
  {
    if (newThenCaseExp != thenCaseExp)
    {
      NotificationChain msgs = null;
      if (thenCaseExp != null)
        msgs = ((InternalEObject)thenCaseExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__THEN_CASE_EXP, null, msgs);
      if (newThenCaseExp != null)
        msgs = ((InternalEObject)newThenCaseExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__THEN_CASE_EXP, null, msgs);
      msgs = basicSetThenCaseExp(newThenCaseExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__THEN_CASE_EXP, newThenCaseExp, newThenCaseExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExp getElseCaseExp()
  {
    return elseCaseExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseCaseExp(CaseExp newElseCaseExp, NotificationChain msgs)
  {
    CaseExp oldElseCaseExp = elseCaseExp;
    elseCaseExp = newElseCaseExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP, oldElseCaseExp, newElseCaseExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseCaseExp(CaseExp newElseCaseExp)
  {
    if (newElseCaseExp != elseCaseExp)
    {
      NotificationChain msgs = null;
      if (elseCaseExp != null)
        msgs = ((InternalEObject)elseCaseExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP, null, msgs);
      if (newElseCaseExp != null)
        msgs = ((InternalEObject)newElseCaseExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP, null, msgs);
      msgs = basicSetElseCaseExp(newElseCaseExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP, newElseCaseExp, newElseCaseExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MonadicExp> getDoExp()
  {
    if (doExp == null)
    {
      doExp = new EObjectContainmentEList<MonadicExp>(MonadicExp.class, this, GDSLPackage.CLOSED_EXP__DO_EXP);
    }
    return doExp;
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
      case GDSLPackage.CLOSED_EXP__IF_CASE_EXP:
        return basicSetIfCaseExp(null, msgs);
      case GDSLPackage.CLOSED_EXP__THEN_CASE_EXP:
        return basicSetThenCaseExp(null, msgs);
      case GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP:
        return basicSetElseCaseExp(null, msgs);
      case GDSLPackage.CLOSED_EXP__DO_EXP:
        return ((InternalEList<?>)getDoExp()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.CLOSED_EXP__IF_CASE_EXP:
        return getIfCaseExp();
      case GDSLPackage.CLOSED_EXP__THEN_CASE_EXP:
        return getThenCaseExp();
      case GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP:
        return getElseCaseExp();
      case GDSLPackage.CLOSED_EXP__DO_EXP:
        return getDoExp();
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
      case GDSLPackage.CLOSED_EXP__IF_CASE_EXP:
        setIfCaseExp((CaseExp)newValue);
        return;
      case GDSLPackage.CLOSED_EXP__THEN_CASE_EXP:
        setThenCaseExp((CaseExp)newValue);
        return;
      case GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP:
        setElseCaseExp((CaseExp)newValue);
        return;
      case GDSLPackage.CLOSED_EXP__DO_EXP:
        getDoExp().clear();
        getDoExp().addAll((Collection<? extends MonadicExp>)newValue);
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
      case GDSLPackage.CLOSED_EXP__IF_CASE_EXP:
        setIfCaseExp((CaseExp)null);
        return;
      case GDSLPackage.CLOSED_EXP__THEN_CASE_EXP:
        setThenCaseExp((CaseExp)null);
        return;
      case GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP:
        setElseCaseExp((CaseExp)null);
        return;
      case GDSLPackage.CLOSED_EXP__DO_EXP:
        getDoExp().clear();
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
      case GDSLPackage.CLOSED_EXP__IF_CASE_EXP:
        return ifCaseExp != null;
      case GDSLPackage.CLOSED_EXP__THEN_CASE_EXP:
        return thenCaseExp != null;
      case GDSLPackage.CLOSED_EXP__ELSE_CASE_EXP:
        return elseCaseExp != null;
      case GDSLPackage.CLOSED_EXP__DO_EXP:
        return doExp != null && !doExp.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClosedExpImpl
