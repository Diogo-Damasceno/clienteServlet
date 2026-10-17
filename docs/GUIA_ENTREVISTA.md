# Como demonstrar este projeto em uma entrevista Java Júnior

1. Explique o fluxo original: formulário -> Servlet -> resposta HTTP.
2. Abra `Cliente` e demonstre invariantes em um `record` imutável.
3. Abra `Funcionario`, `Desenvolvedor` e `AnalistaSuporte` para mostrar herança e encapsulamento.
4. Mostre `FolhaPagamento` chamando `calcularRemuneracao()` de maneira polimórfica.
5. Mostre `ClienteRepository` e `ClienteCadastroService` para explicar injeção de dependência.
6. Execute `mvn test` e discuta os cenários de falha validados.
7. Abra `database/schema.sql` para explicar PK, UNIQUE, CHECK e índices.
8. Diferencie o que já funciona do que está planejado em `docs/CONTRATO_REST.md`.

## Perguntas para praticar

- Por que usar `BigDecimal` em valores financeiros?
- Onde é aplicado o polimorfismo?
- Por que uma interface de repositório facilita testes?
- O que diferencia `401`, `403` e `404`?
- Por que valores SQL devem ser parametrizados?
- Qual a diferença entre testes unitários e de integração?

Sempre explique limites e melhorias futuras em vez de afirmar que funcionalidades planejadas já estão prontas.
