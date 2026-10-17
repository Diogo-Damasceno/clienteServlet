package com.exemplo.domain;

import java.util.List;
import java.util.Objects;

public final class ClienteCsvExporter {
    public String exportar(List<Cliente> clientes) {
        Objects.requireNonNull(clientes, "clientes");
        StringBuilder csv = new StringBuilder("nome,email,idade,telefone\n");
        for (Cliente cliente : clientes) {
            csv.append(campo(cliente.nome())).append(',')
                .append(campo(cliente.email())).append(',')
                .append(cliente.idade()).append(',')
                .append(campo(cliente.telefone())).append('\n');
        }
        return csv.toString();
    }

    private static String campo(String texto) {
        String seguro = texto == null ? "" : texto;
        if (!seguro.isEmpty() && "=+-@".indexOf(seguro.charAt(0)) >= 0) seguro = "'" + seguro;
        return "\"" + seguro.replace("\"", "\"\"") + "\"";
    }
}
