package homework2.test;

import com.miskevich.homework1.service.ContinueInput;
import com.miskevich.homework1.service.NumberInput;
import com.miskevich.homework1.service.OperationInput;
import com.miskevich.homework1.service.impl.CalculatorInputImpl;
import com.miskevich.homework1.service.impl.ContinueInputImpl;
import com.miskevich.homework1.service.impl.NumberInputImpl;
import com.miskevich.homework1.service.impl.OperatorInputImpl;
import homework2.MyListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@ExtendWith({MyListener.class})
public class CalculatorInputImplTest {
    private CalculatorInputImpl calculatorInput;

    @BeforeEach
    public void setup() {
        NumberInput numberInput = new NumberInputImpl();
        OperationInput operationInput = new OperatorInputImpl();
        ContinueInput continueInput = new ContinueInputImpl();
        calculatorInput = new CalculatorInputImpl(numberInput, operationInput, continueInput);
    }

    @Test
    @DisplayName("addition check 2 numbers")
    public void testAddition() {
        String input = "5\n3\n+\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("subtraction check 2 numeral")
    public void testSubtraction() {
        String input = "10\n2\n-\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("multiplication check of 2 numeral")
    public void testMultiplication() {
        String input = "4\n5\n*\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("check division 2 numeral")
    public void testDivision() {
        String input = "10\n2\n/\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("check division by zero")
    public void testDivisionByZero() {
        String input = "10\n0\n/\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("check division by zero")
    public void testInvalidOperator() {
        String input = "5\n3\n&\n+\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("input check for incorrect input of the first number")
    public void testInvalidFirstNumberInput() {
        String input = "a\n3\n5\n+\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("checking for incorrect input of the second number")
    public void testInvalidSecondNumberInput() {
        String input = "5\na\n3\n+\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();

    }

    @Test
    @DisplayName("checking input is not correct input continue work")
    public void testInvalidContinueInput() {
        String input = "5\n3\n+\nz\nn";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();
    }

//  пример теста Assertions он жалуется, что передается не то, что в актуал
// org.opentest4j.AssertionFailedError:
//<Click to see difference> я тут сделал одинаковое,что передается и что ожидает одинаково,всеравно ошибка
//
//
//	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
//	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
//	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
//	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:182)
//	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:177)
//	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:1141)
//	at homework2.test.CalculatorInputImplTest.testInvalidContinueInput1(CalculatorInputImplTest.java:124)
//	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
//	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
//	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
//    @Test
//    public void testInvalidContinueInput1() {
//        String input = "5\n3\n+\nz\nn";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//        calculatorInput.start();
//
//        String expectedOutput = "Enter first number: Enter second number: Choose an operator (+, -, *, /): Result: 5.0 + 3.0 = 8.0\n" +
//                "Do you want to continue? (y/n): Error: Invalid input. Type 'y' to continue or 'n' to end: \n\nDo you want to continue? (y/n):";
//        String actualOutput = outputStream.toString().trim();
//        Assertions.assertEquals(expectedOutput, actualOutput);
//    }

}