/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.CaseExp;
import gdsl.plugin.gDSL.ClosedExp;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.PAT;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getClosedExp <em>Closed Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getPat <em>Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.CaseExpImpl#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseExpImpl extends MinimalEObjectImpl.Container implements CaseExp
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
   * The cached value of the '{@link #getPat() <em>Pat</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPat()
   * @generated
   * @ordered
   */
  protected EList<PAT> pat;

  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected EList<Exp> exp;

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
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.CASE_EXP__NAME, oldName, name));
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
  public EList<PAT> getPat()
  {
    if (pat == null)
    {
      pat = new EObjectContainmentEList<PAT>(PAT.class, this, GDSLPackage.CASE_EXP__PAT);
    }
    return pat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Exp> getExp()
  {
    if (exp == null)
    {
      exp = new EObjectContainmentEList<Exp>(Exp.class, this, GDSLPackage.CASE_EXP__EXP);
    }
    return exp;
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
      case GDSLPackage.CASE_EXP__PAT:
        return ((InternalEList<?>)getPat()).basicRemove(otherEnd, msgs);
      case GDSLPackage.CASE_EXP__EXP:
        return ((InternalEList<?>)getExp()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.CASE_EXP__NAME:
        return getName();
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        return getClosedExp();
      case GDSLPackage.CASE_EXP__PAT:
        return getPat();
      case GDSLPackage.CASE_EXP__EXP:
        return getExp();
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
      case GDSLPackage.CASE_EXP__NAME:
        setName((String)newValue);
        return;
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        setClosedExp((ClosedExp)newValue);
        return;
      case GDSLPackage.CASE_EXP__PAT:
        getPat().clear();
        getPat().addAll((Collection<? extends PAT>)newValue);
        return;
      case GDSLPackage.CASE_EXP__EXP:
        getExp().clear();
        getExp().addAll((Collection<? extends Exp>)newValue);
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
      case GDSLPackage.CASE_EXP__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        setClosedExp((ClosedExp)null);
        return;
      case GDSLPackage.CASE_EXP__PAT:
        getPat().clear();
        return;
      case GDSLPackage.CASE_EXP__EXP:
        getExp().clear();
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
      case GDSLPackage.CASE_EXP__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GDSLPackage.CASE_EXP__CLOSED_EXP:
        return closedExp != null;
      case GDSLPackage.CASE_EXP__PAT:
        return pat != null && !pat.isEmpty();
      case GDSLPackage.CASE_EXP__EXP:
        return exp != null && !exp.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CaseExpImpl
