package com.sistemas.app.service;

import org.springframework.stereotype.Service;

import com.sistemas.app.model.Categoria;
import com.sistemas.app.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepo;

    @Override
    public Categoria createCategoria(Categoria newCategoria) {
        Categoria categoriaSaved = categoriaRepo.save(newCategoria);
        return categoriaSaved;
    }

}
