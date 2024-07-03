package com.campus.modules.generos.application;

import java.util.List;
import java.util.Optional;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.generos.adapter.out.GeneroMySQLRepository;
import com.campus.modules.generos.domain.Genero;
import com.campus.modules.generos.infrastructure.GeneroRepository;

public class GeneroService {
    GeneroRepository generoRepository;

    private String url = ConfiguracionProyecto.URL();
    private String user = ConfiguracionProyecto.USER();
    private String password = ConfiguracionProyecto.PASSWORD();

    public GeneroService(GeneroMySQLRepository generoMySQLRepository) {
        this.generoRepository = generoMySQLRepository;
    }

    public GeneroService() {
        this.generoRepository = new GeneroMySQLRepository(url, user, password);
    }

    public void saveGenero(Genero genero) {
        generoRepository.save(genero);
    }

    public void deleteGenero(int id) {
        generoRepository.delete(id);
    }

    public void updateGenero(Genero genero) {
        generoRepository.update(genero);
    }

    public Optional<Genero> findByIdGenero(int id) {
        return generoRepository.findById(id);
    }

    public List<Genero> findAllGenero() {
        return generoRepository.findAll();
    }
}
