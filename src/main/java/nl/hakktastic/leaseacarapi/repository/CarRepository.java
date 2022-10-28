package nl.hakktastic.leaseacarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nl.hakktastic.leaseacarapi.entity.Car;

/** JPA Repository for Car Entities. */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {}
