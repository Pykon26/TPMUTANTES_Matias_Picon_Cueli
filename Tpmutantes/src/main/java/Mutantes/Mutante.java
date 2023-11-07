/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutantes;

import java.util.Scanner;

/**
 *
 * @author Matias
 */
public class Mutante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);   
        
        String vectorAdn []= new String[6];
        
        for (int i = 0; i < 6; i++) {
            do {                
                
            System.out.println("Ingresar la secuencia de la fila 6 valores (sin espacios) "+ (i+1));
            vectorAdn[i]= sc.nextLine();
            
            } while (!validarLetras(vectorAdn[i]));
        }
        
         if (isMutant(vectorAdn)) {
            System.out.println("La secuencia de ADN corresponde a un mutante.");
        } else {
            System.out.println("La secuencia de ADN NO corresponde a un mutante.");
        }

        sc.close();
    }
    
    
     static boolean isMutant(String[] dna) {
        int contadorSecuencias = 0;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                char letra = dna[i].charAt(j);
                if (j + 3 < dna[i].length() && contarSecuenciasHorizontal(dna[i], letra, j)) {
                    contadorSecuencias++;
                }
                if (i + 3 < dna.length && contarSecuenciasVertical(dna, letra, i, j)) {
                    contadorSecuencias++;
                }
                if (i + 3 < dna.length && j + 3 < dna[i].length() && contarSecuenciasDiagonal(dna, letra, i, j)) {
                    contadorSecuencias++;
                }
                // Si ya se encontraron dos secuencias, no es necesario seguir buscando.
                if (contadorSecuencias > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean contarSecuenciasHorizontal(String secuencia, char letra, int indice) {
        return secuencia.charAt(indice + 1) == letra && 
               secuencia.charAt(indice + 2) == letra && 
               secuencia.charAt(indice + 3) == letra;
    }

    static boolean contarSecuenciasVertical(String[] dna, char letra, int fila, int columna) {
        return dna[fila + 1].charAt(columna) == letra && 
               dna[fila + 2].charAt(columna) == letra && 
               dna[fila + 3].charAt(columna) == letra;
    }

    static boolean contarSecuenciasDiagonal(String[] dna, char letra, int fila, int columna) {
        return dna[fila + 1].charAt(columna + 1) == letra && 
               dna[fila + 2].charAt(columna + 2) == letra && 
               dna[fila + 3].charAt(columna + 3) == letra;
    }

   static boolean validarLetras(String secuenciaADN){
        if (secuenciaADN.length()!=6){
            System.out.println("La cantidad de valores no coincide, deben ser 6");
            return false;
        }
        for (char letras : secuenciaADN.toUpperCase().toCharArray()) {
            
            if (letras != 'A' && letras != 'C' && letras != 'G' && letras != 'T') {
                System.out.println("Letras no correspondientes a un ADN");
                return false; 
            }
        }
        
        return true;
    }
    
   

}
