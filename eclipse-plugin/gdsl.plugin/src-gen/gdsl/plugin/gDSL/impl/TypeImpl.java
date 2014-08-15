/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ConDecl;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Ty;
import gdsl.plugin.gDSL.TyVars;
import gdsl.plugin.gDSL.Type;

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
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TypeImpl#getConDecl <em>Con Decl</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.TypeImpl#getTyVars <em>Ty Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends DeclImpl implements Type
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
   * The cached value of the '{@link #getConDecl() <em>Con Decl</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConDecl()
   * @generated
   * @ordered
   */
  protected EList<ConDecl> conDecl;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Ty value;

  /**
   * The cached value of the '{@link #getTyVars() <em>Ty Vars</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTyVars()
   * @generated
   * @ordered
   */
  protected TyVars tyVars;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
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
    return GDSLPackage.Literals.TYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConDecl> getConDecl()
  {
    if (conDecl == null)
    {
      conDecl = new EObjectContainmentEList<ConDecl>(ConDecl.class, this, GDSLPackage.TYPE__CON_DECL);
    }
    return conDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Ty newValue, NotificationChain msgs)
  {
    Ty oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TYPE__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Ty newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TYPE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TYPE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TYPE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TyVars getTyVars()
  {
    return tyVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTyVars(TyVars newTyVars, NotificationChain msgs)
  {
    TyVars oldTyVars = tyVars;
    tyVars = newTyVars;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.TYPE__TY_VARS, oldTyVars, newTyVars);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTyVars(TyVars newTyVars)
  {
    if (newTyVars != tyVars)
    {
      NotificationChain msgs = null;
      if (tyVars != null)
        msgs = ((InternalEObject)tyVars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TYPE__TY_VARS, null, msgs);
      if (newTyVars != null)
        msgs = ((InternalEObject)newTyVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.TYPE__TY_VARS, null, msgs);
      msgs = basicSetTyVars(newTyVars, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.TYPE__TY_VARS, newTyVars, newTyVars));
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
      case GDSLPackage.TYPE__CON_DECL:
        return ((InternalEList<?>)getConDecl()).basicRemove(otherEnd, msgs);
      case GDSLPackage.TYPE__VALUE:
        return basicSetValue(null, msgs);
      case GDSLPackage.TYPE__TY_VARS:
        return basicSetTyVars(null, msgs);
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
      case GDSLPackage.TYPE__NAME:
        return getName();
      case GDSLPackage.TYPE__CON_DECL:
        return getConDecl();
      case GDSLPackage.TYPE__VALUE:
        return getValue();
      case GDSLPackage.TYPE__TY_VARS:
        return getTyVars();
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
      case GDSLPackage.TYPE__NAME:
        setName((String)newValue);
        return;
      case GDSLPackage.TYPE__CON_DECL:
        getConDecl().clear();
        getConDecl().addAll((Collection<? extends ConDecl>)newValue);
        return;
      case GDSLPackage.TYPE__VALUE:
        setValue((Ty)newValue);
        return;
      case GDSLPackage.TYPE__TY_VARS:
        setTyVars((TyVars)newValue);
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
      case GDSLPackage.TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GDSLPackage.TYPE__CON_DECL:
        getConDecl().clear();
        return;
      case GDSLPackage.TYPE__VALUE:
        setValue((Ty)null);
        return;
      case GDSLPackage.TYPE__TY_VARS:
        setTyVars((TyVars)null);
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
      case GDSLPackage.TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GDSLPackage.TYPE__CON_DECL:
        return conDecl != null && !conDecl.isEmpty();
      case GDSLPackage.TYPE__VALUE:
        return value != null;
      case GDSLPackage.TYPE__TY_VARS:
        return tyVars != null;
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

} //TypeImpl
