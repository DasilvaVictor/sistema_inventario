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
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String username;
    private String rol;
}