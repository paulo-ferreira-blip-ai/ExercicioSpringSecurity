package com.api.loginusuario.service;

import com.api.loginusuario.model.UsuarioModel;
import com.api.loginusuario.model.dto.UsuarioRequest;
import com.api.loginusuario.model.dto.UsuarioResponse;
import com.api.loginusuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {
        UsuarioModel usuarioModel = new UsuarioModel(null, usuarioRequest.getNome()
                , usuarioRequest.getIdade()
                , usuarioRequest.getTelefone()
                , usuarioRequest.getLogin()
                , usuarioRequest.getSenha());
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));

        usuarioRepository.save(usuarioModel);

        UsuarioResponse usuarioResponse = new UsuarioResponse(usuarioModel.getNome(),
                usuarioModel.getLogin(),
                usuarioModel.getSenha());
        return usuarioResponse;
    }

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarId(Long id) {
        return Optional.ofNullable( usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public UsuarioModel alterar(Long id, UsuarioRequest usuarioRequest)  {
        usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));

        UsuarioModel usuarioModel = new UsuarioModel(null, usuarioRequest.getNome()
                , usuarioRequest.getIdade()
                , usuarioRequest.getTelefone()
                , usuarioRequest.getLogin()
                , usuarioRequest.getSenha());
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));

        return usuarioModel;

    }
}
