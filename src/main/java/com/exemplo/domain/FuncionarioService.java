package com.exemplo.domain;

import java.util.List;
import java.util.Objects;

public final class FuncionarioService {
    private final FolhaPagamento folha;

    public FuncionarioService(FolhaPagamento folha) {
        this.folha = Objects.requireNonNull(folha, "folha");
    }

    public ResumoFolha resumir(List<? extends Funcionario> funcionarios) {
        Objects.requireNonNull(funcionarios, "funcionarios");
        return new ResumoFolha(funcionarios.size(), folha.total(funcionarios));
    }
}
