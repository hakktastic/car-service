package nl.hakktastic.leaseacarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Car service application. */
@SpringBootApplication
public class CarServiceApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(CarServiceApplication.class, args);
  }
}
