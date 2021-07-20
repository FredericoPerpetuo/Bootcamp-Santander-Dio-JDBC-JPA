package curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    //1) Listagem de alunos
    public List<Curso> list(){
        List<Curso> cursos = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM curso";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float duracao_horas = rs.getFloat("duracao_horas");

                cursos.add(new Curso(
                        id,
                        nome,
                        duracao_horas
                ));
            }

        }catch(SQLException e){
            System.out.println("Falha na listagem de cursos!");
            e.printStackTrace();
        }
        return cursos;
    }


    //2) Buscar por ID
    public Curso getById(int id) {
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                curso.setId(id);
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getFloat("duracao_horas"));
            }

        } catch (SQLException e) {
            System.out.println("Falha na busca!");
            e.printStackTrace();
        }

        return curso;
    }

    //3-Buscar por nome
    public Curso getByName(String name) {
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM curso WHERE nome = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getFloat("duracao_horas"));
            }

        } catch (SQLException e) {
            System.out.println("Falha na busca!");
            e.printStackTrace();
        }

        return curso;
    }

    public void editName(Curso curso){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE curso SET nome = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getId());
            stmt.executeUpdate();

            System.out.println("Atualização bem sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na atualização!");
            e.printStackTrace();
        }
    }

    public void editDuration(Curso curso){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE curso SET duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, curso.getDuracaoHoras());
            stmt.setInt(2, curso.getId());
            stmt.executeUpdate();

            System.out.println("Atualização bem sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na atualização!");
            e.printStackTrace();
        }
    }

    public void deleteCourse(Curso curso){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getId());
            stmt.executeUpdate();

            System.out.println("Exclusão bem sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na exclusão!");
            e.printStackTrace();
        }
    }

    public void insertCourse(Curso curso){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setFloat(2, curso.getDuracaoHoras());
            stmt.executeUpdate();

            System.out.println("Inserção bem sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na inserção!");
            e.printStackTrace();
        }
    }


}
