package com.example.supermartbilling.promotion;

/*
 PromotionStrategy接口定义了一个应用促销策略的方法,
 后期可以把促销类型之类的方法放到这个接口。
 */

public interface PromotionStrategy {
//     应用促销策略，返回应用促销后的价格
//         // 促销类型：打折
//    final int TYPE_DISCOUNT = 1;
//    // 促销类型：买一送一
//    final int TYPE_BUY_ONE_GET_ONE = 2;
//    // 促销类型：满减
//    final int TYPE_FULL_REDUCTION = 3;
    double applyPromotion(double originalPrice);
}