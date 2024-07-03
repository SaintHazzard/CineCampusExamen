package com.campus.modules.generos.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campus.modules.generos.domain.Genero;
import com.campus.modules.generos.infrastructure.GeneroRepository;

public class GeneroMySQLRepository implements GeneroRepository{
    private final String url;
    private final String user;
    private final String password;

    public GeneroMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO genero (descripcion) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genero.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM genero WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE genero SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genero.getDescripcion());
                statement.setInt(2, genero.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Genero> findById(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE genero SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Genero genero = new Genero(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(genero);
                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return Optional.empty();
    }

    @Override
    public List<Genero> findAll() {
        List<Genero> generos = new ArrayList<Genero>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM genero";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Genero genero = new Genero(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        generos.add(genero);
                    }
                    return generos;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
