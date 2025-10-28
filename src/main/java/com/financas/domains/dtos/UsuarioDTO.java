package com.financas.domains.dtos;

import com.financas.domains.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UsuarioDTO extends PessoaDTO {

    private int idUsuario;

    @NotBlank(message = "O campo razaoSocial não pode estar vazio")
    private String razaoSocial;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario u) {
        super(u); // chama o construtor da PessoaDTO
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

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
