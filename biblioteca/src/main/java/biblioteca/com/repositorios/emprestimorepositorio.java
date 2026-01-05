package biblioteca.com.repositorios;
import biblioteca.com.Classes.*;
import biblioteca.com.Excecoes.JacadastradoException;
import biblioteca.com.Excecoes.naocadastradoException;

import java.util.List;
import java.time.LocalDate;
public class emprestimorepositorio {
    private repositorio<emprestimo, Long> emprestimos;

    public emprestimorepositorio() {
        this.emprestimos = new repositorio<>();
    }
    public void listarTodos(){
        emprestimos.buscarTodos().forEach(e -> System.out.println("ID: " + e.getId() + ", Livro: " + e.getLivro().getTitulo() + ", Usuario: " + e.getUsuario().getNome() + ", Data Emprestimo: " + e.getDatainicioEmprestimo() + ", Data Devolucao: " + e.getDatadevolucao()));
    }
    public emprestimo buscarPorId(Long id){
        return emprestimos.buscarporID(id).orElse(null);
    }
    public void salvar(emprestimo emprestimo) throws JacadastradoException{
        emprestimo e1=emprestimos.buscarporID(emprestimo.getId()).orElse(null);
        if(e1!=null){
            throw new JacadastradoException("Esse emprestimo");
        }
        emprestimos.salvar(emprestimo);
    }
    public void deletar(Long id) throws naocadastradoException{
        if(emprestimos.buscarporID(id)==null){
            throw new naocadastradoException("Esse emprestimo ");
        }
        emprestimos.deletar(id);
    }
    public List<emprestimo> buscarTodos(){
        return emprestimos.buscarTodos();
    }
    public boolean emprestimovenceu(emprestimo emprestimo, LocalDate data_atual) throws naocadastradoException{
        if(emprestimos.buscarporID(emprestimo.getId())==null){
            throw new naocadastradoException("Esse emprestimo ");
        }
        if(data_atual.isAfter(emprestimo.getDatadevolucao())){
            return true;
        }
        return false;
    }
    public void aplicamulta(emprestimo emprestimo) throws naocadastradoException{
        if(emprestimos.buscarporID(emprestimo.getId())==null){
            throw new naocadastradoException("Esse emprestimo ");
        }
        emprestimo.getUsuario().setMultado(emprestimo.getMulta());
    }

}
