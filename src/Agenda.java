import java.util.Objects;
import java.util.Scanner;

public class Agenda {
    private final Contato[] listaContatos;
    private int qtd;

    public Agenda() {
        this.listaContatos = new Contato[100];
        this.qtd = 0;
    }

    public static Contato criarContato(Scanner input) {
        input.nextLine();
        System.out.println("Informe um nome");
        String nome = input.nextLine();
        System.out.println("Informe um email");
        String email = input.nextLine();
        System.out.println("Informe o telefone");
        String telefone = input.nextLine();
        return new Contato(nome, email, telefone);
    }

    public void inserir(Contato contato) {
        this.listaContatos[qtd] = contato;
        qtd++;
    }

    public Contato pesquisar(String email) {
        int pos = obterIndice(email);
        if (pos >= 0) {
            return listaContatos[pos];
        }
        return null;
    }

    private int obterIndice(String email) {
        int i = 0;
        boolean achou = false;
        while(!achou && i < qtd) {
            if(Objects.equals(listaContatos[i].getEmail(), email)) {
                achou = true;
            } else {
                i++;
            }
        }
        return achou ? i : -1;
    }

    public void remover(String email) {
        int pos = obterIndice(email);
        if (pos >= 0) {
            listaContatos[pos] = listaContatos[qtd-1];
            listaContatos[qtd-1] = null;
            qtd--;
        }
    }

    public void listarContatos() {
        for (int i = 0; i < qtd; i++) {
            System.out.printf("%-30s %20s %s\n",
                    listaContatos[i].getNome(), listaContatos[i].getTel(), listaContatos[i].getEmail());
        }
    }

    public void alterarContato(Contato contatoAlterado, String email) {
        int pos = obterIndice(email);
        listaContatos[pos] = contatoAlterado;
    }
}
