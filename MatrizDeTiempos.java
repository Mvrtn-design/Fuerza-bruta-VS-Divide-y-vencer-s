/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divideyvenceras;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Mvrtn
 */
public class MatrizDeTiempos {

    private int numFilas;
    private int numColumnas;
    private long[][] matriz;
    private String[] titulos;

    public MatrizDeTiempos(int numFilas, int numColumnas, String[] titulos) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        matriz = new long[numFilas][numColumnas];
        this.titulos = titulos;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public String[] getTitulos() {
        return titulos;
    }
    

    public void asignaValor(int fila, int columna, long dato) {
        matriz[fila][columna] = dato;
    }

    public void imprimeTiempos() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void guardaTiempos(String nombreArchivo) {
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".csv"))) {
            String cabecera = "";
            for (int idx = 0; idx < this.getTitulos().length; idx++) {
                cabecera += this.getTitulos()[idx] + ";";
            }
            cabecera += "\n";
            writer.write(cabecera);

            String integerFormat = "%8d;";
            for (int idx = 0; idx < this.getNumFilas(); idx++) {
                String fila = "";
                for (int idx2 = 0; idx2 < this.getNumColumnas(); idx2++) {
                    fila += String.format(integerFormat, this.matriz[idx][idx2]);
                }
                fila += "\n";
                writer.write(fila);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
