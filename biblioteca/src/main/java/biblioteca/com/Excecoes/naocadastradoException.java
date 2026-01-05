package biblioteca.com.Excecoes;

public class naocadastradoException extends Exception {
    public naocadastradoException(String titulo) {
        super(titulo+" não foi encontrado.");
    }
}
