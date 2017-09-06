package designModel.J2EE.modelMethod;

/**
 * @author Yangsheng
 */
abstract class Phone {
    //模板方法：开机
    public final void turnOn(){
        initSystem();
        showLogo();
        //钩子方法
        if(isPlayMusic())
            playMusic();

        lockAndSleep();
    }
    //初始系统
    protected abstract void initSystem();
    //显示开机logo
    protected abstract void showLogo();
    //播放开机音乐
    protected abstract void playMusic();
    //锁屏并待机
    protected abstract void lockAndSleep();
    //是否播放开机音乐  :钩子函数
    protected boolean isPlayMusic(){
        return true;
    }
}

class SmartPhone extends Phone {

    @Override
    protected void initSystem() {
        System.out.println("正在加载智能机系统 。。。");
    }

    @Override
    protected void showLogo() {
        System.out.println("显示LOGO：3G梦想！");
    }

    @Override
    protected void playMusic() {
        System.out.println("播放开机音乐：欢迎使用智能机");
    }

    @Override
    protected void lockAndSleep() {
        System.out.println("一切就绪，锁屏待机");
    }

    @Override
    protected boolean isPlayMusic(){
        return false;//什么年代了，智能机不播开机音乐！
    }
}

class FeaturePhone extends Phone {
    @Override
    protected void initSystem() {
        System.out.println("正在加载功能机系统 。。。");
    }

    @Override
    protected void showLogo() {
        System.out.println("显示LOGO：NOKIA待机王！");
    }

    @Override
    protected void playMusic() {
        System.out.println("播放开机音乐：123456");
    }

    @Override
    protected void lockAndSleep() {
        System.out.println("一切就绪，锁屏待机");
    }
}

public class TestPhone {
    public static void main(String[] args) {
        Phone sp = new SmartPhone();
        sp.turnOn();

        Phone fp = new FeaturePhone();
        fp.turnOn();
    }
}
