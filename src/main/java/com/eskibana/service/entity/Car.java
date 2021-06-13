package com.eskibana.service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "practical-java")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {
    @Id
    private String id;
    private String brand;
    private String color;
    private String type;
    private int price;
    private boolean available;
    @Field(type = FieldType.Date,format = DateFormat.date)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Jakarta")
    private LocalDate firstReleaseDate;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;
    private Engine engine;
    private List<Tire> tires;
}
