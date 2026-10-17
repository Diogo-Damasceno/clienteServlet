-- Operações SQL para estudo e futura integração JDBC/JPA.
INSERT INTO clientes (nome, email, idade, telefone)
VALUES ('Ana Maria', 'ana@example.com', 25, '61999990000');

SELECT id, nome, email, idade FROM clientes WHERE lower(nome) LIKE '%' || lower('ana') || '%';

UPDATE clientes SET telefone = '61988880000' WHERE email = 'ana@example.com';

SELECT tipo, count(*) AS quantidade, sum(salario_base) AS folha_base
FROM funcionarios GROUP BY tipo ORDER BY tipo;

-- Use transação e parâmetros preparados na aplicação, nunca concatenação de entradas.
