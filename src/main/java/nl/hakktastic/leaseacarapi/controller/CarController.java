package nl.hakktastic.leaseacarapi.controller;

import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** Rest Controller for Car Service. */
@RestController
@Slf4j
public class CarController {

  @Autowired private CarService carService;

  /**
   * Create Car Entity.
   *
   * @param car {@link Car} data
   * @return Returns a {@link Car} Entity
   */
  @PostMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Car> createCar(@RequestBody @Valid Car car) {

    log.info("create car --> starting creation of car -> {}", car);

    var optionalCar = this.carService.createCar(car);
    var status = (optionalCar.isPresent()) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND;

    log.info(
        "create car --> response code -> {} ({}) - response body -> {} ",
        status.value(),
        status.name(),
        optionalCar.orElseGet(() -> null));

    return new ResponseEntity<>(optionalCar.orElseGet(() -> null), status);
  }

  /**
   * Delete Car Entity.
   *
   * @param id ID of Car Entity
   * @return Returns HTTP Response OK if Car is deleted, otherwise NO_CONTENT
   */
  @DeleteMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> deleteCar(@PathVariable @Valid int id) {

    log.info("delete car --> starting deletion of car with id-> {}", id);

    var isCarDeleted = carService.deleteCar(id);
    var status = (isCarDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

    log.info("delete car --> response code -> {} ({})", status.value(), status.name());

    return new ResponseEntity<>("", status);
  }

  /**
   * Get Car Entity by ID.
   *
   * @param id ID of car
   * @return Returns a {@link Car} entity
   */
  @GetMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Car> getCar(@PathVariable @Valid int id) {

    log.info("get car --> starting retrieval of car with id -> {}", id);

    var optionalCar = this.carService.getSingleCar(id);
    var status = (optionalCar.isPresent()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

    log.info(
        "get car --> response code -> {} ({}) - response body -> {} ",
        status.value(),
        status.name(),
        optionalCar.orElseGet(() -> null));

    return new ResponseEntity<>(optionalCar.orElseGet(() -> null), status);
  }

  /**
   * Get all Car Entities.
   *
   * @return Returns a {@link List} with Car Entities.
   */
  @GetMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Car>> getCars() {

    log.info("get cars --> starting retrieval of all cars");

    var carEntityList = this.carService.getAllCars();
    HttpStatus status = (!carEntityList.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

    log.info(
        "get cars --> response code -> {} ({}) - nr of found cars -> {}",
        status.value(),
        status.name(),
        (!(carEntityList.isEmpty()) ? carEntityList.size() : "-"));

    return new ResponseEntity<>(carEntityList, status);
  }
}
