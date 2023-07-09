package com.example.supermartbilling.promotion;

public enum PromotionType {
    DISCOUNT("折扣"),
    FULL_REDUCTION("满减活动"),
    BUY_ONE_GET_ONE("买一送一");
    private final String description;

    PromotionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}