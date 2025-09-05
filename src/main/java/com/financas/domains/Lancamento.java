package com.financas.domains;

import jakarta.persistence.*;

@Entity
@Table(name="lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
    private int idLancamento;
}
