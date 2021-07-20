import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public List<Livro> list(){
        List<Livro> livros = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM livro";


            PreparedStatement stmt = conn.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String editora = rs.getString("editora");

                livros.add(new Livro(
                        id,
                        titulo,
                        autor,
                        editora
                ));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de livros falhou!");
            e.printStackTrace();
        }


        return livros;
    }
}
