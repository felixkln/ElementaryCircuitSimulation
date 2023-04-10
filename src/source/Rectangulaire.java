package source;

public class Rectangulaire extends Source {
    private double tempsHaut;

    public Rectangulaire() {tempsHaut=1e-7;}
    public Rectangulaire(double amplitude, double phi, double tempsSimulation, double tempsHaut) {
        super(amplitude, phi, tempsSimulation);
        this.tempsHaut=tempsHaut;
    }
    @Override
    public double genererSignal(double temps) {
        double Ve;
        if (temps>(phi+tempsHaut)||temps<phi) Ve=0;
        else Ve=amplitude;
        return Ve;
    }

    // getter
    public double getTempsHaut() {
        return tempsHaut;
    }

    // setter
    public void setTempsHaut(double tempsHaut) {
        this.tempsHaut = tempsHaut;
    }
}