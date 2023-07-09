package com.example.supermartbilling.checkout;

import com.example.supermartbilling.customer.Customer;
import com.example.supermartbilling.customer.ShoppingCart;

// 结账过程类，一般超市的结算流程应该会有多个步骤，为了扩展和维护，结算流程单独需要一个类
public class CheckoutProcess {
    // 结账方法，输出应付总额

    /*
     * @param customer:顾客对象
     * @return double
     * @author LeoLiu
     * @description 完成顾客的结算；
     * @date 2023/7/7 20:30
     */
    public static double checkout(Customer customer) {
        return customer.getShoppingCart().calculateTotalPrice();
    }

}