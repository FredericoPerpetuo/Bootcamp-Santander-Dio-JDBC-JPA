public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String editora;

    public Livro(int id, String titulo, String autor, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Editora: " + editora + "\n";
    }
}
