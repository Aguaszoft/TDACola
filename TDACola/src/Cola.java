import javax.swing.*;

public class Cola {
    public Nodo frente;
    public  Nodo finalCola;
    public  int tamano;

    public Cola() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    // Método para encolar (agregar al final) un valor entero
    public void encolar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        tamano++;
        actualizarTextArea(textArea);
    }

    // Método para desencolar (eliminar del frente) un valor entero
    public int desencolar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return -1;
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        tamano--;
        if (frente == null) {
            finalCola = null; // Si la cola está vacía, el final también debe ser null
        }
        actualizarTextArea(textArea);
        return dato;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para mostrar la cola en el JTextArea
    public void mostrarCola(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía.");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null) {
                colaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    // Método para actualizar el JTextArea cada vez que cambia la cola
    private void actualizarTextArea(JTextArea textArea) {
        mostrarCola(textArea);
    }
}
