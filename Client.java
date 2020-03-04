
/**
 * Client
 */
public class Client {

    private int numero;
    private String nom;
    private String domicile;
    private static int nbClients = 0;

    public Client(String n, String dom) {
        numero = nbClients;
        nbClients++;
        nom = n;
        domicile = dom;
    }

    public void afficher() {
        System.out.println("Numéro : " + this.numero);
        System.out.println("Nom : " + this.nom);
        System.out.println("Domicile : " + this.domicile);
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the domicile
     */
    public String getDomicile() {
        return domicile;
    }
}