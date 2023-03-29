/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_avl_umg;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author amilkar
 */

public class Main {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de nodos a insertar: ");
        
        
        int cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el valor del nodo " + (i + 1) + ":");
            int valor = scanner.nextInt();
            arbol.raiz = arbol.insertar(arbol.raiz, valor);
        }
        
        scanner.close();
        System.out.println("Árbol AVL resultante:");
        arbol.imprimir();
        
        System.out.print("\nRecorrido preorden: ");
        arbol.preorden(arbol.raiz);

        System.out.print("\nRecorrido inorden: ");
        arbol.inorden(arbol.raiz);

        System.out.print("\nRecorrido postorden: ");
        arbol.postorden(arbol.raiz);
        
        System.out.println("\nLa altura del arbol es: " + arbol.obtenerAlturaArbol());
        
        List<Nodo> nodosHojas = arbol.obtenerNodosHojas();
        System.out.println("Los nodos hojas del arbol son:");
        for (Nodo nodo : nodosHojas) {
            System.out.println(nodo.valor);
    }
    }
}   