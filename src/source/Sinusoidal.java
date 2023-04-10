package source;

public class Sinusoidal extends Source {
    private double offset, periode;

    public Sinusoidal() {
        offset=0;
        periode=1e-7;
    }
    public Sinusoidal(double amplitude, double phi, double tempsSimulation, double offset, double periode) {
        super(amplitude, phi, tempsSimulation);
        this.offset=offset;
        this.periode=periode;
    }
    @Override
    public double genererSignal(double temps) {
        double Ve;
        if (temps>=0) Ve = offset + amplitude * Math.sin(2*Math.PI*temps/periode+phi);
        else Ve = 0;
        return Ve;
    }

    // getters
    public double getPeriode() {
        return periode;
    }
    public double getOffset() {
        return offset;
    }

    // setters
    public void setPeriode(double periode) {
        this.periode = periode;
    }
    public void setOffset(double offset) {
        this.offset = offset;
    }
}
