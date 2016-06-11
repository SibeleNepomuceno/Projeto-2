/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.servico;

/**
 *
 * @author Alessandra
 */
public class servicoDao {
    
    
    private Connection comando;

    public servicoDao(Connection comando) {
        this.comando = comando;
    }

    public void buscar(servico serv) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM SERVICO");
            while (rs.next()) {
                servico temp = new servico();

                temp.setId_Servico(rs.getInt("ID_SERVICO"));
                temp.setDescricao_desc(rs.getString("DESCRICAO_SERV"));
                temp.setValor(rs.getDouble("VALOR"));
                

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_SERVICO") + " - " + rs.getString("DESCRICAO_SERV") + " - "+ rs.getDouble("VALOR"));
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar unidade", e.getMessage());
        }

    }
    
}
