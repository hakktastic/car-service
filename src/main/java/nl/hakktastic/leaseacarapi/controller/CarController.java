package nl.hakktastic.leaseacarapi.controller;

import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Rest Controller for Car Service.
 */
@RestController
@Slf4j
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CarRepository repository;

    /**
     * Create Car Entity.
     *
     * @param car {@link Car} data
     * @return Returns a {@link Car} Entity
     */
    @PostMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> createCar(@RequestBody Car car) {

        final Car carEntity = repository.save(car);
        return new ResponseEntity<>(carEntity, HttpStatus.CREATED);
    }

    /**
     * Delete Car Entity.
     *
     * @param id ID of Car Entity
     * @return Returns HTTP Response Code 202 Accepted if Car is deleted
     */
    @DeleteMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> deleteCar(@PathVariable int id) {

        final Car carEntity = repository.getReferenceById(id);
        repository.delete(carEntity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * Get Car Entity by ID.
     *
     * @param id ID of car
     * @return Returns a {@link Car} entity
     */
    @GetMapping(path = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@PathVariable int id) {

        final ResponseEntity<Car> responseEntity;
        final Optional<Car> optionalCarEntity = repository.findById(id);

        if (optionalCarEntity.isPresent()) {

            responseEntity = new ResponseEntity<>(optionalCarEntity.get(), HttpStatus.OK);

            logger.info("Get Customer by ID --> Response Code -> {} - Response -> {} ",
                    responseEntity.getStatusCodeValue(), responseEntity.getBody());

        } else {

            responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    /**
     * Get all Car Entities.
     *
     * @return Returns a {@link List} with Car Entities.
     */
    @GetMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCars() {

        final List<Car> careEntityList = repository.findAll();

        if (!careEntityList.isEmpty()) {

            return new ResponseEntity<>(careEntityList, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

}
