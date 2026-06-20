package com.sistemas.app.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepo
                .findByUsername(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException(
                        "Usuario no encontrado"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }
}