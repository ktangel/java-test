package com.example.supermartbilling.product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.example.supermartbilling.promotion.Promotion;
import com.example.supermartbilling.promotion.PromotionStrategy;


// 商品类
public class Product {
    private int id; // 商品ID
    private String name; // 商品名称
    private double price; // 商品价格
    private double originalPrice; // 商品原价
    private int quantity; // 商品数量
    private int weight; // 商品重量
    private String weightUnit; // 重量单位
    private List<PromotionStrategy> promotions; // 商品的促销策略列表

    // 商品类的构造函数
    public Product(int id, String name, double originalPrice, String weightUnit) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.quantity = 1;
        this.weight = 0;
        this.weightUnit = weightUnit;
        this.promotions = new ArrayList<>();
    }


    // getter 和 setter 方法
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 获取当前售价
    public double getPrice() {
        return price;
    }

    // 设置当前售价
    public void setPrice(double price) {
        this.price = price;
    }

    // 获取原价
    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        // 验证输入的重量是否大于0
        if (weight <= 0) {
            throw new IllegalArgumentException("重量必须大于0");
        }
        this.weight = weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    // 获取折扣
    public List<PromotionStrategy> getPromotions() {
        return promotions;
    }

    /*
     * @param promotion: 促销活动对象
     * @return void
     * @author LeoLiu
     * @description 添加促销活动
     * @date 2023/7/7 17:36
     */
    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    /*
     * @param promotion: 需要移除的促销活动对象
     * @return void
     * @author LeoLiu
     * @description 移除促销活动，后期可以扩展按类型移除促销活动
     * @date 2023/7/7 17:36
     */
    public void removePromotion(Promotion promotion) {
        promotions.remove(promotion);
    }

    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 计算商品的促销后单价
     * @date 2023/7/7 17:39
     */

    public double getPromotionPrice() {
        BigDecimal currentPrice = new BigDecimal(Double.toString(originalPrice));
        for (PromotionStrategy promotion : promotions) {
            double promotionPrice = promotion.applyPromotion(currentPrice.doubleValue());
            currentPrice = new BigDecimal(Double.toString(promotionPrice));
        }
        return currentPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 计算商品应用促销活动后的实际应付小计金额
     * @date 2023/7/7 17:38
     */
    public double calculateSubTotal() {
        BigDecimal promotionPrice = new BigDecimal(Double.toString(getPromotionPrice()));
        BigDecimal quantity = new BigDecimal(Integer.toString(getQuantity()));
        return promotionPrice.multiply(quantity).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 计算商品原价的小计金额
     * @date 2023/7/7 17:38
     */
    public double calculateOriginalTotal() {
        return Math.round((originalPrice * quantity) * 100.0) / 100.0;
    }
}
