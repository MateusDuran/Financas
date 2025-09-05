package com.financas.services;

import com.financas.domains.Pessoa;
import com.financas.domains.dtos.PessoaDTO;
import com.financas.repositories.PessoaRepository;
import com.financas.services.exceptions.DataIntegrityViolationException;
import com.financas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    public List<PessoaDTO> findAll(){
        return pessoaRepo.findAll().stream()
                .map(obj -> new PessoaDTO(obj))
                .collect(Collectors.toList());
    }

    public Pessoa findbyId(int idPessoa){
        Optional<Pessoa> obj = pessoaRepo.findByIdUsuario(idPessoa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado! ID: "+ idPessoa));
    }

    public Pessoa findbyDocumentoPessoal(String documentoPessoal){
        Optional<Pessoa> obj = pessoaRepo.findByDocumentoPessoal(documentoPessoal);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado! Documento Pessoal: "+documentoPessoal));
    }

    public Pessoa create(PessoaDTO dto){
        dto.setIdPessoa(null);
        validaPessoa(dto);
        Pessoa obj = new Pessoa(dto);
        return pessoaRepo.save(obj);
    }

    private void validaPessoa(PessoaDTO dto){
        Optional<Pessoa> obj = pessoaRepo.findByDocumentoPessoal(dto.getDocumentoPessoal());
        if(obj.isPresent() && obj.get().getIdPessoa() != dto.getIdPessoa()){
            throw new DataIntegrityViolationException("Pessoa já Cadastrado!");
        }
    }

    public Pessoa update(int idPessoa, PessoaDTO objDto){
        objDto.setIdPessoa(idPessoa);
        Pessoa oldObj = findbyIdPessoa(idPessoa);
        validaPessoa(objDto);
        oldObj = new Pessoa(objDto);
        return pessoaRepo.save(oldObj);
    }

    public void delete(int idPessoa) {
        Pessoa obj = findbyIdPessoa(idPessoa);
    }
}
