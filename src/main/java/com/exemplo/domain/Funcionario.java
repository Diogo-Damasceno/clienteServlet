package com.exemplo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Funcionario {
    private final String nome;
    private final BigDecimal salarioBase;

    protected Funcionario(String nome, BigDecimal salarioBase) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
        Objects.requireNonNull(salarioBase, "salarioBase");
        if (salarioBase.signum() < 0) throw new IllegalArgumentException("Salário negativo");
        this.nome = nome.trim();
        this.salarioBase = salarioBase;
    }

    public final String getNome() { return nome; }
    public final BigDecimal getSalarioBase() { return salarioBase; }
    public abstract BigDecimal calcularRemuneracao();
}
