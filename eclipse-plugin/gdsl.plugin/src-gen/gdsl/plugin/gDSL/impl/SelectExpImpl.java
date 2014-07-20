/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.SelectExp;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.SelectExpImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.SelectExpImpl#getApplyexps <em>Applyexps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectExpImpl extends MExpImpl implements SelectExp
{
  /**
   * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected EList<String> symbol;

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
  protected SelectExpImpl()
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
    return GDSLPackage.Literals.SELECT_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSymbol()
  {
    if (symbol == null)
    {
      symbol = new EDataTypeEList<String>(String.class, this, GDSLPackage.SELECT_EXP__SYMBOL);
    }
    return symbol;
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
      applyexps = new EObjectContainmentEList<ApplyExp>(ApplyExp.class, this, GDSLPackage.SELECT_EXP__APPLYEXPS);
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
      case GDSLPackage.SELECT_EXP__APPLYEXPS:
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
      case GDSLPackage.SELECT_EXP__SYMBOL:
        return getSymbol();
      case GDSLPackage.SELECT_EXP__APPLYEXPS:
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
      case GDSLPackage.SELECT_EXP__SYMBOL:
        getSymbol().clear();
        getSymbol().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.SELECT_EXP__APPLYEXPS:
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
      case GDSLPackage.SELECT_EXP__SYMBOL:
        getSymbol().clear();
        return;
      case GDSLPackage.SELECT_EXP__APPLYEXPS:
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
      case GDSLPackage.SELECT_EXP__SYMBOL:
        return symbol != null && !symbol.isEmpty();
      case GDSLPackage.SELECT_EXP__APPLYEXPS:
        return applyexps != null && !applyexps.isEmpty();
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
    result.append(" (symbol: ");
    result.append(symbol);
    result.append(')');
    return result.toString();
  }

} //SelectExpImpl
