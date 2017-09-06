package designModel.J2EE.singInterface;

/**
 * Created by Yangsheng on 2017-6-26.
 */
/*
鸟类
 */
class Bird{
    //用第一个接口操作，鸟类吃东西
    public void eat(BehaviorOne one){
        one.hunt();
    }
    //用第三个接口操作，鸟类滑翔
    public void slide(BehaviorThree three){
        three.glide();
    }
    //用第三个接口操作，鸟类飞翔
    public void fly(BehaviorThree three){
        three.fly();
    }

}

/**
 * 鸽子类
 */
public class Dove implements BehaviorOne, BehaviorThree {
    @Override
    public void hunt() {
        System.out.println("我是鸽子喜欢吃虫子");
    }

    @Override
    public void glide() {
        System.out.println("我是鸽子喜欢滑翔！");
    }

    @Override
    public void fly() {
        System.out.println("我是鸽子喜欢飞翔！");
    }
    //不需要的方法这次不污染了。
//    @Override
//    public void walk() { }
//    @Override
//    public void run() { }
}
