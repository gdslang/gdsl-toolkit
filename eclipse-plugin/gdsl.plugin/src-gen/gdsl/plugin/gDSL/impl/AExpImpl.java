/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.AExp;
import gdsl.plugin.gDSL.GDSLPackage;

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
 * An implementation of the model object '<em><b>AExp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.AExpImpl#getSym <em>Sym</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AExpImpl#getAexps <em>Aexps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AExpImpl extends RExpImpl implements AExp
{
  /**
   * The cached value of the '{@link #getSym() <em>Sym</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSym()
   * @generated
   * @ordered
   */
  protected EList<String> sym;

  /**
   * The cached value of the '{@link #getAexps() <em>Aexps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAexps()
   * @generated
   * @ordered
   */
  protected EList<AExp> aexps;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AExpImpl()
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
    return GDSLPackage.Literals.AEXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSym()
  {
    if (sym == null)
    {
      sym = new EDataTypeEList<String>(String.class, this, GDSLPackage.AEXP__SYM);
    }
    return sym;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AExp> getAexps()
  {
    if (aexps == null)
    {
      aexps = new EObjectContainmentEList<AExp>(AExp.class, this, GDSLPackage.AEXP__AEXPS);
    }
    return aexps;
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
      case GDSLPackage.AEXP__AEXPS:
        return ((InternalEList<?>)getAexps()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.AEXP__SYM:
        return getSym();
      case GDSLPackage.AEXP__AEXPS:
        return getAexps();
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
      case GDSLPackage.AEXP__SYM:
        getSym().clear();
        getSym().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.AEXP__AEXPS:
        getAexps().clear();
        getAexps().addAll((Collection<? extends AExp>)newValue);
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
      case GDSLPackage.AEXP__SYM:
        getSym().clear();
        return;
      case GDSLPackage.AEXP__AEXPS:
        getAexps().clear();
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
      case GDSLPackage.AEXP__SYM:
        return sym != null && !sym.isEmpty();
      case GDSLPackage.AEXP__AEXPS:
        return aexps != null && !aexps.isEmpty();
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
    result.append(" (sym: ");
    result.append(sym);
    result.append(')');
    return result.toString();
  }

} //AExpImpl
