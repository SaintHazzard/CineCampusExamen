package com.campus.modules.actores.domain;

public class Actor {

  private String name;
  private int edad;
  private String genero;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getGenero() {
    return genero;
  }

  @Override
  public String toString() {
    return "Actor [name=" + name + ", edad=" + edad + ", genero=" + genero + "]";
  }

}
