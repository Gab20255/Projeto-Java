package biblioteca.com.Classes;

import biblioteca.com.Interfaces.indentificar;

public class livro implements indentificar<Long> {
    private static Long contador = 0L;
    private String titulo;
    private Long id;
    private int paginas;
    private String genero;
    private autor autor;
    private boolean emprestado;

    public livro(String titulo, autor autor, int paginas, String generor, boolean emprestado, String genero) {
        this.titulo = titulo;
        this.id = ++contador;
        this.paginas = paginas;
        this.genero = genero;
        this.autor = autor;
        this.emprestado = emprestado;
    }
    
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public autor getAutor() {
        return autor;
    }

    public void setAutor(autor autor) {
        this.autor = autor;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }
    @Override
    public Long getId() {
        return id;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getGenero() {
        return genero;
    }
    
}
