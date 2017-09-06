package designModel.J2EE.Clone;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Yangsheng
 */
class Prototype implements Cloneable {
    private String name;
    private Integer id ;
    private ArrayList list = new ArrayList();

    public void setName(String name) {
        this.name = name;
    }

    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
            prototype.list = (ArrayList) this.list.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
    public String getName() {
        return name;
    }
    public ArrayList getList() {
        return list;
    }
    public Prototype(String name, int id, ArrayList list) {
        this.name = name;
        this.id = id;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", list=" + list +
                '}';
    }
}

public class Clone {
    @Test
    public void c(){
        ArrayList arrayList = new ArrayList(){
            {add("str01"); add("str02");}
        };

        Prototype prototype1 = new Prototype("羊老大", 1,arrayList);
        System.out.println(prototype1 + "//" );
        Prototype prototype2 = prototype1.clone();
        System.out.println(prototype2 + "//" );

        //prototype1.setName("咩咩");
        System.out.println(prototype2 + "//" );

        System.out.println((prototype1.getName() == prototype2.getName()) ?  "String is 浅clone" : "String is deep clone");
        System.out.println((prototype1.getList() == prototype2.getList()) ?  "ArrayList is 浅clone" : "ArrayList is deep clone");

    }

}
