/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat May 03 20:31:31 GMT 2025
 */

package org.apache.commons.math3.optim.nonlinear.vector;

import shaded.org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import shaded.org.evosuite.runtime.sandbox.Sandbox;
import shaded.org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class Weight_ESTest_scaffolding {

  @org.junit.Rule 
  public shaded.org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new shaded.org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private shaded.org.evosuite.runtime.thread.ThreadStopper threadStopper =  new shaded.org.evosuite.runtime.thread.ThreadStopper (shaded.org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    shaded.org.evosuite.runtime.RuntimeSettings.className = "org.apache.commons.math3.optim.nonlinear.vector.Weight"; 
    shaded.org.evosuite.runtime.GuiSupport.initialize(); 
    shaded.org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    shaded.org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    shaded.org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    shaded.org.evosuite.runtime.RuntimeSettings.sandboxMode = shaded.org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    shaded.org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    shaded.org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    shaded.org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    shaded.org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    shaded.org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    shaded.org.evosuite.runtime.GuiSupport.setHeadless(); 
    shaded.org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    shaded.org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    shaded.org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    shaded.org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    shaded.org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    shaded.org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    shaded.org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("user.dir", "/home/cfee3/software/project/improving-automated-bug-finding-evosuite"); 
    java.lang.System.setProperty("java.io.tmpdir", "/tmp"); 
  }

  private static void initializeClasses() {
    shaded.org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Weight_ESTest_scaffolding.class.getClassLoader() ,
      "org.apache.commons.math3.linear.RealMatrixPreservingVisitor",
      "org.apache.commons.math3.exception.util.ExceptionContextProvider",
      "org.apache.commons.math3.linear.BlockRealMatrix",
      "org.apache.commons.math3.linear.FieldVector",
      "org.apache.commons.math3.linear.RealVector",
      "org.apache.commons.math3.linear.BlockFieldMatrix",
      "org.apache.commons.math3.exception.util.ArgUtils",
      "org.apache.commons.math3.exception.MathArithmeticException",
      "org.apache.commons.math3.exception.NumberIsTooSmallException",
      "org.apache.commons.math3.exception.OutOfRangeException",
      "org.apache.commons.math3.exception.NotPositiveException",
      "org.apache.commons.math3.linear.MatrixDimensionMismatchException",
      "org.apache.commons.math3.exception.MathIllegalStateException",
      "org.apache.commons.math3.linear.FieldMatrixPreservingVisitor",
      "org.apache.commons.math3.linear.NonSquareMatrixException",
      "org.apache.commons.math3.linear.FieldMatrix",
      "org.apache.commons.math3.linear.MatrixUtils",
      "org.apache.commons.math3.linear.ArrayRealVector",
      "org.apache.commons.math3.exception.MultiDimensionMismatchException",
      "org.apache.commons.math3.linear.NonSymmetricMatrixException",
      "org.apache.commons.math3.exception.MathIllegalArgumentException",
      "org.apache.commons.math3.exception.MathUnsupportedOperationException",
      "org.apache.commons.math3.linear.Array2DRowRealMatrix",
      "org.apache.commons.math3.exception.MathIllegalNumberException",
      "org.apache.commons.math3.util.CompositeFormat",
      "org.apache.commons.math3.exception.util.LocalizedFormats",
      "org.apache.commons.math3.linear.AbstractRealMatrix",
      "org.apache.commons.math3.linear.RealMatrixFormat",
      "org.apache.commons.math3.linear.Array2DRowFieldMatrix",
      "org.apache.commons.math3.exception.ZeroException",
      "org.apache.commons.math3.linear.AnyMatrix",
      "org.apache.commons.math3.exception.MathParseException",
      "org.apache.commons.math3.linear.AbstractFieldMatrix",
      "org.apache.commons.math3.exception.DimensionMismatchException",
      "org.apache.commons.math3.exception.util.Localizable",
      "org.apache.commons.math3.optim.OptimizationData",
      "org.apache.commons.math3.exception.NotStrictlyPositiveException",
      "org.apache.commons.math3.exception.util.ExceptionContext",
      "org.apache.commons.math3.exception.NullArgumentException",
      "org.apache.commons.math3.exception.NoDataException",
      "org.apache.commons.math3.linear.RealMatrix",
      "org.apache.commons.math3.linear.DiagonalMatrix",
      "org.apache.commons.math3.linear.RealMatrixChangingVisitor",
      "org.apache.commons.math3.optim.nonlinear.vector.Weight",
      "org.apache.commons.math3.linear.RealLinearOperator"
    );
  } 

  private static void resetClasses() {
    shaded.org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(Weight_ESTest_scaffolding.class.getClassLoader()); 

    shaded.org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.apache.commons.math3.optim.nonlinear.vector.Weight",
      "org.apache.commons.math3.linear.RealLinearOperator",
      "org.apache.commons.math3.linear.RealMatrixFormat",
      "org.apache.commons.math3.util.CompositeFormat",
      "org.apache.commons.math3.linear.AbstractRealMatrix",
      "org.apache.commons.math3.linear.BlockRealMatrix",
      "org.apache.commons.math3.exception.MathIllegalArgumentException",
      "org.apache.commons.math3.exception.MathIllegalNumberException",
      "org.apache.commons.math3.exception.NumberIsTooSmallException",
      "org.apache.commons.math3.exception.NotStrictlyPositiveException",
      "org.apache.commons.math3.exception.util.LocalizedFormats",
      "org.apache.commons.math3.exception.util.ExceptionContext",
      "org.apache.commons.math3.exception.util.ArgUtils",
      "org.apache.commons.math3.linear.MatrixUtils",
      "org.apache.commons.math3.linear.Array2DRowRealMatrix",
      "org.apache.commons.math3.linear.DiagonalMatrix",
      "org.apache.commons.math3.util.MathUtils",
      "org.apache.commons.math3.exception.DimensionMismatchException",
      "org.apache.commons.math3.linear.NonSquareMatrixException",
      "org.apache.commons.math3.exception.NoDataException",
      "org.apache.commons.math3.linear.RealVector",
      "org.apache.commons.math3.linear.RealVectorFormat",
      "org.apache.commons.math3.linear.ArrayRealVector",
      "org.apache.commons.math3.exception.NullArgumentException",
      "org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor",
      "org.apache.commons.math3.exception.MathUnsupportedOperationException",
      "org.apache.commons.math3.exception.OutOfRangeException"
    );
  }
}
