/**
 * 适配器模式代码设计

 * 小明购买了一台新电脑，该电脑使用 TypeC 接口，他已经有了一个USB接口的充电器和数据线，
 * 为了确保新电脑可以使用现有的USB接口充电器和数据线，他购买了一个TypeC到USB的扩展坞。
 * 请你使用适配器模式设计并实现这个扩展坞系统，
 * 确保小明的新电脑既可以通过扩展坞使用现有的USB接口充电线和数据线，也可以使用TypeC接口充电。

 * 输入描述

 * 题目包含多行输入，第一行输入一个数字 N （1 < N <= 20)，表示后面有N组测试数据。
 * 之后N行都是一个整数，1表示使用电脑本身的TypeC接口，2表示使用扩展坞的USB接口充电。

 * 输出描述

 * 根据每行输入，输出相应的充电信息。
 */

package StructuralPatterns.AdapterPattern;

import java.util.Scanner;

public class MyAdapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                Typec Computer = new newComputer();
                Computer.chargeWithTypec();
            } else if (choice == 2) {
                USB adapter = new chargeAdapter();
                adapter.charge();
            }
        }

        scanner.close();
    }
}

// USB充电接口
interface USB {
    void charge();
}

// Type-C充电接口
interface Typec {
    void chargeWithTypec();
}

// 此类为适配器类，负责将typec的充电方法适配给USB使用
class TypecAdapter implements USB {
    private Typec typec;

    public TypecAdapter(Typec typec) {
        this.typec = typec;
    }

    @Override
    public void charge() {
        typec.chargeWithTypec();
    }
}

// 电脑充电接口类，使用TypeC直接充电
class newComputer implements Typec {

    @Override
    public void chargeWithTypec() {
        System.out.println("TypeC");
    }
}

// 转换器扩展坞充电接口类，调用扩展坞的USB充电接口充电
class chargeAdapter implements USB {

    @Override
    public void charge() {
        System.out.println("USB Adapter");
    }
}