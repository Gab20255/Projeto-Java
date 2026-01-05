package biblioteca.com;
import biblioteca.com.Classes.*;
import biblioteca.com.Services.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        autor autor1= new autor("Machado De Assis","Brasileiro");
        autor autor2= new autor("J.K. Rowling","Britanica");
        livro livro1= new livro("Dom Casmurro", autor1, 256, "Romance", false, "Ficcao");
        livro livro2= new livro("Harry Potter e a Pedra Filosofal", autor2, 320, "Fantasia", false, "Ficcao");
        livro livro3= new livro("Harry Potter e a Camara Secreta", autor2, 341, "Fantasia", false, "Ficcao");
        usuario usuario1= new usuario("Gabriel","gab@gmail.com", null, 0);
        usuario usuario2= new usuario("Ellen","ellen@gmail.com", null, 0);
        bibliotecaservice biblioteca= new bibliotecaservice();
        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarUsuario(usuario1);
        biblioteca.cadastrarUsuario(usuario2);
        biblioteca.registrarAutor(autor2);
        biblioteca.registrarAutor(autor1);
        biblioteca.emprestarlivro("Dom Casmurro", usuario1.getId());
        biblioteca.emprestarlivro("Dom Casmurro", usuario2.getId());
        biblioteca.emprestarlivro("Harry Potter e a Pedra Filosofal", usuario2.getId());
        biblioteca.listarEmprestimos();
        biblioteca.devolverlivro("Dom Casmurro", LocalDate.of(2025,12,28));
        biblioteca.convitePalestra(autor1);
        biblioteca.listarAutores();
        biblioteca.listarEmprestimos();
        biblioteca.listarUsuarios();
        biblioteca.listarLivrosDisponiveis();
    }
}