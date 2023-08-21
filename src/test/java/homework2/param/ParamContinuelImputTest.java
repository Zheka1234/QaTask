package homework2.param;

import com.miskevich.homework1.service.impl.ContinueInputImpl;
import homework2.MyListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

@ExtendWith({MyListener.class})
public class ParamContinuelImputTest {

    @ParameterizedTest
    @MethodSource("provideChoices")
    void testAskForContinue(boolean expected, String choice) {
        ContinueInputImpl continueInput = new ContinueInputImpl();
        Scanner scanner = new Scanner(choice);
        boolean result = continueInput.askForContinue(scanner);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Object[]> provideChoices() {
        return Stream.of(
                new Object[]{true, "y"},
                new Object[]{true, "Y"},
                new Object[]{false, "n"},
                new Object[]{false, "N"}

        );
    }
}

