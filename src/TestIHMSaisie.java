public class TestIHMSaisie {
    public static void main(String[] args) {
        IHMSaisie saisie = new IHMSaisie();
        // choix de la source
        ChoixSource choixSource = saisie.proposerChoixSource();
        System.out.println("Votre choix est " + choixSource);
        // choix du circuit
        ChoixCircuit choixCircuit = saisie.proposerChoixCircuit();
        System.out.println("Votre choix est " + choixCircuit);
    }
}
