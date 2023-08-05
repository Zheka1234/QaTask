package homework2.test;

import com.miskevich.homework1.service.NumberInput;
import com.miskevich.homework1.service.impl.NumberInputImpl;
import homework2.MyListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MyListener.class})
public class NumberInputImplTest {


    @Test
    @DisplayName("should pass with the correct input of the first and second number")
    public void testGetNumberInput() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("1,3\n1,5");

        double actual = numberInput.getNumberInput(reader, "Enter a number: ");
        double actual1 = numberInput.getNumberInput(reader, "\n" + "Enter b number: ");

        assertEquals(1.3, actual);
        assertEquals(1.5, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a symbol in place of the first number")
    public void invalidTestGetNumberInputFirst() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("s\n1,3\n1,5");

        double actual = numberInput.getNumberInput(reader, "Enter a number: " + "\n");
        double actual1 = numberInput.getNumberInput(reader, "Enter b number: ");

        assertEquals(1.3, actual);
        assertEquals(1.5, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of the second number")
    public void invalidTestGetNumberInputSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("1,3\na\n1,5");

        double actual = numberInput.getNumberInput(reader, "Enter a number: ");
        double actual1 = numberInput.getNumberInput(reader, "\n" + "Enter b number: ");

        assertEquals(1.3, actual);
        assertEquals(1.5, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of first the first number then the second number")
    public void invalidTestGetNumberInputFirstAndSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("-\n2,2\na\n3,6");

        double actual = numberInput.getNumberInput(reader, "Enter a number: " + "\n");
        double actual1 = numberInput.getNumberInput(reader, "Enter b number: " + "\n");

        assertEquals(2.2, actual);
        assertEquals(3.6, actual1);

    }
}