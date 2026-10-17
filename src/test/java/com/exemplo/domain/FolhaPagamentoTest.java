package com.exemplo.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FolhaPagamentoTest {
    @Test void somaRemuneracoesDeTiposDiferentes() {
        Funcionario dev = new Desenvolvedor("Ana", new BigDecimal("3000.00"), new BigDecimal("500.00"));
        Funcionario suporte = new AnalistaSuporte("Bia", new BigDecimal("2000.00"), 2, new BigDecimal("150.00"));
        assertEquals(new BigDecimal("5800.00"), new FolhaPagamento().total(List.of(dev, suporte)));
    }

    @Test void rejeitaValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () ->
            new Desenvolvedor("Ana", BigDecimal.ONE, new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class, () ->
            new AnalistaSuporte("Bia", BigDecimal.ONE, -1, BigDecimal.TEN));
    }

    @Test void listaVaziaRetornaZero() {
        assertEquals(BigDecimal.ZERO, new FolhaPagamento().total(List.of()));
    }
}
