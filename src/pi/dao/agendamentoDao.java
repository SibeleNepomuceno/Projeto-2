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
import modelo.agendamento;

public class agendamentoDao {

    private Connection comando;

    public agendamentoDao(Connection comando) {
        this.comando = comando;
    }

    public agendamento buscarEspecifica(int idAgenda) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        agendamento temp = new agendamento();
     
        String query = "SELECT * FROM AGENDAMENTO WHERE ID_AGENDAMENTO = '" + idAgenda + "';";
        try {
            ResultSet rs = comando1.executeQuery(query);
            while (rs.next()) {

                temp.setIdCliente(rs.getInt("ID_CLIENTE"));
                temp.setIdUnidade(rs.getInt("ID_UNIDADE"));
                temp.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                temp.setIdServico(rs.getInt("ID_SERVICO"));
                temp.setIdStatus(rs.getInt("ID_STATUS"));
                temp.setIdAgendamento(rs.getInt("ID_AGENDAMENTO"));
                temp.setHoraInicial(rs.getString("HORARIO_INICIAL"));
                temp.setHoraFinal(rs.getString("HORARIO_FINAL")); //subsitui a primeira ocorrÃªncia da interrogaÃ§Ã£o pelo atributo nome
                temp.setFilaEspera(rs.getBoolean("FILA_ESPERA"));
                temp.setPromocao(rs.getBoolean("PROMOCAO"));
                temp.setDataAgendamento(rs.getString("DATA_AGEN"));

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_CLIENTE") + " | " + rs.getInt("ID_UNIDADE") + " | " + rs.getInt("ID_FUNCIONARIO") + " | " + rs.getInt("ID_SERVICO") + " | " + rs.getInt("ID_STATUS") + " | " + rs.getInt("ID_AGENDAMENTO") + "|" + rs.getString("HORARIO_INICIAL") + "|" + rs.getString("HORARIO_FINAL") + "|" + rs.getBoolean("FILA_ESPERA") + "|" + rs.getBoolean("PROMOCAO") + "|" + rs.getString("DATA_AGEN"));

            }

        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar agendamento", e.getMessage());
        }
        return temp;
    }

    public void insere(agendamento agendar) throws SQLException {

        Statement comando1 = this.comando.createStatement();

        //string com a consulta que serao executada no banco
        String sql = "INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,ID_AGENDAMENTO,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,PROMOCAO,DATA_AGEN) value(?,?,?,?,?,?,?,?,?,?,?);";

        try {
            //tenta realizar a conexao, se retornar verdadeiro entra no IF
            if (!this.comando.isClosed()) {
                //prepara a sentensão com a consulta da string
                PreparedStatement sentenca = this.comando.prepareStatement(sql);

                //subtitui as interrogações da consulta, pelo valor especifico
                sentenca.setInt(1, agendar.getIdCliente());
                sentenca.setInt(2, agendar.getIdUnidade());
                sentenca.setInt(3, agendar.getIdFuncionario());
                sentenca.setInt(4, agendar.getIdServico());
                sentenca.setInt(5, agendar.getIdStatus());
                sentenca.setInt(6, agendar.getIdAgendamento());
                sentenca.setString(7, agendar.getHoraInicial());
                sentenca.setString(8, agendar.getHoraFinal()); //subsitui a primeira ocorrÃªncia da interrogaÃ§Ã£o pelo atributo nome
                sentenca.setBoolean(9, agendar.isFilaEspera());
                sentenca.setBoolean(10, agendar.isPromocao());
                sentenca.setString(11, agendar.getDataAgendamento());
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentenÃ§a
                this.comando.prepareStatement(sql).close(); //fecha a conexÃ£o com o banco
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void buscar(agendamento agendar) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        ResultSet rs;
        try {
            rs = comando1.executeQuery("SELECT * FROM AGENDAMENTO");
            while (rs.next()) {
                agendamento temp = new agendamento();
                // pega todos os atributos da pessoa e guarda na classe

                temp.setIdCliente(rs.getInt("ID_CLIENTE"));
                temp.setIdUnidade(rs.getInt("ID_UNIDADE"));
                temp.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                temp.setIdServico(rs.getInt("ID_SERVICO"));
                temp.setIdStatus(rs.getInt("ID_STATUS"));
                temp.setIdAgendamento(rs.getInt("ID_AGENDAMENTO"));
                temp.setHoraInicial(rs.getString("HORARIO_INICIAL"));
                temp.setHoraFinal(rs.getString("HORARIO_FINAL")); //subsitui a primeira ocorrÃªncia da interrogaÃ§Ã£o pelo atributo nome
                temp.setFilaEspera(rs.getBoolean("FILA_ESPERA"));
                temp.setPromocao(rs.getBoolean("PROMOCAO"));
                temp.setDataAgendamento(rs.getString("DATA_AGEN"));

                // exibe os cadastros no banco
                System.out.println(rs.getInt("ID_CLIENTE") + " | " + rs.getInt("ID_UNIDADE") + " | " + rs.getInt("ID_FUNCIONARIO") + " | " + rs.getInt("ID_SERVICO") + " | " + rs.getInt("ID_STATUS") + " | " + rs.getInt("ID_AGENDAMENTO") + "|" + rs.getString("HORARIO_INICIAL") + "|" + rs.getString("HORARIO_FINAL") + "|" + rs.getBoolean("FILA_ESPERA") + "|" + rs.getBoolean("PROMOCAO") + "|" + rs.getString("DATA_AGEN"));

            }
        } catch (SQLException e) {
            Conexao.imprimeErro("Erro ao buscar cliente", e.getMessage());
        }

    }

    public void atualizar(agendamento agend, int dados, int IdAgen) throws SQLException {
        Statement comando1 = this.comando.createStatement();

        try {

            String query = "UPDATE AGENDAMENTO SET ID_STATUS = '" + agend.getIdStatus()+ "', ID_STATUS = '" + dados + "' where ID_AGENDAMENTO = '" + IdAgen + "';";

            System.out.println(" status atualizado!");
            comando1.executeUpdate(query); //com é a mesma variavel que esta guardando a String
        } //com é a mesma variavel que esta guardando a String
        catch (SQLException e) {
            Conexao.imprimeErro("Erro ao atualizar agendamento", e.getMessage());
        }
    }

}
