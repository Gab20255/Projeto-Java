package biblioteca.com.repositorios;
import biblioteca.com.Classes.*;
import biblioteca.com.Excecoes.JacadastradoException;
import biblioteca.com.Excecoes.RepositorioVazio;
import biblioteca.com.Excecoes.naocadastradoException;

import java.util.List;
import java.util.stream.Collectors;


public class livrosrepositorio {
    private repositorio<livro, Long> livros;
    public void listarTodos() throws RepositorioVazio{
        if(livros.buscarTodos()==null){
            throw new RepositorioVazio();
        }
        livros.buscarTodos().forEach(l -> System.out.println("ID: " + l.getId() + ", Titulo: " + l.getTitulo() + ", Autor: " + l.getAutor().getNome() + ", Emprestado: " + l.isEmprestado()));
    }
    public livrosrepositorio() {
        this.livros = new repositorio<>();
    }

    public void adicionarLivro(livro livro) throws JacadastradoException {
        livro livro1=livros.buscarporID(livro.getId()).orElse(null);
        if(livro1!=null){
            throw new JacadastradoException(livro.getTitulo());
        }
        livros.salvar(livro);
    }

    public livro buscarLivroPorId(Long id) throws naocadastradoException {
        livro livro=livros.buscarporID(id).orElse(null);
        if(livro==null){
            throw new naocadastradoException("Livro ");
        }
        return livro;
    }

    public void removerLivro(Long id) throws naocadastradoException {
        livro livro=livros.buscarporID(id).orElse(null);
        if(livro==null){
            throw new naocadastradoException("Livro ");
        }
        livros.deletar(id);
    }

    public java.util.List<livro> listarTodosLivros() throws RepositorioVazio {
        if(livros==null){
            throw new RepositorioVazio();
        }
        return livros.buscarTodos();
    }

    public livro buscarLivroPorTitulo(String titulo) throws naocadastradoException{
        livro livro_e;
        livro_e=livros.buscarTodos().stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
        if(livro_e== null){
            throw new naocadastradoException(titulo);
        }
        return livro_e;
    }
    public List<livro> listarLivrosEmprestados() throws RepositorioVazio{
        if(livros.buscarTodos()==null){
            throw new RepositorioVazio();
        }
        return livros.buscarTodos().stream().filter(l -> l.isEmprestado()).collect(Collectors.toList());
    }

    public List<livro> listarLivrosPorAutor(autor autor)throws RepositorioVazio{
        if(livros.buscarTodos()==null){
            throw new RepositorioVazio();
        }
        return livros.buscarTodos().stream().filter(l -> l.getAutor().getId().equals(autor.getId())).collect(Collectors.toList());
    }


}
