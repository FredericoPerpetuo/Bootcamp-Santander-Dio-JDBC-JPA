package userTests;

import classes.Aluno;
import classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTests {
    public static void main(String[] args) {

        /*
        OBS: Esse codigo pode ou nao funcionar de acordo com a biblioteca que foi baixada.
        Se estiver somente com o JPA baixado, o codigo NÃO IRA funcionar. Porem se estiver com
        a biblioteca de algum framework com implementacao JPA (Hibernate ou EclipseLink),
        o JPA ira automaticamente utiliza-lo.

        O ideal eh que nessa parte (Parte 1) o codigo EXECUTE COM ERRO
        (Ao tentar executar irá mostrar um erro afirmando que não foi
        encontradado nenhuma implementação do JPA), pois utilizamoes apenas o JPA puro para
        demonstrar que através dele eh possivel definir a estrutura do codigo e
        depois escolher a implementacao a ser utilizada.
        Apenas na parte 2 do  curso será escolhida uma implementacao para o codigo executar sem erro*/

        /*Passos iniciais para criar um gerenciador de entidades com o banco de
        dados especificado no arquivo "persistence.xml"*/
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        // 3 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}