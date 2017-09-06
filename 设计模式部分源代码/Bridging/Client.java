package designModel.J2EE.Bridging;

/**
 * @author Yangsheng
 * 桥接模式的通用代码
 */
interface Implementor {
    // 基本方法
    public void doSomething();

    public void doAnything();
}

class ConcreteImplementor1 implements Implementor {
    public void doSomething() {
        // 业务逻辑处理
    }
    public void doAnything() {
        // 业务逻辑处理
    }
}

class ConcreteImplementor2 implements Implementor {
    public void doSomething() {
        // 业务逻辑处理
    }
    public void doAnything() {
        // 业务逻辑处理
    }
}

abstract class Abstraction {
    // 定义对实现化角色的引用
    private Implementor imp;

    // 约束子类必须实现该构造函数
    public Abstraction(Implementor _imp) {
        this.imp = _imp;
    }
    // 自身的行为和属性
    public void request() {
        this.imp.doSomething();
    }
    // 获得实现化角色
    public Implementor getImp() {
        return imp;
    }
}

class RefinedAbstraction extends Abstraction {
    // 覆写构造函数
    public RefinedAbstraction(Implementor _imp) {
        super(_imp);
    }
    // 修正父类的行文
    @Override
    public void request() {
		/*
		 * 业务处理....
		 */
        super.request();
        super.getImp().doAnything();
    }
}

public class Client {
    public static void main(String[] args) {
        // 定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        // 定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行行文
        abs.request();
    }
}
