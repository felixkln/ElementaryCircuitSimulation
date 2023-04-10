package circuits;

public class CircuitD extends SecondOrdre{
    public CircuitD() { super(); };
    public CircuitD(double h, double u0, double tempsSimulation, double uprime0, double R, double L, double C) {
        super(h,u0,tempsSimulation,uprime0,R,L,C);
    }

    @Override
    public double f(double temps, double un, double uprimen) {
        return ((maSource.genererSignal(temps)- maSource.genererSignal(temps-h))/(h)-uprimen)/(R*C)-un/(L*C);
    }
}