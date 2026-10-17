package com.exemplo.domain;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    void salvar(Cliente cliente);
    Optional<Cliente> buscarPorEmail(String email);
    List<Cliente> listar();
}
