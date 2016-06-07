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
import java.util.Vector;
import modelo.cliente;

/**
 *
 * @author Alessandra
 */
public class clienteDao {

    private Connection comando;

    public clienteDao(Connection comando) {
        this.comando = comando;
    }

    public void apagar(String rg) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        try {
            comando1.executeUpdate("DELETE FROM CLIENTE WHERE rg = '" + rg + "';");
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao apagar cliente", e.getMessage());
        } finally {
            Conexao.fechar();
        }
    }

    public Vector<cliente> buscarTodos() throws SQLException {
        Statement comando1 = this.comando.createStatement();
        Vector<cliente> resultados = new Vector<cliente>();
        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                cliente temp = new cliente();
                // pega todos os atributos da pessoa  

                temp.setNome(rs.getString("nome"));
                temp.setRg(rs.getString("rg"));
                temp.setCpf(rs.getString("cpf"));
                temp.setTelefone(rs.getString("telefone"));
                temp.setCelular(rs.getString("celular"));
                resultados.add(temp);
            }
            return resultados;
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar cliente", e.getMessage());
            return null;
        } finally {
            Conexao.fechar();
        }
    }

    public void atualizar(cliente cliente) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        String com = "UPDATE pessoa SET nome = '" + cliente.getNome()
                + "', cpf =" + cliente.getCpf() + ", telefone = '"
                + cliente.getTelefone() + "', celular ='" + cliente.getCelular()
                + "' WHERE  rg = '" + cliente.getRg() + "';";
        System.out.println("Atualizada!");
        try {
            comando1.executeUpdate(com);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fechar();
        }
    }
    
    

    

    public void buscar(cliente cliente) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        
        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM CLIENTE");
            while (rs.next()) {
                cliente temp = new cliente();
                // pega todos os atributos da pessoa e guarda na classe
                
                temp.setNome(rs.getString("NOME_CLIENTE"));
                temp.setCpf(rs.getString("CPF"));
                temp.setRg(rs.getString("RG"));
                temp.setTelefone(rs.getString("TELEFONE"));
                temp.setCelular(rs.getString("CELULAR"));
               
                // exibe os cadastros no banco
               
                System.out.println(rs.getString("NOME_CLIENTE") + " | " + rs.getString("CPF") + " | " +rs.getString("RG") + " | " + rs.getString("TELEFONE") + " | " +rs.getString("CELULAR"));
            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar cliente", e.getMessage());
        }

    }

    public void insere(cliente cliente) throws SQLException {

        Statement comando1 = this.comando.createStatement();

        //string com a consulta que serÃ¡ executada no banco
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, NOME_CLIENTE, CPF, RG, TELEFONE, CELULAR) VALUES (?,?,?,?,?,?)";

        try {
            //tenta realizar a conexÃ£o, se retornar verdadeiro entra no IF
            if (!this.comando.isClosed()) {
                //prepara a sentenÃ§a com a consulta da string
                PreparedStatement sentenca = this.comando.prepareStatement(sql);

                //subtitui as interrograÃ§Ãµes da consulta, pelo valor especÃ­fico
                sentenca.setInt(1, cliente.getIdcliente());
                sentenca.setString(2, cliente.getNome()); //subsitui a primeira ocorrÃªncia da interrogaÃ§Ã£o pelo atributo nome
                sentenca.setString(3, cliente.getCpf());
                sentenca.setString(4, cliente.getRg()); //subsitui a terceira ocorrÃ
                sentenca.setString(5, cliente.getTelefone());
                sentenca.setString(6, cliente.getCelular());
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentenÃ§a
               this.comando.prepareStatement(sql).close(); //fecha a conexÃ£o com o banco
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}