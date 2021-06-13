package com.eskibana.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = {"color","serialNumber"})
public class Engine {
    private String fuelType;
    private int horsePower;
    private String color ="Black";
    private String serialNumber = "SN0000001";
}
