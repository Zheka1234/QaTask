package homework2.testNg;


import com.miskevich.homework1.service.ContinueInput;
import com.miskevich.homework1.service.impl.ContinueInputImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@Listeners(MyListenerCalculatorTestNg.class)
public class ContinueInputImplTestNg {

    private ContinueInput continueInput;
    private Scanner reader;

    @BeforeMethod
    public void setUp() {
        continueInput = new ContinueInputImpl();
    }

    @AfterMethod
    public void tearDown() {
        reader.close();
    }

    @DataProvider(name = "continueInputs", parallel = true)
    public Object[][] continueInputs() {
        return new Object[][]{
                {"y", true},
                {"n", false},
                {"x\ny", true}
        };
    }

    @Test(dataProvider = "continueInputs", groups = "calculator", priority = 3)
    public void testAskForContinue(String input, boolean expected) throws InterruptedException {

        Thread.sleep(200);
        reader = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean result = continueInput.askForContinue(reader);

        Assert.assertEquals(result, expected);
    }
}


