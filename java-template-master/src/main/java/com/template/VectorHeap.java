package com.template;

import java.util.Vector;

/**
 * Se implementa un Priority Queue basada en un Binary Heap.
 * Se utiliza el @link java.util.Vector como estructura de almacenamiento.
 * Los elementos deben implementar la interfaz @link Comparable para determinar su orden de prioridad. El elemento con el valor "menor".
 * @param <E> El tipo de elementos almacenados en el heap, debe ser Comparable.
 * @author Diego Ayala, 25570
 * @version 1.0
 */
public class VectorHeap<E extends Comparable<E>> {

    /**
     * El vector que almacena los elementos del heap en forma de árbol binario completo.
     */
    protected Vector<E> data;

    /**
     * Construye una nueva cola de prioridad vacía.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     * El elemento se coloca inicialmente al final y luego se  * desplaza hacia arriba hasta que se cumple la propiedad  * del heap.
     *
     * @param value El elemento que se desea agregar.
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Mueve el elemento en el índice especificado hacia arriba en el árbol para mantener la propiedad del heap.
     *
     * @param leaf Es el índice del elemento que se va a desplazar hacia arriba.
     */
    protected void percolateUp(int leaf) {
        int parent = (leaf - 1) / 2;
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = (leaf - 1) / 2;
        }
        data.set(leaf, value);
    }

    /**
     * Remueve y devuelve el elemento con la mayor prioridad (el valor mínimo).
     * El último elemento del vector se mueve a la raíz y luego * se desplaza hacia abajo para restaurar la propiedad del * heap.
     *
     * Retorna el elemento con mayor prioridad, o @code null si la cola está vacía.
     */
    public E remove() {
        if (data.isEmpty()) return null;
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Reubica el elemento en la raíz hacia abajo en el árbol hasta que se cumpla la propiedad del heap.
     *
     * @param root Es el índice desde el cual comenzar el desplazamiento hacia abajo.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = 2 * root + 1;
            if (childpos < heapSize) {
                if ((childpos + 1 < heapSize) &&
                    (data.get(childpos + 1).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Devuelve la cantidad de elementos presentes en la cola  * de prioridad.
     */
    public int size() {
        return data.size();
    }
}