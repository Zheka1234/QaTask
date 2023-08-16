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
    @DisplayName("multiplication check of 2 long numbers")
    public void testMultiplicationWithLongNumbers() {
        String input = "100000000000\n200000000000\n*\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();
    }

    @Test
    @DisplayName("addition check with strings")
    public void testAdditionWithStrings() {
        String input = "Hello\n3\nWorld\n5\n+\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();
    }

    @Test
    @DisplayName("check division of 2 floating-point numbers")
    public void testDivisionWithFloatingPointNumbers() {
        String input = "3,5\n2,1\n/\nn\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        calculatorInput.start();
    }

    @Test
    @DisplayName("subtraction check with negative numbers")
    public void testSubtractionWithNegativeNumbers() {
        String input = "-10\n-5\n-\nn\n";
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
    public void testInvalidContinueInput1() {
        String input = "5\n3\n+\nz\nn";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        calculatorInput.start();

        String expectedOutput = "Enter first number: Enter second number: Choose an operator (+, -, *, /): Result: 5.0 + 3.0 = 8.0\n" +
                "Do you want to continue? (y/n): Error: Invalid input. Type 'y' to continue or 'n' to end: \r\n\nDo you want to continue? (y/n):";
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

}