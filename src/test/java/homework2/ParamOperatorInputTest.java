package homework2;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;


public class ParamOperatorInputTest {
    private OperatorInputImpl operatorInput = new OperatorInputImpl();

    @DisplayName("Test invalid operator inputs")
    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("invalidInputs")
    void testInvalidOperatorInputs(String input) {
        Scanner scanner = new Scanner(input);
        Assertions.assertThrows(NoSuchElementException.class, () -> operatorInput.getOperatorInput(scanner));
    }

    @DisplayName("Test valid operator input")
    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("validInputs")
    void testValidOperatorInput(String input) {
        Scanner scanner = new Scanner(input);
        Assertions.assertDoesNotThrow(() -> operatorInput.getOperatorInput(scanner));
    }

    private static Stream<String> validInputs() {
        return Stream.of("+", "-", "*", "/");
    }

    private static Stream<String> invalidInputs() {
        return Stream.of("=", "abc", "1", "++", "--", "**", "//");
    }
}