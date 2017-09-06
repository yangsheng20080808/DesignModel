package designModel.J2EE.singInterface;

import org.junit.Test;

/**
 * @author Yangsheng
 * 接口隔离原则
 */
public class TestBehaver {
    @Test
    public void test(){
        //犬
        Dog dog = new Dog();
        PetDog smallDog = new PetDog();
        dog.eat(smallDog);
        dog.flash(smallDog);
        dog.move(smallDog);
        //鸟
        Bird bird = new Bird();
        Dove beautiDove = new Dove();
        bird.eat(beautiDove);
        bird.fly(beautiDove);
        bird.slide(beautiDove);
    }
}
