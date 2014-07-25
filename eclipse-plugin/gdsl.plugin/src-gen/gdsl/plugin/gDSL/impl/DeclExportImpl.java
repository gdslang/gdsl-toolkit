/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.DeclExport;
import gdsl.plugin.gDSL.Export;
import gdsl.plugin.gDSL.GDSLPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decl Export</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.impl.DeclExportImpl#getExports <em>Exports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclExportImpl extends DeclImpl implements DeclExport
{
  /**
   * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExports()
   * @generated
   * @ordered
   */
  protected EList<Export> exports;

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
  public EList<Export> getExports()
  {
    if (exports == null)
    {
      exports = new EObjectContainmentEList<Export>(Export.class, this, GDSLPackage.DECL_EXPORT__EXPORTS);
    }
    return exports;
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
      case GDSLPackage.DECL_EXPORT__EXPORTS:
        return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
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
      case GDSLPackage.DECL_EXPORT__EXPORTS:
        return getExports();
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
      case GDSLPackage.DECL_EXPORT__EXPORTS:
        getExports().clear();
        getExports().addAll((Collection<? extends Export>)newValue);
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
      case GDSLPackage.DECL_EXPORT__EXPORTS:
        getExports().clear();
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
      case GDSLPackage.DECL_EXPORT__EXPORTS:
        return exports != null && !exports.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DeclExportImpl
