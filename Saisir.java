import java.io.*;

/**
 * Saisir
 */
public class Saisir {
    private static String ligne;
    private static BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

    public static int entier() throws IOException {
        System.out.println("Tapez un entier :");
        ligne = entree.readLine();
        return Integer.parseInt(ligne);
    }

    public static double reeld() throws IOException {
        System.out.println("Tapez un réel (double) :");
        ligne = entree.readLine();
        return Double.valueOf(ligne).doubleValue();
    }

    public static float reelf() throws IOException {
        System.out.println("Tapez un réel (float) :");
        ligne = entree.readLine();
        return Float.valueOf(ligne).floatValue();
    }

    public static String chaine() throws IOException {
        System.out.println("Tapez une ligne :");
        ligne = entree.readLine();
        return ligne;
    }

    public static char car() throws IOException {
        System.out.println("Tapez un caractère :");
        ligne = entree.readLine();
        return ligne.charAt(0);
    }
}