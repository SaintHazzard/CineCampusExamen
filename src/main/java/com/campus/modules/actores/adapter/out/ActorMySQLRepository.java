package com.campus.modules.actores.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.campus.modules.actores.domain.Actor;
import com.campus.modules.actores.infraestructure.ActorRepository;

public class ActorMySQLRepository implements ActorRepository {

  protected final String url;
  protected final String user;
  protected final String password;

  public ActorMySQLRepository(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  @Override
  public Actor save(Actor actor) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "INSERT INTO actores (nombre, edad, idGenero,idNacionalidad) VALUES (?, ?, ?, ?)";
      try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, actor.getNombre());
        statement.setInt(2, actor.getEdad());
        statement.setInt(3, actor.getIdGenero());
        statement.setInt(4, actor.getIdNacionalidad());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actor;
  }

  @Override
  public void delete(Actor actor) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "DELETE FROM actores WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, actor.getId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Actor update(Actor actor) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "UPDATE actores SET nombre = ?, edad = ?, idGenero = ?, idNacionalidad = ? WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, actor.getNombre());
        statement.setInt(2, actor.getEdad());
        statement.setInt(3, actor.getIdGenero());
        statement.setInt(4, actor.getIdNacionalidad());
        statement.setInt(5, actor.getId());
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actor;
  }
}
