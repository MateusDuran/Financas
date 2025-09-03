package com.financas.domains.enums;

public enum TipoConta {

    CONTACORRENTE(0, "CONTACORRENTE"), CONTAINVESTIMENTO(1, "CONTAINVESTIMENTO"),CARTAODECREDITO(2, "CARTAODECREDITO"),
    ALIMENTACAO (3, "ALIMENTACAO"), POUPANCA(4, "POUPANCA");

    private Integer id;
    private String situacao;

    TipoConta() {
    }

    TipoConta(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static TipoConta toEnum(Integer id) {
        if (id == null) return null;
        for (TipoConta x : TipoConta.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Conta inválida");
    }
}
