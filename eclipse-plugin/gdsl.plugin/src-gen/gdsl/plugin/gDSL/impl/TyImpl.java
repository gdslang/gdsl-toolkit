/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.DeclType;
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
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getDecl <em>Decl</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getType <em>Type</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getTyBind <em>Ty Bind</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getParam <em>Param</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getResType <em>Res Type</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getR <em>R</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getIn <em>In</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TyImpl#getOut <em>Out</em>}</li>
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
   * The cached value of the '{@link #getDecl() <em>Decl</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecl()
   * @generated
   * @ordered
   */
  protected DeclType decl;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

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
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected EList<Ty> param;

  /**
   * The cached value of the '{@link #getResType() <em>Res Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResType()
   * @generated
   * @ordered
   */
  protected Ty resType;

  /**
   * The cached value of the '{@link #getR() <em>R</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getR()
   * @generated
   * @ordered
   */
  protected Ty r;

  /**
   * The cached value of the '{@link #getIn() <em>In</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIn()
   * @generated
   * @ordered
   */
  protected Ty in;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected Ty out;

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
  public DeclType getDecl()
  {
    if (decl != null && decl.eIsProxy())
    {
      InternalEObject oldDecl = (InternalEObject)decl;
      decl = (DeclType)eResolveProxy(oldDecl);
      if (decl != oldDecl)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GDSLPackage.TY__DECL, oldDecl, decl));
      }
    }
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclType basicGetDecl()
  {
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecl(DeclType newDecl)
  {
    DeclType oldDecl = decl;
    decl = newDecl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__DECL, oldDecl, decl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__TYPE, oldType, type));
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
  public EList<Ty> getParam()
  {
    if (param == null)
    {
      param = new EObjectContainmentEList<Ty>(Ty.class, this, GDSLPackage.TY__PARAM);
    }
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getResType()
  {
    return resType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResType(Ty newResType, NotificationChain msgs)
  {
    Ty oldResType = resType;
    resType = newResType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__RES_TYPE, oldResType, newResType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResType(Ty newResType)
  {
    if (newResType != resType)
    {
      NotificationChain msgs = null;
      if (resType != null)
        msgs = ((InternalEObject)resType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__RES_TYPE, null, msgs);
      if (newResType != null)
        msgs = ((InternalEObject)newResType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__RES_TYPE, null, msgs);
      msgs = basicSetResType(newResType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__RES_TYPE, newResType, newResType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getR()
  {
    return r;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetR(Ty newR, NotificationChain msgs)
  {
    Ty oldR = r;
    r = newR;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__R, oldR, newR);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR(Ty newR)
  {
    if (newR != r)
    {
      NotificationChain msgs = null;
      if (r != null)
        msgs = ((InternalEObject)r).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__R, null, msgs);
      if (newR != null)
        msgs = ((InternalEObject)newR).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__R, null, msgs);
      msgs = basicSetR(newR, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__R, newR, newR));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getIn()
  {
    return in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIn(Ty newIn, NotificationChain msgs)
  {
    Ty oldIn = in;
    in = newIn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__IN, oldIn, newIn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIn(Ty newIn)
  {
    if (newIn != in)
    {
      NotificationChain msgs = null;
      if (in != null)
        msgs = ((InternalEObject)in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__IN, null, msgs);
      if (newIn != null)
        msgs = ((InternalEObject)newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__IN, null, msgs);
      msgs = basicSetIn(newIn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__IN, newIn, newIn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getOut()
  {
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOut(Ty newOut, NotificationChain msgs)
  {
    Ty oldOut = out;
    out = newOut;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__OUT, oldOut, newOut);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOut(Ty newOut)
  {
    if (newOut != out)
    {
      NotificationChain msgs = null;
      if (out != null)
        msgs = ((InternalEObject)out).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__OUT, null, msgs);
      if (newOut != null)
        msgs = ((InternalEObject)newOut).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TY__OUT, null, msgs);
      msgs = basicSetOut(newOut, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TY__OUT, newOut, newOut));
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
      case GDSLPackage.TY__PARAM:
        return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
      case GDSLPackage.TY__RES_TYPE:
        return basicSetResType(null, msgs);
      case GDSLPackage.TY__R:
        return basicSetR(null, msgs);
      case GDSLPackage.TY__IN:
        return basicSetIn(null, msgs);
      case GDSLPackage.TY__OUT:
        return basicSetOut(null, msgs);
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
      case GDSLPackage.TY__DECL:
        if (resolve) return getDecl();
        return basicGetDecl();
      case GDSLPackage.TY__TYPE:
        return getType();
      case GDSLPackage.TY__TY_BIND:
        return getTyBind();
      case GDSLPackage.TY__ELEMENTS:
        return getElements();
      case GDSLPackage.TY__PARAM:
        return getParam();
      case GDSLPackage.TY__RES_TYPE:
        return getResType();
      case GDSLPackage.TY__R:
        return getR();
      case GDSLPackage.TY__IN:
        return getIn();
      case GDSLPackage.TY__OUT:
        return getOut();
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
      case GDSLPackage.TY__DECL:
        setDecl((DeclType)newValue);
        return;
      case GDSLPackage.TY__TYPE:
        setType((String)newValue);
        return;
      case GDSLPackage.TY__TY_BIND:
        getTyBind().clear();
        getTyBind().addAll((Collection<? extends TyBind>)newValue);
        return;
      case GDSLPackage.TY__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends TyElement>)newValue);
        return;
      case GDSLPackage.TY__PARAM:
        getParam().clear();
        getParam().addAll((Collection<? extends Ty>)newValue);
        return;
      case GDSLPackage.TY__RES_TYPE:
        setResType((Ty)newValue);
        return;
      case GDSLPackage.TY__R:
        setR((Ty)newValue);
        return;
      case GDSLPackage.TY__IN:
        setIn((Ty)newValue);
        return;
      case GDSLPackage.TY__OUT:
        setOut((Ty)newValue);
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
      case GDSLPackage.TY__DECL:
        setDecl((DeclType)null);
        return;
      case GDSLPackage.TY__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case GDSLPackage.TY__TY_BIND:
        getTyBind().clear();
        return;
      case GDSLPackage.TY__ELEMENTS:
        getElements().clear();
        return;
      case GDSLPackage.TY__PARAM:
        getParam().clear();
        return;
      case GDSLPackage.TY__RES_TYPE:
        setResType((Ty)null);
        return;
      case GDSLPackage.TY__R:
        setR((Ty)null);
        return;
      case GDSLPackage.TY__IN:
        setIn((Ty)null);
        return;
      case GDSLPackage.TY__OUT:
        setOut((Ty)null);
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
      case GDSLPackage.TY__DECL:
        return decl != null;
      case GDSLPackage.TY__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case GDSLPackage.TY__TY_BIND:
        return tyBind != null && !tyBind.isEmpty();
      case GDSLPackage.TY__ELEMENTS:
        return elements != null && !elements.isEmpty();
      case GDSLPackage.TY__PARAM:
        return param != null && !param.isEmpty();
      case GDSLPackage.TY__RES_TYPE:
        return resType != null;
      case GDSLPackage.TY__R:
        return r != null;
      case GDSLPackage.TY__IN:
        return in != null;
      case GDSLPackage.TY__OUT:
        return out != null;
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
    result.append(", type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //TyImpl
