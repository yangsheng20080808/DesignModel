package designModel.J2EE.Adopter;

import org.junit.Test;

/**
 * @author Yangsheng
 * 适配器实例
 */
//目标接口：凤凰
interface Phoenix{
    //叫声
    void quack();
    //飞翔
    void fly();

}

//目标实现：火凤凰
class FirePhoenix implements Phoenix {

    @Override
    public void quack() {
        System.out.println("I am a FirePhoenix");
    }

    @Override
    public void fly() {
        System.out.println("Fly in the Fire!");
    }

}

interface Turkey{
    //叫声
    void gobble();
    //飞翔
    void flyShort();
}

class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("I am a Turkey");
    }

    @Override
    public void flyShort() {
        System.out.println("Fly a short distance!");
    }
}

class Adapter implements Phoenix {
    //关联一只想变凤凰的火鸡
    Turkey turkey;

    public Adapter(Turkey turkey) {
        this.turkey = turkey;
    }

    //把凤凰的叫声换成火鸡的
    @Override
    public void quack() {
        turkey.gobble();
    }
    //把凤凰的飞翔行为换成火鸡的
    @Override
    public void fly() {
        turkey.flyShort();
    }
}

public class Client2 {

    @Test
    public void TurkeyToPhoenix(){
        //火凤凰
        Phoenix phoenix = new FirePhoenix();
        //火鸡
        Turkey turkey = new WildTurkey();
        //有一个变形者将火鸡变形为凤凰
        Adapter adapter = new Adapter(turkey);

        testPhoenix(phoenix);
        testPhoenix(adapter);
    }

    void testPhoenix(Phoenix phoenix){
        phoenix.quack();
        phoenix.fly();
    }
}
