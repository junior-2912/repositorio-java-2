package Exercicios.ExercicioFixacao177.services;

public interface ServicoPagamentoOnline {
    double taxaPagamento(double quantia);

    double juros(double quantia, int meses);
}
