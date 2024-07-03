package com.campus.modules.peliculaProtagonista.application;

import java.util.List;
import java.util.Optional;

import com.campus.modules.peliculaProtagonista.adapter.out.PeliculaProtagonistaMySQLRepository;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;



public class PeliculaProtagonistaService {
    PeliculaProtagonistaMySQLRepository peliculaprotagonistaMySQLRepository;

    public PeliculaProtagonistaService(PeliculaProtagonistaMySQLRepository peliculaprotagonistaMySQLRepository) {
        this.peliculaprotagonistaMySQLRepository = peliculaprotagonistaMySQLRepository;
    }

    public void savePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista){
        peliculaprotagonistaMySQLRepository.save(peliculaprotagonista);
    }

    public void deletePeliculaprotagonista(int idPelicula, int idProtagonista){
        peliculaprotagonistaMySQLRepository.delete(idPelicula, idProtagonista);
    }

    public void updatePeliculaprotagonista(PeliculaProtagonista peliculaprotagonista){
        peliculaprotagonistaMySQLRepository.update(peliculaprotagonista);
    }
    
    public Optional<PeliculaProtagonista> findByIdPeliculaprotagonista(int idPelicula, int idProtagonista){
        return peliculaprotagonistaMySQLRepository.findById(idPelicula, idProtagonista);
    }

    public List<PeliculaProtagonista> findAllPeliculaprotagonista(){
        return peliculaprotagonistaMySQLRepository.findAll();
    }
}
