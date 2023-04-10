package circuits;

public class CircuitC extends SecondOrdre{
    public CircuitC() { super(); };
    public CircuitC(double h, double u0, double tempsSimulation, double uprime0, double R, double L, double C) {
        super(h,u0,tempsSimulation,uprime0,R,L,C);
    }

    @Override
    public double f(double temps, double un, double uprimen) {
        return -(R/L)*uprimen + (maSource.genererSignal(temps)-un)/(L*C);
    }
}
