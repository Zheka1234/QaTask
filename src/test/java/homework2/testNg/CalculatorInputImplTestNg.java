package homework2.testNg;

import com.miskevich.homework1.service.ContinueInput;
import com.miskevich.homework1.service.NumberInput;
import com.miskevich.homework1.service.impl.CalculatorInputImpl;
import com.miskevich.homework1.service.impl.ContinueInputImpl;
import com.miskevich.homework1.service.impl.NumberInputImpl;
import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Listeners(MyListenerCalculatorTestNg.class)
public class CalculatorInputImplTestNg {

    private CalculatorInputImpl calculatorInput;

    @BeforeMethod
    public void setUp() {
        NumberInput numberInput = new NumberInputImpl();
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        ContinueInput continueInput = new ContinueInputImpl();
        calculatorInput = new CalculatorInputImpl(numberInput, operatorInput, continueInput);
    }

    @DataProvider(name = "calculationData", parallel = true)
    public Object[][] getCalculationData() {
        return new Object[][]{
                {"5\n3\n+\nn\n"},
                {"8\n4\n-\nn\n"},
                {"2\n6\n*\nn\n"},
                {"10\n2\n/\nn\n"},
                {"5\n0\n/\nn\n"}
        };
    }

    @Test(dataProvider = "calculationData", groups = "calculator", priority = 2)
    public void testStart(String input) throws InterruptedException {
        Thread.sleep(1000);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculatorInput.start();


    }

    @AfterMethod
    public void restoreSystemInput() {
        System.setIn(System.in);
    }
}

