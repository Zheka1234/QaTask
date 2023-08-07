package homework2;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

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

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testGetOperatorInput_InvalidInput_ThrowsException() {
        String input = "invalid";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        try {
            operatorInput.getOperatorInput(reader);
        } finally {
            System.setIn(System.in);
        }
    }



}

