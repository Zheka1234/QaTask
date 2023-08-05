package homework2.test;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import homework2.MyListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MyListener.class})
public class OperatorInputImplTest {

    @Test
    @DisplayName("checking for valid operator input")
    void validOperatorInputTest() {
        String input = "+";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        char result = operatorInput.getOperatorInput(new Scanner(System.in));
        assertEquals('+', result);
    }

    @Test
    @DisplayName("should return an error if an incorrect operator is selected and require the correct operator to be entered")
    void invalidOperatorInputTest() {
        String input = "x\n-";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        char result = operatorInput.getOperatorInput(new Scanner(System.in));
        assertEquals('-', result);
    }

}
