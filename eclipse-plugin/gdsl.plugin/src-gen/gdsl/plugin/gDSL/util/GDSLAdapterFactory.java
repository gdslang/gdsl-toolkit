/**
 */
package gdsl.plugin.gDSL.util;

import gdsl.plugin.gDSL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gdsl.plugin.gDSL.GDSLPackage
 * @generated
 */
public class GDSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GDSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GDSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GDSLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GDSLSwitch<Adapter> modelSwitch =
    new GDSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseDecl(Decl object)
      {
        return createDeclAdapter();
      }
      @Override
      public Adapter caseDeclGranularity(DeclGranularity object)
      {
        return createDeclGranularityAdapter();
      }
      @Override
      public Adapter caseDeclExport(DeclExport object)
      {
        return createDeclExportAdapter();
      }
      @Override
      public Adapter caseDeclType(DeclType object)
      {
        return createDeclTypeAdapter();
      }
      @Override
      public Adapter caseDeclVal(DeclVal object)
      {
        return createDeclValAdapter();
      }
      @Override
      public Adapter caseExport(Export object)
      {
        return createExportAdapter();
      }
      @Override
      public Adapter caseConDecls(ConDecls object)
      {
        return createConDeclsAdapter();
      }
      @Override
      public Adapter caseConDecl(ConDecl object)
      {
        return createConDeclAdapter();
      }
      @Override
      public Adapter caseTy(Ty object)
      {
        return createTyAdapter();
      }
      @Override
      public Adapter caseTyElement(TyElement object)
      {
        return createTyElementAdapter();
      }
      @Override
      public Adapter caseTyBind(TyBind object)
      {
        return createTyBindAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Decl
   * @generated
   */
  public Adapter createDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.DeclGranularity <em>Decl Granularity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.DeclGranularity
   * @generated
   */
  public Adapter createDeclGranularityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.DeclExport <em>Decl Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.DeclExport
   * @generated
   */
  public Adapter createDeclExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.DeclType <em>Decl Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.DeclType
   * @generated
   */
  public Adapter createDeclTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.DeclVal <em>Decl Val</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.DeclVal
   * @generated
   */
  public Adapter createDeclValAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Export
   * @generated
   */
  public Adapter createExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.ConDecls <em>Con Decls</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.ConDecls
   * @generated
   */
  public Adapter createConDeclsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.ConDecl <em>Con Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.ConDecl
   * @generated
   */
  public Adapter createConDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Ty <em>Ty</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Ty
   * @generated
   */
  public Adapter createTyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.TyElement <em>Ty Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.TyElement
   * @generated
   */
  public Adapter createTyElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.TyBind <em>Ty Bind</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.TyBind
   * @generated
   */
  public Adapter createTyBindAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //GDSLAdapterFactory