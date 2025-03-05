/**
 * 外观模式代码设计

 * 小明家的电源总开关控制了家里的三个设备：空调、台灯和电视机。每个设备都有独立的开关密码，分别用数字1、2和3表示。
 * 即输入1时，空调关闭，输入2时，台灯关闭，输入3时，电视机关闭，当输入为4时，表示要关闭所有设备。
 * 请你使用外观模式编写程序来描述电源总开关的操作。

 * 输入描述

 * 第一行是一个整数 N（1 <= N <= 100），表示后面有 N 行输入。
 * 接下来的 N 行，每行包含一个数字，表示对应设备的开关操作（1表示关闭空调，2表示关闭台灯，3表示关闭电视机，4表示关闭所有设备）。

 * 输出描述

 * 输出关闭所有设备后的状态，当输入的数字不在1-4范围内时，输出Invalid device code.
 */

package StructuralPatterns.FacadePattern;

import java.util.Scanner;

public class MyFacade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        PowerSwitchFacade powerSwitch = new PowerSwitchFacade();

        for (int i = 0; i < N; i++) {
            int code = sc.nextInt();
            powerSwitch.turnOffDevice(code);
        }
    }
}

class AirConditioner {
    public void closeAirConditioner() {
        System.out.println("Air Conditioner is turned off");
    }
}

class DeskLamp {
    public void closeDeskLamp() {
        System.out.println("Desk Lamp is turned off");
    }
}

class Television {
    public void closeTelevision() {
        System.out.println("Television is turned off");
    }
}

class PowerSwitchFacade {
    private AirConditioner airConditioner;
    private DeskLamp deskLamp;
    private Television television;

    public PowerSwitchFacade() {
        this.airConditioner = new AirConditioner();
        this.deskLamp = new DeskLamp();
        this.television = new Television();
    }

    public void turnOffDevice(int code) {
        switch(code) {
            case 1:
                airConditioner.closeAirConditioner();
                break;

            case 2:
                deskLamp.closeDeskLamp();
                break;

            case 3:
                television.closeTelevision();
                break;

            case 4:
                System.out.println("All devices are off.");
                break;

            default:
                System.out.println("Invalid code");
        }
    }
}