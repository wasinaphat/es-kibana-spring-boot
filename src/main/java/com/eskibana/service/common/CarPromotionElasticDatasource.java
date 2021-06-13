package com.eskibana.service.common;

import com.eskibana.service.entity.CarPromotion;
import com.eskibana.service.repository.CarPromotionElasticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CarPromotionElasticDatasource {

    @Autowired
    private CarPromotionElasticRepository carPromotionElasticRepository;
    public static final Logger LOG = LoggerFactory.getLogger(CarPromotionElasticDatasource.class);

    @EventListener(ApplicationReadyEvent.class)
    public void populateData(){
        carPromotionElasticRepository.deleteAll();
        var carPromotions = new ArrayList<CarPromotion>();
        var promotion1 = new CarPromotion();
        promotion1.setType("discount").setDescription("Today only! we gives 0.5 % additional discount");

        var promotion2 = new CarPromotion();
        promotion2.setType("discount").setDescription("Today only! we gives 1.5 % additional discount");

        var promotion3 = new CarPromotion();
        promotion3.setType("discount").setDescription("Today only! we gives 2.5 % additional discount");

        var promotion4 = new CarPromotion();
        promotion4.setType("bonus").setDescription("Purchase three cars and get 20 gram of gold");

        var promotion5 = new CarPromotion();
        promotion5.setType("bonus").setDescription("Purchase four cars and get 20 gram of gold");

        var promotion6 = new CarPromotion();
        promotion6.setType("bonus").setDescription("Purchase five cars and get 20 gram of gold");

        carPromotions.add(promotion1);
        carPromotions.add(promotion2);
        carPromotions.add(promotion3);
        carPromotions.add(promotion4);
        carPromotions.add(promotion5);
        carPromotions.add(promotion6);

        carPromotionElasticRepository.saveAll(carPromotions);

        LOG.info("Saved dummy promotion data :{} ",carPromotionElasticRepository.count());

    }
}
