package designModel.J2EE.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yangsheng
 */
//具体的菜单项, ArrayList和数组的基本元素
class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

interface Menu {
    public Iterator<MenuItem> createIterator();
}

class BreakfastMenu implements Menu {
    ArrayList<MenuItem> menuItems;
    public BreakfastMenu() {
        menuItems = new ArrayList<MenuItem>();
        addItem("豆浆", 0.99);
        addItem("油条", 1.99);
        addItem("白粥", 2.49);
        addItem("面包", 3.59);
    }
    public void addItem(String name, double price) {
        MenuItem menuItem = new MenuItem(name, price);
        menuItems.add(menuItem);
    }
    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

//晚餐菜单，数组类型, 创建相应的迭代器类, 继承(implements)迭代器(Iterator), 重写迭代器的方法.
class DinnerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("白饭", 0.49);
        addItem("白菜", 1.99);
        addItem("清汤", 2.29);
        addItem("猪肉", 3.05);
    }

    public void addItem(String name, double price) {
        MenuItem menuItem = new MenuItem(name, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            ++numberOfItems;
        }
    }
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }
    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        ++position;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }

        if (items[position-1] != null) {
            for (int i=position-1; i<(items.length-1); ++i) {
                items[i] = items[i+1];
            }
            items[items.length-1] = null;
        }
    }
}

class Waitress {

    Menu breakfastMenu;
    Menu dinnerMenu;

    public Waitress(Menu breakfastMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        Iterator<MenuItem> breakfastMenu = this.breakfastMenu.createIterator();
        Iterator<MenuItem> dinerIterator = this.dinnerMenu.createIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(breakfastMenu);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);

    }
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.print(menuItem.getName() + ": ");
            System.out.print(menuItem.getPrice() + " -- ");
        }
    }

}

public class Client {
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        DinnerMenu dinerMenu = new DinnerMenu();

        Waitress waitress = new Waitress(breakfastMenu, dinerMenu);
        waitress.printMenu();
    }
}
