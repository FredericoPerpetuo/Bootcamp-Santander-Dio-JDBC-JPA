package curso;
import java.util.List;
import java.util.Scanner;

public class UserTest {
    public static CursoDAO cursoDAO =  new CursoDAO();
    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }

    private static void menu() {
        int opcao = 0;
        do {
            System.out.println("\n===============MENU TESTES===============");
            System.out.println("1-LISTAR");
            System.out.println("2-BUSCAR POR ID");
            System.out.println("3-BUSCAR POR NOME");
            System.out.println("4-ALTERAR NOME");
            System.out.println("5-ALTERAR DURAÇÃO");
            System.out.println("6-EXCLUIR");
            System.out.println("7-INSERIR");
            System.out.println("0-SAIR");
            System.out.print("Opção: ");
            opcao = read.nextInt();
            read.nextLine();//Limpeza de buffer
            System.out.println("==========================================\n");

            switch (opcao) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    searchById();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    editName();
                    break;
                case 5:
                    editDuration();
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    insert();
                    break;
                case 0:
                    System.out.println("Obrigado pelos testes!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao!=0);

    }

    private static void insert() {
        String nome = null;
        float duracao = 0;
        System.out.println("=======Inserir curso=======");
        while(true){
            System.out.print("Nome: ");
            nome = read.nextLine().toUpperCase();
            if(nome.isEmpty()){
                System.out.println("A inserção do nome é obrigatória!");
            }else{
                break;
            }
        }

        while(true){
            System.out.print("Duração: ");
            duracao = read.nextFloat();
            read.nextLine();
            if(duracao < 0){
                System.out.println("Insira um valor de duração válido!");
            }else{
                break;
            }
        }

        Curso novoCurso = new Curso(nome, duracao);
        cursoDAO.insertCourse(novoCurso);
    }

    private static void delete() {
        int id = 0;
        String confirmacao = null;

        System.out.println("=======Excluir curso=======");
        System.out.print("Digite o id do curso que deseja excluir: ");
        id = read.nextInt();
        read.nextLine();//Limpeza de buffer

        Curso cursoParaExcluir = cursoDAO.getById(id);
        System.out.println(cursoParaExcluir.toString());

        while(true){
            System.out.print("Confirma exclusão(S/N): ");
            confirmacao = read.nextLine().toUpperCase();

            if(confirmacao.equals("S")){
                cursoDAO.deleteCourse(cursoParaExcluir);
                break;
            }else{
                System.out.println("Exclusão cancelada!");
                break;
            }
        }
    }

    private static void editDuration() {
        int id = 0;
        float novaDuracao = 0;
        System.out.println("=======Editar duração=======");
        System.out.print("Digite o id do curso que deseja modificar: ");
        id = read.nextInt();
        read.nextLine();//Limpeza de buffer

        Curso cursoParaAtualizar = cursoDAO.getById(id);
        System.out.println(cursoParaAtualizar.toString());

        System.out.print("Digite a nova duração: ");
        novaDuracao = read.nextFloat();
        cursoParaAtualizar.setDuracaoHoras(novaDuracao);
        cursoDAO.editDuration(cursoParaAtualizar);
    }

    private static void editName() {
        int id = 0;
        String novoNome = null;
        System.out.println("=======Editar nome=======");
        System.out.print("Digite o id do curso que deseja modificar: ");
        id = read.nextInt();
        read.nextLine();//Limpeza de buffer

        Curso cursoParaAtualizar = cursoDAO.getById(id);
        System.out.println(cursoParaAtualizar.toString());

        System.out.print("Digite o novo nome:");
        novoNome = read.nextLine().toUpperCase();
        cursoParaAtualizar.setNome(novoNome);
        cursoDAO.editName(cursoParaAtualizar);
    }

    private static void searchByName() {
        System.out.println("=======Busca por nome=======");
        System.out.println("Para sair digite sair");
        String nome = null;
        Curso curso = new Curso();

        while(true){
            System.out.print("Digite o nome: ");
            nome = read.nextLine().toUpperCase();
            curso = cursoDAO.getByName(nome);
            if(nome.equals("sair")) {
                return;
            }else if(curso.getNome() == null){
                System.out.println("Nome inexistente na base de dados!");
            } else {
                break;
            }
        }

        System.out.println(curso.toString());
    }

    private static void searchById() {
        System.out.println("=======Busca por ID=======");
        System.out.println("Para sair digite -1");
        int id = 0;
        Curso curso = new Curso();

        while(true){
            System.out.print("Digite o id: ");
            id = read.nextInt();
            curso = cursoDAO.getById(id);
            if(id == -1){
                return;
            }else if(curso.getNome() == null){
                System.out.println("Id inexistente na base de dados!");
            } else{
                break;
            }
        }

        System.out.println(curso.toString());
    }

    private static void listAllCourses() {
        System.out.println("=======Lista de Cursos=======");
        List<Curso> cursos = cursoDAO.list();
        cursos.stream().forEach(System.out::println);
    }





}
