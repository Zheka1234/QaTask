package homework2.param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class ParamCalculatorTest {

    @ParameterizedTest
    @MethodSource("additionData")
    void testAddition(int num1, int num2, int expectedSum) {
        int sum = num1 + num2;
        assertEquals(expectedSum, sum);
    }

    @ParameterizedTest
    @MethodSource("additionData")
    void testAddition(double num1, double num2, double expectedSum) {
        double sum = num1 + num2;
        assertEquals(expectedSum, sum);
    }

    @ParameterizedTest
    @MethodSource("additionData")
    void testAddition(float num1, float num2, float expectedSum) {
        float sum = num1 + num2;
        assertEquals(expectedSum, sum);
    }

    @ParameterizedTest
    @MethodSource("longAdditionData")
    void testLongAddition(long num1, long num2, long expectedSum) {
        long sum = num1 + num2;
        assertEquals(expectedSum, sum);
    }

    @ParameterizedTest
    @MethodSource("longSubtractionData")
    void testLongSubtraction(long num1, long num2, long expectedDifference) {
        long difference = num1 - num2;
        assertEquals(expectedDifference, difference);
    }

    @ParameterizedTest
    @MethodSource("subtractionData")
    void testSubtraction(int num1, int num2, int expectedDifference) {
        int difference = num1 - num2;
        assertEquals(expectedDifference, difference);
    }

    @ParameterizedTest
    @MethodSource("subtractionData")
    void testSubtraction(double num1, double num2, double expectedDifference) {
        double difference = num1 - num2;
        assertEquals(expectedDifference, difference);
    }

    @ParameterizedTest
    @MethodSource("subtractionData")
    void testSubtraction(float num1, float num2, float expectedSum) {
        float difference = num1 - num2;
        assertEquals(expectedSum, difference);
    }

    @ParameterizedTest
    @MethodSource("concatenationData")
    void testConcatenation(String str1, String str2, String expectedConcatenation) {
        String concatenation = str1 + " " + str2;
        assertEquals(expectedConcatenation, concatenation);
    }

    @ParameterizedTest
    @MethodSource("substringData")
    void testSubstring(String str, String substring, String expectedSubstring) {
        String result = str.replace(substring, "");
        assertEquals(expectedSubstring, result);
    }

    @ParameterizedTest
    @MethodSource("multiplicationData")
    void testMultiplication(float num1, float num2, float expectedProduct) {
        float product = num1 * num2;
        assertEquals(expectedProduct, product);
    }

    @ParameterizedTest
    @MethodSource("divisionData")
    void testDivision(int num1, int num2, int expectedQuotient) {
        int quotient = num1 / num2;
        assertEquals(expectedQuotient, quotient);
    }

    @ParameterizedTest
    @MethodSource("stringMultiplicationData")
    void testStringMultiplication(String str, int multiplier, String expectedString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            result.append(str);
        }
        assertEquals(expectedString, result.toString());
    }

    @ParameterizedTest
    @MethodSource("doubleMultiplicationData")
    void testDoubleMultiplication(double num1, double num2, double expectedProduct) {
        double product = num1 * num2;
        assertEquals(expectedProduct, product);
    }

    @ParameterizedTest
    @MethodSource("integerDivisionData")
    void testIntegerDivision(int num1, int num2, int expectedQuotient) {
        int quotient = num1 / num2;
        assertEquals(expectedQuotient, quotient);
    }

    @ParameterizedTest
    @MethodSource("doubleDivisionData")
    void testDoubleDivision(double num1, double num2, double expectedQuotient) {
        double quotient = num1 / num2;
        assertEquals(expectedQuotient, quotient);
    }

    @ParameterizedTest
    @MethodSource("longMultiplicationData")
    void testLongMultiplication(long num1, long num2, long expectedProduct) {
        long product = num1 * num2;
        assertEquals(expectedProduct, product);
    }

    @ParameterizedTest
    @MethodSource("longDivisionData")
    void testLongDivision(long num1, long num2, long expectedQuotient) {
        long quotient = num1 / num2;
        assertEquals(expectedQuotient, quotient);
    }

    @ParameterizedTest
    @MethodSource("stringDivisionData")
    void testStringDivision(String str, String divisor, String expectedQuotient) {
        String quotient = str.replace(divisor, "");
        assertEquals(expectedQuotient, quotient);
    }

