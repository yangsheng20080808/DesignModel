package designModel.J2EE.singInterface;

/**
 * @author Yangsheng
 */

/**
 * 犬科
 */
class Dog{
    //犬科吃东西
    public void eat(BehaviorOne one){
        one.hunt();
    }
    //犬科走路
    public void move(BehaviorTwo two){
        two.walk();
    }
    //犬科奔跑
    public void flash(BehaviorTwo two){
        two.run();
    }
}

public class PetDog implements BehaviorOne, BehaviorTwo {
    @Override
    public void hunt() {
        System.out.println("我喜欢吃狗粮");
    }

    @Override
    public void walk() {
        System.out.println("主人牵我散步");
    }

    @Override
    public void run() {
        System.out.println("我是宠物狗，跑得特别快");
    }

    //不需要的方法这次不污染了。
//    @Override
//    public void glide() {}
//    @Override
//    public void fly() {}
}
