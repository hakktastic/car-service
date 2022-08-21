package nl.hakktastic.leaseacarapi.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static nl.hakktastic.leaseacarapi.testdata.CarTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerIntegrationTest {

  private static final String URL_TEMPLATE_CARS = "/cars";

  @Autowired private MockMvc mockMvc;

  @Test
  public void givenNoArgs_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCar = new Gson().toJson(CAR_OBJECT_INVALID_NO_ARGS);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS).contentType(MediaType.APPLICATION_JSON).content(jsonStrCar))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenValidArgs_whenCreateCar_thenReturnIsCreated() throws Exception {

    var jsonStrCarLandRover = new Gson().toJson(CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER);
    var jsonStrCarVolvo = new Gson().toJson(CAR_OBJECT_VALID_ALL_ARGS_VOLVO);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarLandRover))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.make").value(MAKE_VALID_LAND_ROVER))
        .andExpect(jsonPath("$.model").value(MODEL_VALID_DISCOVERY))
        .andExpect(jsonPath("$.version").value(VERSION_VALID_DISCOVERY))
        .andExpect(jsonPath("$.numberOfDoors").value(NR_OF_DOORS_VALID_5))
        .andExpect(jsonPath("$.grossPrice").value(GROSS_PRICE_VALID_LAND_ROVER))
        .andExpect(jsonPath("$.nettPrice").value(NETT_PRICE_VALID_LAND_ROVER))
        .andExpect(jsonPath("$.hp").value(HP_VALID_LAND_ROVER));

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarVolvo))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.make").value(MAKE_VALID_VOLVO))
        .andExpect(jsonPath("$.model").value(MODEL_VALID_XC90))
        .andExpect(jsonPath("$.version").value(VERSION_VALID_XC90))
        .andExpect(jsonPath("$.numberOfDoors").value(NR_OF_DOORS_VALID_5))
        .andExpect(jsonPath("$.grossPrice").value(GROSS_PRICE_VALID_VOLVO))
        .andExpect(jsonPath("$.nettPrice").value(NETT_PRICE_VALID_VOLVO))
        .andExpect(jsonPath("$.hp").value(HP_VALID_VOLVO));
  }

  @Test
  public void givenInvalidMake_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCarTooShortMake = new Gson().toJson(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_SHORT);
    var jsonStrCarTooLongMake = new Gson().toJson(CAR_OBJECT_INVALID_MAKE_INVALID_TOO_LONG);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooShortMake))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooLongMake))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenInvalidModel_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCarTooShortModel = new Gson().toJson(CAR_OBJECT_INVALID_MODEL_TOO_SHORT);
    var jsonStrCarTooLongModel = new Gson().toJson(CAR_OBJECT_INVALID_MODEL_TOO_LONG);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooShortModel))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooLongModel))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenInvalidVersion_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCarTooShortVersion = new Gson().toJson(CAR_OBJECT_INVALID_VERSION_TOO_SHORT);
    var jsonStrCarTooLongVersion = new Gson().toJson(CAR_OBJECT_INVALID_VERSION_TOO_LONG);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooShortVersion))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooLongVersion))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenInvalidNrOfDoors_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCarTooShortNrOfDoors = new Gson().toJson(CAR_OBJECT_INVALID_NR_OF_DOORS_1);
    var jsonStrCarTooLongNrOfDoors = new Gson().toJson(CAR_OBJECT_INVALID_NR_OF_DOORS_6);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooShortNrOfDoors))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrCarTooLongNrOfDoors))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenInvalidGrossPrice_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCar = new Gson().toJson(CAR_OBJECT_INVALID_GROSS_PRICE);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS).contentType(MediaType.APPLICATION_JSON).content(jsonStrCar))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenInvalidNettPrice_whenCreateCar_thenReturnBadRequest() throws Exception {

    var jsonStrCar = new Gson().toJson(CAR_OBJECT_INVALID_NETT_PRICE);

    mockMvc
        .perform(
            post(URL_TEMPLATE_CARS).contentType(MediaType.APPLICATION_JSON).content(jsonStrCar))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenValidId_whenDeleteCar_thenReturnOK() throws Exception {

    mockMvc
        .perform(
            delete(URL_TEMPLATE_CARS + "/{id}", CAR_ID_VALID_2891)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void givenInvalidId_whenDeleteCar_thenReturnNotFound() throws Exception {

    mockMvc
        .perform(
            delete(URL_TEMPLATE_CARS + "/{id}", CAR_ID_INVALID_0)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  public void givenValidId_whenGetCar_thenReturnOK() throws Exception {

    mockMvc
        .perform(
            get(URL_TEMPLATE_CARS + "/{id}", CAR_ID_VALID_11329)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.make").value(MAKE_VALID_VOLVO))
        .andExpect(jsonPath("$.model").value(MODEL_VALID_XC90))
        .andExpect(jsonPath("$.version").value(VERSION_VALID_XC90))
        .andExpect(jsonPath("$.numberOfDoors").value(NR_OF_DOORS_VALID_5))
        .andExpect(jsonPath("$.grossPrice").value(GROSS_PRICE_VALID_VOLVO))
        .andExpect(jsonPath("$.nettPrice").value(NETT_PRICE_VALID_VOLVO))
        .andExpect(jsonPath("$.hp").value(HP_VALID_VOLVO));
  }

  @Test
  public void givenInvalidId_whenGetCar_thenReturnNotFound() throws Exception {

    mockMvc
        .perform(
            get(URL_TEMPLATE_CARS + "/{id}", CAR_ID_INVALID_0)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  public void givenCarsExistInRepository_whenGetCars_thenReturnOK() throws Exception {

    mockMvc.perform(get(URL_TEMPLATE_CARS)).andExpect(status().isOk());
  }
}
