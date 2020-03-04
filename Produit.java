import java.util.Scanner;

/**
 * Produit
 */
public class Produit {

    private String ref = new String();
    private int dateEntree;
    private Scanner sc = new Scanner(System.in);

    public void afficher() {
        System.out.println("Référence : " + this.ref);
        System.out.println("Date d'entrée : " + this.dateEntree);
    }

    public Produit(int dateJour) {
        ref = sc.nextLine();
        dateEntree = dateJour;
    }

    public int getDate() {
        return this.dateEntree;
    }
}