package designModel.J2EE.OCP.iPhone;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author Yangsheng
 * 开放封闭原则的例子
 */
//书籍接口：
interface IBook {
    //书籍有名称
    public String getName();
    //书籍有售价
    public int getPrice();
    //书籍有作者
    public String getAuthor();
}

interface IComputerBook extends IBook {
    //计算机书籍是有一个范围
    public String getScope();
}

class ComputerBook implements IComputerBook {
    private String name;
    private String scope;
    private String author;
    private int price;

    public ComputerBook(String _name,int _price,String _author,String _scope){
        this.name=_name;
        this.price = _price;
        this.author = _author;
        this.scope = _scope;
    }
    public String getScope() {
        return this.scope;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
}


//小说书籍的源代码如下：
class NovelBook implements IBook {
    //书籍名称
    private String name;
    //书籍的价格
    private int price;
    //书籍的作者
    private String author;
    //通过构造函数传递书籍数据
    public NovelBook(String _name,int _price,String _author){
        this.name = _name;
        this.price = _price;
        this.author = _author;
    }
    //获得作者是谁
    public String getAuthor() {    return this.author;   }
    //书籍叫什么名字
    public String getName() {    return this.name;  }
    //获得书籍的价格
    public int getPrice() {    return this.price;   }
}

//要打折销售的书籍
class OffNovelBook extends NovelBook {
    public OffNovelBook(String _name,int _price,String _author){
        super(_name,_price,_author);
    }
    //覆写销售价格
    @Override
    public int getPrice(){
        //原价
        int selfPrice = super.getPrice();
        int offPrice=0;
        if(selfPrice>4000){  //原价大于40元，则打9折
            offPrice = selfPrice * 80 /100;
        }else{
            offPrice = selfPrice * 90 /100;
        }return offPrice;}}


//书店售书
public class BookStore {
    private final static ArrayList<IBook> bookList = new ArrayList<IBook>();
    //静态模块初始化，项目中一般是从持久层初始化产
    static{
        bookList.add(new OffNovelBook("天龙八部",3200,"金庸"));
        bookList.add(new OffNovelBook("巴黎圣母院",5600,"雨果"));
        bookList.add(new OffNovelBook("悲惨世界",3500,"雨果"));
        bookList.add(new OffNovelBook("金瓶梅",4300,"兰陵笑笑生"));
        //增加计算机书籍
        bookList.add(new ComputerBook("Think in Java",4300,"Bruce Eckel","编程语言"));
    }
    //模拟书店买书
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        System.out.println("------------书店买出去的书籍记录如下：---------------------");
        for(IBook book:bookList){
            System.out.println("书籍名称：" + book.getName()+"\t书籍作者：" +
                    book.getAuthor()+ "\t书籍价格：" + formatter.format(book.getPrice()/100.0)+"元");
        }
    }
}
