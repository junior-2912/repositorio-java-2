package Exercicios.ExercicioFixacao177.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private int numero;
    private LocalDate data;
    private double valor;
    private List<Parcela> parcelas = new ArrayList<>();

    public Contrato(LocalDate data, int numero, double valor) {
        this.data = data;
        this.numero = numero;
        this.valor = valor;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
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

    public void adicionarParcelas(Parcela parcela) {
        parcelas.add(parcela);
    }
}
