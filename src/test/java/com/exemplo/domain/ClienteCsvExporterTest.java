package com.exemplo.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteCsvExporterTest {
    @Test void escapaAspasEVirgulas() {
        Cliente cliente = new Cliente("Ana, \"Silva\"", "ana@example.com", 18, null);
        String csv = new ClienteCsvExporter().exportar(List.of(cliente));
        assertTrue(csv.contains("\"Ana, \"\"Silva\"\"\""));
        assertTrue(csv.startsWith("nome,email,idade,telefone\n"));
    }

    @Test void previneFormulaAoAbrirEmPlanilha() {
        Cliente cliente = new Cliente("=1+1", "ana@example.com", 20, "");
        assertTrue(new ClienteCsvExporter().exportar(List.of(cliente)).contains("\"'=1+1\""));
    }

    @Test void exportaColecaoVaziaComCabecalho() {
        assertEquals("nome,email,idade,telefone\n", new ClienteCsvExporter().exportar(List.of()));
    }
}
