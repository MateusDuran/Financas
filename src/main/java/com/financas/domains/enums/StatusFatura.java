package com.financas.domains.enums;

public enum StatusFatura {

    ABERTO(0, "ABERTO"), FECHADO(1, "FECHADO"), ATRASADO(2, "ATRASADO"), PAGO(3, "PAGO");

    private Integer id;
    private String situacao;

    StatusFatura() {
    }

    StatusFatura(Integer id, String situacao) {
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

    public static StatusFatura toEnum(Integer id) {
        if (id == null) return null;
        for (StatusFatura x : StatusFatura.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status Fatura inválida");
    }
}
