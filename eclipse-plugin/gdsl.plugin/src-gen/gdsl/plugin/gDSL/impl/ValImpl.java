/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.Exp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.Val;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Val</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getAttr <em>Attr</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getMid <em>Mid</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getDecPat <em>Dec Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.ValImpl#getExps <em>Exps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValImpl extends DeclImpl implements Val
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
   * The cached value of the '{@link #getAttr() <em>Attr</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttr()
   * @generated
   * @ordered
   */
  protected EList<String> attr;

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
   * The cached value of the '{@link #getMid() <em>Mid</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMid()
   * @generated
   * @ordered
   */
  protected EList<String> mid;

  /**
   * The cached value of the '{@link #getDecPat() <em>Dec Pat</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecPat()
   * @generated
   * @ordered
   */
  protected EList<String> decPat;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValImpl()
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
    return GDSLPackage.Literals.VAL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.VAL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAttr()
  {
    if (attr == null)
    {
      attr = new EDataTypeEList<String>(String.class, this, GDSLPackage.VAL__ATTR);
    }
    return attr;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.VAL__EXP, oldExp, newExp);
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
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.VAL__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.VAL__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.VAL__EXP, newExp, newExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMid()
  {
    if (mid == null)
    {
      mid = new EDataTypeEList<String>(String.class, this, GDSLPackage.VAL__MID);
    }
    return mid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDecPat()
  {
    if (decPat == null)
    {
      decPat = new EDataTypeEList<String>(String.class, this, GDSLPackage.VAL__DEC_PAT);
    }
    return decPat;
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
      exps = new EObjectContainmentEList<Exp>(Exp.class, this, GDSLPackage.VAL__EXPS);
    }
    return exps;
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
      case GDSLPackage.VAL__EXP:
        return basicSetExp(null, msgs);
      case GDSLPackage.VAL__EXPS:
        return ((InternalEList<?>)getExps()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.VAL__NAME:
        return getName();
      case GDSLPackage.VAL__ATTR:
        return getAttr();
      case GDSLPackage.VAL__EXP:
        return getExp();
      case GDSLPackage.VAL__MID:
        return getMid();
      case GDSLPackage.VAL__DEC_PAT:
        return getDecPat();
      case GDSLPackage.VAL__EXPS:
        return getExps();
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
      case GDSLPackage.VAL__NAME:
        setName((String)newValue);
        return;
      case GDSLPackage.VAL__ATTR:
        getAttr().clear();
        getAttr().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.VAL__EXP:
        setExp((Exp)newValue);
        return;
      case GDSLPackage.VAL__MID:
        getMid().clear();
        getMid().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.VAL__DEC_PAT:
        getDecPat().clear();
        getDecPat().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.VAL__EXPS:
        getExps().clear();
        getExps().addAll((Collection<? extends Exp>)newValue);
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
      case GDSLPackage.VAL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GDSLPackage.VAL__ATTR:
        getAttr().clear();
        return;
      case GDSLPackage.VAL__EXP:
        setExp((Exp)null);
        return;
      case GDSLPackage.VAL__MID:
        getMid().clear();
        return;
      case GDSLPackage.VAL__DEC_PAT:
        getDecPat().clear();
        return;
      case GDSLPackage.VAL__EXPS:
        getExps().clear();
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
      case GDSLPackage.VAL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GDSLPackage.VAL__ATTR:
        return attr != null && !attr.isEmpty();
      case GDSLPackage.VAL__EXP:
        return exp != null;
      case GDSLPackage.VAL__MID:
        return mid != null && !mid.isEmpty();
      case GDSLPackage.VAL__DEC_PAT:
        return decPat != null && !decPat.isEmpty();
      case GDSLPackage.VAL__EXPS:
        return exps != null && !exps.isEmpty();
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
    result.append(", attr: ");
    result.append(attr);
    result.append(", mid: ");
    result.append(mid);
    result.append(", decPat: ");
    result.append(decPat);
    result.append(')');
    return result.toString();
  }

} //ValImpl
