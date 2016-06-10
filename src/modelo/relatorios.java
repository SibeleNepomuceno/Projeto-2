/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sibele
 */
public class relatorios {

//METODOS PARA CADA RELATORIO
//Atendimentos realizados por unidade
    public void atendimento_unidade() {
        String sql = ("SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                + "            A.ID_AGENDAMENTO AS CODIGO_AGENDAMENTO,\n"
                + "            S.ID_STATUS AS CODIGO_STATUS,S.DESCRICAO_STATUS AS STATUS\n"
                + "               FROM UNIDADE AS U\n"
                + "               INNER JOIN AGENDAMENTO AS A\n"
                + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "			   INNER JOIN STATUS AS S\n"
                + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                + "               WHERE S.DESCRICAO_STATUS = 'Realizado';");
    }

//Atendimentos realizados por funcionario
    public void atendimento_funcionario() {
        String sql = ("SELECT F.ID_FUNCIONARIO AS CODIGO_FUNCIONARIO,F.NOME_FUNCIO AS NOME,\n"
                + "             A.ID_AGENDAMENTO AS AGENDAMENTOS,\n"
                + "             S.DESCRICAO_STATUS AS STATUS\n"
                + "                FROM FUNCIONARIO AS F\n"
                + "                INNER JOIN AGENDAMENTO AS A\n"
                + "                ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                + "                INNER JOIN STATUS AS S\n"
                + "                ON A.ID_STATUS = S.ID_STATUS\n"
                + "                WHERE S.DESCRICAO_STATUS = 'Realizado';");
    }
//Atendimentos concluidos por clientes

    public void atendimento_cliente(int id_cliente) {
        String sql = ("SELECT C.ID_CLIENTE AS CODIGO_CLIENTE, C.NOME_CLIENTE AS NOME,\n"
                + "             count(A.ID_AGENDAMENTO) AS QUANTIDADE_FREQUENCIA,\n"
                + "             S.DESCRICAO_STATUS AS STATUS_SERVICO\n"
                + "                FROM CLIENTE AS C\n"
                + "                INNER JOIN AGENDAMENTO AS A\n"
                + "                ON A.ID_CLIENTE= C.ID_CLIENTE\n"
                + "                INNER JOIN STATUS AS S\n"
                + "                ON A.ID_STATUS = S.ID_STATUS\n"
                + "                WHERE S.DESCRICAO_STATUS = 'Realizado',\n"
                + "                C.NOME_CLIENTE ="+id_cliente+// FICA ASSIM?
                "                GROUP BY C.ID_CLIENTE;");

    }

//Funcionario e sua unidade
    public void funcionario_e_unidade(int id_unidade) {
        String sql = ("SELECT F.ID_FUNCIONARIO AS FUNCIONARIO,F.NOME_FUNCIO AS NOME, U.ID_UNIDADE AS UNIDADE, U.DESCRICAO_UNID AS NOME_UNIDADE\n"
                + "FROM UNIDADE AS U\n"
                + "INNER JOIN FUNCIONARIO AS F\n"
                + "  ON  F.ID_UNIDADE= U.ID_UNIDADE"
                + "WHERE ID_FUNCIONARIO =" + id_unidade);//Fica assim?

    }
//Funcionario e sua agenda

    public void funcionario_e_agenda(int id_funcionario) {
        String sql = ("SELECT F.ID_FUNCIONARIO AS CODIGO_FUNCIONARIO, F.NOME_FUNCIO AS FUNCIONARIO,\n"
                + "           A.ID_AGENDAMENTO AS AGENDAMENTO, A.DATA_AGEN AS DATA, A.HORARIO_INICIAL AS INICIO, A.HORARIO_FINAL AS FINAL\n"
                + "           FROM AGENDAMENTO AS A\n"
                + "           INNER JOIN FUNCIONARIO AS F\n"
                + "           ON A.ID_FUNCIONARIO=F.ID_FUNCIONARIO\n"
                + "WHERE id_funcionario = " + id_funcionario + //Fica assim?
                "           ORDER BY A.DATA_AGEN ASC,\n"
                + "	A.HORARIO_INICIAL ASC;");

    }
//Agendamentos marcados para o dia atual

