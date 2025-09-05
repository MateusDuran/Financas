package com.financas.domains;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="centrocusto")
public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_centrocusto")
    private int idCentroCusto;
    private String descricao;

    public CentroCusto() {
    }

    public CentroCusto(int idCentroCusto, String descricao) {
        this.idCentroCusto = idCentroCusto;
        this.descricao = descricao;
    }

    public int getIdCentroCusto() {
        return idCentroCusto;
    }

    public void setIdCentroCusto(int idCentroCusto) {
        this.idCentroCusto = idCentroCusto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CentroCusto that = (CentroCusto) o;
        return idCentroCusto == that.idCentroCusto && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCentroCusto, descricao);
    }
}
