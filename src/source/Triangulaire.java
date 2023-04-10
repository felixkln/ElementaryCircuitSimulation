package source;

public class Triangulaire extends Source {
    private double periode;

    public Triangulaire() {
        periode=1e-7;
    }
    public Triangulaire(double amplitude, double phi, double tempsSimulation, double periode) {
        super(amplitude, phi, tempsSimulation);
        this.periode=periode;
    }
    @Override
    public double genererSignal(double temps) {
        double Ve;
        // 4 équations différentes selon le temps
        if (temps<phi) {
            if (phi-temps>periode/2) Ve= 2*amplitude*(temps-phi+periode)/(periode);
            else Ve= -2*amplitude*(temps-phi)/(periode);
        }
        else {
            if (temps-phi%periode<periode/2) Ve=2*amplitude*(temps-phi%periode)/(periode);
            else Ve=-2*amplitude*(temps-phi%periode-periode)/(periode);
        }
        return Ve;
    }

    // getter
    public double getPeriode() {
        return periode;
    }

    // setter
    public void setPeriode(double periode) {
        this.periode = periode;
    }
}
