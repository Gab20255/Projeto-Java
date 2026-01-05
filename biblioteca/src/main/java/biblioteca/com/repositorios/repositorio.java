package biblioteca.com.repositorios;
import java.util.List;
import java.util.Optional;

import biblioteca.com.Interfaces.crudrepositorio;
import biblioteca.com.Interfaces.indentificar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class repositorio<T extends indentificar<ID>, ID> implements crudrepositorio<T, ID> {
    private final Map<ID, T> armazenamento = new HashMap<>();

    @Override
    public T salvar(T entity) {
        armazenamento.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> buscarporID(ID id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public void deletar(ID id) {
        armazenamento.remove(id);
    }
    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(armazenamento.values());
    }
    @Override
    public void listarTodos(){
        armazenamento.values().forEach(e -> System.out.println(e.toString()));
    }
}