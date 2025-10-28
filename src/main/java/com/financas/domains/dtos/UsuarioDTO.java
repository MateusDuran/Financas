package com.financas.domains.dtos;

import com.financas.domains.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class UsuarioDTO {

    private int idUsuario;

    @NotNull(message = "O campo razaoSocial não pode ser nulo")
    @NotBlank(message = "O campo razaoSocial não pode estar vazio")
    private String razaoSocial;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario u) {
        // compatível com o método auxiliar getIdUsuario() na entidade
        this.idUsuario = u.getIdUsuario();
        this.razaoSocial = u.getRazaoSocial();
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

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDTO that)) return false;
        return idUsuario == that.idUsuario &&
                Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, razaoSocial);
    }
}
