package com.api.loginusuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequest {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String idade;
    @NotEmpty
    private String telefone;
    @Column(unique = true)
    @NotEmpty
    private String login;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // anotação para não retornar a senha do usuario
    @NotEmpty
    private String senha;
}
