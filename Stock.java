/**
 * Stock
 */
public class Stock {

    private Pile pile;

    public Stock(int taille) {
        pile = new Pile(taille);
    }

    public void entrer(Produit p) {
        if (pile.pilepleine()) {
            System.out.println("Erreur : Pile pleine.");
        }
        else {
            pile.empiler(p);
        }
    }

    public void sortir(int dateJ) {
        if (pile.pilevide()) {
            System.out.println("Erreur : Pile vide.");
        }
        else {
            if ((dateJ - pile.sommet().getDate()) <= 5) {
                pile.depiler();
            }
            else {
                System.out.println("On jette ces produits :");
                while ((dateJ - pile.sommet().getDate()) > 5) {
                    pile.depiler();
                }
            }
        }
    }
}