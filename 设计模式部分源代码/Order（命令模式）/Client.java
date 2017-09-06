package designModel.J2EE.Order;//package com.xfintech.J2EE.Order;
//
///**
// * @author Yangsheng
// * 命令模式模板
// */
///**
// * 通用Receiver类
// * 为什么Receiver是一个抽象类？那是因为接收者可以有多个，有多个就需要定
// 义一个所有特性的抽象集合——抽象的接收者，其具体的接收者如代码
// */
//abstract class Receiver {
//    //抽象接收者，定义每个接收者都必须完成的业务
//    public abstract void doSomething();
//}
///**
// * 具体的Receiver类,接收者可以是N个，这要依赖业务的具体定义
// */
//class ConcreteReciver1 extends Receiver{
//    //每个接收者都必须处理一定的业务逻辑
//    public void doSomething(){
//    }
//}
//class ConcreteReciver2 extends Receiver{
//    //每个接收者都必须处理一定的业务逻辑
//    public void doSomething(){
//    }
//}
//
///**
// * 命令角色是命令模式的核心，其抽象的命令类Command类
// */
//abstract class Command {
//    //每个命令类都必须有一个执行命令的方法
//    public abstract void execute();
//}
///**
// * 根据环境的需求，具体的命令类也可以有N个，其实具体Command类
// * 定义了两个具体的命令类，读者可以在实际应用中扩展该命令类。在每个命令类中
// * ，通过构造函数定义了该命令是针对哪一个接收者发出的，定义一个命令接收的主体
// */
//class ConcreteCommand1 extends Command {
//    //对哪个Receiver类进行命令处理
//    private Receiver receiver;
//    //构造函数传递接收者
//    public ConcreteCommand1(Receiver _receiver){
//        this.receiver = _receiver;
//    }
//    //必须实现一个命令
//    public void execute() {
//    //业务处理
//        this.receiver.doSomething();
//    }
//}
//class ConcreteCommand2 extends Command {
//    //哪个Receiver类进行命令处理
//    private Receiver receiver;
//    //构造函数传递接收者
//    public ConcreteCommand2(Receiver _receiver){
//        this.receiver = _receiver;
//    }
//    //必须实现一个命令
//    public void execute() {
//    //业务处理
//        this.receiver.doSomething();
//    }
//}
//
///**
// * 调用者非常简单，仅实现命令的传递。调用者Invoker类
// * 调用者就像是一个受气包，不管什么命令，都要接收、执行！
// */
//class Invoker {
//    private Command command;
//    //受气包，接受命令
//    public void setCommand(Command _command){
//        this.command = _command;
//    }
//    //执行命令
//    public void action(){
//        this.command.execute();
//    }
//}
//
///**
// * 场景类
// */
//public class Client {
//    public static void main(String[] args) {
//        //首先声明调用者Invoker
//        Invoker invoker = new Invoker();
//        //定义接收者
//        Receiver receiver = new ConcreteReciver1();
//        //定义一个发送给接收者的命令
//        Command command = new ConcreteCommand1(receiver);
//        //把命令交给调用者去执行
//        invoker.setCommand(command);
//        invoker.action();
//    }
//}
