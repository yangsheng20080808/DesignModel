package designModel.J2EE.Strategy;

/**
 * @author Yangsheng
 * 策略模式例子
 *
 */
//妙计接口
interface IStrategy {
    //每个锦囊妙计都是一个可执行的算法
    public void operate();
}

//乔国老开后门
class BackDoor implements IStrategy {
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}

//吴国太开绿灯
class GivenGreenLight implements IStrategy {
    public void operate() {
        System.out.println("求吴国太开绿灯,放行！");
    }
}

//孙夫人断后
class BlockEnemy implements IStrategy {
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}

// 锦囊
class Context {
    //构造函数，你要使用哪个妙计
    private IStrategy straegy;
    public Context(IStrategy strategy){
        this.straegy = strategy;
    }
    //使用计谋了，看我出招了
    public void operate(){
        this.straegy.operate();
    }
}

public class ZhaoYun {
    //赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
    public static void main(String[] args) {
        Context context;
    //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");
        context = new Context(new BackDoor()); //拿到妙计
        context.operate(); //拆开执行
        System.out.println("");
    //刘备乐不思蜀了，拆第二个了
        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context = new Context(new GivenGreenLight());
        context.operate(); //执行了第二个锦囊
        System.out.println("");
    //孙权的小兵追来了，咋办？拆第三个
        System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
        context = new Context(new BlockEnemy());
        context.operate(); //孙夫人退兵
        System.out.println("");
    }
}
