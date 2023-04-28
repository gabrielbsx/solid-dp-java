import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.Optional;

public class UsuarioRepositorioMemoria extends RepositorioMemoria<Usuario>
{
    protected static ArrayList<Usuario> usuarios;
    
    public UsuarioRepositorioMemoria()
    {
        super();
    }
    
    public Optional<Usuario> procurarPeloNome(String nome)
    {
        return listar()
            .stream()
            .filter(u -> u.getNome().equals(nome))
            .findFirst();
    }
}
