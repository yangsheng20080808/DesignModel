package designModel.J2EE.Decorate;

import org.junit.Test;

/**
 * @author Yangsheng
 * 装饰模式的例子
 */
//Component抽象类，奶茶抽象类，不能被实例化
abstract class Drinking{
    String description = "没有添加调料的奶茶";

    /**
     * 获取奶茶的描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 计算添加不同配料后的奶茶价格
     */
    public abstract double cost();
}

//实现Component的具体类，茉莉花茶具体类，可以被实例化
class JasmineTea extends Drinking {

    //构造函数
    public JasmineTea() {
        this.description = "茉莉花茶";
    }

    //茉莉花茶原价3块一杯
    @Override
    public double cost() {
        return 3;
    }
}

//实现Component的具体类，红茶具体类
class RedTea extends Drinking {

    //构造函数
    public RedTea() {
        this.description = "红茶";
    }

    //红茶原价5块一杯
    @Override
    public double cost() {
        return 5;
    }
}

//调味料的接口
abstract class CondimentDecorator extends Drinking {

    //需要被装饰的实体类，因为调料依赖Drinking的存在而存在，所以
    //我们使用聚合的关系
    Drinking drinking;
    /**
     * 复写添加调味料的接口，从新定义为abstract，子类实现
     * @return
     */
    public abstract String getDescription();
}

//实现具体装饰者类（＋奶盖）
class MikeCup extends CondimentDecorator {
    //需要被装饰的实体类
    //Drinking drinking;
    //构造装饰着的时候指定修饰对象
    public MikeCup(Drinking drinking) {
        this.drinking = drinking;
    }
    //加一个奶盖2块钱
    @Override
    public double cost() {
        return 2 + drinking.cost();
    }
    //添加了什么
    @Override
    public String getDescription() {
        return drinking.getDescription() + ",加一个奶盖";
    }
}

//实现具体装饰者类（＋抹茶）
class Matcha extends CondimentDecorator {

    //需要被装饰的实体类
    //Drinking drinking;
    //构造装饰着的时候指定修饰对象
    public Matcha(Drinking drinking) {
        this.drinking = drinking;
    }
    //加一层抹茶5块钱
    @Override
    public double cost() {
        return 5 + drinking.cost();
    }
    //添加了什么
    @Override
    public String getDescription() {
        return drinking.getDescription() + ",加一层抹茶";
    }
}

//奶茶店销售顾客喜欢的奶茶
public class MikeTeaStory {

    @Test
    public void soldTea(){
        //制作一杯茉莉花茶
        Drinking Moli = new JasmineTea();
        //添加奶盖跟抹茶
        Moli = new MikeCup(Moli);
        Moli = new Matcha(Moli);
        System.out.println("你的饮料是：" + Moli.getDescription()+",价钱：" + Moli.cost());

        //制作一杯红茶
        Drinking Red = new RedTea();
        //添加抹茶跟两个奶盖
        Red = new Matcha(Red);
        Red = new MikeCup(Red);
        Red = new MikeCup(Red);
        System.out.println("你的饮料是：" + Red.getDescription()+",价钱：" + Red.cost());
    }
}
