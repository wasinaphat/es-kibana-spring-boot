package com.eskibana.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "practical-java-2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CarPromotion {
    @Id
    private String id;
    private String type;
    private String description;
}
