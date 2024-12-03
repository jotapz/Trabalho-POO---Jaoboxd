package concretas;

import abstratas.BancoUsuario;

import java.util.ArrayList;
import java.util.List;

public class BancoUsuarios extends BancoUsuario {

    protected List<Usuario> criarListaUsuarios(){
        return new ArrayList<>();
    }
}
