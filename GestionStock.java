/**
 * GestionStock
 */

import java.io.*;
import java.util.*;

public class GestionStock {

    static void afficheMenu() {
        System.out.println("Menu :");
        System.out.println("e : entrée d'un produit");
        System.out.println("s : sortie d'un produit");
        System.out.println("i : incrémentation de la date du jour");
        System.out.println("q : quitter");
        System.out.print("> ");
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String choix = new String(" ");

        int dateJ = 0;

        final int t = 50;
        Stock s = new Stock(t);

        GestionStock.afficheMenu();
        
        while (choix.charAt(0) != 'q') {
            choix = sc.nextLine();
            switch (choix.charAt(0)) {
                case 'e':
                    System.out.println("Saisir la référence :");
                    Produit p = new Produit(dateJ);
                    s.entrer(p);
                    break;
                
                case 's':
                    s.sortir(dateJ);
                    break;

                case 'i':
                    dateJ++;
                    break;

                case 'q':
                    System.out.println("Au revoir.");
                    break;

                default:
                    System.out.println("Erreur.");
                    break;
            }
            GestionStock.afficheMenu();
        }
        sc.close();
    }
}