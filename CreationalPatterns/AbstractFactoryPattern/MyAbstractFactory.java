/**
 * 抽象工厂模式代码设计

 * 小明家新开了两个工厂用来生产家具，
 * 一个生产现代风格的沙发和椅子，
 * 一个生产古典风格的沙发和椅子，
 * 现在工厂收到了一笔订单，请你帮他设计一个系统，描述订单需要生产家具的信息。

 * 输入描述

 * 输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示订单的数量。
 * 接下来的 N 行，每行输入一个字符串，字符串表示家具的类型。家具类型分为 "modern" 和 "classical" 两种。

 * 输出描述

 * 对于每笔订单，输出字符串表示该订单需要生产家具的信息。
 * modern订单会输出下面两行字符串
 * modern chair
 * modern sofa

 * classical订单会输出下面两行字符串
 * classical chair
 * classical soft
 */

package CreationalPatterns.AbstractFactoryPattern;

import java.util.Scanner;

public class MyAbstractFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取订单数量
        int N = scanner.nextInt();

        // 处理每个订单
        for (int i = 0; i < N; i++) {
            String furnitureType = scanner.next();

            FurnitureFactory factory = null;

            if (furnitureType.equals("modern")) {
                factory = new modernFurnitureFactory();
            } else if (furnitureType.equals("classical")) {
                factory = new classicalFurnitureFactory();
            }
            
            chair chairE = factory.createChair();
            sofa sofaE = factory.createSofa();

            chairE.showInfo();
            sofaE.displayInfo();
        }
    }
}

interface chair {
    void showInfo();
}

class modernChair implements chair {
    public void showInfo() {
        System.out.println("modern chair");
    }
}

class classicalChair implements chair {
    public void showInfo() {
        System.out.println("classical chair");
    }
}

interface sofa {
    void displayInfo();
}

class modernSofa implements sofa {
    public void displayInfo() {
        System.out.println("modern sofa");
    }
}

class classicalSofa implements sofa {
    public void displayInfo() {
        System.out.println("classical sofa");
    }
}

interface FurnitureFactory {
    chair createChair();
    sofa createSofa();
}

class modernFurnitureFactory implements FurnitureFactory {
    @Override
    public chair createChair() {
        return new modernChair();
    }

    @Override
    public sofa createSofa() {
        return new modernSofa();
    }
}

class classicalFurnitureFactory implements FurnitureFactory {
    @Override
    public chair createChair() {
        return new classicalChair();
    }

    @Override
    public sofa createSofa() {
        return new classicalSofa();
    }
}
