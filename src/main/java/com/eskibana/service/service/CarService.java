package com.eskibana.service.service;

import com.eskibana.service.entity.Car;

import java.util.List;

public interface CarService {

    List<String> BRANDS =  List.of("Toyota","Honda","Ford","Mitsubishi");
    List<String> COLORS = List.of("Red","Black","White","Silver");
    List<String> TYPES = List.of("Sedan","SUV","MPV","Hatchback","Convertible");
    List<String> ADDITIONAL_FEATURES = List.of("GPS","Alarm","Sunroof","Media player","Leather seat");
    List<String> FUELS = List.of("Petrol","Electric","Hybrid");
    List<String> TIRE_MANUFACTURERS = List.of("Goodyear","Bridgestone","Dunlop");
    Car generateCar();
}
