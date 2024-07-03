package com.campus.modules.peliculas.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
  public Pelicula save(Pelicula pelicula) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "INSERT INTO peliculas (codInterno, nombre, duracion,sinopsis) VALUES (?, ?, ?, ?)";
      try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        statement.setInt(1, pelicula.getCodInterno());
        statement.setString(2, pelicula.getNombre());
        statement.setString(3, pelicula.getDuracion());
        statement.setString(4, pelicula.getSinopsis());
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
      String query = "DELETE FROM peliculas WHERE id = ?";
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

}
