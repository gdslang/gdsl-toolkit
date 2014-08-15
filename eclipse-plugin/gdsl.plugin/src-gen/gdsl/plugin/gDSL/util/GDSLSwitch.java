/**
 */
package gdsl.plugin.gDSL.util;

import gdsl.plugin.gDSL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gdsl.plugin.gDSL.GDSLPackage
 * @generated
 */
public class GDSLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GDSLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GDSLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GDSLPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GDSLPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.DECL:
      {
        Decl decl = (Decl)theEObject;
        T result = caseDecl(decl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.DECL_EXPORT:
      {
        DeclExport declExport = (DeclExport)theEObject;
        T result = caseDeclExport(declExport);
        if (result == null) result = caseDecl(declExport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = caseDecl(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.DECL_VAL:
      {
        DeclVal declVal = (DeclVal)theEObject;
        T result = caseDeclVal(declVal);
        if (result == null) result = caseDecl(declVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.TY_VARS:
      {
        TyVars tyVars = (TyVars)theEObject;
        T result = caseTyVars(tyVars);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.CON_DECL:
      {
        ConDecl conDecl = (ConDecl)theEObject;
        T result = caseConDecl(conDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.TY:
      {
        Ty ty = (Ty)theEObject;
        T result = caseTy(ty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.TY_BIND:
      {
        TyBind tyBind = (TyBind)theEObject;
        T result = caseTyBind(tyBind);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.TY_ELEMENT:
      {
        TyElement tyElement = (TyElement)theEObject;
        T result = caseTyElement(tyElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.EXP:
      {
        Exp exp = (Exp)theEObject;
        T result = caseExp(exp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.CASE_EXP:
      {
        CaseExp caseExp = (CaseExp)theEObject;
        T result = caseCaseExp(caseExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.CLOSED_EXP:
      {
        ClosedExp closedExp = (ClosedExp)theEObject;
        T result = caseClosedExp(closedExp);
        if (result == null) result = caseCaseExp(closedExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.MONADIC_EXP:
      {
        MonadicExp monadicExp = (MonadicExp)theEObject;
        T result = caseMonadicExp(monadicExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.OR_ELSE_EXP:
      {
        OrElseExp orElseExp = (OrElseExp)theEObject;
        T result = caseOrElseExp(orElseExp);
        if (result == null) result = caseClosedExp(orElseExp);
        if (result == null) result = caseCaseExp(orElseExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.AND_ALSO_EXP:
      {
        AndAlsoExp andAlsoExp = (AndAlsoExp)theEObject;
        T result = caseAndAlsoExp(andAlsoExp);
        if (result == null) result = caseOrElseExp(andAlsoExp);
        if (result == null) result = caseClosedExp(andAlsoExp);
        if (result == null) result = caseCaseExp(andAlsoExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.REXP:
      {
        RExp rExp = (RExp)theEObject;
        T result = caseRExp(rExp);
        if (result == null) result = caseAndAlsoExp(rExp);
        if (result == null) result = caseOrElseExp(rExp);
        if (result == null) result = caseClosedExp(rExp);
        if (result == null) result = caseCaseExp(rExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.AEXP:
      {
        AExp aExp = (AExp)theEObject;
        T result = caseAExp(aExp);
        if (result == null) result = caseRExp(aExp);
        if (result == null) result = caseAndAlsoExp(aExp);
        if (result == null) result = caseOrElseExp(aExp);
        if (result == null) result = caseClosedExp(aExp);
        if (result == null) result = caseCaseExp(aExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.MEXP:
      {
        MExp mExp = (MExp)theEObject;
        T result = caseMExp(mExp);
        if (result == null) result = caseAExp(mExp);
        if (result == null) result = caseRExp(mExp);
        if (result == null) result = caseAndAlsoExp(mExp);
        if (result == null) result = caseOrElseExp(mExp);
        if (result == null) result = caseClosedExp(mExp);
        if (result == null) result = caseCaseExp(mExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.SELECT_EXP:
      {
        SelectExp selectExp = (SelectExp)theEObject;
        T result = caseSelectExp(selectExp);
        if (result == null) result = caseMExp(selectExp);
        if (result == null) result = caseAExp(selectExp);
        if (result == null) result = caseRExp(selectExp);
        if (result == null) result = caseAndAlsoExp(selectExp);
        if (result == null) result = caseOrElseExp(selectExp);
        if (result == null) result = caseClosedExp(selectExp);
        if (result == null) result = caseCaseExp(selectExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.APPLY_EXP:
      {
        ApplyExp applyExp = (ApplyExp)theEObject;
        T result = caseApplyExp(applyExp);
        if (result == null) result = caseSelectExp(applyExp);
        if (result == null) result = caseMExp(applyExp);
        if (result == null) result = caseAExp(applyExp);
        if (result == null) result = caseRExp(applyExp);
        if (result == null) result = caseAndAlsoExp(applyExp);
        if (result == null) result = caseOrElseExp(applyExp);
        if (result == null) result = caseClosedExp(applyExp);
        if (result == null) result = caseCaseExp(applyExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.ATOMIC_EXP:
      {
        AtomicExp atomicExp = (AtomicExp)theEObject;
        T result = caseAtomicExp(atomicExp);
        if (result == null) result = caseApplyExp(atomicExp);
        if (result == null) result = caseSelectExp(atomicExp);
        if (result == null) result = caseMExp(atomicExp);
        if (result == null) result = caseAExp(atomicExp);
        if (result == null) result = caseRExp(atomicExp);
        if (result == null) result = caseAndAlsoExp(atomicExp);
        if (result == null) result = caseOrElseExp(atomicExp);
        if (result == null) result = caseClosedExp(atomicExp);
        if (result == null) result = caseCaseExp(atomicExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.FIELD:
      {
        Field field = (Field)theEObject;
        T result = caseField(field);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GDSLPackage.VALUE_DECL:
      {
        ValueDecl valueDecl = (ValueDecl)theEObject;
        T result = caseValueDecl(valueDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecl(Decl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decl Export</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decl Export</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclExport(DeclExport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decl Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decl Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclVal(DeclVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ty Vars</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ty Vars</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTyVars(TyVars object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Con Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Con Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConDecl(ConDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ty</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ty</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTy(Ty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ty Bind</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ty Bind</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTyBind(TyBind object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ty Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ty Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTyElement(TyElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExp(Exp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Case Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Case Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCaseExp(CaseExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Closed Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Closed Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClosedExp(ClosedExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Monadic Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Monadic Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMonadicExp(MonadicExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Else Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Else Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrElseExp(OrElseExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Also Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Also Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndAlsoExp(AndAlsoExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RExp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RExp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRExp(RExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AExp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AExp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAExp(AExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MExp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MExp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMExp(MExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectExp(SelectExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Apply Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Apply Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplyExp(ApplyExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicExp(AtomicExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseField(Field object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueDecl(ValueDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //GDSLSwitch
