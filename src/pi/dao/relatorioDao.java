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
import modelo.relatorios;

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

    public void relato(relatorios rel) throws SQLException {
        Statement comando1 = this.comando.createStatement();
        
        //RELATORIOS DE AGENDAMENTOS CONCLUIDOS POR UNIDADE
        String query = "SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                + "            A.ID_AGENDAMENTO AS CODIGO_AGENDAMENTO,\n"
                + "            S.ID_STATUS AS CODIGO_STATUS,S.DESCRICAO_STATUS AS STATUS\n"
                + "               FROM UNIDADE AS U\n"
                + "               INNER JOIN AGENDAMENTO AS A\n"
                + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "			   INNER JOIN STATUS AS S\n"
                + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                + "               WHERE S.DESCRICAO_STATUS = 'Realizado';";

        ResultSet rs = comando1.executeQuery(query);
        while (rs.next()) {

            System.out.println(rs.getString("NUMERO_UNIDADE") + " | " + rs.getString("NOME") + " | " + rs.getString("CODIGO_AGENDAMENTO") + " | " + rs.getString("CODIGO_STATUS") + " | " + rs.getString("STATUS"));
        }

        //RELATORIOS DE AGENDAMENTOS CONCLUIDOS POR FUNCIONARIOS
       /* String query2 = "SELECT F.ID_FUNCIONARIO AS CODIGO_FUNCIONARIO,F.NOME_FUNCIO AS NOME,\n"
                + "             A.ID_AGENDAMENTO AS AGENDAMENTOS,\n"
                + "             S.DESCRICAO_STATUS AS STATUS\n"
                + "                FROM FUNCIONARIO AS F\n"
                + "                INNER JOIN AGENDAMENTO AS A\n"
                + "                ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                + "                INNER JOIN STATUS AS S\n"
                + "                ON A.ID_STATUS = S.ID_STATUS\n"
                + "                WHERE S.DESCRICAO_STATUS = 'Realizado';";

        comando1.executeQuery(query2);
        while (rs.next()) {

            System.out.println(rs.getString("CODIGO_FUNCIONARIO") + " | " + rs.getString("NOME") + " | " + rs.getString("AGENDAMENTOS") + " | " + rs.getString("STATUS"));
        }

        String query3 = "SELECT C.ID_CLIENTE AS CODIGO_CLIENTE, C.NOME_CLIENTE AS NOME,\n"
                + "             count(A.ID_AGENDAMENTO) AS QUANTIDADE_FREQUENCIA,\n"
                + "             S.DESCRICAO_STATUS AS STATUS_SERVICO\n"
                + "                FROM CLIENTE AS C\n"
                + "                INNER JOIN AGENDAMENTO AS A\n"
                + "                ON A.ID_CLIENTE= C.ID_CLIENTE\n"
                + "                INNER JOIN STATUS AS S\n"
                + "                ON A.ID_STATUS = S.ID_STATUS\n"
                + "                WHERE S.DESCRICAO_STATUS = 'Realizado,'\n"
                + "                id_cliente=" //id_cliente
                + "                GROUP BY C.ID_CLIENTE;";

        comando1.executeQuery(query3);
        while (rs.next()) {

            System.out.println(rs.getString("CODIGO_CLIENTE") + " | " + rs.getString("NOME") + " | " + rs.getString("QUANTIDADE_FREQUENCIA") + " | " + rs.getString("STATUS_SERVICO"));
        }

        String query4 = "SELECT F.ID_FUNCIONARIO AS FUNCIONARIO,F.NOME_FUNCIO AS NOME, U.ID_UNIDADE AS UNIDADE, U.DESCRICAO_UNID AS NOME_UNIDADE\n"
                + "FROM UNIDADE AS U\n"
                + "INNER JOIN FUNCIONARIO AS F\n"
                + "  ON  F.ID_UNIDADE= U.ID_UNIDADE"
                + "WHERE ID_FUNCIONARIO =" /*+ id_unidade";*/;

       /* comando1.executeQuery(query4);
        while (rs.next()) {

            System.out.println(rs.getString("FUNCIONARIO") + " | " + rs.getString("NOME") + " | " + rs.getString("UNIDADE") + " | " + rs.getString("NOME_UNIDADE"));
        }

        String query5 = "SELECT F.ID_FUNCIONARIO AS CODIGO_FUNCIONARIO, F.NOME_FUNCIO AS FUNCIONARIO,\n"
                + "           A.ID_AGENDAMENTO AS AGENDAMENTO, A.DATA_AGEN AS DATA, A.HORARIO_INICIAL AS INICIO, A.HORARIO_FINAL AS FINAL\n"
                + "           FROM AGENDAMENTO AS A\n"
                + "           INNER JOIN FUNCIONARIO AS F\n"
                + "           ON A.ID_FUNCIONARIO=F.ID_FUNCIONARIO\n"
                + "            WHERE ID_FUNCIONARIO= \n"/*+id_fucionario*/
         /*       + "           ORDER BY A.DATA_AGEN ASC,\n"
                + "	      A.HORARIO_INICIAL ASC;";
        comando1.executeQuery(query5);
        while (rs.next()) {

            System.out.println(rs.getString("CODIGO_FUNCIONARIO") + " | " + rs.getString("FUNCIONARIO") + " | " + rs.getString("AGENDAMENTO") + " | " + rs.getString("DATA") + rs.getString("INICIO") + rs.getString("FINAL"));
        }

        String query6 = "SELECT U.ID_UNIDADE AS UNIDADE, A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                + "        A.DATA_AGEN AS DATA, C.ID_CLIENTE AS CLIENTE \n"
                + "        FROM UNIDADE AS U \n"
                + "        INNER JOIN AGENDAMENTO AS A \n"
                + "        ON U.ID_UNIDADE = A.ID_UNIDADE \n"
                + "        INNER JOIN CLIENTE AS C \n"
                + "        ON C.ID_CLIENTE= A.ID_CLIENTE \n"
                + "        WHERE A.DATA_AGEN = now() ;";

        comando1.executeQuery(query6);

        while (rs.next()) {

            System.out.println(rs.getString("UNIDADE") + " | " + rs.getString("AGENDAMENTO") + " | " + rs.getString("DATA") + " | " + rs.getString("CLIENTE"));
        }

        String query7 = "SELECT A.FILA_ESPERA AS ESPERA,\n"
                + "	   A.ID_AGENDAMENTO AS AGENDAMENTO\n"
                + "       FROM AGENDAMENTO AS A\n"
                + "		WHERE FILA_ESPERA = 1;";

        comando1.executeQuery(query7);

        while (rs.next()) {

            System.out.println(rs.getString("ESPERA") + " | " + rs.getString("AGENDAMENTO"));
        }

        String query8 = "SELECT A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                + "	   D.ID_STATUS AS CODIGO,D.DESCRICAO_STATUS AS STATUS\n"
                + "	   FROM AGENDAMENTO AS A\n"
                + "		INNER JOIN STATUS AS D\n"
                + "		ON D.ID_STATUS=A.ID_STATUS\n"
                + "		WHERE D.DESCRICAO_STATUS='cancelado';";

        comando1.executeQuery(query8);

        while (rs.next()) {

            System.out.println(rs.getString("AGENDAMENTO") + " | " + rs.getString("CODIGO") + rs.getString("STATUS"));
        }
        String query9 = "SELECT COUNT(A.PROMOCAO) AS QUANTIDADE_PROMOCAO,\n"
                + "U.DESCRICAO_UNID AS NOME,\n"
                + "U.ID_UNIDADE AS UNIDADE\n"
                + "       FROM AGENDAMENTO AS A\n"
                + "       INNER JOIN UNIDADE AS U\n"
                + "	   ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "       GROUP BY U.ID_UNIDADE;";
        comando1.executeQuery(query9);

        while (rs.next()) {

            System.out.println(rs.getString("QUANTIDADE_PROMOCAO") + " | " + rs.getString("NOME") + rs.getString("UNIDADE"));
        }

        String query10 = "SELECT F.ID_FUNCIONARIO AS FUNCIONARIO, F.NOME_FUNCIO AS NOME,\n"
                + "       COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE\n"
                + "       FROM FUNCIONARIO AS F\n"
                + "       INNER JOIN AGENDAMENTO AS A\n"
                + "       ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                + "       GROUP BY F.ID_FUNCIONARIO\n"
                + "       ORDER BY QUANTIDADE DESC;";

        comando1.executeQuery(query10);

        while (rs.next()) {

            System.out.println(rs.getString("FUNCIONARIO") + " | " + rs.getString("NOME") + rs.getString("QUANTIDADE"));
        }

        String query11 = "SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                + "            COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE,\n"
                + "            S.DESCRICAO_STATUS AS STATUS\n"
                + "               FROM UNIDADE AS U\n"
                + "               INNER JOIN AGENDAMENTO AS A\n"
                + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "			   INNER JOIN STATUS AS S\n"
                + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                + "               WHERE S.DESCRICAO_STATUS = 'Realizado'\n"
                + "               GROUP BY U.ID_UNIDADE\n"
                + "               ORDER BY QUANTIDADE DESC;";

        comando1.executeQuery(query11);

        while (rs.next()) {

            System.out.println(rs.getString("NUMERO_UNIDADE") + " | " + rs.getString("NOME") + rs.getString("QUANTIDADE")+ rs.getString("STATUS"));
        }
    */}
}

         