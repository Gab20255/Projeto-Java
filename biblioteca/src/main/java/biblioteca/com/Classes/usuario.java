package biblioteca.com.Classes;

import biblioteca.com.Interfaces.indentificar;

public class usuario implements indentificar<Long> {
    private String nome;
    private Long id;
    private String email;
    private static Long contador = 0L;
    private int quantidadeemprestimos;
    private float multado=0.0f; 
    public usuario(String nome, String email, emprestimo emprestimo, int quantidadeemprestimos) {
        this.nome = nome;
        this.email = email;
        this.id = ++contador;
        this.quantidadeemprestimos = quantidadeemprestimos;
        this.multado=0.0f;
    }
    public float getMultado() {
        return multado;
    }
    public void setMultado(float multado) {
        this.multado = multado;
    }
    public int getQuantidadeemprestimos() {
        return quantidadeemprestimos;
    }
    public void setQuantidadeemprestimos(int quantidadeemprestimos) {
        this.quantidadeemprestimos = quantidadeemprestimos;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
