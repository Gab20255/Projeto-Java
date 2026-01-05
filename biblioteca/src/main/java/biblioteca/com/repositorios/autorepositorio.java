package biblioteca.com.repositorios;
import biblioteca.com.Classes.autor;
import biblioteca.com.Classes.livro;
import biblioteca.com.Excecoes.JacadastradoException;
import biblioteca.com.Excecoes.RepositorioVazio;
import biblioteca.com.Excecoes.naocadastradoException;

import java.util.List;
public class autorepositorio  {
    private repositorio<autor, Long> autores;

    public autorepositorio() {
        this.autores = new repositorio<>();
    }
    public void listarTodos(){
        autores.buscarTodos().forEach(a -> System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome() + ", Nacionalidade: " + a.getNacionalidade()));
    }
    
    public void adicionarAutor(autor autor) throws JacadastradoException{
        if(autores.buscarporID(autor.getId()).isPresent()){
            throw new JacadastradoException(autor.getNome());
        }
        autores.salvar(autor);
    }
    public autor buscarAutorPorId(Long id) throws naocadastradoException {
        autor autor=autores.buscarporID(id).orElse(null);
        if (autor== null) {
            throw new naocadastradoException("Autor indefinido");
        }
        return autor;
    }
    public void removerAutor(Long id) throws naocadastradoException {
        if(autores.buscarporID(id)==null){
            throw new naocadastradoException("Este autor");
        }
        autores.deletar(id);
    }
    public List<autor> listarTodosAutores() throws RepositorioVazio {
        if(autores==null){
            throw new RepositorioVazio();
        }
        return autores.buscarTodos();
    }
    public autor buscarAutorPorNome(String nome) throws naocadastradoException {
        autor autor=autores.buscarTodos().stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (autor== null) {
            throw new naocadastradoException("Autor "+nome);
        }
        return autor;
    }
    public List<livro> listarLivrosPorAutor(autor autor, livrosrepositorio livroServices) throws RepositorioVazio{
        return livroServices.listarLivrosPorAutor(autor);
    }
    public void publicarLivroParaAutor(autor autor, livro livro, livrosrepositorio livroServices) throws naocadastradoException, JacadastradoException{
        autor=autores.buscarporID(autor.getId()).orElse(null);
        if (autor== null) {
            throw new naocadastradoException("Autor ");
        }
        livroServices.adicionarLivro(livro);
    }

}
