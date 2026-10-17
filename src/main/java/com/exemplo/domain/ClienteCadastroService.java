package com.exemplo.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class ClienteCadastroService {
    private final ClienteRepository repository;

    public ClienteCadastroService(ClienteRepository repository) {
        this.repository = Objects.requireNonNull(repository, "repository");
    }

    public Cliente cadastrar(String nome, String email, int idade, String telefone) {
        Cliente novo = new Cliente(nome, email, idade, telefone);
        repository.salvar(novo);
        return novo;
    }

    public Optional<Cliente> buscarPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }

    public List<Cliente> listar() {
        return repository.listar();
    }
}
