package com.financas.domains.enums;

public enum TipoLancamento {

    CREDITO(0, "CREDITO"), DEBITO(1, "DEBITO");

    private Integer id;
    private String situacao;

    TipoLancamento() {
    }

    TipoLancamento(Integer id, String situacao) {
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

    public static TipoLancamento toEnum(Integer id) {
        if (id == null) return null;
        for (TipoLancamento x : TipoLancamento.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Lancamento inválida");
    }
}
