/**
 * 装饰模式代码设计

 * 小明喜欢品尝不同口味的咖啡，他发现每种咖啡都可以加入不同的调料，比如牛奶、糖和巧克力。他决定使用装饰者模式制作自己喜欢的咖啡。
 * 请设计一个简单的咖啡制作系统，使用装饰者模式为咖啡添加不同的调料。系统支持两种咖啡类型：黑咖啡（Black Coffee）和拿铁（Latte）。

 * 输入描述

 * 多行输入，每行包含两个数字。第一个数字表示咖啡的选择（1 表示黑咖啡，2 表示拿铁），第二个数字表示要添加的调料类型（1 表示牛奶，2 表示糖）。

 * 输出描述

 * 根据每行输入，输出制作咖啡的过程，包括咖啡类型和添加的调料。
 */

package StructuralPatterns.DecoratorPattern;

import java.util.Scanner;

// 客户端类
public class MyDecorator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int coffeeType = sc.nextInt();
            int addingType = sc.nextInt();

            Coffee coffee = null;

            // 首先创建对应需要的具体基本组件
            if (coffeeType == 1) {
                coffee = new BlackCoffee();
            } else if (coffeeType == 2) {
                coffee = new Latte();
            }

            // 使用装饰器进一步加工组件，使得组件满足对应需求
            if (addingType == 1) {
                coffee = new MilkDecorator(coffee);
            } else if (addingType == 2) {
                coffee = new SugarDecorator(coffee);
            }

            coffee.brew();
        }
    }
}

// 组件接口，是具体组件类和抽象装饰器类的父亲
interface Coffee {
    void brew();
}

// 具体组件类，负责实现组件本身具有的功能
class BlackCoffee implements Coffee {

    @Override
    public void brew() {
        System.out.println("Brewing Black Coffee");
    }
}

class Latte implements Coffee {

    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }
}

// 抽象装饰器类，是所有具体装饰器的父类
abstract class Decorator implements Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void brew() {
        coffee.brew();
    }

}

// 具体装饰器类，继承抽象类，并完成对应的独特方法扩展
class MilkDecorator extends Decorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        coffee.brew();
        System.out.println("Adding Milk");
    }
}

class SugarDecorator extends Decorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        coffee.brew();
        System.out.println("Adding Sugar");
    }
}
