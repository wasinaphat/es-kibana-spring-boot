package com.eskibana.service.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DefaultCarPromotionService implements CarPromotionService{
    @Override
    public boolean isValidPromotionType (String promotionType) {
        return PROMOTION_TYPES.contains(promotionType.toLowerCase());
    }
}
