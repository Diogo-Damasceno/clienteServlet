package com.exemplo.domain;

import java.util.Objects;

public record Cliente(String nome, String email, int idade, String telefone) {
    public Cliente {
        nome = Objects.requireNonNull(nome, "nome").trim();
        email = Objects.requireNonNull(email, "email").trim();
        telefone = telefone == null ? "" : telefone.trim();
        if (nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório");
        if (nome.length() > 120) throw new IllegalArgumentException("Nome muito longo");
        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$") || email.length() > 254)
            throw new IllegalArgumentException("E-mail inválido");
        if (idade < 18 || idade > 130) throw new IllegalArgumentException("Idade fora do intervalo permitido");
        if (telefone.length() > 30) throw new IllegalArgumentException("Telefone muito longo");
    }
}
