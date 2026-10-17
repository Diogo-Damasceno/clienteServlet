# Persistência e integração PostgreSQL

O código atual usa `ClienteRepository` (interface) e `InMemoryClienteRepository` (implementação transitória), permitindo testar a regra de negócio sem banco.

O diretório `database/` contém um esquema PostgreSQL didático, **não conectado ao Servlet atual**.

## Execução local

1. Crie um banco PostgreSQL de desenvolvimento.
2. Execute `database/schema.sql`.
3. Execute `database/seed.sql` (dados fictícios).
4. Explore `database/consultas_avancadas.sql`.

## Próxima implementação

Implementar `JdbcClienteRepository` com `DataSource` e `PreparedStatement`, parametrizando consultas, garantindo fechamento de recursos e retornando `Optional<Cliente>`.

Não armazene credenciais no código, não concatene entrada do usuário em SQL e não exponha mensagens internas de erro.
