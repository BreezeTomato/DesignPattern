/**
 * 建造者模式代码设计

 * 小明家新开了一家自行车工厂，用于使用自行车配件（车架 frame 和车轮 tires ）进行组装定制不同的自行车，包括山地车和公路车。
 * 山地车使用的是Aluminum Frame（铝制车架）和 Knobby Tires（可抓地轮胎），公路车使用的是 Carbon Frame （碳车架）和 Slim Tries。
 * 现在它收到了一笔订单，要求定制一批自行车，请你使用【建造者模式】告诉小明这笔订单需要使用那些自行车配置吧。

 * 输入描述

 * 输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示订单的数量。
 * 接下来的 N 行，每行输入一个字符串，字符串表示客户的自行车需求。
 * 字符串可以包含关键词 "mountain" 或 "road"，表示客户需要山地自行车或公路自行车。

 * 输出描述

 * 对于每笔订单，输出该订单定制的自行车配置。
 */

package BuilderPattern;

import java.util.Scanner;

public class MyBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        BikeDirector director = new BikeDirector();

        for(int i = 0; i < N; i++) {
            String bikeType = scanner.nextLine();

            BikeBuilder builder;
            if (bikeType.equals("mountain")) {
                builder = new MountainBikeBuilder();
            } else {
                builder = new RoadBikeBuilder();
            }

            Bike bike = director.construct(builder);
            System.out.println(bike);
        }
    }
}

class Bike {
    private String frame;
    private String tires;

    public void setFrame(String frame) {
        this.frame = frame;
    }
    public void setTires(String tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return frame + " " + tires;
    }
}

interface BikeBuilder {
    void buildFrame();
    void buildTires();
    Bike getResult();
}

// 山地车建造者
class MountainBikeBuilder implements BikeBuilder {

    private Bike bike;

    public MountainBikeBuilder() {
        this.bike = new Bike();
    }

    @Override
    public void buildFrame() {
        bike.setFrame("Aluminum Frame");
    }

    @Override
    public void buildTires() {
        bike.setTires("Knobby Tires");
    }

    @Override
    public Bike getResult() {
        return bike;
    }
}

// 公路车建造者
class RoadBikeBuilder implements BikeBuilder {

    private Bike bike;

    public RoadBikeBuilder() {
        this.bike = new Bike();
    }

    @Override
    public void buildFrame() {
        bike.setFrame("Carbon Frame");
    }

    @Override
    public void buildTires() {
        bike.setTires("Slim Tires");
    }

    @Override
    public Bike getResult() {
        return bike;
    }
}

class BikeDirector {
    public Bike construct(BikeBuilder bikeBuilder) {
        bikeBuilder.buildFrame();
        bikeBuilder.buildTires();
        return bikeBuilder.getResult();
    }
}
