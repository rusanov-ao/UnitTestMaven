import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BankCalculatorTest {
    BankCalculator sut;

    @BeforeAll
    public static void startedAll() {
        System.out.println("All test started");
    }

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new BankCalculator();
    }


    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("All tests completed");
    }

    @Test
    public void testPow() {
        int a = 5;
        int expected = 25;
        int result = sut.pow(a);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAbs() {
        int a = 10;
        int expected = 10;
        int result = sut.abs(a);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testProcent() {
        int a = 100000;
        int b = 13;
        int expected = 13000;
        int result = sut.procent(a, b);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testComparison() {
        int a = 10;
        int b = 15;
        int expected = -1;
        int result = sut.comparison(a, b);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testProcent(int a, int b, int expected) {
        int result = sut.procent(a, b);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(50000, 15, 7500),
                Arguments.of(285000, 89, 253650),
                Arguments.of(15000, 23, 3450),
                //Arguments.of(2000, 8, 5), // специально поставил не верный expected
                Arguments.of(567657634, 35, 198680160));
    }

    @Test
    public void testDivideAndPow() {
        int a = 10;
        int b = 5;
        int expected = 4;
        int result = sut.divideAndPow(a, b);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDivideAndPowByZero() {
        int a = 5;
        int b = 0;

        var expected = ArithmeticException.class;

        Assertions.assertThrows(expected, () -> sut.divideAndPow(a, b));
    }

    @Test
    public void testDivideAndPowByNonZero() {
        int a = 525;
        int b = 5;

        Assertions.assertDoesNotThrow(() -> sut.divideAndPow(a, b));
    }
}

