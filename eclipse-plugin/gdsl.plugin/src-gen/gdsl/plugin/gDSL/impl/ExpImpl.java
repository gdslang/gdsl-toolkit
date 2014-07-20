/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.GDSLPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ExpImpl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ExpImpl#getMid <em>Mid</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ExpImpl#getCaseExps <em>Case Exps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpImpl extends MinimalEObjectImpl.Container implements Exp
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected CaseExp name;

  /**
   * The cached value of the '{@link #getMid() <em>Mid</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMid()
   * @generated
   * @ordered
   */
  protected EList<String> mid;

  /**
   * The cached value of the '{@link #getCaseExps() <em>Case Exps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCaseExps()
   * @generated
   * @ordered
   */
  protected EList<CaseExp> caseExps;

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
  public CaseExp getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(CaseExp newName, NotificationChain msgs)
  {
    CaseExp oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.EXP__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(CaseExp newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.EXP__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.EXP__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.EXP__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMid()
  {
    if (mid == null)
    {
      mid = new EDataTypeEList<String>(String.class, this, GDSLPackage.EXP__MID);
    }
    return mid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CaseExp> getCaseExps()
  {
    if (caseExps == null)
    {
      caseExps = new EObjectContainmentEList<CaseExp>(CaseExp.class, this, GDSLPackage.EXP__CASE_EXPS);
    }
    return caseExps;
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
      case GDSLPackage.EXP__NAME:
        return basicSetName(null, msgs);
      case GDSLPackage.EXP__CASE_EXPS:
        return ((InternalEList<?>)getCaseExps()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.EXP__NAME:
        return getName();
      case GDSLPackage.EXP__MID:
        return getMid();
      case GDSLPackage.EXP__CASE_EXPS:
        return getCaseExps();
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
      case GDSLPackage.EXP__NAME:
        setName((CaseExp)newValue);
        return;
      case GDSLPackage.EXP__MID:
        getMid().clear();
        getMid().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.EXP__CASE_EXPS:
        getCaseExps().clear();
        getCaseExps().addAll((Collection<? extends CaseExp>)newValue);
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
      case GDSLPackage.EXP__NAME:
        setName((CaseExp)null);
        return;
      case GDSLPackage.EXP__MID:
        getMid().clear();
        return;
      case GDSLPackage.EXP__CASE_EXPS:
        getCaseExps().clear();
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
      case GDSLPackage.EXP__NAME:
        return name != null;
      case GDSLPackage.EXP__MID:
        return mid != null && !mid.isEmpty();
      case GDSLPackage.EXP__CASE_EXPS:
        return caseExps != null && !caseExps.isEmpty();
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
