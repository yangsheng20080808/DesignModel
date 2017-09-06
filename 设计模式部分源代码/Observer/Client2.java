package designModel.J2EE.Observer;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Yangsheng
 */
class ConcreteSubject extends Observable {
    public void doSomething(){
        System.out.println("做一些改变！！！！！");
        setChanged();
        notifyObservers();
    }
}
class ConcreteObserver1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("①号观察者作出反应");
    }
}
class ConcreteObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("②号观察者作出反应");
    }
}
class ConcreteObserver3 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("③号观察者作出反应");
    }
}
public class Client2 {
    public static void main(String args[]){
        ConcreteSubject observable = new ConcreteSubject();
        Observer one = new ConcreteObserver1();
        Observer two = new ConcreteObserver2();
        Observer thr = new ConcreteObserver3();
        observable.addObserver(one);
        observable.addObserver(two);
        observable.addObserver(thr);
        observable.doSomething();
    }
}
