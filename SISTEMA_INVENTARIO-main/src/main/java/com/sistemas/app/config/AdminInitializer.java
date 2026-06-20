package com.sistemas.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (usuarioRepository.findByUsername("admin").isEmpty()) {

            Usuario admin = Usuario.builder()
                    .nombre("Administrador")
                    .apellido("Sistema")
                    .email("vchirinos@gmail.com")
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .rol("ADMIN")
                    .build();

            usuarioRepository.save(admin);

            System.out.println("=================================");
            System.out.println("Usuario administrador creado");
            System.out.println("Usuario: admin");
            System.out.println("Password: admin123");
            System.out.println("=================================");
        }
    }
}