import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.Optional;

public class UsuarioRepositorioMemoriaImpl extends RepositorioMemoria<Usuario>
{
    private static ArrayList<Usuario> usuarios;
    
    public UsuarioRepositorioMemoriaImpl()
    {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
    }
    
    public void criar(Usuario u)
    {
        usuarios.add(u);
    }
    
    public void atualizar(String id, Usuario u)
    {
        OptionalInt index = IntStream
            .range(0, usuarios.size())
            .filter(i -> usuarios.get(i).getId().equals(id))
            .findFirst();
        
        if (index.isEmpty())
        {
            throw new Error("Usuário não encontrado!");
        }
        usuarios.set(index.getAsInt(), u);
    }
    
    public Optional<Usuario> procurarPeloNome(String nome)
    {
        Optional<Usuario> usuario = usuarios
            .stream()
            .filter(u -> u.getNome().equals(nome))
            .findFirst();
        
        return usuario;
    }
}
