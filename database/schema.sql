-- Esquema didático PostgreSQL para futura camada de persistência.
CREATE TABLE IF NOT EXISTS clientes (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(120) NOT NULL CHECK (length(trim(nome)) > 0),
    email VARCHAR(254) NOT NULL UNIQUE,
    idade INTEGER NOT NULL CHECK (idade BETWEEN 18 AND 130),
    telefone VARCHAR(30),
    criado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_clientes_nome ON clientes (lower(nome));

CREATE TABLE IF NOT EXISTS funcionarios (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN ('DESENVOLVEDOR', 'ANALISTA_SUPORTE')),
    salario_base NUMERIC(12, 2) NOT NULL CHECK (salario_base >= 0),
    bonus NUMERIC(12, 2) NOT NULL DEFAULT 0 CHECK (bonus >= 0),
    plantoes INTEGER NOT NULL DEFAULT 0 CHECK (plantoes >= 0),
    valor_plantao NUMERIC(12, 2) NOT NULL DEFAULT 0 CHECK (valor_plantao >= 0)
);
