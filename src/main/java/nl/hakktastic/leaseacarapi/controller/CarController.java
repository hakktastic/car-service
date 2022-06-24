package nl.hakktastic.leaseacarapi.controller;

import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for Car Service.
 */
@RestController
@Slf4j
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarService carService;

    /**
     * Create Car Entity.
     *
     * @param car {@link Car} data
     * @return Returns a {@link Car} Entity
     */
    @PostMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> createCar(@RequestBody Car car) {

        logger.info("create car --> starting creation of car -> {}", car);

        var optionalCar = carService.createCar(car);
        var status = (optionalCar.isPresent()) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND;

        logger.info("create car --> response code -> {} ({}) - response body -> {} ", status.value(), status.name(), optionalCar.orElseGet(() -> null));

        return new ResponseEntity<>(optionalCar.orElseGet(() -> null), status);
    }

    /**
     * Delete Car Entity.
     *
     * @param id ID of Car Entity
     * @return Returns HTTP Response Code 202 Accepted if Car is deleted
     */
    @DeleteMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCar(@PathVariable int id) {

        logger.info("delete car --> starting deletion of car with id-> {}", id);

        carService.deleteCar(id);

        logger.info("delete car --> response code -> {} ({})", HttpStatus.OK.value(), HttpStatus.OK.name());

        return new ResponseEntity<>("Car deleted successsfully", HttpStatus.OK);
    }

    /**
     * Get Car Entity by ID.
     *
     * @param id ID of car
     * @return Returns a {@link Car} entity
     */
    @GetMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@PathVariable int id) {

        logger.info("get car --> starting retrieval of car with id -> {}", id);

        var optionalCar = carService.getSingleCar(id);
        var status = (optionalCar.isPresent()) ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        logger.info("get car --> response code -> {} ({}) - response body -> {} ", status.value(), status.name(), optionalCar.orElseGet(() -> null));

        return new ResponseEntity<>(optionalCar.orElseGet(() -> null), status);
    }


    /**
     * Get all Car Entities.
     *
     * @return Returns a {@link List} with Car Entities.
     */
    @GetMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCars() {

        logger.info("get cars --> starting retrieval of all cars");

        var carEntityList = carService.getAllCars();
        HttpStatus status = (!carEntityList.isEmpty()) ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        logger.info("get cars --> response code -> {} ({}) - nr of found cars -> {}", status.value(), status.name(), (!(carEntityList.isEmpty())? carEntityList.size() : "-"));

        return new ResponseEntity<>(carEntityList, status);
    }

}
