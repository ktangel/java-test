package com.example.supermartbilling;

import com.example.supermartbilling.customer.*;
import com.example.supermartbilling.product.*;
import com.example.supermartbilling.pay.CheckoutProcess;
import com.example.supermartbilling.promotion.DiscountPromotion;
import com.example.supermartbilling.promotion.FixedPromotion;
import com.example.supermartbilling.promotion.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.supermartbilling.TestUtils.calculateTotalPrice;
import static com.example.supermartbilling.TestUtils.randomWeight;


public class ShoppingCartTest {
    //
    private double applePrice = 8.0;
    private double strawberryPrice = 13.0;
    private double mangoPrice = 20.0;

    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 测试计算价格的工具函数
     * @date 2023/7/7 19:56
     */
    @Test
    public void testCalculateTotalPrice() {
        // 正例: 常规的价格和数量
        double[][] priceAndQuantityList = {
                {10.0, 2},
                {20.0, 1},
                {30.0, 3}
        };
        double expectedTotal = 130.0;
        double actualTotal = calculateTotalPrice(priceAndQuantityList);
        Assertions.assertEquals(expectedTotal, actualTotal, 0.001, "正常情况下的总价计算错误");

        // 反例: 商品数量为负数
        double[][] priceAndQuantityListWithNegativeQuantity = {
                {10.0, -2},
                {20.0, 1},
                {30.0, 3}
        };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            double test;
            test = calculateTotalPrice(priceAndQuantityListWithNegativeQuantity);
            System.out.println(test);
        }, "期望函数在处理负数数量时抛出IllegalArgumentException异常");

        // 边界情况: 商品价格为零
        double[][] priceAndQuantityListWithZeroPrice = {
                {0.0, 2},
                {20.0, 1},
                {30.0, 3}
        };
        expectedTotal = 110.0;
        actualTotal = calculateTotalPrice(priceAndQuantityListWithZeroPrice);
        Assertions.assertEquals(expectedTotal, actualTotal, 0.001, "商品价格为零时的总价计算错误");
    }


    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 题目1
     * @date 2023/7/7 20:11
     */
    @Test
    public void TestSubject1() {

        // 题目1：
        System.out.println("题目1：");

        // 创建一个苹果产品，每斤价格是8元，重量是2公斤

        Fruit apple = new Fruit(1, "苹果", applePrice);
        Fruit strawberry = new Fruit(2, "草莓", strawberryPrice);

        // 用户要购买的苹果重量：
        int appleWeight = randomWeight();
        int strawberryWeight = randomWeight();

        // 创建顾客

        Customer customer = new Customer(111, "顾客A");

        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);

        // 用户将商品放到购物车中
        customer.addProductToCert(apple);
        customer.addProductToCert(strawberry);

        double[][] priceAndQuantityList = {
                {applePrice, appleWeight},
                {strawberryPrice, strawberryWeight},
        };

        // 计算购物车的总价格
        double checkoutTotalPrice = CheckoutProcess.checkout(customer);

        // 正确的价格：
        double totalPrice = calculateTotalPrice(priceAndQuantityList);

        // 检查计算出的总价格是否正确。
        Assertions.assertEquals(totalPrice, checkoutTotalPrice, "测试未通过：计算的总价格：" + checkoutTotalPrice + ",应为：" + totalPrice);
        System.out.println("题目1测试通过：");
        System.out.println(customer.getName() + "一共消费了" + totalPrice + "元");
        System.out.println("-------------");


    }


    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 题目2
     * @date 2023/7/7 20:11
     */
    @Test
    public void TestSubject2() {

        //题目2：

        System.out.println("题目2：");

        // 创建一个苹果产品，每斤价格是8元，重量是2公斤

        Fruit apple = new Fruit(1, "苹果", applePrice);
        Fruit strawberry = new Fruit(2, "草莓", strawberryPrice);
        Fruit mango = new Fruit(3, "芒果", mangoPrice);


        Customer customer = new Customer(222, "顾客B");


        // 用户购买的水果重量：

        int appleWeight = randomWeight();
        int strawberryWeight = randomWeight();
        int mangoWeight = randomWeight();

        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        mango.setWeight(mangoWeight);

        // 将用户购买的商品添加到购物车；

        customer.addProductToCert(apple);
        customer.addProductToCert(strawberry);
        customer.addProductToCert(mango);

        double[][] priceAndQuantityList = {
                {applePrice, appleWeight},
                {strawberryPrice, strawberryWeight},
                {mangoPrice, mangoWeight},
        };

        // 计算购物车的总价格
        double checkoutTotalPrice = CheckoutProcess.checkout(customer);

        // 正确的价格：
        double totalPrice = calculateTotalPrice(priceAndQuantityList);

        // 检查计算出的总价格是否正确。
        Assertions.assertEquals(totalPrice, checkoutTotalPrice, "测试未通过：计算的总价格：" + checkoutTotalPrice + ",应为：" + totalPrice);
        System.out.println("题目2测试通过：");
        System.out.println(customer.getName() + "一共消费了" + totalPrice + "元");
        System.out.println("-------------");

    }

    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 题目3
     * @date 2023/7/7 20:11
     */
    @Test
    public void Subject3() {

        //题目3：

        System.out.println("题目3：");
        // 创建一个苹果产品，每斤价格是8元，重量是2公斤

        Fruit apple = new Fruit(1, "苹果", applePrice);
        Fruit strawberry = new Fruit(2, "草莓", strawberryPrice);
        Fruit mango = new Fruit(3, "芒果", mangoPrice);

        Customer customer = new Customer(333, "顾客C");


        // 用户购买的水果重量：

        int appleWeight = randomWeight();
        int strawberryWeight = randomWeight();
        int mangoWeight = randomWeight();

        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        mango.setWeight(mangoWeight);

        // 商品促销

        Promotion discountPromotion1 = new DiscountPromotion(1, "商品打8折", (byte) 20);

        strawberry.addPromotion(discountPromotion1);
        // 将用户购买的商品添加到购物车；

        customer.addProductToCert(apple);
        customer.addProductToCert(strawberry);
        customer.addProductToCert(mango);

        double[][] priceAndQuantityList = {
                {applePrice, appleWeight},
                {strawberryPrice * .8, strawberryWeight},
                {mangoPrice, mangoWeight},
        };

        // 计算购物车的总价格
        double checkoutTotalPrice = CheckoutProcess.checkout(customer);

        // 正确的价格：
        double totalPrice = calculateTotalPrice(priceAndQuantityList);

        // 检查计算出的总价格是否正确。
        Assertions.assertEquals(totalPrice, checkoutTotalPrice, "测试未通过：计算的总价格：" + checkoutTotalPrice + ",应为：" + totalPrice);
        System.out.println("题目3测试通过：");
        System.out.println(customer.getName() + "一共消费了" + totalPrice + "元" + "，原价为:" + customer.getShoppingCart().calculateOriginalTotalPrice());
        System.out.println("-------------");
    }


    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 题目4
     * @date 2023/7/7 20:11
     */
    @Test
    public void Subject4() {

        //题目4：

        System.out.println("题目4：");

        // 创建一个苹果产品，每斤价格是8元，重量是2公斤

        Fruit apple = new Fruit(1, "苹果", applePrice);
        Fruit strawberry = new Fruit(2, "草莓", strawberryPrice);
        Fruit mango = new Fruit(3, "芒果", mangoPrice);

        Customer customer = new Customer(444, "顾客D");


        // 用户购买的水果重量：

        int appleWeight = randomWeight();
        int strawberryWeight = randomWeight();
        int mangoWeight = randomWeight();

        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        mango.setWeight(mangoWeight);

        // 商品促销，打8折

        Promotion discountPromotion1 = new DiscountPromotion(1, "商品打8折", (byte) 20);


        strawberry.addPromotion(discountPromotion1);

        // 将商品加入购物车；

        customer.addProductToCert(apple);
        customer.addProductToCert(strawberry);
        customer.addProductToCert(mango);

        // 购物车满100减10

        Promotion fixedPromotion1 = new FixedPromotion(1, "满100减10", 100.0, 10.0);
        // 满减的促销信息加入购物车，也可以设置成商店的全局配置，购物车结算时去读取，我目前是跟商品一样的逻辑处理。

        customer.getShoppingCart().addPromotionStrategy(fixedPromotion1);

        // 计算正确的价格；
        double[][] priceAndQuantityList = {
                {applePrice, appleWeight},
                {strawberryPrice * .8, strawberryWeight},
                {mangoPrice, mangoWeight},
        };


        // 计算购物车的总价格
        double checkoutTotalPrice = CheckoutProcess.checkout(customer);

        // 正确的价格：
        double totalPrice = calculateTotalPrice(priceAndQuantityList);
        if (totalPrice >= 100.0) {
            totalPrice -= 10;
        }

        // 检查计算出的总价格是否正确。
        Assertions.assertEquals(totalPrice, checkoutTotalPrice, "测试未通过：计算的总价格：" + checkoutTotalPrice + ",应为：" + totalPrice);
        System.out.println("题目4测试通过：");
        System.out.println(customer.getName() + "一共消费了" + totalPrice + "元，原价为:" + customer.getShoppingCart().calculateOriginalTotalPrice());
        System.out.println("-------------");


    }

    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 测试打折促销
     * @date 2023/7/7 21:33
     */
    @Test
    public void TestDiscountPromotion() {
        // 正例: 正常打折促销
        DiscountPromotion discountPromotion = new DiscountPromotion(1, "全场打65折", (byte) 20);
        double originalPrice = 100.0;
        double expectedPrice = 80.0;
        double actualPrice = discountPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "打折促销计算错误");


        // 反例: 折扣百分比为0，价格应保持不变
        discountPromotion = new DiscountPromotion(2, "No Discount", (byte) 0);
        originalPrice = 100.0;

        expectedPrice = 100.0;
        actualPrice = discountPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "折扣百分比为100时，价格应保持不变");

        // 边界情况: 折扣百分比为100，价格应为0
        discountPromotion = new DiscountPromotion(3, "Full Discount", (byte) 100);

        expectedPrice = 0.0;
        actualPrice = discountPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "折扣百分比为100时，价格应为0");


        // 边界情况:价格带小数。
        discountPromotion = new DiscountPromotion(2, "全场打77折", (byte) 33);
        originalPrice = 99.99;
        expectedPrice = 66.99;
        actualPrice = discountPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "商品价格为99.99,折扣百分比为33时,打折计算的结果不对");

    }

    /*
     * @param :
     * @return void
     * @author LeoLiu
     * @description 测试满减促销
     * @date 2023/7/7 21:33
     */
    @Test
    public void TestFixedPromotion() {


        // 正例: 商品价格大于固定金额
        FixedPromotion fixedPromotion = new FixedPromotion(1, "Fixe Discount", 100.0, 20.0);
        double originalPrice = 101.0;
        double expectedPrice = 81.0;
        double actualPrice = fixedPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "商品价格大于固定金额时，需要正常应用促销逻辑");


        // 反例: 商品价格小于固定金额
        originalPrice = 80.0;
        expectedPrice = 80.0;
        actualPrice = fixedPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "商品价格小于固定金额时，应该不减。");

        // 边界情况: 商品价格等于固定金额
        originalPrice = 100.0;
        expectedPrice = 80.0;
        actualPrice = fixedPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "商品价格等于固定金额时，应该要减");


        // 商品价格为边界99.99小数
        originalPrice = 99.99;
        expectedPrice = 99.99;
        actualPrice = fixedPromotion.applyPromotion(originalPrice);
        Assertions.assertEquals(expectedPrice, actualPrice, 0.001, "商品价格在边界99.99时，应该不减");

    }
}

