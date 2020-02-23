package binary;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;


class BinaryTest extends Binary {


    @BeforeEach
    void setUp() {
    }

    @DisplayName("should return number of 0 between 1")
    @ParameterizedTest(name="Given {0} than {1}")
    @CsvSource({"1000,0","10001,3","1010001,3","111011,1"})
    void countZeroBetweenOnes_test1(String a,int b) {
          Assertions.assertThat(countZeroBetweenOnes(a)).isEqualTo(b);

    }

    @DisplayName("should return binary number from intiger")
    @ParameterizedTest
    @ValueSource(ints={-11,-10,-3,0,12,31,159,3007})
    @Tag("fast")
    void binary_test1(int a) {
        Assertions.assertThat(binary(a)).isEqualTo(Integer.toBinaryString(a));
    }

    @Test
    @Tag("fast")
    void binary_tet1() {
    }

    @DisplayName("Integrated test - should return binary number from intiger")
    @ParameterizedTest
    @CsvSource({"54,1","566,3","4640,3","1,0","-9,1"})
    @Tag("fast")
    void testGiveResult(int dec, int count) {
        Assertions.assertThat(giveResult(dec)).isEqualTo(count);
    }

    @Test
    void ttt() throws InterruptedException {
        long s = System.currentTimeMillis();
        timeOutTest();
        Assertions.assertThat(System.currentTimeMillis()).isCloseTo(s, Percentage.withPercentage(3));
    }


    @Test
    void test1() {
        org.junit.jupiter.api.Assertions.assertTimeout(Duration.ofMillis(200), () -> timeOutTest());
    }

    @Test
    @Timeout(2)
    void test2() throws InterruptedException {
        Assertions.assertThat(timeOutTest()).isEqualTo(36);
    }

}