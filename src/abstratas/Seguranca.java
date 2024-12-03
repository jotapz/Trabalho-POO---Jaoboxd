package abstratas;

public interface Seguranca {
    boolean registrar(String nome, String senha);
    boolean login(String nome, String senha);
}
