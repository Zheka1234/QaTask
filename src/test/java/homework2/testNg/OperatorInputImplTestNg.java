package homework2.testNg;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

@Listeners(MyListenerCalculatorTestNg.class)
public class OperatorInputImplTestNg {

    private OperatorInputImpl operatorInput;
    private Scanner reader;

    @BeforeMethod
    public void setUp() {
        operatorInput = new OperatorInputImpl();
    }

    @AfterMethod
    public void tearDown() {
        reader.close();
        System.setIn(System.in);
    }

    @DataProvider(name = "validInputs", parallel = true)
    public Object[][] validInputs() {
        return new Object[][]{
                {"+", '+'},
                {"-", '-'},
                {"*", '*'},
                {"/", '/'}
        };
    }

    @Test(dataProvider = "validInputs", groups = "calculator", retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void testGetOperatorInput_ValidInput_ReturnsOperator(String input, char expected) throws InterruptedException {

        Thread.sleep(1000);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        reader = new Scanner(System.in);

        char result = operatorInput.getOperatorInput(reader);

        assertEquals(expected, result);
    }

    @Test(expectedExceptions = NoSuchElementException.class, groups = "calculator")
    public void testGetOperatorInput_InvalidInput_ThrowsException() {

        String input = "invalid";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        reader = new Scanner(System.in);

        operatorInput.getOperatorInput(reader);
        System.setIn(System.in);
    }
}

