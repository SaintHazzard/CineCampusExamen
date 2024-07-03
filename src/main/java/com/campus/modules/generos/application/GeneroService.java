package com.campus.modules.generos.application;

import java.util.List;
import java.util.Optional;

import com.campus.modules.generos.adapter.out.GeneroMySQLRepository;
import com.campus.modules.generos.domain.Genero;

public class GeneroService {
    GeneroMySQLRepository generoMySQLRepository;

    public GeneroService(GeneroMySQLRepository generoMySQLRepository) {
        this.generoMySQLRepository = generoMySQLRepository;
    }

    public void saveGenero(Genero genero){
        generoMySQLRepository.save(genero);
    }

    public void deleteGenero(int id){
        generoMySQLRepository.delete(id);
    }

    public void updateGenero(Genero genero){
        generoMySQLRepository.update(genero);
    }
    
    public Optional<Genero> findByIdGenero(int id){
        return generoMySQLRepository.findById(id);
    }

    public List<Genero> findAllGenero(){
        return generoMySQLRepository.findAll();
    }
}
