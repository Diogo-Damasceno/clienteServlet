package com.exemplo.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteCadastroServiceTest {
    @Test void cadastraEConsultaCliente() {
        ClienteCadastroService service = new ClienteCadastroService(new InMemoryClienteRepository());
        Cliente cliente = service.cadastrar("Ana", "ana@example.com", 23, null);
        assertEquals(cliente, service.buscarPorEmail("ANA@EXAMPLE.COM").orElseThrow());
        assertEquals(1, service.listar().size());
    }

    @Test void rejeitaCadastroInvalidoAntesDePersistir() {
        ClienteCadastroService service = new ClienteCadastroService(new InMemoryClienteRepository());
        assertThrows(IllegalArgumentException.class, () -> service.cadastrar("Ana", "invalido", 23, null));
        assertTrue(service.listar().isEmpty());
    }
}
