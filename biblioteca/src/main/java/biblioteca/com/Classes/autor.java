package biblioteca.com.Classes;
import biblioteca.com.Interfaces.indentificar;

public class autor implements indentificar<Long> {
    private boolean palestrando=false;
    private String nome;
    private String nacionalidade;
    private Long id;
    private static Long contador = 0L;
    public autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.id = ++contador;
        this.palestrando=false;
    }
    public boolean isPalestrando() {
        return palestrando;
    }
    public void setPalestrando(boolean palestrando) {
        this.palestrando = palestrando;
    }
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}