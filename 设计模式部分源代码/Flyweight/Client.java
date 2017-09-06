package designModel.J2EE.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangsheng
 * 享元模式
 */
//FlyWeight抽象享元类:围棋享元类
interface ChessFlyWeight {
    String getColor();//获取颜色，内部状态
    void display(Location c);//展示位置，外部状态
}

//UnSharedConcreteFlyweight 非共享享元类:

/**
 * 外部状态：棋子坐标位置
 */
class Location{
    private int x,y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//ConcreteFlyWeight具体享元类:具体的围棋类
class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void display(Location c) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置"+c.getX()+"-----"+c.getY());
    }
}

//FlyWeightFactory享元工厂
class ChessFlyWeightFactory {
    //享元池
    private static Map<String,ChessFlyWeight> map=new HashMap<String,ChessFlyWeight>();

    public static ChessFlyWeight getChess(String color){
        //共性已经存在
        if(map.get(color) != null){
            return map.get(color);
        }else{//共性不存在
            ChessFlyWeight cfw=new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1= ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2= ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("-----增加外部状态的处理----");
        chess1.display(new Location(10,10));
        chess2.display(new Location(20,20));

    }
}
