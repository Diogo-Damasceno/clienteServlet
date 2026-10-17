package com.exemplo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public record ResumoFolha(int quantidade, BigDecimal total) {
    public ResumoFolha {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade negativa");
        Objects.requireNonNull(total, "total");
        if (total.signum() < 0) throw new IllegalArgumentException("Total negativo");
    }
}
