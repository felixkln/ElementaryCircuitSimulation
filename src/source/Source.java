package source;

public abstract class Source {
    protected double amplitude, phi, tempsSimulation;

    public Source() {
        amplitude=1;
        phi=0;
        tempsSimulation=1;
    }
    public Source(double amplitude, double phi, double tempsSimulation) {
        this.amplitude=amplitude;
        this.phi=phi;
        this.tempsSimulation=tempsSimulation;
    }
    // méthode qui diffère selon le type de signal : équation différente
    public abstract double genererSignal(double temps);

    // getters
    public double getAmplitude() {
        return amplitude;
    }
    public double getPhi() {
        return phi;
    }
    public double getTempsSimulation() {
        return tempsSimulation;
    }

    // setters
    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }
    public void setPhi(double phi) {
        this.phi = phi;
    }
    public void setTempsSimulation(double tempsSimulation) {
        this.tempsSimulation = tempsSimulation;
    }
}
