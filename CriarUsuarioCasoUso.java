public class CriarUsuarioCasoUso
{
    private Repositorio<UsuarioGenerico> repositorio;
    
    public CriarUsuarioCasoUso(Repositorio r)
    {
        repositorio = r;
    }
    
    public void executar(String nome) throws Exception 
    {
        validarNome(nome);
        UsuarioGenerico u = new UsuarioGenerico();
        u.setNome(nome);
        repositorio.criar(u);
    }
    
    protected void validarNome(String nome) throws Exception
    {
        if (nome.equals("Erro")) {
            throw new Exception("Nome inválido!");
        }
    }
}
