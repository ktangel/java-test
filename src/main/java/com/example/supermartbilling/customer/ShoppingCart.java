package com.example.supermartbilling.customer;

import com.example.supermartbilling.product.Product;
import com.example.supermartbilling.promotion.PromotionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


// 购物车类
public class ShoppingCart {
    // 存储购物车中的商品的列表
    private final List<Product> items = new ArrayList<>();

    // 购物车对应的促销策略列表
    private final List<PromotionStrategy> promotionStrategies = new ArrayList<>();


    /*
     * @param product: 商品对象
     * @return void
     * @author LeoLiu
     * @description 在购物车中添加商品
     * @date 2023/7/7 21:21
     */
    public void addItem(Product product) {
        items.add(product);
    }

    /*
     * @param product:要移除的商品对象
     * @return void
     * @author LeoLiu
     * @description 从购物车中移除商品
     * @date 2023/7/7 21:21
     */
    public void removeItem(Product product) {
        items.remove(product);
    }

    // 获取购物车中的商品列表
    public List<Product> getItems() {
        return items;
    }

    /*
     * @param promotionStrategy:
     * @return void
     * @author LeoLiu
     * @description 添加购物车的促销策略
     * @date 2023/7/7 21:21
     */
    public void addPromotionStrategy(PromotionStrategy promotionStrategy) {
        promotionStrategies.add(promotionStrategy);
    }

    /*
     * @param promotionStrategy:
     * @return void
     * @author LeoLiu
     * @description 移除购物车的促销策略
     * @date 2023/7/7 21:20
     */
    public void removePromotionStrategy(PromotionStrategy promotionStrategy) {
        promotionStrategies.remove(promotionStrategy);
    }

    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 计算购物车中所有商品的总价
     * @date 2023/7/7 21:20
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.calculateSubTotal();
        }
        // 对每一种促销策略，应用到总价格上
        for (PromotionStrategy promotionStrategy : promotionStrategies) {
            totalPrice = promotionStrategy.applyPromotion(totalPrice);
        }

        return totalPrice;
    }

    /*
     * @param :
     * @return double
     * @author LeoLiu
     * @description 计算购物车中的所有商品按原价的总金额.
     * @date 2023/7/7 21:20
     */
    public double calculateOriginalTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0.0");
        for (Product item : items) {
            totalPrice.add(new BigDecimal(Double.toString(item.calculateOriginalTotal())));
        }
        // 对每一种促销策略，应用到总价格上
        return totalPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
