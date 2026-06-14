package com.sistemas.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
import com.sistemas.app.mapper.Mapper;
import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;

@Service
public class LoginService implements ILoginService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioResponseDTO createUser(UsuarioRequestDTO usuarioDTO) {

        if (usuarioRepo.findByUsername(usuarioDTO.getUsername()).isPresent()) {
            throw new RuntimeException(
                    "El username ya existe");
        }

        Usuario newUser = Mapper.toUsuarioEntity(usuarioDTO);

        newUser.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        Usuario usuarioSaved = usuarioRepo.save(newUser);

        return Mapper.toUsuarioResponseDTO(usuarioSaved);
    }
}