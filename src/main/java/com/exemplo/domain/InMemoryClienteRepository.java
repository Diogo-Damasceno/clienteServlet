package com.exemplo.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class InMemoryClienteRepository implements ClienteRepository {
    private final Map<String, Cliente> clientes = new LinkedHashMap<>();

    private static String chave(String email) {
        return Objects.requireNonNull(email, "email").strip().toLowerCase(Locale.ROOT);
    }

    @Override
    public synchronized void salvar(Cliente cliente) {
        Objects.requireNonNull(cliente, "cliente");
        String email = chave(cliente.email());
        if (clientes.containsKey(email)) throw new IllegalArgumentException("E-mail já cadastrado");
        clientes.put(email, cliente);
    }

    @Override
    public synchronized Optional<Cliente> buscarPorEmail(String email) {
        return Optional.ofNullable(clientes.get(chave(email)));
    }

    @Override
    public synchronized List<Cliente> listar() {
        return List.copyOf(clientes.values());
    }
}
