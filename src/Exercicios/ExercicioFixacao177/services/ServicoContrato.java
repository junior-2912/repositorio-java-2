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

        for (int i = 1; i <= meses; i++) {
            double resultadoJuros =  servicoPagamentoOnline.juros(valorParcela, i);
            double resultadoTaxa = servicoPagamentoOnline.taxaPagamento(valorParcela + resultadoJuros);
            contrato.adicionarParcelas(new Parcela(dataInicio.plusMonths(i), valorParcela + resultadoJuros + resultadoTaxa));
        }

        for (Parcela parcela : contrato.getParcelas()) {
            System.out.println(parcela.getDataPagamento() + " - " + parcela.getValor());
        }

    }
}
