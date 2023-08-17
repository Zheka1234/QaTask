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

    @Test
    @DisplayName("should pass with the correct input of the first and second number")
    public void testGetNumberInputFloat() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("1,3\n1,5");

        float actual = numberInput.getNumberInputFloat(reader, "Enter a number: ");
        float actual1 = numberInput.getNumberInputFloat(reader, "\n" + "Enter b number: ");

        assertEquals(1.3f, actual);
        assertEquals(1.5f, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a symbol in place of the first number")
    public void invalidTestGetNumberInputFloatFirst() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("s\n1,3\n1,5");

        float actual = numberInput.getNumberInputFloat(reader, "Enter a number: " + "\n");
        float actual1 = numberInput.getNumberInputFloat(reader, "Enter b number: ");

        assertEquals(1.3f, actual);
        assertEquals(1.5f, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of the second number")
    public void invalidTestGetNumberInputFloatSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("1,3\na\n1,5");

        float actual = numberInput.getNumberInputFloat(reader, "Enter a number: ");
        float actual1 = numberInput.getNumberInputFloat(reader, "\n" + "Enter b number: ");

        assertEquals(1.3f, actual);
        assertEquals(1.5f, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of first the first number then the second number")
    public void invalidTestGetNumberInputFloatFirstAndSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("-\n2,2\na\n3,6");

        float actual = numberInput.getNumberInputFloat(reader, "Enter a number: " + "\n");
        float actual1 = numberInput.getNumberInputFloat(reader, "Enter b number: " + "\n");

        assertEquals(2.2f, actual);
        assertEquals(3.6f, actual1);

    }

    @Test
    @DisplayName("should pass with the correct input of the first and second number")
    public void testGetNumberInputLong() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("13\n15");

        long actual = numberInput.getNumberInputLong(reader, "Enter a number: ");
        long actual1 = numberInput.getNumberInputLong(reader, "\n" + "Enter b number: ");

        assertEquals(13l, actual);
        assertEquals(15l, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a symbol in place of the first number")
    public void invalidTestGetNumberInputLongFirst() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("s\n13\n15");

        long actual = numberInput.getNumberInputLong(reader, "Enter a number: " + "\n");
        long actual1 = numberInput.getNumberInputLong(reader, "Enter b number: ");

        assertEquals(13l, actual);
        assertEquals(15l, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of the second number")
    public void invalidTestGetNumberInputLongSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("13\na\n15");

        long actual = numberInput.getNumberInputLong(reader, "Enter a number: ");
        long actual1 = numberInput.getNumberInputLong(reader, "\n" + "Enter b number: ");

        assertEquals(13l, actual);
        assertEquals(15l, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of first the first number then the second number")
    public void invalidTestGetNumberInputLongFirstAndSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("-\n22\na\n36");

        long actual = numberInput.getNumberInputLong(reader, "Enter a number: " + "\n");
        long actual1 = numberInput.getNumberInputLong(reader, "Enter b number: " + "\n");

        assertEquals(22L, actual);
        assertEquals(36L, actual1);

    }

    @Test
    @DisplayName("should pass with the correct input of the first and second number")
    public void testGetNumberInputInt() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("13\n15");

        int actual = numberInput.getNumberInputInt(reader, "Enter a number: ");
        int actual1 = numberInput.getNumberInputInt(reader, "\n" + "Enter b number: ");

        assertEquals(13, actual);
        assertEquals(15, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a symbol in place of the first number")
    public void invalidTestGetNumberInputIntFirst() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("s\n13\n15");

        int actual = numberInput.getNumberInputInt(reader, "Enter a number: " + "\n");
        int actual1 = numberInput.getNumberInputInt(reader, "Enter b number: ");

        assertEquals(13, actual);
        assertEquals(15, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of the second number")
    public void invalidTestGetNumberInputIntSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("13\na\n15");

        int actual = numberInput.getNumberInputInt(reader, "Enter a number: ");
        int actual1 = numberInput.getNumberInputInt(reader, "\n" + "Enter b number: ");

        assertEquals(13, actual);
        assertEquals(15, actual1);

    }

    @Test
    @DisplayName("should return an error when entering a character instead of first the first number then the second number")
    public void invalidTestGetNumberInputIntFirstAndSecond() {

        NumberInput numberInput = new NumberInputImpl();
        Scanner reader = new Scanner("-\n22\na\n36");

        int actual = numberInput.getNumberInputInt(reader, "Enter a number: " + "\n");
        int actual1 = numberInput.getNumberInputInt(reader, "Enter b number: " + "\n");

        assertEquals(22, actual);
        assertEquals(36, actual1);

    }
}