package com.campus.modules.actores.domain;

public class Actor {
  private int id;
  private String nombre;
  private int edad;
  private int idGenero;
  private int idNacionalidad;

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
    return "Nombre: " + nombre + ", Edad: " + edad + ", Genero: " + idGenero + ", Pais: " + idNacionalidad;
  }

}
