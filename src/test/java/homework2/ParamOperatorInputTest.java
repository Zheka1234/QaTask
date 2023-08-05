package homework2;

import com.miskevich.homework1.service.impl.OperatorInputImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

//Тут я пробывал написать тест с параметрами=)было очень весело=)
//Это же нормально,что первый валится,так как я проверяю только не допустимый ввод,а второй гуд проходит?
//При этом если запустить ParamOperatorInputTest первый покажет кучу выбросов исключения на неверные вводы значени,
//потом запускается и вводятся нужные операторы и все гуд.Но в итоге мне не нравится,что пишет вот так
//Process finished with exit code -1 это нормально? а если запустить чисто testValidOperatorInput то Process finished with exit code 0
public class ParamOperatorInputTest {
    private OperatorInputImpl operatorInput = new OperatorInputImpl();

    @DisplayName("Test invalid operator inputs")
    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("invalidInputs")
    void testInvalidOperatorInputs(String input) {
        Scanner scanner = new Scanner(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> operatorInput.getOperatorInput(scanner));
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