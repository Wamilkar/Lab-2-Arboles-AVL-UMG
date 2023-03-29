/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_avl_umg;

/**
 *
 * @author amilkar
 */

class Nodo {
    
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    int altura;

    Nodo(int valor) {
        this.valor = valor;
        altura = 1;
    }
    
      boolean esHoja() {
        return this.izquierdo == null && this.derecho == null;
    }
      
}