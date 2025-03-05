/**
 * 桥接模式代码设计

 * 小明家有一个万能遥控器，能够支持多个品牌的电视。每个电视可以执行开机、关机和切换频道的操作，请你使用桥接模式模拟这个操作。

 * 输入描述

 * 第一行是一个整数 N（1 <= N <= 100），表示后面有 N 行输入。
 * 接下来的 N 行，每行包含两个数字。第一个数字表示创建某个品牌的遥控和电视，第二个数字表示执行的操作。
 * 其中，0 表示创建 Sony 品牌的电视，1 表示创建 TCL 品牌的遥控和电视；
 * 2 表示开启电视、3表示关闭电视，4表示切换频道。

 * 输出描述

 * 对于每个操作，输出相应的执行结果。
 */

package StructuralPatterns.BridgePattern;

import java.util.Scanner;

public class MyBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int TVType = sc.nextInt();
            int OperationType = sc.nextInt();

            TV tv = null;

            if (TVType == 0) {
                tv = new SonyTV();
            } else if (TVType == 1) {
                tv = new TCLTV();
            }

            RemoteControl remoteControl = null;
            
            switch (OperationType) {
                case 2:{
                    remoteControl = new PowerOnOperation(tv);
                    break;
                }
                case 3:{
                    remoteControl = new PowerOffOperation(tv);
                    break;
                }
                case 4:{
                    remoteControl = new ChangeChannelOperation(tv);
                    break;
                }
            }
            remoteControl.performOperation();
        }
    }
}

interface TV {
    void turnOn();
    void turnOff();
    void changeChannel();
}

class SonyTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void changeChannel() {
        System.out.println("Switching Sony TV channel");
    }
}

class TCLTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("TCL TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TCL TV is OFF");
    }

    @Override
    public void changeChannel() {
        System.out.println("Switching TCL TV channel");
    }
}

abstract class RemoteControl {
    protected TV tv;
    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void performOperation();
}

class PowerOnOperation extends RemoteControl {
    public PowerOnOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOn();
    }
}

class PowerOffOperation extends RemoteControl {
    public PowerOffOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOff();
    }
}

class ChangeChannelOperation extends RemoteControl {
    public ChangeChannelOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.changeChannel();
    }
}