package designModel.J2EE.Bridging;

/**
 * @author Yangsheng
 * 桥接模式
 */
//基类 路
abstract class AbstractRoad {
    AbstractCar aCar;
    abstract void run();

}

//汽车抽象类
abstract class AbstractCar{
    abstract void run();
}


//市区街道
class Street extends AbstractRoad {
    void run() {
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}

//高速公路
class SpeedWay extends AbstractRoad {
    void run() {
        aCar.run();
        System.out.println("在高速公路行驶");
    }
}


//公交车
class Bus extends AbstractCar {
    void run() {
        System.out.println("公交车");
    }
}

//小汽车
class Car extends AbstractCar {
    void run() {
        System.out.println("小汽车");
    }
}

abstract class People {
    AbstractRoad road;
    void run() {}
}

class Man extends People {
    @Override
    void run() {
        super.run();
        System.out.print("男人开着");
        road.run();
    }
}

class Woman extends People {
    @Override
    void run() {
        super.run();
        System.out.print("女人开着");
        road.run();
    }
}

public class Client2 {
    //测试
    public static void main(String[] args) {

        //男人开着小汽车在高速公路跑
        AbstractRoad speedWay = new SpeedWay();
        speedWay.aCar = new Car();

        People man = new Man();
        man.road = speedWay;
        man.run();

    }
}
