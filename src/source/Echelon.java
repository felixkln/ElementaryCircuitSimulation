package source;

public class Echelon extends Source {
    public Echelon() {};
    public Echelon(double amplitude, double phi, double tempsSimulation) {
        super(amplitude, phi, tempsSimulation);
    }
    @Override
    public double genererSignal(double temps) {
        double Ve;
        if (temps >= phi) Ve = amplitude;
        else Ve = 0;
        return Ve;
    }
}
