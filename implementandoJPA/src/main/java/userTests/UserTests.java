
package userTests;

import classes.Aluno;
import classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTests {
    public static void main(String[] args) {

        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("estudo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar1 = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar1 = new Aluno("Maria", 29, estadoParaAdicionar1);
        Aluno alunoParaAdicionar2 = new Aluno("Joao", 32, estadoParaAdicionar1);

        // 2.2 - Iniciar uma trasacao para adicionar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar1);
        entityManager.persist(alunoParaAdicionar1);
        entityManager.persist(alunoParaAdicionar2);

        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados

        Aluno alunoEncontrado1 = entityManager.find(Aluno.class, 1);
        Aluno alunoEncontrado2 = entityManager.find(Aluno.class, 2);


        System.out.println("======ANTES DE MUDAR======\n" + alunoEncontrado1);
        System.out.println(alunoEncontrado2);
//
//        // 4 - Alterar uma entidade
        entityManager.getTransaction().begin();

        alunoEncontrado1.setNome(alunoEncontrado1.getNome() + " Karam");
        alunoEncontrado1.setIdade(20);
        System.out.println("======DEPOIS DE MUDAR======\n" + alunoEncontrado1);

        entityManager.getTransaction().commit();
//
//        // 5 - Remover uma entidade
        entityManager.getTransaction().begin();
        entityManager.remove(alunoEncontrado2);
        entityManager.getTransaction().commit();

        if(entityManager.find(Aluno.class, 2) == null){
            System.out.println("Aluno não encontrado!!!");
        }


        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}