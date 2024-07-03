package com.campus.modules.paises.application;

import java.util.List;
import java.util.Optional;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.paises.adapter.out.PaisMySQLRepository;
import com.campus.modules.paises.domain.Pais;
import com.campus.modules.paises.infrastructure.PaisRepository;

public class PaisService {
    PaisRepository paisRepository;

    private String url = ConfiguracionProyecto.URL();
    private String user = ConfiguracionProyecto.USER();
    private String password = ConfiguracionProyecto.PASSWORD();

    public PaisService(PaisMySQLRepository paisMySQLRepository) {
        this.paisRepository = paisMySQLRepository;
    }

    public PaisService() {
        this.paisRepository = new PaisMySQLRepository(url, user, password);
    }

    public void savePais(Pais pais) {
        paisRepository.save(pais);
    }

    public void deletePais(int id) {
        paisRepository.delete(id);
    }

    public void updatePais(Pais pais) {
        paisRepository.update(pais);
    }

    public Optional<Pais> findByIdPais(int id) {
        return paisRepository.findById(id);
    }

    public List<Pais> findAllPais() {
        return paisRepository.findAll();
    }

}
