package com.campus.modules.formatos.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.campus.modules.formatos.domain.Formato;
import com.campus.modules.formatos.infraestructure.FormatoRepository;

public class FormatoMySQLRepository implements FormatoRepository {

  private final String url;
  private final String user;
  private final String password;

  public FormatoMySQLRepository(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  @Override
  public Formato save(Formato formato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "INSERT INTO formatos (descripcion) VALUES (?)";
      PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, formato.getDescripcion());
      statement.executeUpdate();
      ResultSet resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        formato.setId(resultSet.getInt(1));
      }
      return formato;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(Formato formato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "DELETE FROM formatos WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, formato.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Formato update(Formato formato) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "UPDATE formatos SET descripcion = ? WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, formato.getDescripcion());
      statement.setInt(2, formato.getId());
      statement.executeUpdate();
      return formato;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
