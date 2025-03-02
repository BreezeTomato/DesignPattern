/**
 * 工厂方法模式代码设计

 * 小明家有两个工厂，一个用于生产圆形积木，一个用于生产方形积木，请你帮他设计一个积木工厂系统，记录积木生产的信息。

 * 输入描述
 * 输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示生产的次数。
 * 接下来的 N 行，每行输入一个字符串和一个整数，字符串表示积木的类型。积木类型分为 "Circle" 和 "Square" 两种。整数表示该积木生产的数量

 * 输出描述
 * 对于每个积木，输出一行字符串表示该积木的信息。

 * 输入示例
 * 3
 * Circle 1
 * Square 2
 * Circle 1

 * 输出示例
 * Circle Block
 * Square Block
 * Square Block
 * Circle Block
 */

package FactoryMethodPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFactoryMethod {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //创建积木工厂系统
        BlockFactorySystem factorySystem = new BlockFactorySystem();

        int count = scanner.nextInt();
        scanner.nextLine();

        //读取生产的积木和数量
        for (int i = 0; i < count; i++) {
            String[] productionInfo = scanner.nextLine().split(" ");
            String BlockType = productionInfo[0];
            int quantity = Integer.parseInt(productionInfo[1]);

            if (BlockType.equals("Circle")) {
                factorySystem.produceBlocks(new CircleBlockFactory(), quantity);
            }
            else if (BlockType.equals("Square")) {
                factorySystem.produceBlocks(new SquareBlockFactory(), quantity);
            }
        }

    }
}

//抽象工厂类
interface BlockFactory {
    Block createBlock();
}

//抽象积木类
interface Block {
    void produce();
}

//具体CircleBlock积木工厂类
class CircleBlockFactory implements BlockFactory {

    @Override
    public Block createBlock() {
        return new CircleBlock();
    }
}

//具体SquareBlock积木工厂类
class SquareBlockFactory implements BlockFactory {

    @Override
    public Block createBlock() {
        return new SquareBlock();
    }
}

//具体CircleBlock类
class CircleBlock implements Block {

    @Override
    public void produce() {
        System.out.println("Circle Block");
    }
}

//具体SquareBlock类
class SquareBlock implements Block {

    @Override
    public void produce() {
        System.out.println("Square Block");
    }
}

//积木工厂系统类
class BlockFactorySystem {
    private List<Block> blocks = new ArrayList<>();

    public void produceBlocks(BlockFactory factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Block block = factory.createBlock();
            blocks.add(block);
            block.produce();
        }
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
