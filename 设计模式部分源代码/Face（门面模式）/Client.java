package designModel.J2EE.Face;

/**
 * @author Yangsheng
 */
//模块A
class ModuleA {
    /**
     * 提供给子系统外部使用的方法
     */
    public void a1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void a2(){};
    private void a3(){};
}

//模块B
class ModuleB {
    /**
     * 提供给子系统外部使用的方法
     */
    public void b1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void b2(){};
    private void b3(){};
}

class ModuleC {
    /**
     * 提供给子系统外部使用的方法
     */
    public void c1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void c2(){};
    private void c3(){};
}

class ModuleFacade {

    ModuleA a = new ModuleA();
    ModuleB b = new ModuleB();
    ModuleC c = new ModuleC();
    /**
     * 下面这些是A、B、C模块对子系统外部提供的方法
     */
    public void a1(){
        a.a1();
    }
    public void b1(){
        b.b1();
    }
    public void c1(){
        c.c1();
    }
}

public class Client {

    public static void main(String [] args){
        String a = "abc";
        String b = "abc";
        if (a == b){
            System.out.println("ture");
        }
    }
}
