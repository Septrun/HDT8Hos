package com.template;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String prioridad;

    public Paciente(String nombre, String sintoma, String prioridad) {
        this.nombre = nombre.trim();
        this.sintoma = sintoma.trim();
        this.prioridad = prioridad.trim();
    }

    @Override
    public int compareTo(Paciente otro) {
        // Se hace una comparación alfabética por orden del abecedario.
        return this.prioridad.compareTo(otro.prioridad);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", nombre, sintoma, prioridad);
    }

    public String getNombre() { return nombre; }
    public String getPrioridad() { return prioridad; }
}