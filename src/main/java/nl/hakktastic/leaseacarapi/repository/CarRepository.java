package nl.hakktastic.leaseacarapi.repository;


import nl.hakktastic.leaseacarapi.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JPA Repository for Car Entities.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
