package Exercicios.ExercicioFixacao177.services;

import Exercicios.ExercicioFixacao177.entities.Contrato;
import Exercicios.ExercicioFixacao177.entities.Parcela;

import java.time.LocalDate;

public class ServicoContrato {
    private ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }

    public ServicoPagamentoOnline getServicoPagamentoOnline() {
        return servicoPagamentoOnline;
    }

    public void processarContrato(Contrato contrato, int meses) {
        LocalDate dataInicio = contrato.getData();

        double valorParcela = contrato.getValor() / meses;

        double valorJuros = servicoPagamentoOnline.juros(valorParcela, meses);
        double valorTaxaPagamento = servicoPagamentoOnline.taxaPagamento(valorParcela + valorJuros);

        for (int i = 1; i <= meses; i++) {
            new Parcela(dataInicio.plusMonths(i));
        }
    }
}
