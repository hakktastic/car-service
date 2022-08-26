package nl.hakktastic.leaseacarapi.service;

import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static nl.hakktastic.leaseacarapi.testdata.CarTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceUnitTest {

  @Mock private CarRepository carRepository;

  @InjectMocks private CarService carService;

  @Test
  public void givenValidArgs_whenCreateCar_thenReturnValidCarObject() {

    when(carRepository.save(any(Car.class))).thenReturn(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);

    var car = carService.createCar(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
    assertThat(car.get()).isNotNull().isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
  }

  @Test
  public void givenExistingId_whenDeleteCar_thenReturnTrue() {

    when(carRepository.existsById(any(Integer.class))).thenReturn(Boolean.TRUE);

    var isCarDeleted = carService.deleteCar(CAR_ID_VALID_1001);
    assertThat(isCarDeleted).isEqualTo(Boolean.TRUE);
  }

  @Test
  public void givenNonExistingId_whenDeleteCar_thenReturnFalse() {

    when(carRepository.existsById(any(Integer.class))).thenReturn(Boolean.FALSE);

    var isCarDeleted = carService.deleteCar(CAR_ID_INVALID_0);
    assertThat(isCarDeleted).isEqualTo(Boolean.FALSE);
  }

  @Test
  public void givenExistingId_whenGetSingleCar_thenReturnPresentOptional() {

    when(carRepository.findById(any(Integer.class)))
        .thenReturn(Optional.ofNullable(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER));

    var car = carService.getSingleCar(CAR_ID_VALID_2891_FORD);
    assertThat(car.get()).isNotNull().isEqualTo(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
    assertThat(car.get().getMake()).isEqualTo(MAKE_VALID_LAND_ROVER);
  }

  @Test
  public void givenNonExistingId_whenGetSingleCar_thenReturnEmptyOptional() {

    when(carRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

    var car = carService.getSingleCar(CAR_ID_INVALID_0);
    assertThat(car).isNotNull();
    assertThat(car.isEmpty()).isEqualTo(Boolean.TRUE);
  }

  @Test
  public void givenTwoCarsInRepository_whenGetAllCars_thenReturnListWithTwoCars() {

    when(carRepository.findAll())
        .thenReturn(List.of(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER, CAR_OBJECT_VALID_ALL_ARGS_VOLVO));

    var carList = carService.getAllCars();
    assertThat(carList).isNotEmpty().hasSize(2);
  }

  @Test
  public void givenNoCarsInRepository_whenGetAllCars_thenReturnEmptyList() {

    when(carRepository.findAll()).thenReturn(Collections.emptyList());

    var carList = carService.getAllCars();
    assertThat(carList).isEmpty();
  }
}
