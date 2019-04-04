package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoFuncionario {
    static final String caminho = "jdbc:mysql://localhost/lanchonete";

    public void inserirFuncionario(String nome, String cpf, String dataNasc, String dataAdmissao) {
        String operacao = "INSERT INTO funcionario(nome, cpf, dataNasc, dataAdmissao) VALUES('" + nome + "', '" + cpf
                + "', '" + dataNasc + "', '" + dataAdmissao + "')";

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexao = DriverManager.getConnection(caminho, "root", "");
            PreparedStatement inclusao = conexao.prepareStatement(operacao);
            inclusao.execute();
        } catch (SQLException e) {
            System.out.println("Erro no acesso ao banco de dados! " + e.getMessage());
        }
    }
}