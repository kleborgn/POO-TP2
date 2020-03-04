/**
 * Pile
 */
public class Pile {

    private Produit[] tableau;
    private int indice;

    public Pile(int max) {
        tableau = new Produit[max];
        indice = 0;
    }

    public boolean pilevide() {
        if (this.indice == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean pilepleine() {
        if (this.indice == this.tableau.length) {
            return true;
        }
        else {
            return false;
        }
    }

    public void empiler(Produit p) {
        this.tableau[this.indice] = p;
        this.indice++;
    }

    public void depiler() {
        this.indice--;
        this.tableau[this.indice].afficher();
    }

    public Produit sommet() {
        return this.tableau[this.indice - 1];
    }
}