package com.exemplo.domain;

import java.math.BigDecimal;

public final class AnalistaSuporte extends Funcionario {
    private final int plantoes;
    private final BigDecimal valorPlantao;

    public AnalistaSuporte(String nome, BigDecimal salarioBase, int plantoes, BigDecimal valorPlantao) {
        super(nome, salarioBase);
        if (plantoes < 0 || valorPlantao == null || valorPlantao.signum() < 0)
            throw new IllegalArgumentException("Plantões inválidos");
        this.plantoes = plantoes;
        this.valorPlantao = valorPlantao;
    }

    @Override
    public BigDecimal calcularRemuneracao() {
        return getSalarioBase().add(valorPlantao.multiply(BigDecimal.valueOf(plantoes)));
    }
}
