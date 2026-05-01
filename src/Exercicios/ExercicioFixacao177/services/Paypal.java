package Exercicios.ExercicioFixacao177.services;

public class Paypal implements ServicoPagamentoOnline{
    private double porcentagemPagamento = 2.0 / 100;
    private double porcentagemJuros = 1.0 / 100;


    @Override
    public double juros(double quantia, int meses) {
        return quantia * (porcentagemJuros * meses);
    }

    @Override
    public double taxaPagamento(double quantia) {
        return quantia * porcentagemPagamento;
    }
}
