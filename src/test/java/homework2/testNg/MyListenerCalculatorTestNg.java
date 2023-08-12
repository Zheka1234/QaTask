package homework2.testNg;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerCalculatorTestNg implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed due to a bug: " + result.getName());
    }


    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test completed successfully: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test skipped: " + result.getName());
    }
}
