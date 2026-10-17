-- Dados fictícios para desenvolvimento; use somente em banco local.
INSERT INTO clientes (nome, email, idade, telefone)
VALUES
 ('Ana Maria', 'ana@example.com', 24, '61999990000'),
 ('Beatriz Lima', 'beatriz@example.com', 34, NULL)
ON CONFLICT (email) DO NOTHING;

INSERT INTO funcionarios (nome, tipo, salario_base, bonus, plantoes, valor_plantao)
VALUES
 ('Ana Maria', 'DESENVOLVEDOR', 3000.00, 500.00, 0, 0),
 ('Bruno Lima', 'ANALISTA_SUPORTE', 2000.00, 0, 2, 150.00);
