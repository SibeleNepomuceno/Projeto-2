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
import modelo.status;


/**
 *
 * @author Alessandra
 */
public class statusDao {
  
    
    private Connection comando;

    public statusDao(Connection comando) {
        this.comando = comando;
    }

    public void buscar(status sta) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM STATUS");
            while (rs.next()) {
                status temp = new status();

                temp.setIdStatus(rs.getInt("ID_STATUS"));
                temp.setDescricaoStatus(rs.getString("DESCRICAO_STATUS"));
                

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_STATUS") + " - " + rs.getString("DESCRICAO_STATUS") );
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar unidade", e.getMessage());
        }

    }
}
