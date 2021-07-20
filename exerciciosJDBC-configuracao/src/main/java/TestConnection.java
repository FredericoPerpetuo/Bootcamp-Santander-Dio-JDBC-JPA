import java.util.List;

public class TestConnection {
    public static void main(String[] args) {

        LivroDAO livroDAO = new LivroDAO();

        List<Livro> livros = livroDAO.list();

        livros.stream().forEach(System.out::println);
    }
}
