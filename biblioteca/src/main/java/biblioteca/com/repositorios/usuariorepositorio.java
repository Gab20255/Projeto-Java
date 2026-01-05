package biblioteca.com.repositorios;

import biblioteca.com.Classes.usuario;
import biblioteca.com.Excecoes.JacadastradoException;
import biblioteca.com.Excecoes.RepositorioVazio;
import biblioteca.com.Excecoes.naocadastradoException;

import java.util.Comparator;
import java.util.List;
public class usuariorepositorio {
    private repositorio<usuario, Long> usuarios;
    public void listarTodos()  throws RepositorioVazio{
        if(usuarios.buscarTodos()==null){
            throw new RepositorioVazio();
        }
        usuarios.buscarTodos().forEach(u -> System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", Multa: " + u.getMultado() + ", Quantidade Emprestimos: " + u.getQuantidadeemprestimos()));
    }
    public usuariorepositorio() {
        this.usuarios = new repositorio<>();
    }

    public void salvar(usuario usuario) throws JacadastradoException {
        usuario usuario1=usuarios.buscarporID(usuario.getId()).orElse(null);
        if(usuario1!=null){
            throw new JacadastradoException(usuario.getNome());
        }
        usuarios.salvar(usuario);
    }

    public usuario buscarPorId(Long id) throws naocadastradoException {
        usuario usuario_e;
        usuario_e= usuarios.buscarporID(id).orElse(null);
        if(usuario_e== null){
            throw new naocadastradoException(id.toString());
        }
        return usuario_e;
    }

    public void deletar(Long id) throws  naocadastradoException{
        usuario usuario=usuarios.buscarporID(id).orElse(null);
        if(usuario==null){
            throw new naocadastradoException("Livro ");
        }
        usuarios.deletar(id);
    }

    public List<usuario> buscarTodos() {
        return usuarios.buscarTodos();
    }

    public usuario buscarPorNome(String nome) {
        return usuarios.buscarTodos().stream()
                .filter(u -> u.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public usuario usuarioComMaisEmprestimos(){
        return usuarios.buscarTodos().stream().max(Comparator.comparingInt(usuario::getQuantidadeemprestimos)).orElse(null);
    }
}
