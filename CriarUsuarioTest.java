import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class CriarUsuarioTest
{
    private CriarUsuarioCasoUso criarUsuarioCasoUso;
    private UsuarioRepositorioMemoria usuarioRepositorioMemoria;
    
    public CriarUsuarioTest()
    {
        usuarioRepositorioMemoria = new UsuarioRepositorioMemoria();
        criarUsuarioCasoUso = new CriarUsuarioCasoUso(usuarioRepositorioMemoria);
    }

    @BeforeEach
    public void setUp()
    {
    }

    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void criarUsuario()
    {
        assertDoesNotThrow(() -> {
            String nome = "Jovem Mestre";
            criarUsuarioCasoUso.executar(nome);
            assertTrue(
                usuarioRepositorioMemoria
                    .procurarPeloNome(nome)
                    .isPresent()
            );
        });
    }
    
    @Test
    public void criarUsuarioComErro()
    {
        String nome = "Erro";
        assertThrows(Exception.class, () -> {
            criarUsuarioCasoUso.executar(nome);
        });
    }
}
