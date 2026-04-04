package com.template;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class VectorHeapTest {

    @Test
    public void testOrdenEstrictoDePrioridad() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        
        // Se hace una prueba de prioridades
        heap.add(new Paciente("Messi", "Tobillo", "C"));
        heap.add(new Paciente("Haaland", "Fractura", "A"));
        heap.add(new Paciente("Mbappe", "Fatiga", "B"));
        heap.add(new Paciente("Cristiano", "Rutina", "E"));
        heap.add(new Paciente("Rodri", "Ligamentos", "A"));

        // Se valida que el primer "A" salga primero
        assertEquals("A", heap.remove().getPrioridad());
        
        // Se valida que el segundo "A" salga después
        assertEquals("A", heap.remove().getPrioridad());
        
        // Se valida que salgan en orden alfabético
        assertEquals("B", heap.remove().getPrioridad());
        assertEquals("C", heap.remove().getPrioridad());
        assertEquals("E", heap.remove().getPrioridad());
        
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testConsistenciaConMuchosDatos() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        String[] prioridades = {"A", "B", "C", "D", "E"};
        
        // Se insertan los pacientes con prioridades aleatorias
        for (int i = 0; i < 30; i++) {
            String p = prioridades[new Random().nextInt(5)];
            heap.add(new Paciente("Jugador" + i, "Sintoma", p));
        }

        String prioridadAnterior = "A";
        while (!heap.isEmpty()) {
            String prioridadActual = heap.remove().getPrioridad();

            assertTrue(prioridadActual.compareTo(prioridadAnterior) >= 0);
            prioridadAnterior = prioridadActual;
        }
    }

    @Test
    public void testRemoveEnHeapVacio() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        assertNull("Remover de un heap vacío debería retornar null", heap.remove());
    }
}