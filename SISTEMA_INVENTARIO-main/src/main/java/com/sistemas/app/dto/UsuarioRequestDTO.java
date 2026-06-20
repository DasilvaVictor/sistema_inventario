package com.sistemas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private String rol;
}
