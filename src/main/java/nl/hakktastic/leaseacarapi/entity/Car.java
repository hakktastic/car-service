package nl.hakktastic.leaseacarapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
  @Length(min = 2, max = 50)
  private String version;

  @NotNull
  @Range(min = 2, max = 5)
  private int numberOfDoors;

  @NotNull @Positive private double grossPrice;

  @NotNull @Positive private double nettPrice;

  @NotNull @Positive private int hp;
}
