# Evolução do projeto para portfólio Java Júnior

Esta branch mantém a aplicação Servlet original e acrescenta um núcleo de domínio testável, independente da interface HTTP.

## Separação de responsabilidades

- `Cliente`: dados e invariantes de cadastro.
- `ClienteService`: regras de consulta e classificação.
- `Funcionario`: contrato abstrato e estado encapsulado.
- `Desenvolvedor` e `AnalistaSuporte`: especializações com remuneração própria.
- `FolhaPagamento`: depende da abstração, não de subclasses concretas.
- `database/`: modelo PostgreSQL **de referência**, ainda não conectado ao Servlet.

## Perguntas de entrevista

**Herança:** classes específicas estendem `Funcionario`.

**Encapsulamento:** salário-base é privado e validado pelo construtor.

**Polimorfismo:** `FolhaPagamento` chama `calcularRemuneracao()` em diferentes subclasses sem conhecê-las.

**Imutabilidade:** `Cliente` é um record validado na construção.

**Persistência:** o SQL representa o esquema planejado; integrar via JDBC ou JPA é etapa futura.

## Testes

Execute `mvn test`. Os testes cobrem validação de cadastro, filtros e cálculo de folha. Não dependem de rede nem de banco de dados.
