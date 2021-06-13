package com.eskibana.service.api.server;

import com.eskibana.service.entity.Car;
import com.eskibana.service.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarApiTest {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void random () {
        for (int i = 0; i < 100; i++) {
            System.out.println("Testing loop : "+i);
            webTestClient.get().uri("/api/car/v1/random")
                    .exchange()
                    .expectBody(Car.class)
                    .value(car->{
                        assertTrue(CarService.BRANDS.contains(car.getBrand()));
                        assertTrue(CarService.COLORS.contains(car.getColor()));
                    });
        }
    }

    @Test
    void echo () {
    }

    @Test
    void randomCars () {
    }

    @Test
    void countCar () {
    }

    @Autowired
    @Qualifier("randomCarService")
    private CarService carService;
    @Test
    void saveCar () {
        var randomCar = carService.generateCar();
        for (int i = 0; i <100 ; i++) {

            assertTimeout(Duration.ofSeconds(100),()-> webTestClient.post()
                    .uri("/api/car/v1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(randomCar)
                    .exchange()
                    .expectStatus()
                    .is2xxSuccessful());
        }


    }

    @Test
    void getCar () {
    }

    @Test
    void updateCar () {
    }

    @Test
    void findCarsByBrandAndColor () {
    }

    @Test
    void findCarsByPath () {
    }

    @Test
    void findCarsByParam () {
        final  int size =5;
        for (var brand:CarService.BRANDS){
            for (var color:CarService.COLORS){
                webTestClient.get().uri(
                        uriBuilder ->
                                uriBuilder
                                        .path("/api/car/v1/cars")
                                        .queryParam("brand",brand)
                                        .queryParam("color",color)
                                        .queryParam("page",0)
                                        .queryParam("size",size).build())
                        .exchange()
                        .expectBodyList(Car.class)
                        .value(cars->{
                            assertNotNull(cars);
                            assertTrue(cars.size() <= size);
                        });
            }
        }
    }

    @Test
    void findCarsReleaseAfter () {
    }
}