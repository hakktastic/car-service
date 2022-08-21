package nl.hakktastic.leaseacarapi.controller;

import nl.hakktastic.leaseacarapi.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_NO_ARGS;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER;
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

    var carResponseEntity = carController.createCar(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
    assertThat(carResponseEntity).isNotNull();
    assertThat(carResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    var car = carResponseEntity.getBody();
    assertThat(car).isNotNull();
    assertThat(car.getMake()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getMake());
    assertThat(car.getModel()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getModel());
    assertThat(car.getVersion()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getVersion());
    assertThat(car.getNumberOfDoors())
        .isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getNumberOfDoors());
    assertThat(car.getGrossPrice()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getGrossPrice());
    assertThat(car.getNettPrice()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getNettPrice());
    assertThat(car.getHp()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER.getHp());
  }

  @Test
  public void givenNoArgs_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_NO_ARGS)).thenReturn(Optional.empty());

    var carResponseEntity = carController.createCar(CAR_OBJECT_INVALID_NO_ARGS);

    assertThat(carResponseEntity).isNotNull();
    assertThat(carResponseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(carResponseEntity.getBody()).isNull();
  }

  @Test
  public void givenInvalidMake_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenInvalidModel_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenInvalidVersion_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenInvalidNrOfDoors_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenInvalidGrossPrice_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenInvalidNettPrice_whenCreateCar_thenReturnBadRequest() throws Exception {}

  @Test
  public void givenValidId_whenDeleteCar_thenReturnOK() throws Exception {}

  @Test
  public void givenInvalidId_whenDeleteCar_thenReturnNotFound() throws Exception {}

  @Test
  public void givenValidId_whenGetCar_thenReturnOK() throws Exception {}

  @Test
  public void givenInvalidId_whenGetCar_thenReturnNotFound() throws Exception {}

  @Test
  public void givenCarsExistInRepository_whenGetCars_thenReturnOK() throws Exception {}
}
