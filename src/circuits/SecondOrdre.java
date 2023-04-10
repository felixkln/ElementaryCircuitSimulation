package circuits;

import java.io.IOException;
import java.util.Formatter;

public abstract class SecondOrdre extends Euler {
    private Formatter output;
    protected double uprime0, uprimen;
    protected double R,L,C; // composants

    public SecondOrdre() {
        super();
        uprime0=0;
        R=50;
        L=1e-6;
        C=1e-9;
    }
    public SecondOrdre(double h, double u0, double tempsSimulation, double uprime0, double R, double L, double C) {
        super(h,u0,tempsSimulation);
        this.uprime0=uprime0;
        this.R=R;
        this.L=L;
        this.C=C;
    }
    public abstract double f(double temps, double un, double uprimen);
    public void solve() {
        double u=u0, v=uprime0, t=0; // variables locales
        double maxIter = tempsSimulation/h;    // nombre de points de calcul
        // création du fichier en mode écriture
        try {
            output = new Formatter("output.txt");
            output.format("Temps       Entree      Sortie \n");
            output.format("%13.10f %13.10f %13.10f \n",t,maSource.genererSignal(t),u);
            for (int i=1;i<maxIter;i++)
            {
                u = u + h*v; // méthode d'euler : u(n) prend u(n+1)
                v = v + h*f(i*h,u,v); // uprime(n) prend uprime(n+1)
                output.format("%13.10f %13.10f %13.10f \n",i*h,maSource.genererSignal(i*h),u); // écriture
            }
            output.close(); // fermer le fichier
        } catch (IOException e) {   // s'il y a une erreur
            System.out.println("Erreur.");
            e.printStackTrace();
        }
    }

    // getters
    public double getR() {
        return R;
    }
    public double getL() {
        return L;
    }
    public double getC() {
        return C;
    }
    public double getUprime0() {
        return uprime0;
    }

    // setters
    public void setR(double r) {
        R = r;
    }
    public void setL(double l) { L = l; }
    public void setC(double c) {
        C = c;
    }
    public void setUprime0(double uprime0) {
        this.uprime0 = uprime0;
    }
}
