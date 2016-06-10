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
import modelo.unidade;

/**
 *
 * @author Alessandra
 */
public class unidadeDao {

    private Connection comando;

    public unidadeDao(Connection comando) {
        this.comando = comando;
    }

    public void buscar(unidade uni) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM UNIDADE");
            while (rs.next()) {
                unidade temp = new unidade();

                temp.setIdUnidade(rs.getInt("ID_UNIDADE"));
                temp.setDescricaoUnidade(rs.getString("DESCRICAO_UNID"));
                

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_UNIDADE") + " - " + rs.getString("DESCRICAO_UNID") );
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar unidade", e.getMessage());
        }

    }


}
