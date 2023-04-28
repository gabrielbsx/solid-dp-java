public class CriarUsuarioCasoUso
{
    private Repositorio<UsuarioGenerico> repositorio;
    
    public CriarUsuarioCasoUso(Repositorio r)
    {
        repositorio = r;
    }
    
    public void executar(String nome)
    {
        validarNome(nome);
        UsuarioGenerico u = new UsuarioGenerico();
        u.setNome(nome);
        repositorio.criar(u);
    }
    
    protected void validarNome(String nome) throws Error
    {
        if (nome.equals("Jovem")) {
            throw new Error("Nome inválido!");
        }
    }
}
