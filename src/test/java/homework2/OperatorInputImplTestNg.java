package homework2;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

//Тут я попробывал TestNg они сразу 2 выполняються, но  2 не пройдет потомучто не верные операторы это эе нормально?=),
//а для первого вот, что пишет.

// SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
//SLF4J: Defaulting to no-operation (NOP) logger implementation
//SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
//Choose an operator (+, -, *, /):
//===============================================
//Default Suite
//Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
//===============================================
//
//
//Process finished with exit code 0
public class OperatorInputImplTestNg {


    @Test
    public void testGetOperatorInput_ValidInput_ReturnsOperator() {
        String input = "+";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        char result = operatorInput.getOperatorInput(reader);
        assertEquals('+', result);
        System.setIn(System.in);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetOperatorInput_InvalidInput_ThrowsException() {
        String input = "invalid";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        try {
            assertThrows(IllegalArgumentException.class, () -> operatorInput.getOperatorInput(reader));
        } finally {
            System.setIn(System.in);
        }
    }
//Вот, что пишет когда запуск сразу двух

// SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
//SLF4J: Defaulting to no-operation (NOP) logger implementation
//SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
//Choose an operator (+, -, *, /): Error: Invalid operator. Please try again.
//
//org.testng.TestException:
//Expected exception of type class java.lang.IllegalArgumentException but got java.lang.AssertionError: Expected IllegalArgumentException to be thrown, but NoSuchElementException was thrown
//
//	at org.testng.internal.invokers.ExpectedExceptionsHolder.wrongException(ExpectedExceptionsHolder.java:67)
//	at org.testng.internal.invokers.TestInvoker.considerExceptions(TestInvoker.java:850)
//	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:718)
//	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:227)
//	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:50)
//	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:957)
//	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:200)
//	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
//	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
//	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
//	at org.testng.TestRunner.privateRun(TestRunner.java:848)
//	at org.testng.TestRunner.run(TestRunner.java:621)
//	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
//	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
//	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
//	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
//	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
//	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
//	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1280)
//	at org.testng.TestNG.runSuitesLocally(TestNG.java:1200)
//	at org.testng.TestNG.runSuites(TestNG.java:1114)
//	at org.testng.TestNG.run(TestNG.java:1082)
//	at com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)
//	at com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)
//Caused by: java.lang.AssertionError: Expected IllegalArgumentException to be thrown, but NoSuchElementException was thrown
//	at org.testng.Assert.expectThrows(Assert.java:2451)
//	at org.testng.Assert.expectThrows(Assert.java:2422)
//	at org.testng.Assert.assertThrows(Assert.java:2388)
//	at homework2.OperatorInputImplTestNg.testGetOperatorInput_InvalidInput_ThrowsException(OperatorInputImplTestNg.java:48)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
//	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
//	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
//	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
//	... 21 more
//Caused by: java.util.NoSuchElementException: No line found
//	at java.base/java.util.Scanner.nextLine(Scanner.java:1651)
//	at com.miskevich.homework1.service.impl.OperatorInputImpl.getOperatorInput(OperatorInputImpl.java:26)
//	at homework2.OperatorInputImplTestNg.lambda$testGetOperatorInput_InvalidInput_ThrowsException$0(OperatorInputImplTestNg.java:48)
//	at org.testng.Assert.expectThrows(Assert.java:2441)
//	... 30 more
//
//Choose an operator (+, -, *, /):
//===============================================
//Default Suite
//Total tests run: 2, Passes: 1, Failures: 1, Skips: 0
//===============================================
//
//
//Process finished with exit code 0


}

