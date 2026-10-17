-- Exemplos de consulta sobre o esquema em schema.sql.

-- Clientes agrupados pela faixa etária.
SELECT CASE WHEN idade > 60 THEN 'senior' ELSE 'adulto' END AS faixa,
       COUNT(*) AS total
FROM clientes
GROUP BY faixa
ORDER BY faixa;

-- Remuneração calculada por especialidade.
SELECT nome, tipo, salario_base,
       CASE
         WHEN tipo = 'DESENVOLVEDOR' THEN salario_base + bonus
         WHEN tipo = 'ANALISTA_SUPORTE' THEN salario_base + plantoes * valor_plantao
       END AS remuneracao
FROM funcionarios ORDER BY nome;

-- Total de folha por tipo, inclusive bônus ou plantões.
SELECT tipo, SUM(salario_base +
       CASE WHEN tipo = 'DESENVOLVEDOR' THEN bonus
            ELSE plantoes * valor_plantao END) AS total_folha
FROM funcionarios
GROUP BY tipo;
