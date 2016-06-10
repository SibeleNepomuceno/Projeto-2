/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.funcionario;

/**
 *
 * @author Alessandra
 */
public class funcionarioDao {

    private Connection comando;

    public funcionarioDao(Connection comando) {
        this.comando = comando;
    }

    // FUNCAO QUE REALIZA UM SELECT NA TABELA COM PARAMETRO ID
    public void pesquisarPorID(int id) throws SQLException {

        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            //COMANDO QUE EXECUTA O SELECT DO FUNCIONARIO DE UMA DETERMINADA UNIDADE
            rs = comando1.executeQuery("SELECT * FROM FUNCIONARIO WHERE ID_UNIDADE = " + id + ";");
            while (rs.next()) {
                funcionario temp = new funcionario();

                temp.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                temp.setNomeFuncionario(rs.getString("NOME_FUNCIO"));

                // EXIBE OS FUNCIONARIOS DAQUELA UNIDADE
                System.out.println(rs.getInt("ID_FUNCIONARIO") + " - " + rs.getString("NOME_FUNCIO"));
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar funcionario", e.getMessage());
        }

    }

    //ver os funcionarios cadastrados no banco
    public void buscar(funcionario func) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM FUNCIONARIO ORDER BY ID_UNIDADE");
            while (rs.next()) {
                funcionario temp = new funcionario();
                // pega todos os atributos da pessoa e guarda na classe
                temp.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                temp.setIdUnidade(rs.getInt("ID_UNIDADE"));
                temp.setNomeFuncionario(rs.getString("NOME_FUNCIO"));
                temp.setCpf(rs.getString("CPF"));
                temp.setRg(rs.getString("RG"));
                temp.setCargo(rs.getString("CARGO"));

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_FUNCIONARIO") + " | " + rs.getInt("ID_UNIDADE") + " | " + rs.getString("NOME_FUNCIO") + " | " + rs.getString("CPF") + " | " + rs.getString("RG") + " | " + rs.getString("CARGO"));
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar cliente", e.getMessage());
        }

    }
//apaga o funcionario que possui o id que esta sendo passado por parametro
    public void apagar(int idFuncionario) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        try {
            comando1.executeUpdate("DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = '" + idFuncionario + "';");
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao apagar cliente", e.getMessage());
        } finally {
            Conexao.fechar(this.comando);
        }
    }

}
