package biblioteca.com.Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import biblioteca.com.Classes.*;
import biblioteca.com.Excecoes.JacadastradoException;
import biblioteca.com.Excecoes.RepositorioVazio;
import biblioteca.com.Excecoes.naocadastradoException;
import biblioteca.com.repositorios.*;
public class bibliotecaservice {
    private livrosrepositorio repositoriolivros= new livrosrepositorio();
    private autorepositorio repositorioautores= new autorepositorio();
    private usuariorepositorio repositoriousuarios= new usuariorepositorio();
    private emprestimorepositorio repositorioemprestimos= new emprestimorepositorio();
    public bibliotecaservice() {
        
    }
    public emprestimo emprestarlivro(String titulo, Long IDuser){
        livro livroEmprestado;
        try{
        livroEmprestado= repositoriolivros.buscarLivroPorTitulo(titulo);
        }
        catch(naocadastradoException e){
            System.out.println(e.getMessage());
            return null;
        }      
        usuario usuarioEmprestimo;
        try{
            usuarioEmprestimo=repositoriousuarios.buscarPorId(IDuser);
        }
        catch(naocadastradoException g){
            System.out.println(g.getMessage());
            return null;
        }
            if(!livroEmprestado.isEmprestado()){
                emprestimo novoEmprestimo= new emprestimo(livroEmprestado, usuarioEmprestimo, LocalDate.now(), LocalDate.now().plusDays(7));
                livroEmprestado.setEmprestado(true);
                usuarioEmprestimo.setQuantidadeemprestimos(usuarioEmprestimo.getQuantidadeemprestimos()+1);
                try{
                repositorioemprestimos.salvar(novoEmprestimo);
                }
                catch(JacadastradoException e){
                    System.out.println((e.getMessage()));
                }
                return novoEmprestimo;
            }
            else{
                 System.out.println("Livro já foi emprestado\n");
            }

        return null;
    }

    public void devolverlivro(String titulo, LocalDate data_devolucao){
        emprestimo emprestimo = repositorioemprestimos.buscarTodos()
    .stream()
    .filter(e -> titulo.equals(e.getLivro().getTitulo()))
    .findFirst()
    .orElse(null);

        try{
        boolean venceu= repositorioemprestimos.emprestimovenceu(emprestimo, data_devolucao);
        if(venceu){
            System.out.println("Emprestimo venceu, devemos aplicar uma multa!\n");
            try{
            repositorioemprestimos.aplicamulta(emprestimo);
            }
            catch(naocadastradoException g){
                g.getMessage();
            }
        }
        else{
            try{
            emprestimo.getLivro().setEmprestado(false);
            repositorioemprestimos.deletar(emprestimo.getId());
            System.out.println("devolveu");
            }
            catch(naocadastradoException h){
                h.getMessage();
            }
        }
        }
        catch(naocadastradoException e){
            e.getMessage();
        }
        
    }
    
    public void registrarAutor(autor autor){
        try{
        repositorioautores.adicionarAutor(autor);
        }
        catch(JacadastradoException g){
            System.out.println(g.getMessage());
        }
    }

    public void convitePalestra(autor autor){
        try{
           autor =repositorioautores.buscarAutorPorId(autor.getId());
        }
        catch(naocadastradoException b){
            b.getMessage();
        }
        if(autor!=null){
        autor.setPalestrando(true);
        System.out.println("Convite enviado para o autor: " + autor.getNome());
        }
    }
    public void cadastrarUsuario(usuario usuario){
        try{
        repositoriousuarios.salvar(usuario);
        }
        catch(JacadastradoException d){
            System.out.println(d.getMessage());
        }
    }
    public void cadastrarLivro(livro livro){
        try{
        repositoriolivros.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
        }
        catch(JacadastradoException d){
            System.out.println(d.getMessage());
        }
        
    String url = "jdbc:mysql://localhost:3307/dbbiblioteca";
    String user = "root";
    String password = "1234";

    String sql = """
        INSERT INTO livro (titulo, paginas, genero, autor_id, emprestado)
        VALUES (?, ?, ?, ?, ?)
        """;

    try (Connection connection = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, livro.getTitulo());
        stmt.setInt(2, livro.getPaginas());
        stmt.setString(3, livro.getGenero());
        stmt.setLong(4, livro.getAutor().getId());
        stmt.setBoolean(5, livro.isEmprestado());

        stmt.executeUpdate();
        System.out.println("Livro inserido no banco de dados com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void listarLivrosDisponiveis(){
        List<livro> livros = new ArrayList<>();
        try{
        livros =repositoriolivros.listarTodosLivros().stream().filter(livro -> !livro.isEmprestado()).collect(Collectors.toList());
         

        }
        catch(RepositorioVazio d){
            System.out.println("oi");
           System.out.println( d.getMessage());
        }
        livros.forEach(e -> System.out.println("ID: " + e.getId() + ", Titulo: " + e.getTitulo() + ", Autor " + e.getAutor().getNome() + "\n"));
        
    }
    public void listarUsuarios(){
        try{
        repositoriousuarios.listarTodos();
        }
        catch( RepositorioVazio r){
            System.out.println(r.getMessage());
        }
    }
    public void listarAutores(){
        repositorioautores.listarTodos();
    }
    public void listarEmprestimos(){
        repositorioemprestimos.listarTodos();
    }
}
