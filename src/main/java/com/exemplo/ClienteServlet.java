package com.exemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String idadeStr = request.getParameter("idade");
        String telefone = request.getParameter("telefone");

        PrintWriter out = response.getWriter();

        if (nome == null || nome.trim().isEmpty()) {
            respostaErro(out, "Informe o nome do cliente.");
            return;
        }
        if (email == null || email.trim().isEmpty()) {
            respostaErro(out, "Informe o e-mail do cliente.");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr.trim());
        } catch (NumberFormatException e) {
            respostaErro(out, "Informe uma idade válida.");
            return;
        }

        if (idade < 18) {
            respostaErro(out, "O cliente deve ter 18 anos ou mais.");
            return;
        }

        String cabecalho;
        if (idade > 60) {
            cabecalho = "CLIENTE CADASTRADO COM SUCESSO! (Cliente sênior - seja bem-vindo!)";
        } else {
            cabecalho = "CLIENTE CADASTRADO COM SUCESSO!";
        }

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-BR'>");
        out.println("<head><meta charset='UTF-8'><title>Cadastro realizado</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',Arial,sans-serif;background:#f4f6f8;");
        out.println("display:flex;justify-content:center;align-items:center;min-height:100vh;margin:0}");
        out.println(".card{background:#fff;padding:30px 40px;border-radius:10px;");
        out.println("box-shadow:0 4px 14px rgba(0,0,0,.1);max-width:440px;width:100%}");
        out.println("h1{color:#1a7f37;font-size:20px}");
        out.println("ul{list-style:none;padding:0}li{margin:10px 0;font-size:15px}");
        out.println(".voltar{display:inline-block;margin-top:20px;padding:10px 16px;");
        out.println("background:#1a73e8;color:#fff;text-decoration:none;border-radius:6px}</style>");
        out.println("</head>");
        out.println("<body><div class='card'>");
        out.println("<h1>" + escapeHtml(cabecalho) + "</h1>");
        out.println("<ul>");
        out.println("<li><strong>Nome:</strong> " + escapeHtml(nome) + "</li>");
        out.println("<li><strong>E-mail:</strong> " + escapeHtml(email) + "</li>");
        out.println("<li><strong>Idade:</strong> " + idade + " anos</li>");
        if (telefone != null && !telefone.trim().isEmpty()) {
            out.println("<li><strong>Telefone:</strong> " + escapeHtml(telefone) + "</li>");
        }
        out.println("</ul>");
        out.println("<a class='voltar' href='index.html'>Novo cadastro</a>");
        out.println("</div></body></html>");
    }

    private void respostaErro(PrintWriter out, String mensagem) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-BR'>");
        out.println("<head><meta charset='UTF-8'><title>Erro no cadastro</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',Arial,sans-serif;background:#f4f6f8;");
        out.println("display:flex;justify-content:center;align-items:center;min-height:100vh;margin:0}");
        out.println(".card{background:#fff;padding:30px 40px;border-radius:10px;");
        out.println("box-shadow:0 4px 14px rgba(0,0,0,.1);max-width:440px;text-align:center}");
        out.println("h1{color:#c5221f;font-size:20px}");
        out.println(".voltar{display:inline-block;margin-top:20px;padding:10px 16px;");
        out.println("background:#1a73e8;color:#fff;text-decoration:none;border-radius:6px}</style>");
        out.println("</head>");
        out.println("<body><div class='card'>");
        out.println("<h1>" + escapeHtml(mensagem) + "</h1>");
        out.println("<a class='voltar' href='index.html'>Voltar</a>");
        out.println("</div></body></html>");
    }

    private String escapeHtml(String valor) {
        if (valor == null) return "";
        return valor.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;");
    }
}
