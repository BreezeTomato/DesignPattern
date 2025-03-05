/**
 * 单例模式代码设计

 * 小明去了一家大型商场，拿到了一个购物车，并开始购物。请你设计一个购物车管理器，
 * 记录商品添加到购物车的信息（商品名称和购买数量），并在购买结束后打印出商品清单。
 * （在整个购物过程中，小明只有一个购物车实例存在）。

 * 输入描述:
 * 输入包含若干行，每行包含两部分信息，分别是商品名称和购买数量。商品名称和购买数量之间用空格隔开。

 * 输出描述:
 * 输出包含小明购物车中的所有商品及其购买数量。每行输出一种商品的信息，格式为 "商品名称 购买数量"。

 * 输入示例:
 * Apple 3
 * Banana 2
 * Orange 5

 * 输出示例:
 * Apple 3
 * Banana 2
 * Orange 5
 */

package CreationalPatterns.SingletonPattern;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MySingleton {
    public static void main(String[] args) {
        ShoppingCartManager cart = ShoppingCartManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String itemName = scanner.next();
            int num = scanner.nextInt();

            cart.addToCart(itemName, num);
        }

        cart.viewCart();
    }
}

class ShoppingCartManager {

    //使用饿汉式实现单例
    private static final ShoppingCartManager instance = new ShoppingCartManager();

    //私有化构造函数，避免外部创建
    private ShoppingCartManager() {
        cart = new LinkedHashMap<>();
    }

    //获取实例的公用方法，作为该单例的唯一控制入口
    public static ShoppingCartManager getInstance() {
        return instance;
    }

    //定义购物车物品与数量映射map
    private Map<String, Integer> cart;

    //公共方法：添加商品至购物车
    public void addToCart(String name, Integer num) {
        cart.put(name, num);
    }

    //公共方法：查看购物车中的信息
    public  void viewCart() {
        for (Map.Entry<String, Integer> entry: cart.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
