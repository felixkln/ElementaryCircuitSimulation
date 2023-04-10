package circuits;

public class CircuitA extends PremierOrdre {
    private double R,C;

    public CircuitA() {
        super();
        R=50;
        C=1e-9;
    }
    public CircuitA(double h, double u0, double tempsSimulation, double R, double C) {
        super(h,u0,tempsSimulation);
        this.R=R;
        this.C=C;
    }

    @Override
    public double f(double temps, double un, double uprimen) {
        return (maSource.genererSignal(temps)-un)/(R*C);
    }

    // getters
    public double getR() {
        return R;
    }
    public double getC() {
        return C;
    }

    // setters
    public void setR(double r) {
        R = r;
    }
    public void setC(double c) {
        C = c;
    }
}
