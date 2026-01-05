package biblioteca.com.Excecoes;

public class JacadastradoException extends Exception {
    public JacadastradoException(String nome) {
        super(nome+" já está cadastrado.");
    }
}
