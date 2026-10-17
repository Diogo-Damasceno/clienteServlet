package com.exemplo.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryClienteRepositoryTest {
    @Test void impedeDuplicidadeMesmoComCaixaDiferente() {
        InMemoryClienteRepository repo = new InMemoryClienteRepository();
        repo.salvar(new Cliente("Ana", "ana@example.com", 18, ""));
        assertThrows(IllegalArgumentException.class, () ->
            repo.salvar(new Cliente("Outra", "ANA@EXAMPLE.COM", 19, "")));
        assertEquals(1, repo.listar().size());
    }

    @Test void devolveListaDefensiva() {
        InMemoryClienteRepository repo = new InMemoryClienteRepository();
        assertThrows(UnsupportedOperationException.class, () ->
            repo.listar().add(new Cliente("Ana", "ana@example.com", 20, "")));
    }
}
