

/**
 * Voiture
 */
public class Voiture {

    private String immatriculation;
    private String modele;
    private int compteurKm;
    private float tarifLoc;

    public Voiture(String immat, String mod, int compteur, float tarif) {
        immatriculation = immat;
        modele = mod;
        compteurKm = compteur;
        tarifLoc = tarif;
    }

    public boolean isEqual(Voiture voit) {
        return (immatriculation.equals(voit.getImmat()) && modele.equals(voit.getModel()) && (compteurKm == voit.getCompteur()) && (tarifLoc == voit.getTarif()));
    }

    public String getImmat() {
        return this.immatriculation;
    }

    public String getModel() {
        return this.modele;
    }

    public int getCompteur() {
        return this.compteurKm;
    }

    public float getTarif() {
        return this.tarifLoc;
    }

    public void afficher() {
        System.out.println("Immatriculation : " + this.immatriculation);
        System.out.println("Modèle : " + this.modele);
        System.out.println("Compteur : " + this.compteurKm + " km");
        System.out.println("Tarif : " + this.tarifLoc);
    }

    public void addKm(int km) {
        this.compteurKm += km;
    }
}