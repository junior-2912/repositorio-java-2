package Exercicios.ExercicioFixacao177.entities;

import java.time.LocalDate;

public class Contrato {
    private int numero;
    private LocalDate data;
    private double valor;

    public Contrato(LocalDate data, int numero, double valor) {
        this.data = data;
        this.numero = numero;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }
}
