package com.example.supermartbilling.promotion;

import java.math.BigDecimal;
import java.math.RoundingMode;

// 固定金额促销的满减促销，当价格大于多少时减去一定优惠金额。
public class FixedPromotion extends Promotion {
    // 促销折扣金额
    private double discountAmount;

    // 满减值
    private double fixeAmount;


    public FixedPromotion(int id, String name, double fixeAmount, double discountAmount) {
        super(id, name, PromotionType.FULL_REDUCTION);
        this.discountAmount = discountAmount;
        this.fixeAmount = fixeAmount;
    }

    // 实现PromotionStrategy接口的方法，这里实现满减促销，这里也用高精度浮点的比较。
    @Override
    public double applyPromotion(double originalPrice) {
        BigDecimal fixeAmountPrice = new BigDecimal(Double.toString(fixeAmount));
        BigDecimal originalPriceDecimal = new BigDecimal(Double.toString(originalPrice));
        BigDecimal discountAmountPrice = new BigDecimal(Double.toString(discountAmount));
        return fixeAmountPrice.compareTo(originalPriceDecimal) <= 0 ? originalPriceDecimal.subtract(discountAmountPrice).setScale(2, RoundingMode.HALF_UP).doubleValue() : originalPrice;
    }

    // 获取促销折扣金额
    public double getDiscountAmount() {

        return discountAmount;
    }

    // getter setter...

    public double getFixeAmount() {
        return fixeAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setFixeAmount(double fixeAmount) {
        this.fixeAmount = fixeAmount;
    }
}