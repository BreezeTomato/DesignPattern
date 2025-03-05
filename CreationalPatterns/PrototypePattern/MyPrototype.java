/**
 * 原型模式代码设计

 * 公司正在开发一个图形设计软件，其中有一个常用的图形元素是矩形。
 * 设计师在工作时可能需要频繁地创建相似的矩形，而这些矩形的基本属性是相同的（颜色、宽度、高度），
 * 为了提高设计师的工作效率，请你使用原型模式设计一个矩形对象的原型。使用该原型可以快速克隆生成新的矩形对象。

 * 输入描述

 * 首先输入一个字符串，表示矩形的基本属性信息，包括颜色、长度和宽度，用空格分隔，例如 "Red 10 5"。
 * 然后输入一个整数 N（1 ≤ N ≤ 100），表示使用原型创建的矩形数量。

 * 输出描述

 * 对于每个矩形，输出一行字符串表示矩形的详细信息，如 "Color: Red, Width: 10,Height: 5"。
 */

package CreationalPatterns.PrototypePattern;

import java.util.Scanner;

public class MyPrototype {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String color = scanner.next();
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            Prototype originalPrototype = new RectanglePrototype(width, height, color);
            Prototype clonedPrototype = originalPrototype.clone();

            System.out.println(clonedPrototype.getDetials());

        }
    }
}

abstract class Prototype implements Cloneable {
    public abstract String getDetials();
    public abstract Prototype clone();

    public Prototype clonePrototype() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class RectanglePrototype extends Prototype {
    private int width;
    private int height;
    private String color;

    public RectanglePrototype(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String getDetials() {
        return "Color: " + color + ", Width: " + width + ", Height: " + height;
    }

    @Override
    public Prototype clone() {
        return clonePrototype();
    }
}
