/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.MExp;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MExp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.MExpImpl#getApplyexps <em>Applyexps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MExpImpl extends MinimalEObjectImpl.Container implements MExp
{
  /**
   * The cached value of the '{@link #getApplyexps() <em>Applyexps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplyexps()
   * @generated
   * @ordered
   */
  protected EList<ApplyExp> applyexps;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MExpImpl()
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
    return GDSLPackage.Literals.MEXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ApplyExp> getApplyexps()
  {
    if (applyexps == null)
    {
      applyexps = new EObjectContainmentEList<ApplyExp>(ApplyExp.class, this, GDSLPackage.MEXP__APPLYEXPS);
    }
    return applyexps;
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
      case GDSLPackage.MEXP__APPLYEXPS:
        return ((InternalEList<?>)getApplyexps()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.MEXP__APPLYEXPS:
        return getApplyexps();
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
      case GDSLPackage.MEXP__APPLYEXPS:
        getApplyexps().clear();
        getApplyexps().addAll((Collection<? extends ApplyExp>)newValue);
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
      case GDSLPackage.MEXP__APPLYEXPS:
        getApplyexps().clear();
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
      case GDSLPackage.MEXP__APPLYEXPS:
        return applyexps != null && !applyexps.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MExpImpl
