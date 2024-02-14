package com.company;
import java.util.Scanner;
public class SinRefactorizar {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector = crearVector(dato);
        imprimirGeneral(vector, dato, false);
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        imprimirGeneral(vector, dato, true);

    }

    public static void imprimirGeneral(int[] vector, int dato, boolean caso) {

        if (caso) {
            for (int i = 0; i < vector.length; i++) {
                if (i % 10 == 0) System.out.println();
                System.out.print(vector[i] + "\t");
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                if (i % 10 == 0) System.out.println();
                System.out.print(i + 1 + "\t");
            }
            System.out.println("\n");
        }


    }

    public static int[] crearVector(int dato) {
        int vector[] =new int[dato];
        System.out.println("\nVector inicial hasta :"+ dato);
        return  vector;
    }

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {

            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = getBooleans(dim);

            for (i=2; i<Math.sqrt(dim)+1; i++) {
                if (esPrimo[i]) {

                    for (j=2*i; j<dim; j+=i)
                        esPrimo[j] = false;
                }
            }
            int cuenta = getCuenta(dim, esPrimo);
            // Rellenar el vector de números primos
            return getInts1(cuenta, dim, esPrimo);
        } else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }

    public static int getCuenta(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    public static int[] getInts1(int cuenta, int dim, boolean[] esPrimo) {
        int[] primos = getInts(cuenta, dim, esPrimo);
        return primos;
    }

    public static int[] getInts(int cuenta, int dim, boolean[] esPrimo) {
        int i;
        int j;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    public static boolean[] getBooleans(int dim) {
        int i;
        boolean[] esPrimo = new boolean[dim];

        for (i=0; i< dim; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }
}