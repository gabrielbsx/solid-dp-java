public interface Repositorio<T>
{
    public void criar(T data);
    public void atualizar(String id, T data);
}
