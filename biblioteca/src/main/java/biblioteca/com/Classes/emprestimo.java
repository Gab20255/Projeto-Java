package biblioteca.com.Classes;
import java.time.LocalDate;
public class emprestimo implements biblioteca.com.Interfaces.indentificar<Long> {
    private livro livro;
    private usuario usuario;
    private LocalDate datainicioEmprestimo;
    private LocalDate datadevolucao;
    private Long id;
    private static Long contador = 0L;
    private float multa=0.0f;
    public emprestimo(livro livro, usuario usuario, LocalDate datainicioEmprestimo, LocalDate datadevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.datainicioEmprestimo = datainicioEmprestimo;
        this.datadevolucao = datadevolucao; 
        this.id= ++contador;
        this.multa=50.0f;
    }
    
    public void setDatainicioEmprestimo(LocalDate datainicioEmprestimo) {
        this.datainicioEmprestimo = datainicioEmprestimo;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public LocalDate getDatadevolucao() {
        return datadevolucao;
    }
    public void setDatadevolucao(LocalDate datadevolucao) {
        this.datadevolucao = datadevolucao;
    }
    public livro getLivro() {
        return livro;
    }
    public usuario getUsuario() {
        return usuario;
    }
    public LocalDate getDatainicioEmprestimo() {
        return datainicioEmprestimo;
    }
    @Override
    public Long getId() {
        return id;
    }
    public void setLivro(livro livro) {
        this.livro = livro;
    }
    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
