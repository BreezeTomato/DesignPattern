/**
 * 享元模式代码设计

 * 在一个图形编辑器中，用户可以绘制不同类型的图形，
 * 包括圆形（CIRCLE）、矩形（RECTANGLE）、三角形（TRIANGLE）等。
 * 请你实现一个图形绘制程序，要求能够共享相同类型的图形对象，以减少内存占用。

 * 输入描述

 * 输入包含多行，每行表示一个绘制命令。每个命令包括两部分：
 * 图形类型（Circle、Rectangle 或 Triangle）
 * 绘制的坐标位置（两个整数，分别表示 x 和 y）

 * 输出描述

 * 对于每个绘制命令，输出相应图形被绘制的位置信息。如果图形是首次绘制，输出 "drawn at"，否则输出 "shared at"。
 */

package StructuralPatterns.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyFlyweight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeFactory shapeFactory = new ShapeFactory();

        while (sc.hasNext()) {
            String command = sc.nextLine();
            processCommand(shapeFactory, command);
        }
    }

    private static void processCommand(ShapeFactory shapeFactory, String command) {
        String[] parts = command.split(" ");
        ShapeType type = ShapeType.valueOf(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        Shape shape = shapeFactory.getShape(type);
        shape.draw(new Position(x,y));

        ((ConcreteShape) shape).setFirstTime(false);
    }
}

enum ShapeType {
    CIRCLE, RECTANGLE, TRIANGLE
}

class Position {
    int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

interface Shape {
    void draw(Position position);
}

class ConcreteShape implements Shape {
    private ShapeType shapeType;

    public ConcreteShape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public void draw(Position position) {
        System.out.println(shapeType + (isFirstTime ? " drawn" : " shared") + " at (" + position.getX() + ", " + position.getY() + ")");
    }

    private boolean isFirstTime = true;

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }
}

class ShapeFactory {
    private Map<ShapeType, Shape> shapes = new HashMap<>();

    public Shape getShape(ShapeType shapeType) {
        if (!shapes.containsKey(shapeType)) {
            shapes.put(shapeType, new ConcreteShape(shapeType));
        }
        return shapes.get(shapeType);

    }
}