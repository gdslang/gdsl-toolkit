/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.MExp;

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
 * An implementation of the model object '<em><b>MExp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.MExpImpl#getSign <em>Sign</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.MExpImpl#getMexps <em>Mexps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MExpImpl extends AExpImpl implements MExp
{
  /**
   * The cached value of the '{@link #getSign() <em>Sign</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSign()
   * @generated
   * @ordered
   */
  protected EList<String> sign;

  /**
   * The cached value of the '{@link #getMexps() <em>Mexps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMexps()
   * @generated
   * @ordered
   */
  protected EList<MExp> mexps;

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
  public EList<String> getSign()
  {
    if (sign == null)
    {
      sign = new EDataTypeEList<String>(String.class, this, GDSLPackage.MEXP__SIGN);
    }
    return sign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MExp> getMexps()
  {
    if (mexps == null)
    {
      mexps = new EObjectContainmentEList<MExp>(MExp.class, this, GDSLPackage.MEXP__MEXPS);
    }
    return mexps;
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
      case GDSLPackage.MEXP__MEXPS:
        return ((InternalEList<?>)getMexps()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.MEXP__SIGN:
        return getSign();
      case GDSLPackage.MEXP__MEXPS:
        return getMexps();
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
      case GDSLPackage.MEXP__SIGN:
        getSign().clear();
        getSign().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.MEXP__MEXPS:
        getMexps().clear();
        getMexps().addAll((Collection<? extends MExp>)newValue);
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
      case GDSLPackage.MEXP__SIGN:
        getSign().clear();
        return;
      case GDSLPackage.MEXP__MEXPS:
        getMexps().clear();
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
      case GDSLPackage.MEXP__SIGN:
        return sign != null && !sign.isEmpty();
      case GDSLPackage.MEXP__MEXPS:
        return mexps != null && !mexps.isEmpty();
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
    result.append(" (sign: ");
    result.append(sign);
    result.append(')');
    return result.toString();
  }

} //MExpImpl
