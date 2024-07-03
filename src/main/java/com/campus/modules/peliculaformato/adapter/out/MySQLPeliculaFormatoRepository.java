package com.campus.modules.peliculaformato.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculaformato.infraestructure.PeliculaFormatoRepository;

public class MySQLPeliculaFormatoRepository implements PeliculaFormatoRepository {

  private String url;
  private String user;
  private String password;

  public MySQLPeliculaFormatoRepository(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  @Override
  public PeliculaFormato save(PeliculaFormato peliculaFormato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "INSERT INTO peliculaformato (idPelicula, idFormato, cantidad) VALUES (?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, peliculaFormato.getIdPelicula());
      statement.setInt(2, peliculaFormato.getIdFormato());
      statement.setInt(3, peliculaFormato.getCantidad());
      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return peliculaFormato;
  }

  @Override
  public PeliculaFormato update(PeliculaFormato peliculaFormato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "UPDATE peliculaformato SET cantidad = ? WHERE idPelicula = ? AND idFormato = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, peliculaFormato.getCantidad());
      statement.setInt(2, peliculaFormato.getIdPelicula());
      statement.setInt(3, peliculaFormato.getIdFormato());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return peliculaFormato;
  }

  @Override
  public void delete(int idPelicula, int idFormato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "DELETE FROM peliculaformato WHERE idPelicula = ? AND idFormato = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, idPelicula);
      statement.setInt(2, idFormato);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public PeliculaFormato findById(int idPelicula) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM peliculaformato WHERE idPelicula = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, idPelicula);
      statement.executeQuery();
      try (ResultSet resultSet = statement.getResultSet()) {
        if (resultSet.next()) {
          return new PeliculaFormato(resultSet.getInt("idPelicula"), resultSet.getInt("idFormato"),
              resultSet.getInt("cantidad"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<PeliculaFormato> findAll() {
    List<PeliculaFormato> peliculaFormatos = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM peliculaformato";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeQuery();
      try (ResultSet resultSet = statement.getResultSet()) {
        while (resultSet.next()) {
          peliculaFormatos.add(new PeliculaFormato(resultSet.getInt("idPelicula"), resultSet.getInt("idFormato"),
              resultSet.getInt("cantidad")));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return peliculaFormatos;
  }

  @Override
  public PeliculaFormato findById(int idPelicula, int idFormato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM peliculaformato WHERE idPelicula = ? AND idFormato = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, idPelicula);
      statement.setInt(2, idFormato);
      statement.executeQuery();
      try (ResultSet resultSet = statement.getResultSet()) {
        if (resultSet.next()) {
          return new PeliculaFormato(resultSet.getInt("idPelicula"), resultSet.getInt("idFormato"),
              resultSet.getInt("cantidad"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
