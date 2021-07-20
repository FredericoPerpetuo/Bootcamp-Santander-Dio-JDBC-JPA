package b_consultas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    //Crie um construtor privado para evitar que a classe seja instanciada
    private ConnectionFactory(){
        throw new UnsupportedOperationException();
    }

    //Método para conexão
    public static Connection getConnection(){
        Connection connection = null;//Instanciando e inicializando uma conexão

        //Carregamento do arquivo que contem os dados que formarão a string de conexão
        try(InputStream input = Connection.class.getClassLoader().
                getResourceAsStream("connection.properties") ){

            //Atribuições dos parâmetros para a conexão com o BD
            Properties prop =  new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password= prop.getProperty("do.user.password");

            //Concatenação dos parâmetros para formar a string de conexão
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            //Criar a conexão usando o DriveMananger -> parâmeros: url, user, password
            try{
                connection = DriverManager.getConnection(connectionUrl, user, password);
            }catch(SQLException e){
                System.out.println("Falha na conexão!");
                throw new RuntimeException(e);
            }


        }catch (IOException e){
            System.out.println("Falha no carregamento dos arquivos de propriedades!");
            e.getStackTrace();
        }

        return connection;
    }
}
