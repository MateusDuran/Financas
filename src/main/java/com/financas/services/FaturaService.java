package com.financas.services;

import com.financas.repositories.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepo;
}
