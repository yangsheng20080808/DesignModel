package designModel.J2EE.modelMethod;

/**
 * @author Yangsheng
 */
abstract class AbstractClass {
    //基本方法1
    protected abstract void doSomething();
    //基本方法2
    protected abstract void doOther();
    //钩子方法
    protected boolean ifDoOther(){
        return true;
    }
    //模板方法
    public final void templateMethod(){
        doSomething();
        //给子类有选择的空间
        if ( ifDoOther() ) {
            doOther();
        }
    }
}

class ConcreteClass extends AbstractClass {
    @Override
    protected void doSomething() {
    }
    @Override
    protected void doOther() {

    }
    @Override
    protected boolean ifDoOther(){
        return false;
    }
}

public class Client {
    public static void main(String[] args){
        AbstractClass c = new ConcreteClass();
        c.templateMethod();
    }
}