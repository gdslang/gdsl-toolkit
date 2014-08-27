/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ApplyExp;
import gdsl.plugin.gDSL.Args;
import gdsl.plugin.gDSL.AtomicExp;
import gdsl.plugin.gDSL.GDSLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Apply Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ApplyExpImpl#getAtomicExp <em>Atomic Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ApplyExpImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplyExpImpl extends SelectExpImpl implements ApplyExp
{
  /**
   * The cached value of the '{@link #getAtomicExp() <em>Atomic Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtomicExp()
   * @generated
   * @ordered
   */
  protected AtomicExp atomicExp;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected Args args;

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
  public AtomicExp getAtomicExp()
  {
    return atomicExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAtomicExp(AtomicExp newAtomicExp, NotificationChain msgs)
  {
    AtomicExp oldAtomicExp = atomicExp;
    atomicExp = newAtomicExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.APPLY_EXP__ATOMIC_EXP, oldAtomicExp, newAtomicExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtomicExp(AtomicExp newAtomicExp)
  {
    if (newAtomicExp != atomicExp)
    {
      NotificationChain msgs = null;
      if (atomicExp != null)
        msgs = ((InternalEObject)atomicExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.APPLY_EXP__ATOMIC_EXP, null, msgs);
      if (newAtomicExp != null)
        msgs = ((InternalEObject)newAtomicExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.APPLY_EXP__ATOMIC_EXP, null, msgs);
      msgs = basicSetAtomicExp(newAtomicExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.APPLY_EXP__ATOMIC_EXP, newAtomicExp, newAtomicExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Args getArgs()
  {
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgs(Args newArgs, NotificationChain msgs)
  {
    Args oldArgs = args;
    args = newArgs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.APPLY_EXP__ARGS, oldArgs, newArgs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgs(Args newArgs)
  {
    if (newArgs != args)
    {
      NotificationChain msgs = null;
      if (args != null)
        msgs = ((InternalEObject)args).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.APPLY_EXP__ARGS, null, msgs);
      if (newArgs != null)
        msgs = ((InternalEObject)newArgs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.APPLY_EXP__ARGS, null, msgs);
      msgs = basicSetArgs(newArgs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.APPLY_EXP__ARGS, newArgs, newArgs));
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
        return basicSetAtomicExp(null, msgs);
      case GDSLPackage.APPLY_EXP__ARGS:
        return basicSetArgs(null, msgs);
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
      case GDSLPackage.APPLY_EXP__ARGS:
        return getArgs();
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
      case GDSLPackage.APPLY_EXP__ATOMIC_EXP:
        setAtomicExp((AtomicExp)newValue);
        return;
      case GDSLPackage.APPLY_EXP__ARGS:
        setArgs((Args)newValue);
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
        setAtomicExp((AtomicExp)null);
        return;
      case GDSLPackage.APPLY_EXP__ARGS:
        setArgs((Args)null);
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
        return atomicExp != null;
      case GDSLPackage.APPLY_EXP__ARGS:
        return args != null;
    }
    return super.eIsSet(featureID);
  }

} //ApplyExpImpl
