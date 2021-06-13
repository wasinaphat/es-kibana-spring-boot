package com.eskibana.service.api.server;

import com.eskibana.service.entity.Car;
import com.eskibana.service.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/api/car/v1")
public class CarApi {

    public static final Logger LOG = LoggerFactory.getLogger(CarApi.class);

    @Autowired
    private CarService carService;

    @GetMapping(value = "/random",produces = MediaType.APPLICATION_JSON_VALUE)
    public Car random(){
        return carService.generateCar();
    }
    @PostMapping(value = "/echo",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String echo(@RequestBody Car car){
        LOG.info("Car is {}",car);
        return car.toString();
    }

    @GetMapping(value = "/random-cars",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> randomCars(){
        var result = new ArrayList<Car>();

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,10); i++) {
                result.add(carService.generateCar());
        }
        return result;

    }
}
