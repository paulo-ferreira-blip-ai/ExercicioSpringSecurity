package com.api.loginusuario.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuariosLogin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column()
    private String nome;
    @Column()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // anotação para não retornar a senha do usuario
    private String idade;
    @Column()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // anotação para não retornar a senha do usuario
    private String telefone;
    @Column(unique = true)
    private String login;
    @Column()
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // anotação para não retornar a senha do usuario
    private String senha;
}
