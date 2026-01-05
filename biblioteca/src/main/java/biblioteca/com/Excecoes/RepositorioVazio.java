package biblioteca.com.Excecoes;

public class RepositorioVazio extends Exception {
    public RepositorioVazio(){
        super("O repositorio ainda não tem nenhum dado cadastrado");
    }
}
