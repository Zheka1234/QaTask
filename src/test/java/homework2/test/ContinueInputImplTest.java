package homework2.test;

import com.miskevich.homework1.service.impl.ContinueInputImpl;
import homework2.MyListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@ExtendWith({MyListener.class})
public class ContinueInputImplTest {
    private ContinueInputImpl continueInput;

    @BeforeEach
    public void setUp() {
        continueInput = new ContinueInputImpl();
    }

    @Test
    @DisplayName("checking for valid  input y")
    public void testAskForContinue_WhenUserChoosesYes_ReturnsTrue() {
        String input = "y";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        boolean result = continueInput.askForContinue(reader);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("checking for valid input n")
    public void testAskForContinue_WhenUserChoosesNo_ReturnsFalse() {
        String input = "n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        boolean result = continueInput.askForContinue(reader);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("should return an error if the choice is not the correct choice, then the choice is correct")
    public void testAskForContinue_WhenUserEntersInvalidInput_ContinuesToPrompt() {
        String input = "invalid\ny";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        boolean result = continueInput.askForContinue(reader);
        Assertions.assertTrue(result);
    }
}