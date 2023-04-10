import circuits.*;
import source.*;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        IHMSaisie saisie = new IHMSaisie();
        Source source;
        Euler circuit;

        // saisie des paramètres principaux du signal source
        double amplitude = Double.parseDouble(JOptionPane.showInputDialog("Valeur de l'amplitude de votre signal source"));
        double phi = Double.parseDouble(JOptionPane.showInputDialog("Valeur du déphasage"));
        double tempsSimulation = Double.parseDouble(JOptionPane.showInputDialog("Durée de simulation"));

        // choix de la source
        ChoixSource choixSource = saisie.proposerChoixSource();
        System.out.println("Votre choix est " + choixSource);
        switch (choixSource) {
            case RECTANGULAIRE :
                double tempsHaut = Double.parseDouble(JOptionPane.showInputDialog("Durée à l'état haut"));
                source = new Rectangulaire(amplitude, phi, tempsSimulation, tempsHaut);
                break;
            case ECHELON :
                source = new Echelon(amplitude, phi, tempsSimulation);
                break;
            case CRENEAU :
                double rapportCyclique = Double.parseDouble(JOptionPane.showInputDialog("Rapport cyclique"));
                double periodeCreneau = Double.parseDouble(JOptionPane.showInputDialog("Période"));
                source = new Creneau(amplitude, phi, tempsSimulation, rapportCyclique, periodeCreneau);
                break;
            case TRIANGULAIRE :
                double periodeTriangulaire = Double.parseDouble(JOptionPane.showInputDialog("Période"));
                source = new Triangulaire(amplitude, phi, tempsSimulation, periodeTriangulaire);
                break;
            case SINUSOIDAL :
                double offset = Double.parseDouble(JOptionPane.showInputDialog("Composante continue"));
                double periodeSinusoidal = Double.parseDouble(JOptionPane.showInputDialog("Période"));
                source = new Sinusoidal(amplitude, phi, tempsSimulation, offset, periodeSinusoidal);
                break;
            default :
                source = new Echelon(amplitude, phi, tempsSimulation);
                saisie.setMessage("Par défaut, votre signal est un échelon : " +
                        "\n Amplitude : " + source.getAmplitude() + "\n Déphasage : " + source.getPhi() +
                        "\n Durée de simulation : " + source.getTempsSimulation());
                break;
        }

        // paramètres de simulation
        double h = Double.parseDouble(JOptionPane.showInputDialog("Pas de calcul (conseillé de prendre au maximum 1000 fois moins que la durée de simulation)"));
        double u0 = Double.parseDouble(JOptionPane.showInputDialog("Condition initiale sur la tension"));
        double uprime0 = Double.parseDouble(JOptionPane.showInputDialog("Condition initiale sur la dérivée temporelle (si nécessaire)"));
        double C = Double.parseDouble(JOptionPane.showInputDialog("Valeur du condensateur (F)"));

        // choix du circuit
        ChoixCircuit choixCircuit = saisie.proposerChoixCircuit();
        System.out.println("Votre choix est " + choixCircuit);
        switch (choixCircuit) {
            case A :
                double R = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la résistance"));
                circuit = new CircuitA(h, u0, tempsSimulation, R, C);
                break;
            case B :
                double R1 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la résistance 1"));
                double R2 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la résistance 2"));
                circuit = new CircuitB(h, u0, tempsSimulation, R1, R2, C);
                break;
            case C :
                double R3 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la résistance"));
                double L1 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la bobine"));
                circuit = new CircuitC(h, u0, tempsSimulation, uprime0, R3, L1, C);
                break;
            case D :
                double R4 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la résistance"));
                double L2 = Double.parseDouble(JOptionPane.showInputDialog("Valeur de la bobine"));
                circuit = new CircuitD(h, u0, tempsSimulation, uprime0, R4, L2, C);
                break;
            default :
                circuit = new CircuitA(h, u0, tempsSimulation, 50, 1e-9);
                System.out.println("Par défaut on a pris un circuit RC");
                break;
        }

        // résolution
        circuit.setMaSource(source);
        circuit.solve();
    }
}
