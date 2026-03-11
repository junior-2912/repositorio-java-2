package Exercicios.ExercicioTratamentoExcecoes.entities;

import Exercicios.ExercicioTratamentoExcecoes.exceptions.LimiteEstouradoException;

//classe de conta bancaria
public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta(String titular, Double saldo, Integer numero, Double limiteSaque) {
        this.titular = titular;
        this.saldo = saldo;
        this.numero = numero;
        this.limiteSaque = limiteSaque;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void saque(Double valorSaque) {
        if (valorSaque > getLimiteSaque()) {
            throw new LimiteEstouradoException("Valor do saque ultrapassou o limite!");
        }
        if (valorSaque > this.saldo) {
            throw new RuntimeException("Saldo insuficiente!");
        } else {
            setSaldo(this.saldo -= valorSaque);
        }

    }

    public void deposito(Double valorDeposito) {
        setSaldo(this.saldo += valorDeposito);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("Saldo atualizado = ").append(saldo);

        return sb.toString();
    }
}
