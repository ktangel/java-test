package com.example.supermartbilling.product;

import com.example.supermartbilling.promotion.PromotionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;


// 水果类
public class Fruit extends Product {

    public Fruit(int id, String name, double originalPrice) {
        super(id, name, originalPrice, "斤");
    }

    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 获取重量计算的原价
     * @date 2023/7/7 17:32
     */
    public double getWeightedOriginalPrice() {
        BigDecimal originalPrice = new BigDecimal(Double.toString(getOriginalPrice()));
        BigDecimal weight = new BigDecimal(Double.toString(getWeight()));
        return originalPrice.multiply(weight).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    /*
     * @param :
     * @return double 价格
     * @author LeoLiu
     * @description 获取重量计算后的折扣价
     * @date 2023/7/7 17:26
     */

    public double getWeightedPromotionsPrice() {
        BigDecimal weightedOriginalPrice = new BigDecimal(Double.toString(getWeightedOriginalPrice()));
        for (PromotionStrategy promotion : getPromotions()) {
            double promotionPrice = promotion.applyPromotion(weightedOriginalPrice.doubleValue());
            weightedOriginalPrice = new BigDecimal(Double.toString(promotionPrice));
        }
        return weightedOriginalPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 重写价格计算方式
     * @date 2023/7/7 17:34
     */
    @Override
    public double calculateSubTotal() {
        BigDecimal weightedDiscountedPrice = new BigDecimal(Double.toString(getWeightedPromotionsPrice()));
        BigDecimal quantity = new BigDecimal(Double.toString(getQuantity()));
        return weightedDiscountedPrice.multiply(quantity).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double calculateOriginalTotal() {
        return Math.round((getOriginalPrice() * getWeight()) * 100.0) / 100.0;
    }
}