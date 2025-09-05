package com.financas.domains.dtos;

import com.financas.domains.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    private int idUsuario;

    @NotBlank(message = "O campo Razão Social não pode ser nulo")
    @NotNull(message = "O campo Razão Social não pode estar vazio")
    private String razaoSocial;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.razaoSocial = usuario.getRazaoSocial();
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
}
