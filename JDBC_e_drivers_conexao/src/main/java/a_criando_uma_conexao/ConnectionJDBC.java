package a_criando_uma_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {

        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";

        try(Connection conn = DriverManager.getConnection(urlConnection,"root", "FreeYourMind@1999")) {
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Conexão falhou!!!");
        }

//        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";
//
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(urlConnection,"root", "FreeYourMind@1999");
//            System.out.println("Conectado com sucesso!");
//        } catch (Exception e) {
//            System.out.println("Conexão falhou!!!");
//        }
//        finally {
//            conn.close();
//        }
    }
}
