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
      public Adapter caseDeclExport(DeclExport object)
      {
        return createDeclExportAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseVal(Val object)
      {
        return createValAdapter();
      }
      @Override
      public Adapter caseTyVars(TyVars object)
      {
        return createTyVarsAdapter();
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
      public Adapter caseTyBind(TyBind object)
      {
        return createTyBindAdapter();
      }
      @Override
      public Adapter caseTyElement(TyElement object)
      {
        return createTyElementAdapter();
      }
      @Override
      public Adapter caseExp(Exp object)
      {
        return createExpAdapter();
      }
      @Override
      public Adapter caseCaseExp(CaseExp object)
      {
        return createCaseExpAdapter();
      }
      @Override
      public Adapter caseClosedExp(ClosedExp object)
      {
        return createClosedExpAdapter();
      }
      @Override
      public Adapter caseMonadicExp(MonadicExp object)
      {
        return createMonadicExpAdapter();
      }
      @Override
      public Adapter caseOrElseExp(OrElseExp object)
      {
        return createOrElseExpAdapter();
      }
      @Override
      public Adapter caseAndAlsoExp(AndAlsoExp object)
      {
        return createAndAlsoExpAdapter();
      }
      @Override
      public Adapter caseRExp(RExp object)
      {
        return createRExpAdapter();
      }
      @Override
      public Adapter caseAExp(AExp object)
      {
        return createAExpAdapter();
      }
      @Override
      public Adapter caseMExp(MExp object)
      {
        return createMExpAdapter();
      }
      @Override
      public Adapter caseSelectExp(SelectExp object)
      {
        return createSelectExpAdapter();
      }
      @Override
      public Adapter caseApplyExp(ApplyExp object)
      {
        return createApplyExpAdapter();
      }
      @Override
      public Adapter caseArgs(Args object)
      {
        return createArgsAdapter();
      }
      @Override
      public Adapter caseAtomicExp(AtomicExp object)
      {
        return createAtomicExpAdapter();
      }
      @Override
      public Adapter caseField(Field object)
      {
        return createFieldAdapter();
      }
      @Override
      public Adapter caseValueDecl(ValueDecl object)
      {
        return createValueDeclAdapter();
      }
      @Override
      public Adapter casePAT(PAT object)
      {
        return createPATAdapter();
      }
      @Override
      public Adapter caseCONS(CONS object)
      {
        return createCONSAdapter();
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
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Val <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Val
   * @generated
   */
  public Adapter createValAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.TyVars <em>Ty Vars</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.TyVars
   * @generated
   */
  public Adapter createTyVarsAdapter()
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
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Exp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Exp
   * @generated
   */
  public Adapter createExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.CaseExp <em>Case Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.CaseExp
   * @generated
   */
  public Adapter createCaseExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.ClosedExp <em>Closed Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.ClosedExp
   * @generated
   */
  public Adapter createClosedExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.MonadicExp <em>Monadic Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.MonadicExp
   * @generated
   */
  public Adapter createMonadicExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.OrElseExp <em>Or Else Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.OrElseExp
   * @generated
   */
  public Adapter createOrElseExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.AndAlsoExp <em>And Also Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.AndAlsoExp
   * @generated
   */
  public Adapter createAndAlsoExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.RExp <em>RExp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.RExp
   * @generated
   */
  public Adapter createRExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.AExp <em>AExp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.AExp
   * @generated
   */
  public Adapter createAExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.MExp <em>MExp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.MExp
   * @generated
   */
  public Adapter createMExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.SelectExp <em>Select Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.SelectExp
   * @generated
   */
  public Adapter createSelectExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.ApplyExp <em>Apply Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.ApplyExp
   * @generated
   */
  public Adapter createApplyExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Args <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Args
   * @generated
   */
  public Adapter createArgsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.AtomicExp <em>Atomic Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.AtomicExp
   * @generated
   */
  public Adapter createAtomicExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.Field
   * @generated
   */
  public Adapter createFieldAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.ValueDecl <em>Value Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.ValueDecl
   * @generated
   */
  public Adapter createValueDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.PAT <em>PAT</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.PAT
   * @generated
   */
  public Adapter createPATAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link gdsl.plugin.gDSL.CONS <em>CONS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see gdsl.plugin.gDSL.CONS
   * @generated
   */
  public Adapter createCONSAdapter()
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
