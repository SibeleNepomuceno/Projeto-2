/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import com.sun.crypto.provider.RSACipher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Sibele
 */
public class relatorioDao {

    private Connection comando;
    Statement comando1, comando2;

    public relatorioDao(Connection comando) throws SQLException {
        this.comando1 = comando.createStatement();
        this.comando = comando;
    }

    public void getRelatorio_Agendamento_realizado_unid() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                    + "            A.ID_AGENDAMENTO AS CODIGO_AGENDAMENTO,\n"
                    + "            S.ID_STATUS AS CODIGO_STATUS,S.DESCRICAO_STATUS AS STATUS\n"
                    + "               FROM UNIDADE AS U\n"
                    + "               INNER JOIN AGENDAMENTO AS A\n"
                    + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                    + "			   INNER JOIN STATUS AS S\n"
                    + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                    + "               WHERE S.DESCRICAO_STATUS = 'Realizado';");

            while (rs.next()) {
                System.out.println(rs.getString("NUMERO_UNIDADE") + " | " + rs.getString("NOME") + " | " + rs.getString("CODIGO_AGENDAMENTO") + " | " + rs.getString("CODIGO_STATUS") + " | " + rs.getString("STATUS"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getRelatorio_Agendamento_realizado_func() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT F.ID_FUNCIONARIO AS CODIGO_FUNCIONARIO,F.NOME_FUNCIO AS NOME,\n"
                    + "             A.ID_AGENDAMENTO AS AGENDAMENTOS,\n"
                    + "             S.DESCRICAO_STATUS AS STATUS\n"
                    + "                FROM FUNCIONARIO AS F\n"
                    + "                INNER JOIN AGENDAMENTO AS A\n"
                    + "                ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                    + "                INNER JOIN STATUS AS S\n"
                    + "                ON A.ID_STATUS = S.ID_STATUS\n"
                    + "                WHERE S.DESCRICAO_STATUS = 'Realizado'\n"
                    + "                ORDER BY F.ID_FUNCIONARIO;");

            while (rs.next()) {
                System.out.println(rs.getString("CODIGO_FUNCIONARIO") + " | " + rs.getString("NOME") + " | " + rs.getString("AGENDAMENTOS") + " | " + rs.getString("STATUS"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setRelatorio_atendimento_cliente(int id_cliente) {
        try {
            PreparedStatement pst = comando.prepareStatement("SELECT C.ID_CLIENTE AS CODIGO_CLIENTE, C.NOME_CLIENTE AS NOME,\n"
                    + "             count(A.ID_AGENDAMENTO) AS QUANTIDADE_FREQUENCIA,\n"
                    + "             S.DESCRICAO_STATUS AS STATUS_SERVICO\n"
                    + "                FROM CLIENTE AS C\n"
                    + "                INNER JOIN AGENDAMENTO AS A\n"
                    + "                ON A.ID_CLIENTE= C.ID_CLIENTE\n"
                    + "                INNER JOIN STATUS AS S\n"
                    + "                ON A.ID_STATUS = S.ID_STATUS\n"
                    + "                WHERE S.DESCRICAO_STATUS = 'Realizado'and \n"
                    + "                C.ID_CLIENTE=?");
            pst.setInt(1, id_cliente);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("CODIGO_CLIENTE") + " | " + rs.getString("NOME") + " | " + rs.getString("QUANTIDADE_FREQUENCIA") + " | " + rs.getString("STATUS_SERVICO"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setRelatorio_funcio_suaUnid(int id_funcionario) {

        try {
            PreparedStatement pst = comando.prepareStatement("SELECT F.ID_FUNCIONARIO AS FUNCIONARIO,F.NOME_FUNCIO AS NOME, U.ID_UNIDADE AS UNIDADE, U.DESCRICAO_UNID AS NOME_UNIDADE\n"
                    + "FROM UNIDADE AS U\n"
                    + "INNER JOIN FUNCIONARIO AS F\n"
                    + "ON F.ID_UNIDADE= U.ID_UNIDADE\n"
                    + "WHERE ID_FUNCIONARIO = ?;");
            pst.setInt(1, id_funcionario);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("FUNCIONARIO") + " | " + rs.getString("NOME") + " | " + rs.getString("UNIDADE") + " | " + rs.getString("NOME_UNIDADE"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setRelatorio_funcio_suaAgenda(int id_funcionario2) {
        try {
            PreparedStatement pst = comando.prepareStatement(" SELECT F.ID_FUNCIONARIO AS CODIGO, F.NOME_FUNCIO AS FUNCIONARIO,\n"
                    + "           A.ID_AGENDAMENTO AS AGENDAMENTO, A.DATA_AGEN AS DATA, A.HORARIO_INICIAL AS INICIO, A.HORARIO_FINAL AS FINAL\n"
                    + "           FROM AGENDAMENTO AS A\n"
                    + "           INNER JOIN FUNCIONARIO AS F\n"
                    + "           ON A.ID_FUNCIONARIO=F.ID_FUNCIONARIO\n"
                    + "           WHERE F.ID_FUNCIONARIO = ?\n"
                    + "           ORDER BY A.DATA_AGEN ASC,\n"
                    + "		  A.HORARIO_INICIAL ASC;");
            pst.setInt(1, id_funcionario2);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("CODIGO") + " | " + rs.getString("FUNCIONARIO") + " | " + rs.getString("AGENDAMENTO") + " | " + rs.getString("DATA") + " | " + rs.getString("INICIO") + " | " + rs.getString("FINAL"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setRelatorio_Agendamento_dia(int num_unid) {
        try {
            PreparedStatement pst = comando.prepareStatement(" SELECT U.ID_UNIDADE AS UNIDADE, A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                    + "        A.DATA_AGEN AS DATA, C.ID_CLIENTE AS CLIENTE \n"
                    + "        FROM UNIDADE AS U \n"
                    + "        INNER JOIN AGENDAMENTO AS A \n"
                    + "        ON U.ID_UNIDADE = A.ID_UNIDADE \n"
                    + "        INNER JOIN CLIENTE AS C \n"
                    + "        ON C.ID_CLIENTE= A.ID_CLIENTE \n"
                    + "        WHERE U.ID_UNIDADE = ? and \n  "
                    + "        A.DATA_AGEN = date(now());");
            pst.setInt(1, num_unid);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("UNIDADE") + " | " + rs.getString("AGENDAMENTO") + " | " + rs.getString("DATA") + " | " + rs.getString("CLIENTE"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getRelatorio_Agendamento_emEspera() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT A.FILA_ESPERA AS ESPERA,\n"
                    + "	   A.ID_AGENDAMENTO as AGENDAMENTO\n"
                    + "       FROM AGENDAMENTO AS A\n"
                    + "		WHERE A.FILA_ESPERA = 1;");

            while (rs.next()) {
                System.out.println(rs.getString("ESPERA") + " | " + rs.getString("AGENDAMENTO"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getRelatorio_Agendamento_cancelados() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                    + "	   D.ID_STATUS AS CODIGO,D.DESCRICAO_STATUS AS STATUS\n"
                    + "	   FROM AGENDAMENTO AS A\n"
                    + "		INNER JOIN STATUS AS D\n"
                    + "		ON D.ID_STATUS=A.ID_STATUS\n"
                    + "		WHERE D.DESCRICAO_STATUS='cancelado';");

            while (rs.next()) {
                System.out.println(rs.getString("AGENDAMENTO") + " | " + rs.getString("CODIGO") + " | " + rs.getString("STATUS"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setRelatorio_Agendamento_promocao(String nome_unid) {
        try {
            PreparedStatement pst = comando.prepareStatement("SELECT COUNT(A.PROMOCAO) AS QUANTIDADE_PROMOCAO,\n"
                    + "U.DESCRICAO_UNID AS NOME,\n"
                    + "U.ID_UNIDADE AS UNIDADE\n"
                    + "       FROM AGENDAMENTO AS A\n"
                    + "       INNER JOIN UNIDADE AS U\n"
                    + "	ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                    + "       WHERE DESCRICAO_UNID = ?"
                    + "       GROUP BY U.ID_UNIDADE;");
            pst.setString(1, nome_unid);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("QUANTIDADE_PROMOCAO") + " | " + rs.getString("NOME") + " | " + rs.getString("UNIDADE"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getRanking_Unidade() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                    + "            COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE,\n"
                    + "           S.DESCRICAO_STATUS AS STATUS\n"
                    + "               FROM UNIDADE AS U\n"
                    + "               INNER JOIN AGENDAMENTO AS A\n"
                    + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                    + "			   INNER JOIN STATUS AS S\n"
                    + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                    + "               WHERE S.DESCRICAO_STATUS = 'Realizado'\n"
                    + "               GROUP BY U.ID_UNIDADE\n"
                    + "               ORDER BY QUANTIDADE DESC;");

            while (rs.next()) {
                System.out.println(rs.getString("NUMERO_UNIDADE") + " | " + rs.getString("NOME") + " | " + rs.getString("QUANTIDADE") + " | " + rs.getString("STATUS"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getRanking_funcionario() {
        try {
            Statement st = comando.createStatement();
            ResultSet rs = st.executeQuery("SELECT F.ID_FUNCIONARIO AS FUNCIONARIO, F.NOME_FUNCIO AS NOME,\n"
                    + "       COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE\n"
                    + "       FROM FUNCIONARIO AS F\n"
                    + "       INNER JOIN AGENDAMENTO AS A\n"
                    + "       ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                    + "       GROUP BY F.ID_FUNCIONARIO\n"
                    + "       ORDER BY QUANTIDADE DESC;");

            while (rs.next()) {
                System.out.println(rs.getString("FUNCIONARIO") + " | " + rs.getString("NOME") + " | " + rs.getString("QUANTIDADE"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
