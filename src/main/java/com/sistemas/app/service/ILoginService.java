package com.sistemas.app.service;

import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;

public interface ILoginService {
    UsuarioResponseDTO createUser(UsuarioRequestDTO usuario);
}