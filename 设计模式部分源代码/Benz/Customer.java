package javaBase.model.Benz;

import org.junit.Test;

/**
 * @author Yangsheng
 */
//发动机类型
interface Engine{ }

//“低功耗”发动机
class LowPowerEngine implements Engine {
    public LowPowerEngine(){
        System.out.println("making a LowPowerEngine");
    }
}

//“高性能”发动机
class LargePowerEngine implements Engine {
    public LargePowerEngine(){
        System.out.println("making a LargePowerEngine");
    }
}

//空調類型
interface Aircondition{ }

//普通空調
class CheapAircondition implements Aircondition {
    public CheapAircondition(){
        System.out.println("making a CheapAircondition");
    }
}

//高级空调
class GoodAircondition implements Aircondition {
    public GoodAircondition(){
        System.out.println("making a GoodAircondition");
    }
}


//工厂建造规范（benc工厂接口）
interface BenzFactory{
    //新加的空调
    Aircondition createAircondition();
    //不同的发动机
    Engine createEngine();

    BenzCar createBenz(Aircondition aircondition, Engine engine);

}

//S级工厂,装配高级发动机跟高级空调
class S_ClassFactory implements BenzFactory {
    //高级空调
    public Aircondition createAircondition() {
        return new GoodAircondition();
    }
    //高级发动机
    public Engine createEngine() {
        return new LargePowerEngine();
    }
    //装配一台拥有高级空调和高级发动机的 S——Class
    public BenzCar createBenz(Aircondition aircondition, Engine engine) {
        return new S_Class(engine, aircondition);
    }

}

//E级工厂,装配低级发动机和低级空调
class E_ClassFactory implements BenzFactory {
    //低级空调
    public Aircondition createAircondition() {
        return new CheapAircondition();
    }
    //低级发动机
    public Engine createEngine() {
        return new LowPowerEngine();
    }
    //装配一台拥有低级空调和低级发动机的 E——Class
    public BenzCar createBenz(Aircondition aircondition, Engine engine) {
        return new E_Class(engine, aircondition);
    }
}

//超跑工厂
class SuperFactory implements BenzFactory {
    //低级空调
    public Aircondition createAircondition() {
        return new CheapAircondition();
    }
    //低级发动机
    public Engine createEngine() {
        return new LargePowerEngine();
    }
    //装配一台拥有低级空调和高级发动机的 SuperCar
    public BenzCar createBenz(Aircondition aircondition, Engine engine) {
        return new SuperCar(engine, aircondition);
    }
}

//奔驰汽车原型
abstract class BenzCar{
    //发动机
    private Engine engine;
    //空调
    private Aircondition aircondition;
    //组装奔驰汽车
    public BenzCar(Engine engine, Aircondition aircondition){
        this.engine = engine;
        this.aircondition = aircondition;
    }
}

//E级奔驰的制造方案
class E_Class extends BenzCar {
    public E_Class(Engine engine, Aircondition aircondition){
        super(engine, aircondition);
        System.out.println("making an E_Class Benz");
    }
}

//S级奔驰的制造方案
class S_Class extends BenzCar {
    public S_Class(Engine engine, Aircondition aircondition){
        super(engine, aircondition);
        System.out.println("making an S_Class Benz");
    }
}

//奔驰SuperCar的制造方案
class SuperCar extends BenzCar {
    public SuperCar(Engine engine, Aircondition aircondition){
        super(engine, aircondition);
        System.out.println("making an SuperCar Benz");
    }
}

//顾客买车
public class Customer {
    @Test
    public void buyCar(){

        //向工厂订购一台E_Class奔驰
        BenzFactory E_factory = new E_ClassFactory();
        //工厂生产一辆E_Class,这里甚至允许用户个性化定制不同类型的发动机，意思就是说
        //只要你加钱，我们甚至可以给你一辆拥有高级空调和高级发动机的 E——Class，缺点是：
        //createBenz的行为就暴露在了用户面前，当我们想要一台高级空调＋发动机的E——Class
        //的时候，代码应该应该是：
        //E_factory.createBenz(S_factory.createAircondition(), S_factory.createEngine())，
        //缺点是：用户还需要自己去联系S_factory为自己的 E——Class制造零件
        BenzCar E_benz = E_factory.createBenz(E_factory.createAircondition(), E_factory.createEngine());

        //向工厂订购一台S_Class奔驰
        BenzFactory S_factory = new S_ClassFactory();
        //工厂生产一辆S_Class，因为S——Class是很高级的，所以都是高级货，用户不需要去指定空调跟发动机，
        //都是最好的配置：当然也可以去指定,这样暴露了太多的信息
        BenzCar benzCar2 = S_factory.createBenz(S_factory.createAircondition(), S_factory.createEngine());

        //向工厂订购一台"super"奔驰
        BenzFactory Super_factory = new SuperFactory();
        //工厂生产一辆S_Class
        BenzCar benzCar3 = Super_factory.createBenz(Super_factory.createAircondition(), Super_factory.createEngine());
    }
}
