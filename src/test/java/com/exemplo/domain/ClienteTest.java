package com.exemplo.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test void rejeitaEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Ana", "sem-arroba", 22, null));
    }

    @Test void rejeitaMenorDeIdade() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Ana", "ana@example.com", 17, ""));
    }

    @Test void normalizaCampos() {
        Cliente cliente = new Cliente(" Ana ", " ana@example.com ", 25, null);
        assertEquals("Ana", cliente.nome());
        assertEquals("ana@example.com", cliente.email());
        assertEquals("", cliente.telefone());
    }

    @Test void buscaIgnoraMaiusculas() {
        Cliente ana = new Cliente("Ana Maria", "ana@example.com", 25, "");
        Cliente bia = new Cliente("Beatriz", "bia@example.com", 27, "");
        assertEquals(List.of(ana), new ClienteService().buscarPorNome(List.of(ana, bia), "aNa"));
    }
}
