package com.example.supermartbilling.promotion;

// 打折促销类

public class DiscountPromotion extends Promotion {
    private byte discountPercentage;
    // 折扣1-100的数字；

    public DiscountPromotion(int id, String name, byte discountPercentage) {
        super(id, name, 1);
        this.discountPercentage = (byte) Math.max(Math.min(discountPercentage, 100), 0);
    }

    /*
     * @param originalPrice:原价
     * @return double 折扣后的价格
     * @author LeoLiu
     * @description 打折促销的实现
     * @date 2023/7/7 21:40
     */
    @Override
    public double applyPromotion(double originalPrice) {

        // 如果从来不会出现打折为0的情况，就可以用下面的方法规避，
        //        return originalPrice * (discountPercentage <= 0 ? 1 : getDiscountPercentage()) ;

        return Math.round(originalPrice * getDiscountPercentage() * 100.0) / 100.0;
    }

    // 获取折扣百分比
    public double getDiscountPercentage() {
        return (100 - discountPercentage) / 100.0;
    }

}