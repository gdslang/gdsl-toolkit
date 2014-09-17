/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.GDSLPackage;
import gdsl.plugin.gDSL.PAT;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.PATImpl#getUscore <em>Uscore</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.PATImpl#getInt <em>Int</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.PATImpl#getId <em>Id</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.PATImpl#getPat <em>Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.impl.PATImpl#getBitpat <em>Bitpat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PATImpl extends MinimalEObjectImpl.Container implements PAT
{
  /**
   * The default value of the '{@link #getUscore() <em>Uscore</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUscore()
   * @generated
   * @ordered
   */
  protected static final String USCORE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUscore() <em>Uscore</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUscore()
   * @generated
   * @ordered
   */
  protected String uscore = USCORE_EDEFAULT;

  /**
   * The default value of the '{@link #getInt() <em>Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt()
   * @generated
   * @ordered
   */
  protected static final String INT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInt() <em>Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt()
   * @generated
   * @ordered
   */
  protected String int_ = INT_EDEFAULT;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getPat() <em>Pat</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPat()
   * @generated
   * @ordered
   */
  protected PAT pat;

  /**
   * The default value of the '{@link #getBitpat() <em>Bitpat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBitpat()
   * @generated
   * @ordered
   */
  protected static final String BITPAT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBitpat() <em>Bitpat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBitpat()
   * @generated
   * @ordered
   */
  protected String bitpat = BITPAT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PATImpl()
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
    return GDSLPackage.Literals.PAT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUscore()
  {
    return uscore;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUscore(String newUscore)
  {
    String oldUscore = uscore;
    uscore = newUscore;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__USCORE, oldUscore, uscore));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInt()
  {
    return int_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt(String newInt)
  {
    String oldInt = int_;
    int_ = newInt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__INT, oldInt, int_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PAT getPat()
  {
    return pat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPat(PAT newPat, NotificationChain msgs)
  {
    PAT oldPat = pat;
    pat = newPat;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__PAT, oldPat, newPat);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPat(PAT newPat)
  {
    if (newPat != pat)
    {
      NotificationChain msgs = null;
      if (pat != null)
        msgs = ((InternalEObject)pat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.PAT__PAT, null, msgs);
      if (newPat != null)
        msgs = ((InternalEObject)newPat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GDSLPackage.PAT__PAT, null, msgs);
      msgs = basicSetPat(newPat, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__PAT, newPat, newPat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBitpat()
  {
    return bitpat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBitpat(String newBitpat)
  {
    String oldBitpat = bitpat;
    bitpat = newBitpat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GDSLPackage.PAT__BITPAT, oldBitpat, bitpat));
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
      case GDSLPackage.PAT__PAT:
        return basicSetPat(null, msgs);
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
      case GDSLPackage.PAT__USCORE:
        return getUscore();
      case GDSLPackage.PAT__INT:
        return getInt();
      case GDSLPackage.PAT__ID:
        return getId();
      case GDSLPackage.PAT__PAT:
        return getPat();
      case GDSLPackage.PAT__BITPAT:
        return getBitpat();
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
      case GDSLPackage.PAT__USCORE:
        setUscore((String)newValue);
        return;
      case GDSLPackage.PAT__INT:
        setInt((String)newValue);
        return;
      case GDSLPackage.PAT__ID:
        setId((String)newValue);
        return;
      case GDSLPackage.PAT__PAT:
        setPat((PAT)newValue);
        return;
      case GDSLPackage.PAT__BITPAT:
        setBitpat((String)newValue);
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
      case GDSLPackage.PAT__USCORE:
        setUscore(USCORE_EDEFAULT);
        return;
      case GDSLPackage.PAT__INT:
        setInt(INT_EDEFAULT);
        return;
      case GDSLPackage.PAT__ID:
        setId(ID_EDEFAULT);
        return;
      case GDSLPackage.PAT__PAT:
        setPat((PAT)null);
        return;
      case GDSLPackage.PAT__BITPAT:
        setBitpat(BITPAT_EDEFAULT);
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
      case GDSLPackage.PAT__USCORE:
        return USCORE_EDEFAULT == null ? uscore != null : !USCORE_EDEFAULT.equals(uscore);
      case GDSLPackage.PAT__INT:
        return INT_EDEFAULT == null ? int_ != null : !INT_EDEFAULT.equals(int_);
      case GDSLPackage.PAT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case GDSLPackage.PAT__PAT:
        return pat != null;
      case GDSLPackage.PAT__BITPAT:
        return BITPAT_EDEFAULT == null ? bitpat != null : !BITPAT_EDEFAULT.equals(bitpat);
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
    result.append(" (uscore: ");
    result.append(uscore);
    result.append(", int: ");
    result.append(int_);
    result.append(", id: ");
    result.append(id);
    result.append(", bitpat: ");
    result.append(bitpat);
    result.append(')');
    return result.toString();
  }

} //PATImpl
