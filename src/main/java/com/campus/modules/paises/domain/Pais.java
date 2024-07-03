package com.campus.modules.paises.domain;

public class Pais {

  private int id;
  private String descripcion;

  public Pais(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  public Pais(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Pais id: " + id + ", descripcion: " + descripcion + "";
  }

}
