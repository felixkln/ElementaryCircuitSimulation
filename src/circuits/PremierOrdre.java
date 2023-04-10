package circuits;

import java.io.IOException;  // pour les erreurs
import java.util.Formatter;  // pour manipuler les fichiers

public abstract class PremierOrdre extends Euler {
    private Formatter output;

    public PremierOrdre() { super(); };
    public PremierOrdre(double h, double u0, double tempsSimulation) {
        super(h,u0,tempsSimulation);
    }
    public abstract double f(double temps, double un, double uprimen);
    public void solve() {
        double u=u0, t=0; // variables locales
        double maxIter = tempsSimulation/h;    // nombre de points de calcul
        // création du fichier en mode écriture
        try {
            output = new Formatter("output.txt");
            output.format("Temps Entree Sortie \n");
            output.format("%13.10f %13.10f %13.10f \n",t,maSource.genererSignal(t),u);
            for (int i=1;i<maxIter;i++)
            {
                u= u + h*f(i*h,u,0); // schéma itératif d'circuits.Euler
                output.format("%13.10f %13.10f %13.10f \n",i*h,maSource.genererSignal(i*h),u); // écriture
            }
            output.close(); // fermer le fichier
        } catch (IOException e) {   // s'il y a une erreur
            System.out.println("Erreur.");
            e.printStackTrace();
        }
    }
}
