package biblioteca.com.Interfaces;

import java.util.List;
import java.util.Optional;

public interface crudrepositorio<T, ID> {
    T salvar(T entity);
    Optional<T> buscarporID(ID id);
    List<T> buscarTodos();
    void deletar(ID id);
    void listarTodos();
    
} 

