import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int n;
        do {
            menu();
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
            switch (n) {
                case 1:
                    Contato contato = Agenda.criarContato(input);
                    agenda.inserir(contato);
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Informe o email do contato a ser removido");
                    String email = input.nextLine();
                    agenda.remover(email);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Informe o email do contato a ser filtrado");
                    email = input.nextLine();
                    System.out.println(agenda.pesquisar(email));
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Informe o email do contato a ser filtrado");
                    email = input.nextLine();
                    System.out.println("Informe as novas informações do contato");
                    Contato contatoAlterado = Agenda.criarContato(input);
                    agenda.alterarContato(contatoAlterado, email);
                    break;
            }
        } while (n != 0);
    }

    private static void menu() {
        System.out.println(
                "1 - Adicionar um contato\n" +
                        "2 - Listar contatos\n" +
                        "3 - Apagar um contato\n" +
                        "4 - Filtar um contato pelo email\n" +
                        "5 - Alterar um contato\n" +
                        "0 - Sair");
    }
}
