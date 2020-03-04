/**
 * TP2
 */

import java.io.*;
import java.util.Scanner;

public class TP2 {
    public static Scanner sc;
    public static BufferedReader in;
    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        in = new BufferedReader(new InputStreamReader(System.in));
        Agence agence = new Agence();
        boolean quitter = false;
        char choix;
        
        while (!quitter) {
            System.out.println("--- MENU ---");
            System.out.println("1) Afficher clients");
            System.out.println("2) Afficher voitures");
            System.out.println("3) Afficher locations");
            System.out.println("---");
            System.out.println("4) Enregistrer location");
            System.out.println("5) Retour location");
            System.out.println("---");
            System.out.println("6) Saisir client");
            System.out.println("7) Saisir véhicule");
            System.out.println("---");
            System.out.println("0) QUITTER");

            choix = TP2.in.readLine().charAt(0);

            switch (choix) {
                case '1':
                    agence.afficherClients();
                    break;
                case '2':
                    agence.afficherVoitures();
                    break;
                case '3':
                    agence.afficherLocations();
                    break;
                case '4':
                    agence.enregistrerLocation();
                    break;
                case '5':
                    agence.retourLocation();
                    break;
                case '6':
                    agence.saisirClient();
                    break;
                case '7':
                    agence.saisirVehicule();
                    break;
                case '0':
                    quitter = true;
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}