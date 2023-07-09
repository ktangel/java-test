package com.example.supermartbilling.customer;

import com.example.supermartbilling.product.Product;

import java.util.List;

/*
 * @param null:
 * @return null
 * @author LeoLiu
 * @description 顾客类
 * @date 2023/7/7 20:25
 */
public class Customer {
    // 顾客ID标识
    private int id;
    // 顾客姓名
    private String name;

    // 顾客的购物车
    private ShoppingCart shoppingCart;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        // 为用户创建对应的购物车;
        this.shoppingCart = new ShoppingCart();
    }

    /*
     * @param product: 购买的商品
      * @return void
     * @author LeoLiu
     * @description 将商品添加到顾客的购物车中
     * @date 2023/7/7 20:25
     */
    public void addProductToCert(Product product) {
        System.out.println(getName() + "购买了：" + product.getWeight() + "斤" + product.getName() + "，单价为：" + product.getOriginalPrice() + ",小计价格：" + product.calculateSubTotal());
        shoppingCart.addItem(product);
    }

    /*
     * @param product: 要移除的商品
     * @return void
     * @author LeoLiu
     * @description 用户将商品从购物车中删除;
     * @date 2023/7/7 20:26
     */
    public void removeProductToCert(Product product) {
        System.out.println(getName() + "从购物车移除了商品：" + product.getName() + "，价格为：" + product.calculateSubTotal());
        shoppingCart.removeItem(product);
    }

    // 获取客户 ID
    public int getId() {
        return id;
    }

    // 获取客户名
    public String getName() {
        return name;
    }

    // 获取购物车中的商品
    public List<Product> getCartItems() {
        return shoppingCart.getItems();
    }

    // 获取购物车
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}