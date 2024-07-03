package com.campus.modules.tipoactor.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campus.modules.tipoactor.domain.Tipoactor;
import com.campus.modules.tipoactor.infrastructure.TipoActorRepository;

public class TipoActorMySQLRepository implements TipoActorRepository { 
    
    private final String url;
    private final String user;
    private final String password;

    public TipoActorMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Tipoactor tipoactor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO tipoactor (descripcion) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tipoactor.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM tipoactor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tipoactor tipoactor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE tipoactor SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tipoactor.getDescripcion());
                statement.setInt(2, tipoactor.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Tipoactor> findById(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM tipoactor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Tipoactor tipoactor = new Tipoactor(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(tipoactor);
                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return Optional.empty();
    }

    @Override
    public List<Tipoactor> findAll() {
        List<Tipoactor> tipoactors = new ArrayList<Tipoactor>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM tipoactor";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Tipoactor tipoactor = new Tipoactor(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        tipoactors.add(tipoactor);
                    }
                    return tipoactors;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
}
