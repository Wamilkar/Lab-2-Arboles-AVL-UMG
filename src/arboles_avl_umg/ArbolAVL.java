    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_avl_umg;

/**
 *
 * @author amilkar
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ArbolAVL {
    Nodo raiz;

    int altura(Nodo nodo) {
        if (nodo == null)
            return 0;
        return nodo.altura;
    }

    int balance(Nodo nodo) {
        if (nodo == null)
            return 0;
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }
    
    
    int obtenerAlturaArbol() {
        return altura(this.raiz);
    }
    
    List<Nodo> obtenerNodos(boolean soloHojas, Nodo nodo) {
        List<Nodo> nodos = new ArrayList<>();

        if (nodo != null) {
            if (!soloHojas || nodo.esHoja()) {
                nodos.add(nodo);
            }

            if (nodo.izquierdo != null || nodo.derecho != null) {
                nodos.addAll(obtenerNodos(soloHojas, nodo.izquierdo));
                nodos.addAll(obtenerNodos(soloHojas, nodo.derecho));
            }
        }

        return nodos;
    }

    List<Nodo> obtenerNodosHojas() {
        return obtenerNodos(true, this.raiz);
    }
    
    
    Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }
    
    Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null)
            return new Nodo(valor);

        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else
            return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = balance(nodo);

        if (balance > 1 && valor < nodo.izquierdo.valor)
            return rotarDerecha(nodo);

        if (balance < -1 && valor > nodo.derecho.valor)
            return rotarIzquierda(nodo);

        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }
    
    void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    
    void imprimir() {
        imprimir(raiz, "", true);
    }


void imprimir(Nodo nodo, String prefijo, boolean esIzquierdo) {
        if (nodo != null) {
            System.out.print(prefijo);
            System.out.print(esIzquierdo ? "├──" : "└──");
            System.out.println(nodo.valor);
            imprimir(nodo.izquierdo, prefijo + (esIzquierdo ? "│   " : "    "), true);
            imprimir(nodo.derecho, prefijo + (esIzquierdo ? "│   " : "    "), false);
        }
    }

}

