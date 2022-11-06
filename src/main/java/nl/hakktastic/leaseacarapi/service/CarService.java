package nl.hakktastic.leaseacarapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.repository.CarRepository;

/** Service object to manage {@link Car} entities. */
@Service
public class CarService {

  @Autowired private CarRepository repository;

  /**
   * Create a {@link Car} entity.
   *
   * @param car @{@link Car}
   * @return Returns the car created as an {@link Optional}}
   */
  public Optional<Car> createCar(Car car) {

    return Optional.of(repository.save(car));
  }

  /**
   * Delete a {@link Car} entity.
   *
   * @param id ID of the car to be deleted
   * @return Returns @{@code TRUE} if {@link Car} entity is deleted, othwerise {@code FALSE}
   */
  public boolean deleteCar(int id) {

    if (repository.existsById(id)) {

      repository.deleteById(id);
      return true;
    }

    return false;
  }

  /**
   * Find a single {@link Car} entity with provided ID.
   *
   * @param id ID of the car to be returned
   * @return Returns an {@link Optional} containing the {@link Car} entity
   */
  public Optional<Car> getSingleCar(int id) {

    return repository.findById(id);
  }

  /**
   * Get all {@link Car} entities from the repository.
   *
   * @return Returns a {@link List} with found {@link Car} entities
   */
  public List<Car> getAllCars() {

    return repository.findAll();
  }
}
