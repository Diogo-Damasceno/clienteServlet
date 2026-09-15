# Cadastro de Clientes — Aplicação Java Web (Servlet)

Aplicação simples que demonstra o fluxo:

```
FORMULÁRIO HTML  --POST-->  ClienteServlet  --getParameter()-->  Processamento  -->  Resposta HTML
```

## Estrutura do projeto

```
cadastro-cliente-servlet/
├── pom.xml                              # configuração Maven (empacota como WAR + plugin Jetty)
├── index.html                           # formulário (POST para /cliente)
├── RESPOSTAS.md                         # respostas das questões da atividade
└── src/main/java/com/exemplo/
    └── ClienteServlet.java              # Servlet mapeado em /cliente
```

## Como executar (opção mais fácil)

É necessário ter o **Maven** e o **JDK 17+** instalados.

```bash
# Na pasta do projeto:
mvn jetty:run
```

Acesse no navegador:

```
http://localhost:8080/index.html
```

O formulário envia para `http://localhost:8080/cliente` e o Servlet responde na mesma página.

## Como gerar o WAR e implantar no Tomcat

```bash
mvn clean package
```

O arquivo gerado fica em `target/cadastro-cliente.war`. Copie esse WAR para a pasta
`webapps/` do Tomcat e acesse:

```
http://localhost:8080/cadastro-cliente/index.html
```

> Obs.: esta aplicação usa a API **Jakarta Servlet 6.0** (`jakarta.servlet.*`),
> compatível com **Tomcat 10.1+** ou **Jetty 12**. Caso seu ambiente seja o
> Tomcat 9 (que usa `javax.servlet.*`), troque o `import` no `ClienteServlet.java`
> de `jakarta.servlet` para `javax.servlet` e ajuste a dependência no `pom.xml`
> para `javax.servlet:javax.servlet-api:4.0.1`.

## Regras de validação implementadas

- Nome em branco → "Informe o nome do cliente."
- E-mail em branco → "Informe o e-mail do cliente."
- Idade menor que 18 → "O cliente deve ter 18 anos ou mais."

## Desafio adicional (implementado)

- Campo **telefone** no formulário e exibido na confirmação.
- Mensagem diferente para clientes com **mais de 60 anos**.
- Botão **Limpar** (`type="reset"`) no formulário.
- Estilização da página com **CSS**.
