/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.ConDecl;
import gdsl.plugin.gDSL.ConDecls;
import gdsl.plugin.gDSL.GDSLPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Con Decls</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.ConDeclsImpl#getConDecls <em>Con Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConDeclsImpl extends MinimalEObjectImpl.Container implements ConDecls
{
  /**
   * The cached value of the '{@link #getConDecls() <em>Con Decls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConDecls()
   * @generated
   * @ordered
   */
  protected EList<ConDecl> conDecls;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConDeclsImpl()
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
    return GDSLPackage.Literals.CON_DECLS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConDecl> getConDecls()
  {
    if (conDecls == null)
    {
      conDecls = new EObjectContainmentEList<ConDecl>(ConDecl.class, this, GDSLPackage.CON_DECLS__CON_DECLS);
    }
    return conDecls;
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
      case GDSLPackage.CON_DECLS__CON_DECLS:
        return ((InternalEList<?>)getConDecls()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.CON_DECLS__CON_DECLS:
        return getConDecls();
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
      case GDSLPackage.CON_DECLS__CON_DECLS:
        getConDecls().clear();
        getConDecls().addAll((Collection<? extends ConDecl>)newValue);
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
      case GDSLPackage.CON_DECLS__CON_DECLS:
        getConDecls().clear();
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
      case GDSLPackage.CON_DECLS__CON_DECLS:
        return conDecls != null && !conDecls.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConDeclsImpl
