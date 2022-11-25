/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divideyvenceras;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mvrtn
 */
public class RellenarVector {
    private int [] vector;
    private int numeroElementos;
    
    public RellenarVector(int numeroElementos){
        vector = new int[numeroElementos];
        this.numeroElementos = numeroElementos;
        for(int i = 0; i < this.numeroElementos;i++){
            vector[i] = i+1;
        }
    }
    
    public void aleatorio(int tamanyo){
        Random rnd = new Random();
        for(int i = 0; i < tamanyo; i++){
            int numRand = rnd.nextInt(this.numeroElementos);
            int aux = vector[i];
            vector[i]= vector [numRand];
            vector[numRand]=aux;
        }
    }
    
    public void rellenar(){
        System.out.println("Introduce " + numeroElementos+ " numeros");
        Scanner kdb = new Scanner(System.in);
        for(int i = 0; i < numeroElementos; i++){
            vector[i] = kdb.nextInt();
        } 
    }
    
    public void imprimir(){
        for(int i = 0; i < vector.length;i++){
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
    public long tiempoFuerzaBruta(){
        System.nanoTime();
        long comienzo = System.nanoTime();
        fuerzaBruta();
        long tiempoEjecucion = System.nanoTime() - comienzo;
        return tiempoEjecucion;
    }
    
    
    public int fuerzaBruta(){
        
        int contador = 0;
        for(int i = 0; i < vector.length-1; i++){
            for (int j = i+1; j < vector.length; j++){
                if(vector[i] > vector[j]) contador++;
            }
        }
        return contador;
    }
    
    public long tiempoDivideYVenceras(){
        System.nanoTime();
        long comienzo = System.nanoTime();
        inversiones();
        long tiempoEjecucion = System.nanoTime() - comienzo;
        return tiempoEjecucion;
    }
    public int inversiones(){
        return inversionesRecursivo(vector, 0, vector.length-1);
    }
    
    private int inversionesRecursivo(int[] v, int ini, int fin){
       int contador = 0;
       if(ini < fin){
           int mitad = (ini + fin) / 2;
           
           
           contador = contador + inversionesRecursivo(v, ini, mitad);
           contador = contador + inversionesRecursivo(v, mitad +1, fin);
           contador = contador + metodoMerge(v, ini, mitad, fin);
       }
       return contador;
    }
    
    public int metodoMerge(int[]vector, int ini, int mitad, int fin)
    {
        int inversiones = 0;
        int[] ordenado = new int[fin-ini+1];      //Vamos a meter los numeros ordenados
        if(vector.length < fin)                   //solo tenemos un numero, por tanto no es necesario sacar sus inversiones
            return inversiones;
        
        int izq = ini;
        int dcha = mitad + 1;
        int indice = 0;
        
        while(izq <= mitad && dcha <= fin){
            if(vector[izq] > vector[dcha]){       //comparacion primer elemento del vector, con la "primera" mitad del segundo (siendo el mismo vector)
                inversiones += mitad-izq+1;       //el numero de inversiones son la cantidad de numeros que hay a la izquierda de la mitad
                ordenado[indice] = vector[dcha];
                dcha++;
            }else{
                ordenado[indice] = vector[izq];
                izq++;
            }
            indice++;
        }if(izq <= mitad){                         //pasamos al vector ordenador nuestro vector
            for(int i = izq; i <= mitad; i++){
                ordenado[indice] = vector[i];
                indice++;
            }
        }if(dcha <= fin){
            for(int i = dcha; i <= fin; i++){
                ordenado[indice] = vector[i];
                indice++;
            }
        }
        
        for(int i = ini; i <= fin; i++){
            vector[i] = ordenado[i-ini];
        }
        return inversiones;
    }
}
