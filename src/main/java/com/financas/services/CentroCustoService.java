package com.financas.services;

import com.financas.repositories.CentroCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroCustoService {

    @Autowired
    private CentroCustoRepository centroCustoRepo;
}
