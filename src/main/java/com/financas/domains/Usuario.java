package com.financas.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "idPessoa") // usa a PK herdada de Pessoa
public class Usuario extends Pessoa {

    @NotNull(message = "O campo Razão Social não pode ser nulo")
    @NotBlank(message = "O campo Razão Social não pode estar vazio")
    private String razaoSocial;

    public Usuario() {
    }

    // Construtor completo herdando campos de Pessoa
    public Usuario(int idPessoa, String nome, String email, String senha,
                   java.time.LocalDate criadoEm,
                   String razaoSocial) {
        super(idPessoa, nome, email, senha, criadoEm);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    /**
     * Compatibilidade com seu UsuarioDTO atual (que usa idUsuario).
     * Não é persistido; apenas delega para o id da Pessoa.
     */
    @Transient
    public int getIdUsuario() {
        return getIdPessoa();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        // igualdade pela PK herdada
        return getIdPessoa() == usuario.getIdPessoa();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPessoa());
    }
}
