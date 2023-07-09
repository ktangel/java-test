package com.example.supermartbilling.promotion;

public class Promotion implements PromotionStrategy {

    private final int id;  // 促销活动的id
    private final String name;  // 促销活动的名称
    private final PromotionType type;  // 促销活动的类型

    // 促销类的构造函数
    public Promotion(int id, String name, PromotionType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Getters and Setters
    // 获取促销ID
    public int getId() {
        return id;
    }

    public PromotionType getType() {
        return type;
    }

    // 获取促销名称
    public String getName() {
        return name;
    }
    @Override
    public double applyPromotion(double originalPrice) {
        return originalPrice;
    }
}