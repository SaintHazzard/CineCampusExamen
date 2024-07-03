package com.campus.modules.peliculas.domain;

public class Pelicula {
  private int id;
  private int codInterno;
  private String nombre;
  private String duracion;
  private String sinopsis;

  public Pelicula(int id, int codInterno, String nombre, String duracion, String sinopsis) {
    this.id = id;
    this.codInterno = codInterno;
    this.nombre = nombre;
    this.duracion = duracion;
    this.sinopsis = sinopsis;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCodInterno() {
    return codInterno;
  }

  public void setCodInterno(int codInterno) {
    this.codInterno = codInterno;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDuracion() {
    return duracion;
  }

  public void setDuracion(String duracion) {
    this.duracion = duracion;
  }

  public String getSinopsis() {
    return sinopsis;
  }

  public void setSinopsis(String sinopsis) {
    this.sinopsis = sinopsis;
  }

}
