/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alessandra
 */
public class Conexao {
    
    // Configura essas variáveis de acordo com o seu banco  
   private static final String URL = "jdbc:mysql://127.0.0.1/cliente",
            NOME = "root", SENHA = "beli1771";
    
  /* private static final String URL = "jdbc:mysql://projetointegra.mysql.dbaas.com.br:3306/projetointegra?zeroDateTimeBehavior=convertToNull",
            NOME = "projetointegra", SENHA = "loca1020";*/


    public static Connection con;
    public static Statement comando;

    public static final int MYSQL = 0;
    private static final String MySQLDriver = "com.mysql.jdbc.Driver";

    public static Connection abreConexao(String url, String nome, String senha,
            int banco) throws ClassNotFoundException, SQLException {

        switch (banco) {
            case MYSQL:
                Class.forName(MySQLDriver);
                break;
        }
        return DriverManager.getConnection(url, nome, senha);
    }

    public static Connection conectar() {
        try {
            con = abreConexao(URL, NOME, SENHA, Conexao.MYSQL);
            //System.out.println("Conectado!");
            
            return con;
            
        } catch (ClassNotFoundException e) {
            imprimeErro("Erro ao carregar o driver", e.getMessage());
        } catch (SQLException e) {
            imprimeErro("Erro ao conectar", e.getMessage());
        }
        return con;
    }

  /*  public static void fechar(Connection conn) {
        try {
            conn.close();
            //con.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            imprimeErro("Erro ao fechar conexão", e.getMessage());
        }
    }*/

    public static void imprimeErro(String msg, String msgErro) {
//        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
