package kalkulator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorServiceTest {

    KalkulatorService kalkulatorService;
    Kalkulator kalkulator = Mockito.mock(Kalkulator.class);


    @BeforeEach
    void setUp() {
        kalkulatorService = new KalkulatorService(kalkulator);
    }

    @Test
    void add6_test1() {
        Mockito.when(kalkulator.add(2,3)).thenReturn(80);
        Assertions.assertThat(kalkulatorService.add6(2,3)).isEqualTo(86);
    }

    @ParameterizedTest(name = "test {0} + {1} + 6 = {3} ")
    @CsvSource({"3,4,7,13", "23,45,68,74"})
    void add6_test1(int a, int b, int c, int d) {
        Mockito.when(kalkulator.add(a,b)).thenReturn(c);
        Assertions.assertThat(kalkulatorService.add6(a,b)).isEqualTo(d);
    }
}