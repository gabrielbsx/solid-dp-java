import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class UsuarioRepositorioMemoriaImpl extends RepositorioMemoria<Usuario>
{
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public UsuarioRepositorioMemoriaImpl()
    {
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
}
