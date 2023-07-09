package com.example.supermartbilling.promotion;

public class Promotion implements PromotionStrategy {
    // 促销类型：打折
    public static final int TYPE_DISCOUNT = 1;
    // 促销类型：买一送一
    public static final int TYPE_BUY_ONE_GET_ONE = 2;
    // 促销类型：满减
    public static final int TYPE_FULL_REDUCTION = 3;
    private int id;  // 促销活动的id
    private String name;  // 促销活动的名称
    private int type;  // 促销活动的类型

    // 促销类的构造函数
    public Promotion(int id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Getters and Setters
    // 获取促销ID
    public int getId() {
        return id;
    }

    public int getTyped() {
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