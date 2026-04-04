package com.template;

import java.io.*;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencia = new VectorHeap<>();

        // Se lee el archivo pacientes.txt
        try (Scanner fileScanner = new Scanner(new File("pacientes.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] partes = line.split(",");
                if (partes.length == 3) {
                    colaEmergencia.add(new Paciente(partes[0], partes[1], partes[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Hubo un error. No se encontró el archivo pacientes.txt");
            return;
        }

        // 2. Atender a los pacientes en orden de prioridad
        System.out.println("--Orden de atención de los pacientes--");
        while (!colaEmergencia.isEmpty()) {
            System.out.println(colaEmergencia.remove());
        }
    }
}