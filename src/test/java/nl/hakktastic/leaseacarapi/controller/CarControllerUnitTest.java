package nl.hakktastic.leaseacarapi.controller;

import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_ID_INVALID_0;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_ID_VALID_11329_VOLVO;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_ID_VALID_2891_FORD;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_GROSS_PRICE;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_MAKE_INVALID_TOO_LONG;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_MAKE_INVALID_TOO_SHORT;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_MODEL_TOO_LONG;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_MODEL_TOO_SHORT;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_NETT_PRICE;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_NO_ARGS;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_NR_OF_DOORS_1;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_NR_OF_DOORS_6;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_VERSION_TOO_LONG;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_INVALID_VERSION_TOO_SHORT;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER;
import static nl.hakktastic.leaseacarapi.testdata.CarTestData.CAR_OBJECT_VALID_ALL_ARGS_VOLVO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import nl.hakktastic.leaseacarapi.service.CarService;

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
  public void givenInvalidGrossPrice_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_GROSS_PRICE)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_GROSS_PRICE);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenInvalidNettPrice_whenCreateCar_thenReturnNotFound() {

    when(carService.createCar(CAR_OBJECT_INVALID_NETT_PRICE)).thenReturn(Optional.empty());

    var responseEntity = carController.createCar(CAR_OBJECT_INVALID_NETT_PRICE);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isNull();
  }

  @Test
  public void givenValidId_whenDeleteCar_thenReturnOK() {

    when(carService.deleteCar(CAR_ID_VALID_2891_FORD)).thenReturn(Boolean.TRUE);

    var responseEntity = carController.deleteCar(CAR_ID_VALID_2891_FORD);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isEqualTo(StringUtils.EMPTY);
  }

  @Test
  public void givenInvalidId_whenDeleteCar_thenReturnNotFound() {

    when(carService.deleteCar(CAR_ID_INVALID_0)).thenReturn(Boolean.FALSE);

    var responseEntity = carController.deleteCar(CAR_ID_INVALID_0);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isEqualTo(StringUtils.EMPTY);
  }

  @Test
  public void givenValidId_whenGetCar_thenReturnOK() {

    when(carService.getSingleCar(CAR_ID_VALID_11329_VOLVO))
        .thenReturn(Optional.ofNullable(CAR_OBJECT_VALID_ALL_ARGS_VOLVO));

    var responseEntiy = carController.getCar(CAR_ID_VALID_11329_VOLVO);

    assertThat(responseEntiy.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntiy.getBody()).isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_VOLVO);
  }

  @Test
  public void givenInvalidId_whenGetCar_thenReturnNotFound() {

    when(carService.getSingleCar(CAR_ID_INVALID_0)).thenReturn(Optional.empty());

    var responseEntiy = carController.getCar(CAR_ID_INVALID_0);

    assertThat(responseEntiy.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntiy.getBody()).isNull();
  }

  @Test
  public void givenTwoCarsExistInRepository_whenGetCars_thenReturnOK() {

    when(carService.getAllCars())
        .thenReturn(List.of(CAR_OBJECT_VALID_ALL_ARGS_VOLVO, CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER));

    var responseEntity = carController.getCars();

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody())
        .containsExactly(CAR_OBJECT_VALID_ALL_ARGS_VOLVO, CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
  }

  @Test
  public void givenNoCarsExistInRepository_whenGetCars_thenReturnNotFound() {

    when(carService.getAllCars()).thenReturn(Collections.emptyList());

    var responseEntity = carController.getCars();

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isEqualTo(Collections.emptyList());
  }
}
