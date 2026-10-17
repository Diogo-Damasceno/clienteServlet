package com.exemplo.domain;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {
    @Test void resumeFuncionariosDeTiposDiferentes() {
        var dev = new Desenvolvedor("Ana", new BigDecimal("3000.00"), new BigDecimal("500.00"));
        var suporte = new AnalistaSuporte("Bia", new BigDecimal("2000.00"), 2, new BigDecimal("100.00"));
        var resumo = new FuncionarioService(new FolhaPagamento()).resumir(List.of(dev, suporte));
        assertEquals(2, resumo.quantidade());
        assertEquals(new BigDecimal("5700.00"), resumo.total());
    }

    @Test void listaVazia() {
        var resumo = new FuncionarioService(new FolhaPagamento()).resumir(List.of());
        assertEquals(0, resumo.quantidade());
        assertEquals(BigDecimal.ZERO, resumo.total());
    }
}
