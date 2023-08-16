package homework2.testNg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;

    private final int retryLimit = 20;

    @Override
    public boolean retry(ITestResult result) {
        if (++counter < retryLimit) {
            return true;
        } else {
            return false;
        }

    }
}
