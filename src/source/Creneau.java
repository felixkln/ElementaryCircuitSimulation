package source;

public class Creneau extends Source {
    private double rapportCyclique, periode;

    public Creneau() {
        rapportCyclique=0.5;
        periode=2e-7;
    }
    public Creneau(double amplitude, double phi, double tempsSimulation, double rapportCyclique, double periode) {
        super(amplitude, phi, tempsSimulation);
        this.rapportCyclique=rapportCyclique;
        this.periode=periode;
    }
    @Override
    public double genererSignal(double temps) {
        double Ve;
        if ((temps%periode>phi+periode*rapportCyclique)||(temps%periode<phi)) Ve=0;
        else Ve=amplitude;
        return Ve;
    }

    // getters
    public double getPeriode() {
        return periode;
    }
    public double getRapportCyclique() {
        return rapportCyclique;
    }

    // setters
    public void setPeriode(double periode) {
        this.periode = periode;
    }
    public void setRapportCyclique(double rapportCyclique) {
        this.rapportCyclique = rapportCyclique;
    }
}
