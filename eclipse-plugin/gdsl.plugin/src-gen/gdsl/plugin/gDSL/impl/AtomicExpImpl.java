/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.AtomicExp;
import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.Field;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.ValueDecl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.AtomicExpImpl#getId <em>Id</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AtomicExpImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AtomicExpImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AtomicExpImpl#getExps <em>Exps</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AtomicExpImpl#getValDecl <em>Val Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicExpImpl extends MinimalEObjectImpl.Container implements AtomicExp
{
  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected EList<String> id;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<Field> fields;

  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected Exp exp;

  /**
   * The cached value of the '{@link #getExps() <em>Exps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExps()
   * @generated
   * @ordered
   */
  protected EList<Exp> exps;

  /**
   * The cached value of the '{@link #getValDecl() <em>Val Decl</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValDecl()
   * @generated
   * @ordered
   */
  protected EList<ValueDecl> valDecl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicExpImpl()
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
    return GDSLPackage.Literals.ATOMIC_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getId()
  {
    if (id == null)
    {
      id = new EDataTypeEList<String>(String.class, this, GDSLPackage.ATOMIC_EXP__ID);
    }
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Field> getFields()
  {
    if (fields == null)
    {
      fields = new EObjectContainmentEList<Field>(Field.class, this, GDSLPackage.ATOMIC_EXP__FIELDS);
    }
    return fields;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp getExp()
  {
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExp(Exp newExp, NotificationChain msgs)
  {
    Exp oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.ATOMIC_EXP__EXP, oldExp, newExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExp(Exp newExp)
  {
    if (newExp != exp)
    {
      NotificationChain msgs = null;
      if (exp != null)
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.ATOMIC_EXP__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.ATOMIC_EXP__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.ATOMIC_EXP__EXP, newExp, newExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Exp> getExps()
  {
    if (exps == null)
    {
      exps = new EObjectContainmentEList<Exp>(Exp.class, this, GDSLPackage.ATOMIC_EXP__EXPS);
    }
    return exps;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueDecl> getValDecl()
  {
    if (valDecl == null)
    {
      valDecl = new EObjectContainmentEList<ValueDecl>(ValueDecl.class, this, GDSLPackage.ATOMIC_EXP__VAL_DECL);
    }
    return valDecl;
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
      case GDSLPackage.ATOMIC_EXP__FIELDS:
        return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
      case GDSLPackage.ATOMIC_EXP__EXP:
        return basicSetExp(null, msgs);
      case GDSLPackage.ATOMIC_EXP__EXPS:
        return ((InternalEList<?>)getExps()).basicRemove(otherEnd, msgs);
      case GDSLPackage.ATOMIC_EXP__VAL_DECL:
        return ((InternalEList<?>)getValDecl()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.ATOMIC_EXP__ID:
        return getId();
      case GDSLPackage.ATOMIC_EXP__FIELDS:
        return getFields();
      case GDSLPackage.ATOMIC_EXP__EXP:
        return getExp();
      case GDSLPackage.ATOMIC_EXP__EXPS:
        return getExps();
      case GDSLPackage.ATOMIC_EXP__VAL_DECL:
        return getValDecl();
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
      case GDSLPackage.ATOMIC_EXP__ID:
        getId().clear();
        getId().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.ATOMIC_EXP__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends Field>)newValue);
        return;
      case GDSLPackage.ATOMIC_EXP__EXP:
        setExp((Exp)newValue);
        return;
      case GDSLPackage.ATOMIC_EXP__EXPS:
        getExps().clear();
        getExps().addAll((Collection<? extends Exp>)newValue);
        return;
      case GDSLPackage.ATOMIC_EXP__VAL_DECL:
        getValDecl().clear();
        getValDecl().addAll((Collection<? extends ValueDecl>)newValue);
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
      case GDSLPackage.ATOMIC_EXP__ID:
        getId().clear();
        return;
      case GDSLPackage.ATOMIC_EXP__FIELDS:
        getFields().clear();
        return;
      case GDSLPackage.ATOMIC_EXP__EXP:
        setExp((Exp)null);
        return;
      case GDSLPackage.ATOMIC_EXP__EXPS:
        getExps().clear();
        return;
      case GDSLPackage.ATOMIC_EXP__VAL_DECL:
        getValDecl().clear();
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
      case GDSLPackage.ATOMIC_EXP__ID:
        return id != null && !id.isEmpty();
      case GDSLPackage.ATOMIC_EXP__FIELDS:
        return fields != null && !fields.isEmpty();
      case GDSLPackage.ATOMIC_EXP__EXP:
        return exp != null;
      case GDSLPackage.ATOMIC_EXP__EXPS:
        return exps != null && !exps.isEmpty();
      case GDSLPackage.ATOMIC_EXP__VAL_DECL:
        return valDecl != null && !valDecl.isEmpty();
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //AtomicExpImpl
