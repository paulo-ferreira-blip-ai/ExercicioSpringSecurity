package com.api.loginusuario.controller;

import com.api.loginusuario.model.UsuarioModel;
import com.api.loginusuario.model.dto.UsuarioRequest;
import com.api.loginusuario.model.dto.UsuarioResponse;
import com.api.loginusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
@Validated
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity< List<UsuarioModel>> buscarTodos(){
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok().body(usuarioService.cadastrar(usuarioRequest));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarId(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.buscarId(id));

    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterar(@Valid @PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok().body(usuarioService.alterar(id, usuarioRequest));
    }


}
