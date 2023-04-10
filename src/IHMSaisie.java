// pour les fenêtres de dialogue et les choix
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class IHMSaisie extends JOptionPane {
    final static long serialVersionUID = 1;
    // crée une fenêtre de dialogue vide pour chaque choix
    JDialog dialogue;
    // ressort les choix des enum
    ChoixSource[] choixSource = {ChoixSource.RECTANGULAIRE, ChoixSource.ECHELON, ChoixSource.CRENEAU, ChoixSource.TRIANGULAIRE, ChoixSource.SINUSOIDAL};
    ChoixCircuit[] choixCircuit = {ChoixCircuit.A, ChoixCircuit.B, ChoixCircuit.C, ChoixCircuit.D};
    String nom;

    public IHMSaisie() {
        setMessage("Bienvenue dans ce simulateur de résolution numérique de circuits électriques.\n" +
                "Vous serez amené à choisir un circuit à résoudre ainsi que ses paramètres.\n" +
                "Vous allez aussi devoir choisir le signal que vous allez envoyer en entrée de ce circuit.");
        dialogue = createDialog(null, "Bienvenue");
        dialogue.setVisible(true);
        // rentrer le nom
        nom = JOptionPane.showInputDialog("Entrez votre nom");
    }
    ChoixSource proposerChoixSource() {
        /* lorsque cette méthode est invoquée, elle affiche une fenêtre
        qui permet de choisir un type de signal d'entrée */
        setMessage(this.nom + ", quel signal choisissez-vous ?" );
        setOptions(choixSource);
        dialogue = createDialog(null, "Signal source");
        dialogue.setVisible(true);
        return (ChoixSource)getValue(); // retourne l'objet
    }
    ChoixCircuit proposerChoixCircuit() {
        // même chose mais pour les circuits électriques
        setMessage(this.nom + ", quel circuit choisissez-vous ?" );
        setOptions(choixCircuit);
        dialogue = createDialog(null, "Circuit");
        dialogue.setVisible(true);
        return (ChoixCircuit)getValue();
    }

    // getter
    public String getNom() {
        return nom;
    }

    // setter
    public void setNom(String nom) {
        this.nom = nom;
    }
}
