package com.campus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracionProyecto {
  private static Properties propiedades = new Properties();

  static {
    try {
      propiedades.load(new FileInputStream("CineCampusExamen\\src\\main\\java\\com\\campus\\resources\\application.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String USER() {
    return propiedades.getProperty("user");
  }

  public static String URL() {
    return propiedades.getProperty("url");
  }

  public static String PASSWORD() {
    return propiedades.getProperty("password");
  }
}
