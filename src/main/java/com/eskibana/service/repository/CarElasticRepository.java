package com.eskibana.service.repository;

import com.eskibana.service.entity.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car,String> {

    public List<Car> findByBrandAndColor(String brand,String color);

}
