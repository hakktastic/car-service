package nl.hakktastic.leaseacarapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** JPA Car Entity. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Length(min = 2, max = 50)
  private String make;

  @NotNull
  @Length(min = 2, max = 50)
  private String model;

  @NotNull
  @Length(min = 1, max = 50)
  private String version;

  @NotNull
  @Size(min = 2)
  private int numberOfDoors;

  @NotNull
  @Length(min = 1)
  private double grossPrice;

  @NotNull
  @Length(min = 1)
  private double nettPrice;

  @NotNull
  @Length(min = 1)
  private int hp;
}
