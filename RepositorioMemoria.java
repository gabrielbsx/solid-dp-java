import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public abstract class RepositorioMemoria<T> implements Repositorio<T>
{
    protected final Map<String, T> dados = new HashMap<>();

    public RepositorioMemoria()
    {
    }

    public void criar(T dado) {
        String id = UUID.randomUUID().toString();
        dados.put(id, dado);
    }
    
    public void atualizar(String id, T dado) {
        if (!dados.containsKey(id)) {
            throw new IllegalArgumentException("Objeto não encotrado");
        }
        dados.put(id, dado);
    }
    
    public void remove(String id) {
        dados.remove(id);
    }
    
    public Optional<T> buscar(String id) {
        T dado = dados.get(id);
        return Optional.ofNullable(dado);
    }
    
    public List<T> listar() {
        return new ArrayList<>(dados.values());
    }
}
