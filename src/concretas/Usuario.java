package concretas;

import abstratas.Pessoa;

public class Usuario extends Pessoa {
    protected String senha;

    public Usuario(String nome, String senha){
        super(nome);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void exibifirInfo(){
        System.out.println("Usuario: " +getNome() + "Senha: " + getSenha());
    }
}
