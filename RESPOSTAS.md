# Respostas das questões

## 1. Qual é a função do método `doPost()`?

O `doPost()` é o método da classe `HttpServlet` que o container (servidor, ex.: Tomcat/Jetty)
invoca automaticamente quando o navegador envia uma **requisição HTTP do tipo POST**.
É nele que colocamos a lógica para receber e processar os dados enviados por um formulário,
pois no POST os dados trafegam no **corpo** da requisição (e não na URL).

## 2. Para que serve o objeto `HttpServletRequest`?

`HttpServletRequest` representa a **requisição feita pelo cliente** (navegador).
Ele permite ler tudo o que veio na requisição: parâmetros do formulário (`getParameter`),
cabeçalhos, método HTTP, IP de origem, atributos, etc. No nosso código usamos ele para
recuperar `nome`, `email`, `idade` e `telefone`.

## 3. Para que serve o método `request.getParameter()`?

Retorna o **valor** de um parâmetro enviado pelo formulário, identificado pelo atributo
`name` do campo HTML. Exemplo: `request.getParameter("nome")` devolve o texto digitado
no campo cujo `name="nome"`. Se o parâmetro não existir, retorna `null`.

## 4. Qual é a diferença entre uma requisição GET e uma requisição POST?

| GET | POST |
|-----|------|
| Envia os dados **na URL** (`?nome=...&email=...`) | Envia os dados no **corpo** da requisição |
| Fica visível no endereço e no histórico | Não aparece na URL |
| Tem limite de tamanho | Sem limite prático de tamanho |
| Usado para **buscar/ler** dados | Usado para **enviar/alterar** dados (formulários) |

Por isso o cadastro usa POST: os dados do cliente não ficam expostos na URL.

## 5. Qual é a função do `HttpServletResponse`?

`HttpServletResponse` é o objeto usado para **montar e enviar a resposta** de volta ao
cliente. Com ele definimos o tipo de conteúdo (`setContentType("text/html;charset=UTF-8")`),
o código de status e escrevemos o HTML de saída através de `getWriter()` (o `PrintWriter`
que usamos para gerar a página de confirmação/erro).

## 6. Explique, com suas palavras, o caminho percorrido pelos dados desde o formulário até o Servlet.

1. O usuário preenche os campos em `index.html` e clica em **Cadastrar**.
2. O navegador cria uma requisição **HTTP POST** para a URL `/cliente`, colocando
   `nome`, `email`, `idade` e `telefone` no corpo da requisição.
3. O servidor (container de Servlets) recebe a requisição e, como a URL é `/cliente`,
   identifica o `ClienteServlet` (mapeado com `@WebServlet("/cliente")`) e chama seu `doPost()`.
4. Dentro do `doPost()`, usamos `request.getParameter("nome")` etc. para ler cada valor.
5. O Servlet faz as **validações** e, com `response.getWriter()`, escreve uma página HTML
   de sucesso ou de erro.
6. Essa resposta HTTP volta para o navegador, que a **renderiza** para o usuário.
