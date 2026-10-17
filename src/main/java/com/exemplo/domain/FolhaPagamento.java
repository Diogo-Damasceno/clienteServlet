package com.exemplo.domain;

import java.math.BigDecimal;
import java.util.List;

public final class FolhaPagamento {
    public BigDecimal total(List<? extends Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::calcularRemuneracao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
