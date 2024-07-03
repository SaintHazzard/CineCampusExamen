package com.campus.modules.actores.domain;

public class Actor {
  private int id;
  private String nombre;
  private int edad;
  private int idGenero;
  private int idNacionalidad;

  public Actor(String nombre2, int edad2, int idGenero, int idNacionalidad) {
    this.nombre = nombre2;
    this.edad = edad2;
    this.idGenero = idGenero;
    this.idNacionalidad = idNacionalidad;
  }

  public Actor(int id, String nombre, int edad, int idGenero, int idNacionalidad) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    this.idGenero = idGenero;
    this.idNacionalidad = idNacionalidad;
  }

  public Actor() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getIdGenero() {
    return idGenero;
  }

  public void setIdGenero(int idGenero) {
    this.idGenero = idGenero;
  }

  public int getIdNacionalidad() {
    return idNacionalidad;
  }

  public void setIdNacionalidad(int idPais) {
    this.idNacionalidad = idPais;
  }

  @Override
  public String toString() {
    return "Id: " + id + " Nombre: " + nombre + ", Edad: " + edad + ", Genero: " + idGenero + ", Pais: "
        + idNacionalidad;
  }

}
