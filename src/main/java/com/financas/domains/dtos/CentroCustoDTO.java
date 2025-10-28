package com.financas.domains.dtos;

import com.financas.domains.CentroCusto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CentroCustoDTO {

    private int idCentroCusto;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    public CentroCustoDTO() {}

    public CentroCustoDTO(CentroCusto cc) {
        this.idCentroCusto = cc.getIdCentroCusto();
        this.descricao = cc.getDescricao();
    }

    public int getIdCentroCusto() { return idCentroCusto; }
    public void setIdCentroCusto(int idCentroCusto) { this.idCentroCusto = idCentroCusto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentroCustoDTO that)) return false;
        return idCentroCusto == that.idCentroCusto && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() { return Objects.hash(idCentroCusto, descricao); }
}