// Data sources

    static Stream<Arguments> additionData() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(4, 5, 9),
                Arguments.of(10, 2, 12)
        );
    }

    static Stream<Arguments> longAdditionData() {
        return Stream.of(
                Arguments.of(2L, 3L, 5L),
                Arguments.of(10L, 5L, 15L),
                Arguments.of(100L, 200L, 300L)
        );
    }

    static Stream<Arguments> longSubtractionData() {
        return Stream.of(
                Arguments.of(10L, 5L, 5L),
                Arguments.of(100L, 50L, 50L),
                Arguments.of(200L, 150L, 50L)
        );
    }

    static Stream<Arguments> subtractionData() {
        return Stream.of(
                Arguments.of(5, 3, 2),
                Arguments.of(10, 5, 5),
                Arguments.of(20, 2, 18)
        );
    }

    static Stream<Arguments> concatenationData() {
        return Stream.of(
                Arguments.of("Hello", "World", "Hello World"),
                Arguments.of("Java", "Programming", "Java Programming"),
                Arguments.of("Parameterized", "Testing", "Parameterized Testing")
        );
    }

    static Stream<Arguments> substringData() {
        return Stream.of(
                Arguments.of("Hello", "lo", "Hel"),
                Arguments.of("World", "ld", "Wor"),
                Arguments.of("JUnit", "nit", "JU")
        );
    }

    static Stream<Arguments> multiplicationData() {
        return Stream.of(
                Arguments.of(2.5f, 3.5f, 8.75f),
                Arguments.of(4.2f, 5.7f, 23.939999f),
                Arguments.of(10.1f, 2.2f, 22.220001f)
        );
    }

    static Stream<Arguments> divisionData() {
        return Stream.of(
                Arguments.of(6, 3, 2),
                Arguments.of(10, 5, 2),
                Arguments.of(20, 2, 10)
        );
    }

    static Stream<Arguments> stringMultiplicationData() {
        return Stream.of(
                Arguments.of("Hello", 3, "HelloHelloHello"),
                Arguments.of("World", 2, "WorldWorld"),
                Arguments.of("JUnit", 4, "JUnitJUnitJUnitJUnit")
        );
    }

    static Stream<Arguments> doubleMultiplicationData() {
        return Stream.of(
                Arguments.of(2.5, 1.5, 3.75),
                Arguments.of(5.0, 2.7, 13.5),
                Arguments.of(10.1, 2.1, 21.21)
        );
    }

    static Stream<Arguments> integerDivisionData() {
        return Stream.of(
                Arguments.of(6, 3, 2),
                Arguments.of(10, 5, 2),
                Arguments.of(20, 2, 10)
        );
    }

    static Stream<Arguments> doubleDivisionData() {
        return Stream.of(
                Arguments.of(2.5, 1.5, 1.6666666666666667),
                Arguments.of(5.7, 2.7, 2.111111111111111),
                Arguments.of(10.1, 2.1, 4.809523809523809)
        );
    }

    static Stream<Arguments> longMultiplicationData() {
        return Stream.of(
                Arguments.of(2L, 3L, 6L),
                Arguments.of(4L, 5L, 20L),
                Arguments.of(10L, 2L, 20L)
        );
    }

    static Stream<Arguments> longDivisionData() {
        return Stream.of(
                Arguments.of(100L, 5L, 20L),
                Arguments.of(64L, 8L, 8L),
                Arguments.of(81L, 9L, 9L)
        );
    }

    static Stream<Arguments> stringDivisionData() {
        return Stream.of(
                Arguments.of("Hello World", "World", "Hello "),
                Arguments.of("Java Programming", "Programming", "Java "),
                Arguments.of("Parameterized Testing", "Testing", "Parameterized ")
        );
    }
}