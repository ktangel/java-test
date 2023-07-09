package com.example.supermartbilling;

import java.math.BigDecimal;
import java.util.Random;


public class TestUtils {
    private static Random random = new Random();

    public static int randomWeight() {
        return Math.max(randomInt(), 0);
    }

    /*
     * @param list:二维数组，其中每个子数组的第一个元素是商品的价格，第二个元素是商品的数量，
     * @return double 总价格，保留到小数点后两位
     * @author LeoLiu
     * @description 将多个商品的价格和数量/重量放在二维数组中的求和；
     * @throws IllegalArgumentException 如果商品的数量小于零
     * @date 2023/7/7 20:32
     */
    public static double calculateTotalPrice(double[][] list) {
        double total = 0;
        for (double[] priceAndQuantity : list) {
            double price = priceAndQuantity[0];
            double quantity = priceAndQuantity[1];
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative");
            }
            total += price * quantity;
        }

        // 将总价格四舍五入到小数点后两位
        return Math.round(total * 100.0) / 100.0;
    }

    public static int randomInt() {
        return random.nextInt(400);
    }
}
