package com.campus.modules.peliculas.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.campus.modules.peliculas.domain.Pelicula;
import com.campus.modules.peliculas.infrastructure.PeliculaRepository;

public class PeliculaMySQLRepository implements PeliculaRepository {

  private final String url;
  private final String user;
  private final String password;

  public PeliculaMySQLRepository(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  @Override
  public Pelicula findById(int id) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM peliculas WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);
        statement.executeQuery();
        try (ResultSet resultSet = statement.getResultSet()) {
          if (resultSet.next()) {
            return new Pelicula(resultSet.getInt("id"), resultSet.getInt("codInterno"), resultSet.getString("nombre"),
                resultSet.getString("duracion"), resultSet.getString("sinopsis"));
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Pelicula save(Pelicula pelicula) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "INSERT INTO pelicula (codInterno, nombre, duracion,sinopsis) VALUES (?, ?, ?, ?)";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, pelicula.getCodInterno());
        statement.setString(2, pelicula.getNombre());
        statement.setString(3, pelicula.getDuracion());
        statement.setString(4, pelicula.getSinopsis());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return pelicula;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void delete(Pelicula pelicula) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "DELETE FROM pelicula WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, pelicula.getId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Pelicula update(Pelicula pelicula) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "UPDATE pelicula SET codInterno = ?, nombre = ?, duracion = ?, sinopsis = ? WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, pelicula.getCodInterno());
        statement.setString(2, pelicula.getNombre());
        statement.setString(3, pelicula.getDuracion());
        statement.setString(4, pelicula.getSinopsis());
        statement.setInt(5, pelicula.getId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pelicula;
  }

  @Override
  public List<Pelicula> findAll() {
    List<Pelicula> peliculas = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM pelicula";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.executeQuery();
        try (ResultSet resultSet = statement.getResultSet()) {
          while (resultSet.next()) {
            Pelicula pelicula = new Pelicula(resultSet.getInt("id"), resultSet.getInt("codInterno"),
                resultSet.getString("nombre"), resultSet.getString("duracion"), resultSet.getString("sinopsis"));
            peliculas.add(pelicula);
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

}
