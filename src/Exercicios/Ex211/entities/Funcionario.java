package Exercicios.Ex211.entities;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private String email;
    private double salario;

    public Funcionario(String nome, String email, double salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return nome + " - " + email + " - " + String.format("%.2f", salario);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;
        return Double.compare(salario, that.salario) == 0 && Objects.equals(nome, that.nome) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nome);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Double.hashCode(salario);
        return result;
    }
}
