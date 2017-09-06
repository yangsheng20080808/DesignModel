//package designModel.J2EE.Observer;
//
//import java.util.Vector;
//
///**
// * @author Yangsheng
// */
//abstract class Subject{
//    private Vector<Observer> observers = new Vector<Observer>();
//    //添加观察者
//    public void addObserver(Observer observer){
//        this.observers.add(observer);
//    }
//    //删除观察者
//    public void delObserver(Observer observer){
//        this.observers.remove(observer);
//    }
//    //通知观察者事件
//    public void notifyObservers(){
//        for(Observer O: observers){
//            O.update();
//        }
//    }
//    //被观察实物的动作事件
//    public abstract void doSomething();
//}
//abstract class Observer {
//    public abstract void update();
//}
//class ConcreteSubject extends Subject{
//    @Override
//    public void doSomething() {
//        System.out.println("改变自身状态！！！通知观察者");
//        this.notifyObservers();
//    }
//}
//class ConcreteObserver1 extends Observer {
//    @Override
//    public void update() {
//        System.out.println("①观察者收到消息");
//    }
//}
//class ConcreteObserver2 extends Observer {
//    @Override
//    public void update() {
//        System.out.println("②观察者收到消息");
//    }
//}
//public class Client {
//    public static void main(String[] args){
//        Observer one = new ConcreteObserver1();
//        Observer two = new ConcreteObserver2();
//        Subject subject = new ConcreteSubject();
//        subject.addObserver(one);
//        subject.addObserver(two);
//        subject.doSomething();
//
//    }
//}
