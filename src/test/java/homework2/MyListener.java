package homework2;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyListener implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {


    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("start of all tests");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("end of all tests");
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("\n" + "test start");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.out.println("\n" + "end of test");
    }
}
