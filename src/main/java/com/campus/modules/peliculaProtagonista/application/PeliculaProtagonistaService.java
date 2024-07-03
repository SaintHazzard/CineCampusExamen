package com.campus.modules.peliculaProtagonista.application;

import java.util.List;
import java.util.Optional;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.peliculaProtagonista.adapter.out.PeliculaProtagonistaMySQLRepository;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;
import com.campus.modules.peliculaProtagonista.infrastructure.PeliculaProtagonistaRepository;

public class PeliculaProtagonistaService {
    PeliculaProtagonistaRepository peliculaprotagonistaRepository;

    private String url = ConfiguracionProyecto.URL();
    private String user = ConfiguracionProyecto.USER();
    private String password = ConfiguracionProyecto.PASSWORD();

    public PeliculaProtagonistaService() {
        this.peliculaprotagonistaRepository = new PeliculaProtagonistaMySQLRepository(url, user, password);
    }

    public PeliculaProtagonistaService(PeliculaProtagonistaRepository peliculaprotagonistaRepository) {
        this.peliculaprotagonistaRepository = peliculaprotagonistaRepository;
    }

    public void savePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista) {
        peliculaprotagonistaRepository.save(peliculaprotagonista);
    }

    public void deletePeliculaprotagonista(int idPelicula, int idProtagonista) {
        peliculaprotagonistaRepository.delete(idPelicula, idProtagonista);
    }

    public void updatePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista) {
        peliculaprotagonistaRepository.update(peliculaprotagonista);
    }

    public Optional<PeliculaProtagonista> findByIdPeliculaprotagonista(int idPelicula, int idProtagonista) {
        return peliculaprotagonistaRepository.findById(idPelicula, idProtagonista);
    }

    public List<PeliculaProtagonista> findAllPeliculaprotagonista() {
        return peliculaprotagonistaRepository.findAll();
    }

    public PeliculaProtagonista getPeliculaProtagonistaById(int idPelicula, int idProtagonista) {
        return peliculaprotagonistaRepository.findById(idPelicula, idProtagonista).orElse(null);
    }
}
