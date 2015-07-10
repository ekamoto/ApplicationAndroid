package br.com.hisamoto.aplicacaoLeandro.classes;

/**
 * @author Leandro Shindi
 * @version 1.0 29/06/15.
 */
public class Usuario {

    private Long id;
    private String nome;
    private String email;

    public Usuario(String email, String nome, Long id) {
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
    }

    public Usuario() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
