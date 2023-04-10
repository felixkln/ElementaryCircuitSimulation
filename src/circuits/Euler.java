package circuits;

import source.Source;

public abstract class Euler {
    protected double h, u0, un, tempsSimulation;
    protected Source maSource;

    public Euler() {
        u0=0;
        h=1e-9;
        tempsSimulation=1e-6;
    }
    public Euler(double h, double u0, double tempsSimulation) {
        this.h=h;
        this.u0=u0;
        this.tempsSimulation=tempsSimulation;
    }
    public abstract void solve();
    public abstract double f(double temps, double un, double uprimen);

    // getters
    public double getH() {
        return h;
    }
    public double getU0() {
        return u0;
    }
    public double getTempsSimulation() {
        return tempsSimulation;
    }
    public Source getMaSource() {
        return maSource;
    }

    // setters
    public void setH(double h) {
        this.h = h;
    }
    public void setU0(double u0) {
        this.u0 = u0;
    }
    public void setTempsSimulation(double tempsSimulation) {
        this.tempsSimulation = tempsSimulation;
    }
    public void setMaSource(Source maSource) {
        this.maSource = maSource;
    }
}
