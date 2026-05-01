package Exercicios.ExercicioFixacao177.entities;

import java.time.LocalDate;

public class Parcela {
    private LocalDate dataPagamento;
    private double valor;

    public Parcela(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
