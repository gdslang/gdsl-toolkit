/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Ty;
import gdsl.plugin.gDSL.TyBind;
import gdsl.plugin.gDSL.TyElement;

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
 * An implementation of the model object '<em><b>Ty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getTyBind <em>Ty Bind</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TyImpl extends MinimalEObjectImpl.Container implements Ty
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTyBind() <em>Ty Bind</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTyBind()
   * @generated
   * @ordered
   */
  protected EList<TyBind> tyBind;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<TyElement> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TyImpl()
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
    return GDSLPackage.Literals.TY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TyBind> getTyBind()
  {
    if (tyBind == null)
    {
      tyBind = new EObjectContainmentEList<TyBind>(TyBind.class, this, GDSLPackage.TY__TY_BIND);
    }
    return tyBind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TyElement> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<TyElement>(TyElement.class, this, GDSLPackage.TY__ELEMENTS);
    }
    return elements;
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
      case GDSLPackage.TY__TY_BIND:
        return ((InternalEList<?>)getTyBind()).basicRemove(otherEnd, msgs);
      case GDSLPackage.TY__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.TY__VALUE:
        return getValue();
      case GDSLPackage.TY__TY_BIND:
        return getTyBind();
      case GDSLPackage.TY__ELEMENTS:
        return getElements();
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
      case GDSLPackage.TY__VALUE:
        setValue((String)newValue);
        return;
      case GDSLPackage.TY__TY_BIND:
        getTyBind().clear();
        getTyBind().addAll((Collection<? extends TyBind>)newValue);
        return;
      case GDSLPackage.TY__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends TyElement>)newValue);
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
      case GDSLPackage.TY__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case GDSLPackage.TY__TY_BIND:
        getTyBind().clear();
        return;
      case GDSLPackage.TY__ELEMENTS:
        getElements().clear();
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
      case GDSLPackage.TY__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case GDSLPackage.TY__TY_BIND:
        return tyBind != null && !tyBind.isEmpty();
      case GDSLPackage.TY__ELEMENTS:
        return elements != null && !elements.isEmpty();
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
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //TyImpl
