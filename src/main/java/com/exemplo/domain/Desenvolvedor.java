package com.exemplo.domain;

import java.math.BigDecimal;

public final class Desenvolvedor extends Funcionario {
    private final BigDecimal bonus;

    public Desenvolvedor(String nome, BigDecimal salarioBase, BigDecimal bonus) {
        super(nome, salarioBase);
        if (bonus == null || bonus.signum() < 0) throw new IllegalArgumentException("Bônus inválido");
        this.bonus = bonus;
    }

    @Override
    public BigDecimal calcularRemuneracao() {
        return getSalarioBase().add(bonus);
    }
}
