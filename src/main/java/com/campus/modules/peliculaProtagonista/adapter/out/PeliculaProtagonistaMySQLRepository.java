package com.campus.modules.peliculaProtagonista.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campus.modules.paises.domain.Pais;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;
import com.campus.modules.peliculaProtagonista.infrastructure.PeliculaProtagonistaRepository;

public class PeliculaProtagonistaMySQLRepository implements PeliculaProtagonistaRepository {

    private final String url;
    private final String user;
    private final String password;

    public PeliculaProtagonistaMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override 
    public void save(PeliculaProtagonista peliculaProtagonista) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO peliculaprotagonista (idPelicula, idProtagonista, idTipoActor) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, peliculaProtagonista.getIdPelicula());
                statement.setInt(2, peliculaProtagonista.getIdProtagonista());
                statement.setInt(3, peliculaProtagonista.getIdTipoActor());
                statement.executeUpdate();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int idPelicula, int idProtagonista) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM peliculaprotagonista WHERE idPelicula = ? AND idProtagonista = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, idPelicula);
                statement.setInt(2, idProtagonista);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PeliculaProtagonista peliculaProtagonista) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE peliculaprotagonista SET idPelicula =?, idProtagonista =?, idTipoActor =? WHERE idPelicula = ? AND idProtagonista = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, peliculaProtagonista.getIdPelicula());
                statement.setInt(2, peliculaProtagonista.getIdProtagonista());
                statement.setInt(3, peliculaProtagonista.getIdTipoActor());
                statement.setInt(4, peliculaProtagonista.getIdPelicula());
                statement.setInt(5, peliculaProtagonista.getIdProtagonista());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PeliculaProtagonista> findById(int idPelicula, int idProtagonista) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM peliculaprotagonista WHERE idPelicula = ? AND idProtagonista = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, idPelicula);
                statement.setInt(2, idProtagonista);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        PeliculaProtagonista peliculaProtagonista = new PeliculaProtagonista(
                            resultSet.getInt("idPelicula"),
                            resultSet.getInt("idProtagonista"),
                            resultSet.getInt("idTipoActor")
                        );
                        return Optional.of(peliculaProtagonista);
                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return Optional.empty(); 
    }

    @Override
    public List<PeliculaProtagonista> findAll(){
        List<PeliculaProtagonista> peliculasProtagonistas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM peliculaprotagonista";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        PeliculaProtagonista peliculaProtagonista = new PeliculaProtagonista(
                            resultSet.getInt("idPelicula"),
                            resultSet.getInt("idProtagonista"),
                            resultSet.getInt("idTipoActor")
                        );
                        peliculasProtagonistas.add(peliculaProtagonista);
                    }
                    return peliculasProtagonistas;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
        
    }



    

    
}
