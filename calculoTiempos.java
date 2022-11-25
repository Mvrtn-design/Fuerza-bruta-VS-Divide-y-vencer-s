/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divideyvenceras;

/**
 *
 * @author Mvrtn
 */
public class calculoTiempos {

    private int numIteraciones;
    private RellenarVector vector;
    private MatrizDeTiempos tiempos;

    public calculoTiempos(int numIteraciones) {
        this.numIteraciones = numIteraciones;
        vector = new RellenarVector(numIteraciones);
        String[] titulos = {"Tamanyo del vector", "Fuerza bruta aleatorio", "Divide y Venceras aleatorio"};
        tiempos = new MatrizDeTiempos(numIteraciones, 3, titulos);
    }

    public void ejecutarAlgoritmos() {
        //aignamos el titulo
        for (int i = 0; i < numIteraciones; i++) {
            tiempos.asignaValor(i, 0, i + 1);
        }
        for (int i = 1; i <= numIteraciones; i++) {
           

            vector.aleatorio(i);
            tiempos.asignaValor(i - 1, 1, vector.tiempoFuerzaBruta());
            tiempos.asignaValor(i - 1, 2, vector.tiempoDivideYVenceras());
        }
    }
    
public void imprimeTiempos() {
        tiempos.imprimeTiempos();
    }

    public void guardarDatos(String nombreArchivo) {
        tiempos.guardaTiempos(nombreArchivo);
    }
}
