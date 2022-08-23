package nl.hakktastic.leaseacarapi.controller;

import nl.hakktastic.leaseacarapi.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static nl.hakktastic.leaseacarapi.testdata.CarTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarControllerUnitTest {

  @InjectMocks private CarController carController;
  @Mock private CarService carService;

  @Test
  public void givenValidArgs_whenCreateCar_thenReturnIsCreated() {

    when(carService.createCar(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER))
        .thenReturn(Optional.of(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER));

    var responseEntity = carController.createCar(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(responseEntity.getBody()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
  }

  @Test
  public void givenNoArgs_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_NO_ARGS)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_NO_ARGS);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooShortMake_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_SHORT))
        .thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_SHORT);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooLongMake_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_LONG))
        .thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_LONG);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooShortModel_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_MODEL_TOO_SHORT)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_MODEL_TOO_SHORT);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooLongModel_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_MODEL_TOO_LONG)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_MODEL_TOO_LONG);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooShortVersion_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_VERSION_TOO_SHORT)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_VERSION_TOO_SHORT);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooLongVersion_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_VERSION_TOO_LONG)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_VERSION_TOO_LONG);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooFewNrOfDoors_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_NR_OF_DOORS_1)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_NR_OF_DOORS_1);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenTooManyNrOfDoors_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_NR_OF_DOORS_6)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_NR_OF_DOORS_6);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenInvalidGrossPrice_whenCreateCar_thenReturnNotFound() {}

  @Test
  public void givenInvalidNettPrice_whenCreateCar_thenReturnNotFound() {}

  @Test
  public void givenValidId_whenDeleteCar_thenReturnOK() {}

  @Test
  public void givenInvalidId_whenDeleteCar_thenReturnNotFound() {}

  @Test
  public void givenValidId_whenGetCar_thenReturnOK() {}

  @Test
  public void givenInvalidId_whenGetCar_thenReturnNotFound() {}

  @Test
  public void givenCarsExistInRepository_whenGetCars_thenReturnOK() {}
}
