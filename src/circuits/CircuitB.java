package circuits;

public class CircuitB extends PremierOrdre {
    private double R1,R2,C;
    final double VBE=0.6; // constante : tension de seuil de la diode

    public CircuitB() {
        super();
        R1=100;
        R2=100;
        C=1e-9;
    }
    public CircuitB(double h, double u0, double tempsSimulation, double R1, double R2, double C) {
        super(h,u0,tempsSimulation);
        this.R1=R1;
        this.R2=R2;
        this.C=C;
    }
    @Override
    public double f(double temps, double un, double uprimen) {
        if (maSource.genererSignal(temps)>VBE) return -(1/(R1*C)+1/(R2*C))*un+(maSource.genererSignal(temps)-VBE)/(R1*C);
        else return -un/(R2*C);
    }

    // getters
    public double getR1() {
        return R1;
    }
    public double getR2() {
        return R2;
    }
    public double getC() {
        return C;
    }

    // setters
    public void setR(double r1) {
        R1 = r1;
    }
    public void setR2(double r2) {
        R2 = r2;
    }
    public void setC(double c) {
        C = c;
    }
}
