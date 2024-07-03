package com.campus.modules.formatos.domain;

public class Formato {

  private int id;
  private String descripcion;

  public Formato(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  public Formato(String descripcion) {
    this.descripcion = descripcion;
  }

  public Formato() {
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
    return "Formato id: " + id + ", descripcion: " + descripcion + "";
  }

}
