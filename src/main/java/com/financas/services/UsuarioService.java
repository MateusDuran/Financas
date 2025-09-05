package com.financas.services;

import com.financas.domains.Usuario;
import com.financas.domains.dtos.UsuarioDTO;
import com.financas.repositories.*;
import com.financas.services.exceptions.DataIntegrityViolationException;
import com.financas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<UsuarioDTO> findAll(){
        return usuarioRepo.findAll().stream()
                .map(obj -> new UsuarioDTO(obj))
                .collect(Collectors.toList());
    }

    public Usuario findbyId(Long id){
        Optional<Usuario> obj = usuarioRepo.findByIdUsuario(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado! ID: "+ id));
    }

    public Usuario findbyDocumentoPessoal(String documentoPessoal){
        Optional<Usuario> obj = usuarioRepo.findByDocumentoPessoal(documentoPessoal);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado! Documento Pessoal: "+documentoPessoal));
    }

    public Usuario create(UsuarioDTO dto){
        dto.setIdUsuario(null);
        validaUsuario(dto);
        Usuario obj = new Usuario(dto);
        return usuarioRepo.save(obj);
    }

    private void validaUsuario(UsuarioDTO dto){
        Optional<Usuario> obj = usuarioRepo.findByDocumentoPessoal(dto.getDocumentoPessoal());
        if(obj.isPresent() && obj.get().getIdUsuario() != dto.getIdUsuario()){
            throw new DataIntegrityViolationException("Documento Pessoal já Cadastrado!");
        }
    }

    public Usuario update(int idUsuario, UsuarioDTO objDto){
        objDto.setIdUsuario(idUsuario);
        Usuario oldObj = findbyIdUsuario(idUsuario);
        validaUsuario(objDto);
        oldObj = new Usuario(objDto);
        return usuarioRepo.save(oldObj);
    }

    public void delete(int idUsuario) {
        Usuario obj = findbyIdUsuario(idUsuario);
    }
}
