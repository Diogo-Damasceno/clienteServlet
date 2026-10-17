package com.exemplo.domain;

import java.util.List;
import java.util.Locale;

public final class ClienteService {
    public String faixaEtaria(Cliente cliente) {
        return cliente.idade() > 60 ? "sênior" : "adulto";
    }

    public List<Cliente> buscarPorNome(List<Cliente> clientes, String termo) {
        if (termo == null || termo.isBlank()) return List.copyOf(clientes);
        String filtro = termo.toLowerCase(Locale.ROOT).trim();
        return clientes.stream()
                .filter(cliente -> cliente.nome().toLowerCase(Locale.ROOT).contains(filtro))
                .toList();
    }
}
