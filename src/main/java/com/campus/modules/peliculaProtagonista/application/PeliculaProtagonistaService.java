package com.campus.modules.peliculaProtagonista.application;

import java.util.List;
import java.util.Optional;


import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;
import com.campus.modules.peliculaProtagonista.infrastructure.PeliculaProtagonistaRepository;



public class PeliculaProtagonistaService {
    PeliculaProtagonistaRepository peliculaprotagonistaRepository;

    public PeliculaProtagonistaService(PeliculaProtagonistaRepository peliculaprotagonistaRepository) {
        this.peliculaprotagonistaRepository = peliculaprotagonistaRepository;
    }

    public void savePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista){
        peliculaprotagonistaRepository.save(peliculaprotagonista);
    }

    public void deletePeliculaprotagonista(int idPelicula, int idProtagonista){
        peliculaprotagonistaRepository.delete(idPelicula, idProtagonista);
    }

    public void updatePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista){
        peliculaprotagonistaRepository.update(peliculaprotagonista);
    }
    
    public Optional<PeliculaProtagonista> findByIdPeliculaprotagonista(int idPelicula, int idProtagonista){
        return peliculaprotagonistaRepository.findById(idPelicula, idProtagonista);
    }

    public List<PeliculaProtagonista> findAllPeliculaprotagonista(){
        return peliculaprotagonistaRepository.findAll();
    }
}
