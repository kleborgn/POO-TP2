import java.io.IOException;
import java.util.ArrayList;

/**
 * Agence
 */
public class Agence {
    private final int tailleListe = 100;

    private ArrayList<Voiture> voitures;
    private ArrayList<Client> clients;
    private ArrayList<Location> locations;
    private ArrayList<Voiture> plaquesDispo;

    public Agence() {
        voitures = new ArrayList<Voiture>(tailleListe);
        clients = new ArrayList<Client>(tailleListe);
        locations = new ArrayList<Location>(tailleListe);
        plaquesDispo = new ArrayList<Voiture>(tailleListe);

        Voiture voit1 = new Voiture("123AZ45", "Renault", 2000, 50);
        Voiture voit2 = new Voiture("123AZ46", "Citroen", 4000, 60);
        Voiture voit3 = new Voiture("123AZ47", "Peugeot", 6000, 40);
        Voiture voit4 = new Voiture("123AZ48", "Ford", 8000, 30);

        Client cli1 = new Client("Bernard", "Lannion");
        Client cli2 = new Client("Pierre", "Creil");
        Client cli3 = new Client("Jean", "Soissons");

        Location loc1 = new Location(voit1, cli1, new Date(9, 02, 2020));
        loc1.setDateRetour(new Date(16, 02, 2020));

        Location loc2 = new Location(voit3, cli2, new Date(23, 02, 2020));

        Location loc3 = new Location(voit2, cli1, new Date(16, 02, 2020));
        loc3.setDateRetour(new Date(19, 02, 2020));

        Location loc4 = new Location(voit4, cli3, new Date(01, 03, 2020));

        voitures.add(voit1);
        voitures.add(voit2);
        voitures.add(voit3);
        voitures.add(voit4);

        clients.add(cli1.getNumero(), cli1);
        clients.add(cli2.getNumero(), cli2);
        clients.add(cli3.getNumero(), cli3);

        locations.add(loc1.getNumero(), loc1);
        locations.add(loc2.getNumero(), loc2);
        locations.add(loc3.getNumero(), loc3);
        locations.add(loc4.getNumero(), loc4);
    }

    public void afficherVoitures() {
        for (Voiture voiture : voitures) {
            voiture.afficher();
            System.out.println("---------");
        }
    }

    public void afficherClients() {
        for (Client client : clients) {
            client.afficher();
            System.out.println("---------");
        }
    }

    public void afficherLocations() {
        for (Location location : locations) {
            location.afficher();
            System.out.println("---------");
        }
    }

    public boolean isRegistered(int numcli) {
        return (numcli >= 0) && (numcli < clients.size());
    }

    public void afficherDispo() {
        for (Location location : locations) {
            if (location.getDateRetour() != null) {
                System.out.println(location.getNumero() + " = ");
                location.getVoiture().afficher();
                System.out.println("---------");
                plaquesDispo.add(location.getVoiture());
            }
        }
    }

    public void enregistrerLocation() {
        int numcli;
        int saisie;
        System.out.println("--- Enregistrement Location ---");
        System.out.println("Saisir numero client :");
        numcli = TP2.sc.nextInt();
        if (this.isRegistered(numcli)) {
            afficherDispo();
            System.out.println("Saisir numero ou -1 pour quitter :");
            saisie = TP2.sc.nextInt();
            if (saisie != -1) {
                if (!(plaquesDispo.contains(locations.get(saisie).getVoiture()))) {
                    System.out.println("Cette voiture n'est pas disponible");
                } else {
                    locations.add(new Location(locations.get(saisie).getVoiture(), clients.get(numcli),
                            new Date(10, 02, 2020)));
                }
            }
        } else {
            System.out.println("Le client n'est pas enregistré");
        }
    }

    public int rechercherLocation(int numcli, String immat) {
        boolean existe = false;
        int i = 0;
        while (!existe && (i < locations.size())) {
            if (locations.get(i).getVoiture().getImmat().equals(immat)
                    && (locations.get(i).getClient().getNumero() == numcli)) {
                existe = true;
            } else {
                i++;
            }
        }
        return i;
    }

    public int afficherVoituresLoue(int numcli) {
        int nbLoue = 0;
        for (Location location : locations) {
            if (location.getClient().getNumero() == numcli) {
                location.getVoiture().afficher();
                nbLoue++;
            }
        }
        if (nbLoue == 0) {
            System.out.println("Aucune location en cours");
        }
        return nbLoue;
    }

    public void retourLocation() {
        int numcli;
        String numcliS = new String();
        String immat = new String();
        int nbKm;
        Date dateR;
        int j, m, a;
        int numLoc;
        float prix;
        System.out.println("--- Retour Location ---");
        System.out.println("Saisir le numero client :");
        try {
            numcliS = TP2.in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        numcli = Integer.parseInt(numcliS);
        if (!isRegistered(numcli)) {
            System.out.println("Le client n'existe pas");
        } else {
            System.out.println("Voiture(s) que vous louez :");
            if (this.afficherVoituresLoue(numcli) != 0) {
                System.out.println("Saisir l'immatriculation :");
                try {
                    immat = TP2.in.readLine();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                numLoc = this.rechercherLocation(numcli, immat);
                if (numLoc != locations.size()) {
                    System.out.println("Saisir nombre de km effectues :");
                    nbKm = TP2.sc.nextInt();
                    while (nbKm < 0) {
                        System.out.println("Saisir nombre de km effectues :");
                        nbKm = TP2.sc.nextInt();
                    }
                    System.out.println("Saisir le jour, le mois puis l'année de la date de retour :");
                    j = TP2.sc.nextInt();
                    m = TP2.sc.nextInt();
                    a = TP2.sc.nextInt();
                    dateR = new Date(j, m, a);
                    locations.get(numLoc).getVoiture().addKm(nbKm);
                    locations.get(numLoc).setKmParcouru(nbKm);
                    locations.get(numLoc).setDateRetour(dateR);
                    prix = locations.get(numLoc).getVoiture().getTarif() * nbKm;
                    System.out.println("Prix à payer : " + prix);
                } else {
                    System.out.println("Vous ne louez aucun vehicule avec cette immatriculation");
                }
            }
        }
    }

    public void saisirClient() {
        String nom = new String();
        String domicile = new String();

        System.out.println("-- Ajouter un client --");
        System.out.println("Nom :");
        try {
            nom = TP2.in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Domicile :");
        try {
            domicile = TP2.in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Client cli = new Client(nom, domicile);
        clients.add(cli);

        System.out.println("Client ajouté !");
    }

    public void saisirVehicule() {
        String immat = new String();
        String mod = new String();
        int compteur = 0;
        float tarif = 0;

        System.out.println("-- Ajouter une voiture --");
        System.out.println("Immatriculation :");
        try {
            immat = TP2.in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Modele :");
        try {
            mod = TP2.in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Compteur kilometrique :");
        try {
            compteur = Integer.parseInt(TP2.in.readLine());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Tarif :");
        try {
            tarif = Float.parseFloat(TP2.in.readLine());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Voiture voit = new Voiture(immat, mod, compteur, tarif);
        voitures.add(voit);

        System.out.println("Voiture ajoutee !");
    }
}