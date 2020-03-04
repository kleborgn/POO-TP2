/**
 * Location
 */
public class Location {

    private int numero;
    private Voiture voit;
    private Client cli;
    private Date dateLoc;
    private Date dateRetour;
    private int nbKm;
    private static int nbLoc = 0;

    public Location(Voiture v, Client c, Date d) {
        numero = nbLoc;
        nbLoc++;
        voit = v;
        cli = c;
        dateLoc = d;
        dateRetour = null;
        nbKm = 0;
    }

    public int getNumero() {
        return this.numero;
    }

    public Voiture getVoiture() {
        return voit;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date d) {
        dateRetour = d;
    }

    public void setKmParcouru(int km) {
        this.nbKm = km;
    }

    public Client getClient() {
        return cli;
    }

    public void afficher() {
        System.out.println("Numéro : " + numero);
        System.out.println("Client :");
        this.cli.afficher();
        System.out.println("Voiture :");
        this.voit.afficher();
        System.out.println("Date de location : ");
        dateLoc.afficher();
        System.out.println("Km parcourus : " + nbKm);
        if (dateRetour != null) {
            System.out.println("Statut : Terminée");
            System.out.println("Date de retour : ");
            dateRetour.afficher();
        }
        else {
            System.out.println("Statut : En cours");
        }
    }
}