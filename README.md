## 测试题代码

通过分析测试题的要求，我将几个场景中的超市收银流程所涉及的功能进行了简单的实现。

下面是一些实现相关功能的说明。


### 商品管理

Product类，超市中的商品，包含商品的基本信息和价格计算方法，Fruit水果子类，对于水果稳重的类我重写了价格计算方式，普通商品是按数量计算总价，水果按重量。


### 促销策略管理

促销有针对商品的，也会有全场满减促销的，也就是购物车结算时触发的(我理解为是针对购物车的,其实也可以写在最后的结算流程中),就是促销其实也是有不同类型属性。

考虑到促销活动会不断更新，通过PromotionStrategy抽象的策略接口，利用策略模式来实现针对促销的多种类型的管理和扩展。


### 顾客与购物车管理

这部分包括Customer类和ShoppingCart类。

Customer类代表顾客，包含一些基本信息以及一个购物车。

ShoppingCart类代表购物车，包含添加、移除商品和计算总价等方法。

结账处理：CheckoutProcess类负责这部分，它属于支付一类的功能，定义了结账过程，计算顾客需要结算支付的总金额。


### 测试用例

4个题目分别在`src/test/java/.../ShoppingCartTest.java`中。

部分功能的测试用例分别写了正例、反例和边界情况的测试。