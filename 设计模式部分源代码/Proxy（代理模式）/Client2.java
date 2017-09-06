package designModel.J2EE.Proxy;

/**
 * @author Yangsheng
 */

import org.junit.Test;

/**
 * 一个买车的行为接口
 */
interface buy_car {
    public void buy_mycar();
}

class Customer implements buy_car {

    private int cash;
    private String username;

    //顾客买车的时候具体的选择行为
    @Override
    public void buy_mycar() {
        if (cash < 5000) {
            System.out.println("作为顾客我不买低于5000美元以下的车");
        }
        else if (cash >= 5000 && cash < 10000) {
            System.out.println("作为顾客我买一辆7000美元的大众");
        }else if (cash >= 10000 && cash < 20000){
            System.out.println("作为顾客我买一辆1.5w美元的奥迪");
        }else if (cash >= 20000 ){
            System.out.println("作为顾客我买一辆3w美元奔驰");
        }
    }
    public int getCash(){
        return cash;
    }
    public void setCash(int cash){
        this.cash = cash;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public Customer(int cash, String username) {
        this.cash = cash;
        this.username = username;
    }
}

class ProxyClass implements buy_car {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    //预处理
    private void before(){
        System.out.println("我是汽车销售员，先到汽车管理局等级客户买车的信息");
    }
    //善后处理
    private void after(){
        System.out.println("我是汽车销售员，最后我还要登记客户心里喜欢的汽车品牌");
    }
    @Override
        public void buy_mycar() {
            before();
            if(customer.getCash() > 2000){
                System.out.println("尊敬的客户，你的钱多于2000美元，请选择一台心爱的车吧！");
                customer.buy_mycar();
            }
            else
                System.out.println("真抱歉，您的钱少于2000美元，不可以买车呀");
            after();
        }
    }


public class Client2 {

    @Test
    public void buyCar(){
        //有钱兄弟来买车啦
        Customer customerRich = new Customer(25000, "有钱张三");
        //中产阶级的兄弟来买车啦
        Customer customerModel = new Customer(4500, "工薪阶层的李四");
        //无产阶级的兄弟来买车啦
        Customer customerPore = new Customer(0, "无产阶级的王五");

        //汽车销售员
        ProxyClass proxy = new ProxyClass();
        //帮张三买车
        proxy.setCustomer(customerRich);
        proxy.buy_mycar();
        //帮李四买车
        proxy.setCustomer(customerModel);
        proxy.buy_mycar();
        //帮王五买车
        proxy.setCustomer(customerPore);
        proxy.buy_mycar();
    }


}
