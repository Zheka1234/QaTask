package homework2.param;

import com.miskevich.homework1.service.impl.NumberInputImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ParamNumberInputTest {

    @ParameterizedTest
    @CsvSource({
            "10, 10",
            "0, 0",
            "-5, -5"
    })
    void testGetNumberInput(double expected, String input) {
        NumberInputImpl numberInput = new NumberInputImpl();
        Scanner scanner = new Scanner(input);
        double result = numberInput.getNumberInput(scanner, "Enter a number: ");
        Assertions.assertEquals(expected, result);
    }
}

