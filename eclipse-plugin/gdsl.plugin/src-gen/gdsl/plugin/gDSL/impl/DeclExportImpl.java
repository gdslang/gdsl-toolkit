/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.DeclExport;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Ty;
import gdsl.plugin.gDSL.TyVars;
import gdsl.plugin.gDSL.Val;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decl Export</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclExportImpl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclExportImpl#getTyVars <em>Ty Vars</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclExportImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclExportImpl extends DeclImpl implements DeclExport
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Val name;

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
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Ty type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclExportImpl()
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
    return GDSLPackage.Literals.DECL_EXPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Val getName()
  {
    if (name != null && name.eIsProxy())
    {
      InternalEObject oldName = (InternalEObject)name;
      name = (Val)eResolveProxy(oldName);
      if (name != oldName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GDSLPackage.DECL_EXPORT__NAME, oldName, name));
      }
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Val basicGetName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Val newName)
  {
    Val oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_EXPORT__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_EXPORT__TY_VARS, oldTyVars, newTyVars);
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
        msgs = ((InternalEObject)tyVars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.DECL_EXPORT__TY_VARS, null, msgs);
      if (newTyVars != null)
        msgs = ((InternalEObject)newTyVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.DECL_EXPORT__TY_VARS, null, msgs);
      msgs = basicSetTyVars(newTyVars, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_EXPORT__TY_VARS, newTyVars, newTyVars));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ty getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Ty newType, NotificationChain msgs)
  {
    Ty oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_EXPORT__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Ty newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.DECL_EXPORT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.DECL_EXPORT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.DECL_EXPORT__TYPE, newType, newType));
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
      case GDSLPackage.DECL_EXPORT__TY_VARS:
        return basicSetTyVars(null, msgs);
      case GDSLPackage.DECL_EXPORT__TYPE:
        return basicSetType(null, msgs);
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
      case GDSLPackage.DECL_EXPORT__NAME:
        if (resolve) return getName();
        return basicGetName();
      case GDSLPackage.DECL_EXPORT__TY_VARS:
        return getTyVars();
      case GDSLPackage.DECL_EXPORT__TYPE:
        return getType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GDSLPackage.DECL_EXPORT__NAME:
        setName((Val)newValue);
        return;
      case GDSLPackage.DECL_EXPORT__TY_VARS:
        setTyVars((TyVars)newValue);
        return;
      case GDSLPackage.DECL_EXPORT__TYPE:
        setType((Ty)newValue);
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
      case GDSLPackage.DECL_EXPORT__NAME:
        setName((Val)null);
        return;
      case GDSLPackage.DECL_EXPORT__TY_VARS:
        setTyVars((TyVars)null);
        return;
      case GDSLPackage.DECL_EXPORT__TYPE:
        setType((Ty)null);
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
      case GDSLPackage.DECL_EXPORT__NAME:
        return name != null;
      case GDSLPackage.DECL_EXPORT__TY_VARS:
        return tyVars != null;
      case GDSLPackage.DECL_EXPORT__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //DeclExportImpl
