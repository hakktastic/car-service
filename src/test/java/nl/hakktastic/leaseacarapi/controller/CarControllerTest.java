package nl.hakktastic.leaseacarapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hakktastic.leaseacarapi.entity.Car;
import nl.hakktastic.leaseacarapi.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarController.class)
public class CarControllerTest {

  final String expectedResult =
      "{\"id\":1,\"make\":\"Audi\",\"model\":\"A8\",\"version\":"
          + "\"50 TFSI quattro S tronic Pro Line\",\"numberOfDoors\":4,"
          + "\"grossPrice\":85000.0,\"nettPrice\":75000.0,\"hp\":325}";
  Car mockCar = new Car("Audi", "A8", "50 TFSI quattro S tronic Pro Line", 4, 85000, 75000, 325);
  @MockBean private CarRepository carRepository;
  @Autowired private MockMvc mockMvc;

  @Test
  public void testCreateCar() throws Exception {

    // mock request
    final RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/cars")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(this.mockCar));
    final MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

    // check http response
    assertTrue(result.getResponse().getStatus() == 201);
  }

  @Test
  public void testDeleteCar() throws Exception {

    // mock request
    final RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/cars/1001")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);
    final MvcResult actualResult = this.mockMvc.perform(requestBuilder).andReturn();

    // check HTTP response
    assertTrue(actualResult.getResponse().getStatus() == 202);
  }

  @Test
  public void testGetCarById() throws Exception {

    // mock data
    when(this.carRepository.findById(1001)).thenReturn(Optional.of(this.mockCar));

    // mock request
    final RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cars/1001");
    final MvcResult actualResult = this.mockMvc.perform(requestBuilder).andReturn();

    // check response
    JSONAssert.assertEquals(
        this.expectedResult, actualResult.getResponse().getContentAsString(), false);

    // check HTTP response
    assertTrue(actualResult.getResponse().getStatus() == 200);
  }
}
