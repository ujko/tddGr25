package kalkulator;

public class KalkulatorService {
    private Kalkulator kalkulator;

    public KalkulatorService(Kalkulator kalkulator) {
        this.kalkulator = kalkulator;
    }

    public int add6(int a, int b) {
        return kalkulator.add(a,b) + 6;
    }
}
