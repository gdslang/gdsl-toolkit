/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.AExp;
import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.MExp;

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
 * An implementation of the model object '<em><b>AExp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.AExpImpl#getMexp <em>Mexp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AExpImpl#getSign <em>Sign</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.AExpImpl#getMexps <em>Mexps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AExpImpl extends MinimalEObjectImpl.Container implements AExp
{
  /**
   * The cached value of the '{@link #getMexp() <em>Mexp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMexp()
   * @generated
   * @ordered
   */
  protected MExp mexp;

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
  public MExp getMexp()
  {
    return mexp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMexp(MExp newMexp, NotificationChain msgs)
  {
    MExp oldMexp = mexp;
    mexp = newMexp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.AEXP__MEXP, oldMexp, newMexp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMexp(MExp newMexp)
  {
    if (newMexp != mexp)
    {
      NotificationChain msgs = null;
      if (mexp != null)
        msgs = ((InternalEObject)mexp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.AEXP__MEXP, null, msgs);
      if (newMexp != null)
        msgs = ((InternalEObject)newMexp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.AEXP__MEXP, null, msgs);
      msgs = basicSetMexp(newMexp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.AEXP__MEXP, newMexp, newMexp));
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
      sign = new EDataTypeEList<String>(String.class, this, GDSLPackage.AEXP__SIGN);
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
      mexps = new EObjectContainmentEList<MExp>(MExp.class, this, GDSLPackage.AEXP__MEXPS);
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
      case GDSLPackage.AEXP__MEXP:
        return basicSetMexp(null, msgs);
      case GDSLPackage.AEXP__MEXPS:
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
      case GDSLPackage.AEXP__MEXP:
        return getMexp();
      case GDSLPackage.AEXP__SIGN:
        return getSign();
      case GDSLPackage.AEXP__MEXPS:
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
      case GDSLPackage.AEXP__MEXP:
        setMexp((MExp)newValue);
        return;
      case GDSLPackage.AEXP__SIGN:
        getSign().clear();
        getSign().addAll((Collection<? extends String>)newValue);
        return;
      case GDSLPackage.AEXP__MEXPS:
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
      case GDSLPackage.AEXP__MEXP:
        setMexp((MExp)null);
        return;
      case GDSLPackage.AEXP__SIGN:
        getSign().clear();
        return;
      case GDSLPackage.AEXP__MEXPS:
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
      case GDSLPackage.AEXP__MEXP:
        return mexp != null;
      case GDSLPackage.AEXP__SIGN:
        return sign != null && !sign.isEmpty();
      case GDSLPackage.AEXP__MEXPS:
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

} //AExpImpl
