package com.financas.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name="usuario")
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private int idUsuario;

    @NotBlank(message = "O campo Razão Social não pode ser nulo")
    @NotNull(message = "O campo Razão Social não pode estar vazio")
    private String razaoSocial;


    public Usuario() {
    }

    public Usuario(int idUsuario, String razaoSocial) {
        this.idUsuario = idUsuario;
        this.razaoSocial = razaoSocial;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && Objects.equals(razaoSocial, usuario.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, razaoSocial);
    }
}
