package com.campus.modules.actores.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
          actor.setId(resultSet.getInt(1));
        }
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

  @Override
  public Actor findById(int id) {
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM actores WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
          Actor actor = new Actor();
          actor.setId(resultSet.getInt("id"));
          actor.setNombre(resultSet.getString("nombre"));
          actor.setEdad(resultSet.getInt("edad"));
          actor.setIdGenero(resultSet.getInt("idGenero"));
          actor.setIdNacionalidad(resultSet.getInt("idNacionalidad"));
          return actor;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Actor> findAll() {
    List<Actor> actores = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM actores";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
          Actor actor = new Actor();
          actor.setId(resultSet.getInt("id"));
          actor.setNombre(resultSet.getString("nombre"));
          actor.setEdad(resultSet.getInt("edad"));
          actor.setIdGenero(resultSet.getInt("idGenero"));
          actor.setIdNacionalidad(resultSet.getInt("idNacionalidad"));
          actores.add(actor);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