    public void agendamento_dia(int cod_unid) {
        String sql = (" SELECT U.ID_UNIDADE AS UNIDADE, A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                + "        A.DATA_AGEN AS DATA, C.ID_CLIENTE AS CLIENTE \n"
                + "        FROM UNIDADE AS U \n"
                + "        INNER JOIN AGENDAMENTO AS A \n"
                + "        ON U.ID_UNIDADE = A.ID_UNIDADE \n"
                + "        INNER JOIN CLIENTE AS C \n"
                + "        ON C.ID_CLIENTE= A.ID_CLIENTE \n"
                + "        WHERE A.DATA_AGEN = now(), "//DATA ATUAL É ASSIM MESMO?
                +"         id_unidade ="+cod_unid); 

    }
//Agendamentos que estao em lista de espera

    public void agendamento_espera() {
        String sql = ("SELECT A.FILA_ESPERA AS ESPERA,\n"
                + "	   A.ID_AGENDAMENTO AGENDAMENTO\n"
                + "       FROM AGENDAMENTO AS A\n"
                + "		WHERE FILA_ESPERA = 1;");// FICA ASSIM?

    }

//Agendamentos que foram cancelados
    public void agendamento_cancelado() {
        String sql = ("SELECT A.ID_AGENDAMENTO AS AGENDAMENTO,\n"
                + "	   D.ID_STATUS AS CODIGO,D.DESCRICAO_STATUS AS STATUS\n"
                + "	   FROM AGENDAMENTO AS A\n"
                + "		INNER JOIN STATUS AS D\n"
                + "		ON D.ID_STATUS=A.ID_STATUS\n"
                + "		WHERE D.DESCRICAO_STATUS='cancelado';");

    }

//Quantidade de agendamentos que participaram da promoção
    public void agendamento_promocao() {
        String sql = ("SELECT COUNT(A.PROMOCAO) AS QUANTIDADE_PROMOCAO,\n"
                + "U.DESCRICAO_UNID AS NOME,\n"
                + "U.ID_UNIDADE AS UNIDADE\n"
                + "       \n"
                + "       FROM AGENDAMENTO AS A\n"
                + "       INNER JOIN UNIDADE AS U\n"
                + "	   ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "       GROUP BY U.ID_UNIDADE;");

    }
//Ranking com quantidade de atendimentos, por unidade

    public void ranking_unidade() {
        String sql = ("SELECT F.ID_FUNCIONARIO AS FUNCIONARIO, F.NOME_FUNCIO AS NOME,\n"
                + "       COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE\n"
                + "       FROM FUNCIONARIO AS F\n"
                + "       INNER JOIN AGENDAMENTO AS A\n"
                + "       ON A.ID_FUNCIONARIO= F.ID_FUNCIONARIO\n"
                + "       GROUP BY F.ID_FUNCIONARIO\n"
                + "       ORDER BY QUANTIDADE DESC;");

    }
//Ranking com quantidade de atendimentos,por funcionarios

    public void ranking_funcionario() {
        String sql = ("SELECT U.ID_UNIDADE AS NUMERO_UNIDADE, U.DESCRICAO_UNID AS NOME,\n"
                + "            COUNT(A.ID_AGENDAMENTO) AS QUANTIDADE,\n"
                + "            S.ID_STATUS AS CODIGO_STATUS,S.DESCRICAO_STATUS AS STATUS\n"
                + "               FROM UNIDADE AS U\n"
                + "               INNER JOIN AGENDAMENTO AS A\n"
                + "               ON A.ID_UNIDADE= U.ID_UNIDADE\n"
                + "			   INNER JOIN STATUS AS S\n"
                + "			   ON A.ID_STATUS= S.ID_STATUS\n"
                + "               WHERE S.DESCRICAO_STATUS = 'Realizado'\n"
                + "               GROUP BY U.ID_UNIDADE\n"
                + "               ORDER BY QUANTIDADE DESC;");

    }

    public void relato(relatorios rel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
