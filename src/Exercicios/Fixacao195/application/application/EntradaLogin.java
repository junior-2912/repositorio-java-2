package Exercicios.Fixacao195.application.application;

import java.time.LocalDateTime;
import java.util.Objects;

public class EntradaLogin {
    private String nome;
    private LocalDateTime instante;

    public EntradaLogin(String nome, LocalDateTime instante) {
        this.nome = nome;
        this.instante = instante;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        EntradaLogin that = (EntradaLogin) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
