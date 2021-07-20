package curso;

public class Curso {
    private int id;
    private String nome;
    private float duracaoHoras;

    public Curso(){ }

    public Curso(int id, String nome, float duracaoHoras){
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, float duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(float duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id).append('\n');
        sb.append("Nome: ").append(nome).append('\n');
        sb.append("Duração: ").append(duracaoHoras).append('\n');
        return sb.toString();
    }
}

