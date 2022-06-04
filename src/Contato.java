public class Contato {
    private final String nome;
    private final String email;
    private final String tel;

    public Contato(String nome, String email, String tel) {
        this.nome = nome;
        this.email = email;
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
}
