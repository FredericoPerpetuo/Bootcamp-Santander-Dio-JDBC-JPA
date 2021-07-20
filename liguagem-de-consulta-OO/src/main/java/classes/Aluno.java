package classes;

import javax.persistence.*;

@Entity//Essa anotação informa que a classe aluno representa a tabela aluno do BD
public class Aluno {

    @Id //Informa que o atributo id representa a coluna id da tabela de aluno
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column //Informa que o atributo nome representa a coluna id da tabela de aluno
    private String nome;

    @Column //Informa que o atributo idade representa a coluna id da tabela de aluno
    private int idade;

    @ManyToOne (fetch = FetchType.EAGER)/*Vários alunos podem morar em um estado /
    o FetchTyper.EAGER irá carregar o estado do aluno automaticamente*/
    private Estado estado;

    public Aluno() { }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(String nome, int idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Estado: " + estado + "\n";
    }
}