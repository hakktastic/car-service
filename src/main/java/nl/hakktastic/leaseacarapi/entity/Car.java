package nl.hakktastic.leaseacarapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * JPA Car Entity.
 */
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    private String version;
    @Size(min = 2, message = "A car should have at least two doors")
    private int numberOfDoors;
    private double grossPrice;
    private double nettPrice;
    private int hp;

    /**
     * Default Constructor.
     */
    public Car() {}

    /**
     * Constructor.
     *
     * @param make Make of Car
     * @param model Model of Car
     * @param version Version of Car
     * @param numberOfDoors Number of Doors of Car
     * @param grossPrice Gross Price of Car
     * @param nettPrice Nett Price of Car
     * @param hp HP of Car
     */
    public Car(String make, String model, String version, int numberOfDoors,
               double grossPrice, double nettPrice, int hp) {
        super();
        this.make = make;
        this.model = model;
        this.version = version;
        this.numberOfDoors = numberOfDoors;
        this.grossPrice = grossPrice;
        this.nettPrice = nettPrice;
        this.hp = hp;
    }
}
