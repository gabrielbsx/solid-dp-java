public abstract class RepositorioMemoria<T> implements Repositorio<T>
{
    public RepositorioMemoria()
    {
    }

    public abstract void criar(T data);
    public abstract void atualizar(String id, T data);
}
