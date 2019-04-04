package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.DaoFuncionario;

@WebServlet("/CadastroFuncionario")
public class CadastroFuncionario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String dataNasc = request.getParameter("dataNasc");
        String dataAdmissao = request.getParameter("dataAdmissao");
        
        PrintWriter saida = response.getWriter();
        
        DaoFuncionario daofunc = new DaoFuncionario();
        
        daofunc.inserirFuncionario(nome, cpf, dataNasc, dataAdmissao);
        
        saida.println("<!DOCTYPE html>");
        saida.println("<html lang='pt-br'>");
        saida.println("<head>");
        saida.println("<meta charset='utf-8' />");
        saida.println("<title>Cadastro de Funcionário</title>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("<h2>Cadastro de Produto</h2>");
        saida.println("<p>O seguinte Funcionário foi cadastrado com sucesso!</p>");

        saida.println("<p>");
        saida.println("Nome: " + nome + "<br />");
        saida.println("CPF: " + cpf + "<br />");
        saida.println("Data de Nascimento: " + dataNasc + "<br />");
        saida.println("Data de Admissão: " + dataAdmissao + "<br />");
        saida.println("</p>");
        saida.println("</body>");
        saida.println("</html>");
    }

}