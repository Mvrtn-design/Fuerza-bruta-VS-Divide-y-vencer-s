/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package divideyvenceras;

import java.util.Scanner;

/**
 *
 * @author Mvrtn
 */
public class DivideYVenceras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Scanner kbd = new Scanner(System.in);

        do {
            System.out.println("MENU");
            System.out.println("1. Introducir array por pantalla.");
            System.out.println("2. Generar arrays aleatorios");
            System.out.print("Eliga la opcion:");

            opcion = kbd.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la longitud:");
                    int longitud = kbd.nextInt();
                    RellenarVector pantalla = new RellenarVector(longitud);
                    pantalla.rellenar();
                    System.out.println("1. Fuerza bruta.");
                    System.out.println("2. Divide y venceras.");
                    System.out.print("Elige la opción: ");
                    
                    int opcion2 = kbd.nextInt();
                    switch (opcion2) {
                        case 1:
                            System.out.println("El numero de inversiones es: " + pantalla.inversiones());
                            System.out.println("Por fuerza bruta dura: " + pantalla.tiempoFuerzaBruta() + "ns");
                            break;
                        case 2:
                            System.out.println("El numero de inversiones es: " + pantalla.inversiones());
                            System.out.println("Por divide y venceras dura: " + pantalla.tiempoDivideYVenceras() + "ns");
                            break;
                        default:
                            System.out.println("No es una opción valida.");
                    }
                    
                    break;
                case 2:
                    System.out.print("Introduce la longitud:");
                    int cantidad = kbd.nextInt();
                    calculoTiempos complejidad = new calculoTiempos(cantidad);
                    complejidad.ejecutarAlgoritmos();
                    complejidad.imprimeTiempos();
                    complejidad.guardarDatos("tiempos");
                    break;
                default:
                    System.out.println("No es una opción valida.");
            }
        } while (opcion == 1 || opcion == 2);
    }
}
