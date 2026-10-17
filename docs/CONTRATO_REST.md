# Proposta de contrato REST (a implementar)

O projeto atual continua sendo uma aplicação Servlet; os endpoints abaixo são uma **proposta para evolução em Spring Boot**, não estão disponíveis na aplicação.

| Método | Rota | Resposta prevista |
|---|---|---|
| POST | /api/clientes | 201, Location e representação |
| GET | /api/clientes | 200, lista paginada |
| GET | /api/clientes/{id} | 200 ou 404 |
| PUT | /api/clientes/{id} | 200 ou 404 |
| DELETE | /api/clientes/{id} | 204 ou 404 |
| GET | /api/funcionarios/folha | 200, resumo com total |

## Contratos e segurança

- Validar o corpo e retornar `400` com mensagens de campo previsíveis.
- Evitar exposição de dados sensíveis nos logs e nos erros.
- Aplicar autenticação e autorização antes de publicar endpoints reais.
- Paginar coleções, documentar no OpenAPI e testar respostas negativas.
- Não confundir `401` (não autenticado) com `403` (sem permissão).
