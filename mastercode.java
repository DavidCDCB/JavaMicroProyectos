import java.io.IOException;
import java.util.Random;
import java.util.*;

/**
 * @author David-cdcb 2016
 */
public class mastercode {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        boolean win;
        String codeul;
        String ver = "S";
        int[] code = new int[4];
        int[] out = new int[4];
        int[][] salm = new int[2][2];
        char[] codel = new char[4];
        char[] codeu = new char[4];
        char[][] M = new char[10][4];
        int time=500;
        String V = "\033[32m",R="\033[31m",Z="\033[36m",A="\033[33m",Mo="\033[37m",N="\033[35m";
        System.out.print("Cargando.");
        for (int f = 0; f <= 20 - 1; f++) {
            try { Thread.sleep(300); } catch (InterruptedException ex) {}
            System.out.print(".");
        }
        System.out.println("\n\033[31m▒█▀▄▀█ ░█▀▀█ ▒█▀▀▀█ ▀▀█▀▀ ▒█▀▀▀ ▒█▀▀█");
        System.out.println("\033[31m▒█▒█▒█ ▒█▄▄█ ░▀▀▀▄▄ ░▒█░░ ▒█▀▀▀ ▒█▄▄▀");
        System.out.println("\033[31m▒█░░▒█ ▒█░▒█ ▒█▄▄▄█ ░▒█░░ ▒█▄▄▄ ▒█░▒█");
        try { Thread.sleep(time); } catch (InterruptedException ex) {}
        System.out.println("\033[31m       ▒█▀▀█ ▒█▀▀▀█ ▒█▀▀▄ ▒█▀▀▀");
        System.out.println("\033[31m       ▒█░░░ ▒█░░▒█ ▒█░▒█ ▒█▀▀▀");
        System.out.println("\033[31m       ▒█▄▄█ ▒█▄▄▄█ ▒█▄▄▀ ▒█▄▄▄");
        try { Thread.sleep(time); } catch (InterruptedException ex) {}
        System.out.println("\033[34m▒█▀▀█ █░░█   ▒█▀▀█ ▒█▀▀▄ ▒█▀▀█ ▒█▀▀█");
        System.out.println("\033[34m▒█▀▀▄ █▄▄█   ▒█░░░ ▒█░▒█ ▒█░░░ ▒█▀▀▄");
        System.out.println("\033[34m▒█▄▄█ ▄▄▄█   ▒█▄▄█ ▒█▄▄▀ ▒█▄▄█ ▒█▄▄█\n");
        try { Thread.sleep(time); } catch (InterruptedException ex) {}
        System.out.println("\033[32mEres un experimentado Hacker y necesitas acceder a la información de un sistema\n para eso necesitas descifrar la combinación correcta para ingresar por medio del\n código maestro,tan solo tienes 10 oportunidades antes de que el sistema se\n auto destruya junto con la información, para ello tienes ciertas pistas\n que el software de hacking por fuerza bruta te irá mostrando al azar, indicando\n lo siguiente.\n- 2 Significa que una de las letras se encuentra y en la posición correcta.\n- 1 Significa que una de las letras se encuentra pero en la posición incorrecta.\n- 0 Significa que la letra ingresada no se encuentra.\n");
        try { Thread.sleep(time); } catch (InterruptedException ex) {}
        while ("S".equals(ver)) {
            win = false;
            for (int f = 0; f <= 10 - 1; f++) {
                for (int c = 0; c <= 4 - 1; c++) {
                    M[f][c] = ' ';
                }
            }
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░");
            //llenar(1, 5, code, 6);
            trans(llenar(1, 5, code, 6), codel);
            mostrar1(salm, 2, 2);
            mostrar(M, 10, 4);
            int cont = 0;
            for (int i = 0; i <= 10 - 1; i++) {
                System.out.println("\033[33mIngrese una convinación de cuatro letras sin repetir\n \033[33mLetras: "+R+"R"+V+"-"+A+"A"+V+"-"+V+"V"+V+"-"+Z+"Z"+V+"-"+N+"N"+V+"-"+Mo+"M"+V);
                codeul = obj.nextLine();
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░");
                if ("CDCB".equals(codeul)) {
                    for (int f = 0; f <= 4 - 1; f++) {
                        System.out.print("|" + codel[f] + "|");
                    }
                }
                //div(codeu, codeul.toUpperCase());
                if (anali(codel, div(codeu, codeul.toUpperCase()), out, code, salm, win)) {
                    win = true;
                    break;
                }
                mostrar1(salm, 2, 2);
                ing(codeu, M, cont);
                mostrar(M, 10, 4);
                cont++;

            }
            if (win == false) {

                for (int f = 0; f <= 4 - 1; f++) {
                    System.out.print("|" + codel[f] + "|");
                }
                System.out.println("\n\033[31mGAME OVER");
            } else {

                for (int f = 0; f <= 4 - 1; f++) {
                    System.out.print("|" + codel[f] + "|");
                }
                System.out.println("\n\033[36mYOU WIN!!!");
            }

            System.out.println("¿Desea volver a Jugar?(S o N)");
            ver = obj.nextLine();
            ver = ver.toUpperCase();

            String[] comando = {"cls"};
            try {
                final Process pr = Runtime.getRuntime().exec(comando);
            } catch (IOException ex) {}

            for (int f = 0; f <= 2 - 1; f++) {
                for (int c = 0; c <= 2 - 1; c++) {
                    salm[f][c] = 0;
                }
            }
        }
    }

    public static void ing(char codeu[], char M[][], int cont) {

        for (int f = 0; f <= 10 - 1; f++) {
            for (int c = 0; c <= 4 - 1; c++) {
                M[cont][c] = codeu[c];
            }
        }
    }

    public static boolean anali(char codel[], char codeu[], int out[], int code[], int salm[][], boolean win) {
        int sum = 0;
        for (int f = 0; f <= 4 - 1; f++) {
            for (int c = 0; c <= 4 - 1; c++) {
                if (codel[c] == codeu[f]) {
                    if (f == c) {
                        out[c] = 2;

                    } else {
                        out[c] = 1;
                    }
                }
            }
        }

        llenar(1, 5, code, 4);
        for (int f = 0; f < code.length; f++) {
            if (code[f] == 1) salm[0][0] = out[f];
            if (code[f] == 2) salm[0][1] = out[f];
            if (code[f] == 3) salm[1][0] = out[f];
            if (code[f] == 4) salm[1][1] = out[f];
            sum += out[f];
        }

        if (sum == 8) win = true;

        for (int f = 0; f <= 4 - 1; f++) {
            out[f] = 0;
        }
        return win;
    }

    public static void trans(int num[], char let[]) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) let[i] = 'R';
            if (num[i] == 2) let[i] = 'A';
            if (num[i] == 3) let[i] = 'V';
            if (num[i] == 4) let[i] = 'Z';
            if (num[i] == 5) let[i] = 'N';
            if (num[i] == 6) let[i] = 'M';
        }
    }

    public static void mostrar(char[][] M, int cf, int cc) {

        String V = "\033[32m",R="\033[31m",Z="\033[36m",A="\033[33m",Mo="\033[37m",N="\033[35m";

        for (int i = 0; i < cc; i++) {
            if (i == 0) {
                System.out.println("\033[32m███████████████████");
                System.out.print("\033[32m█+---+");
            } else {
                System.out.print("\033[32m---+");
            }
            if (i == 4 - 1) {
                System.out.print("\033[32m█");
            }
        }
        System.out.print("\n");
        for (int f = 0; f <= cf - 1; f++) {

            for (int c = 0; c <= cc - 1; c++) {
                if (c == 0) {
                    if(M[f][c]==' ')System.out.print("\033[32m█| " +V+ M[f][c] + "\033[32m");
                    if(M[f][c]=='V')System.out.print("\033[32m█| " +V+ M[f][c] + "\033[32m");
                    if(M[f][c]=='R')System.out.print("\033[32m█| " +R+ M[f][c] + "\033[32m");
                    if(M[f][c]=='Z')System.out.print("\033[32m█| " +Z+ M[f][c] + "\033[32m");
                    if(M[f][c]=='A')System.out.print("\033[32m█| " +A+ M[f][c] + "\033[32m");
                    if(M[f][c]=='M')System.out.print("\033[32m█| " +Mo+ M[f][c] + "\033[32m");
                    if(M[f][c]=='N')System.out.print("\033[32m█| " +N+ M[f][c] + "\033[32m");
                } else {
                    if(M[f][c]==' ')System.out.print("\033[32m | " + V + M[f][c] + "\033[32m");
                    if(M[f][c]=='V')System.out.print("\033[32m | " +V+ M[f][c] + "\033[32m");
                    if(M[f][c]=='R')System.out.print("\033[32m | " +R+ M[f][c] + "\033[32m");
                    if(M[f][c]=='Z')System.out.print("\033[32m | " +Z+ M[f][c] + "\033[32m");
                    if(M[f][c]=='A')System.out.print("\033[32m | " +A+ M[f][c] + "\033[32m");
                    if(M[f][c]=='M')System.out.print("\033[32m | " +Mo+ M[f][c] + "\033[32m");
                    if(M[f][c]=='N')System.out.print("\033[32m | " +N+ M[f][c] + "\033[32m");
                }
                if (c == 4 - 1) {
                    System.out.println("\033[32m |█");
                }
            }

            for (int i = 0; i < cc; i++) {
                if (i == 0) {
                    System.out.print("\033[32m█+---+");

                } else {
                    System.out.print("\033[32m---+");
                }
                if (i == 4 - 1) {
                    System.out.print("\033[32m█");
                }
            }
            System.out.print("\n");

        }
        System.out.println("\033[32m███████████████████");

    }

    public static void mostrar1(int[][] M, int cf, int cc) {

        for (int i = 0; i < cc; i++) {
            if (i == 0) {
                System.out.print("\033[31m       +-");
            } else {
                System.out.print("\033[31m+-");
            }
        }
        System.out.print("\033[31m+\n");
        for (int f = 0; f <= cf - 1; f++) {

            for (int c = 0; c <= cc - 1; c++) {
                if (c == 0) {
                    System.out.print("\033[31m       |" + M[f][c]);
                } else {
                    System.out.print("\033[31m|" + M[f][c]);
                }
            }
            System.out.println("\033[31m|");
            for (int i = 0; i < cc; i++) {
                if (i == 0) {
                    System.out.print("\033[31m       +-");
                } else {
                    System.out.print("\033[31m+-");
                }
            }
            System.out.print("\033[31m+\n");
        }
    }

    public static char[] div(char codeu[], String sCadena) {

        int cont = 0;
        char[] aCaracteres = sCadena.toCharArray();
        for (int x = 0; x <= aCaracteres.length - 1; x++) {
            codeu[cont] = aCaracteres[x];
            cont++;
        }
        return codeu;

    }

    public static int[] llenar(int desde, int hasta, int numeros[], int sal) {

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = 0;
        }
        Random rnd = new Random();
        int n = 0, m = 0;
        for (int i = 0; i < numeros.length; i++) {
            do {
                n = rnd.nextInt(sal) + 1;
                m = rnd.nextInt(sal) + 1;
            } while (comp(numeros, i, n));
            numeros[i] = n;
        }
        return numeros;
    }

    public static boolean comp(int[] numeros, int indice, int valor) {
        for (int i = 0; i < indice; i++) {
            if (numeros[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
