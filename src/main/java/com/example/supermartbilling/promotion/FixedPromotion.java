package com.example.supermartbilling.promotion;

// 固定金额促销的满减促销，当价格大于多少时减去一定优惠金额。
public class FixedPromotion extends Promotion {
    private double discountAmount;
    // 促销折扣金额
    private double fixeAmount;

    public FixedPromotion(int id, String name, double fixeAmount, double discountAmount) {
        super(id, name, 2);
        this.discountAmount = discountAmount;
        this.fixeAmount = fixeAmount;
    }

    // 实现PromotionStrategy接口的方法，应用固定金额促销
    @Override
    public double applyPromotion(double originalPrice) {
        double promotionPrice = originalPrice >= fixeAmount ? originalPrice - discountAmount : originalPrice;
        return Math.round(promotionPrice * 100.0) / 100.0;
    }

    // 获取促销折扣金额
    public double getDiscountAmount() {

        return discountAmount;
    }

    public double getFixeAmount() {
        return fixeAmount;
    }
}