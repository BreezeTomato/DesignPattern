/**
 * 代理模式代码设计

 * 小明想要购买一套房子，他决定寻求一家房屋中介来帮助他找到一个面积超过100平方米的房子，
 * 只有符合条件的房子才会被传递给小明查看。

 * 输入描述

 * 第一行是一个整数 N（1 ≤ N ≤ 100），表示可供查看的房子的数量。
 * 接下来的 N 行，每行包含一个整数，表示对应房子的房屋面积。

 * 输出描述

 * 对于每个房子，输出一行，表示是否符合购房条件。如果房屋面积超过100平方米，输出 "YES"；否则输出 "NO"。
 */

package StructuralPatterns.ProxyPattern;

import java.util.Scanner;

// 客户端类
public class MyProxy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        HouseProxy proxy = new HouseProxy();

        for (int i = 0; i < N; i++) {
            int area = sc.nextInt();
            proxy.requesePurchase(area);
        }
    }
}

// 抽象主题接口
interface HousePurchase {
    void requesePurchase(int Area);
}

// 真实主题实现类
class HouseBuyer implements HousePurchase {
    @Override
    public void requesePurchase(int Area) {
        System.out.println("YES");
    }
}

// 代理类
class HouseProxy implements HousePurchase {
    private HouseBuyer buyer = new HouseBuyer();
    @Override
    public void requesePurchase(int Area) {
        if (Area > 100) {
            buyer.requesePurchase(Area);
        } else {
            System.out.println("NO");
        }
    }
}