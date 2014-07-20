/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.AtomicExp;
import gdsl.plugin.gDSL.GDSLPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Apply Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ApplyExpImpl#getAtomicExp <em>Atomic Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplyExpImpl extends SelectExpImpl implements ApplyExp
{
  /**
   * The cached value of the '{@link #getAtomicExp() <em>Atomic Exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtomicExp()
   * @generated
   * @ordered
   */
  protected EList<AtomicExp> atomicExp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplyExpImpl()
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
    return GDSLPackage.Literals.APPLY_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AtomicExp> getAtomicExp()
  {
    if (atomicExp == null)
    {
      atomicExp = new EObjectContainmentEList<AtomicExp>(AtomicExp.class, this, GDSLPackage.APPLY_EXP__ATOMIC_EXP);
    }
    return atomicExp;
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        return ((InternalEList<?>)getAtomicExp()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        return getAtomicExp();
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        getAtomicExp().clear();
        getAtomicExp().addAll((Collection<? extends AtomicExp>)newValue);
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        getAtomicExp().clear();
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        return atomicExp != null && !atomicExp.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ApplyExpImpl
