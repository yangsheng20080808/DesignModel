package designModel.J2EE.Order;

/**
 * @author Yangsheng
 * 空调实现的命令模式
 */
//执行命令的接口
interface Command {
    void execute();
}

//空调抽象类
abstract class AirCondReceiver{
    //开空调
    abstract void turnOn();
    //关空调
    abstract void turnOff();
    //调温度
    abstract void changeTemp(int i);
}

//美的空调
class MideaRecevier extends AirCondReceiver {
    int temperature ;

    void turnOn() {
        System.out.println("打开美的空调");
    }

    void turnOff() {
        System.out.println("关闭美的空调");
    }

    void changeTemp(int i) {
        temperature = i;
        System.out.println("当前温度是："+i+" 摄氏度");
    }
}

//海尔空调
class HaierRecevier extends AirCondReceiver {
    int temperature ;

    void turnOn() {
        System.out.println("打开海尔空调");
    }

    void turnOff() {
        System.out.println("关闭海尔空调");
    }

    void changeTemp(int i) {
        temperature = i;
        System.out.println("当前温度是："+i+" 摄氏度");
    }
}

//打开空调命令ConcreteCommand
class CommandOn implements Command {
    private AirCondReceiver airCondReceiver;

    public CommandOn(AirCondReceiver airCondReceiver) {
       this.airCondReceiver = airCondReceiver;
    }

    public void execute() {
       airCondReceiver.turnOn();
    }
}

//关闭空调命令ConcreteCommand
class CommandOff implements Command {
    private AirCondReceiver airCondReceiver;

    public CommandOff(AirCondReceiver airCondReceiver) {
        this.airCondReceiver = airCondReceiver;
    }

    public void execute() {
        airCondReceiver.turnOff();
    }
}

//调节空调温度命令ConcreteCommand
class CommandChange implements Command {
    private AirCondReceiver airCondReceiver;
    //温度
    int temperature ;

    public CommandChange(AirCondReceiver airCondReceiver, int i) {
        this.airCondReceiver = airCondReceiver;
        temperature = i;
    }

    public void execute() {
        airCondReceiver.changeTemp(temperature);
    }
}

//Invoker 空调遥控器
class RemoteInvoker{
    //遥控器里面的一些命令：
    private Command onCommand, offCommand, tempChange;

    //初始化这些命令
    public RemoteInvoker(Command onCommand, Command offCommand, Command tempChange) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
        this.tempChange = tempChange;
    }

    //遥控器打开空调的功能
    public void turnOn(){
        onCommand.execute();
    }

    //遥控器关闭空调的功能
    public void turnOff(){
        offCommand.execute();
    }

    //遥控器调节温度的功能
    public void changeTemp(){
        tempChange.execute();
    }
}

public class Client2 {
    public static void main(String[] args) {
        // 命令接收者Receiver,美的空调
        AirCondReceiver mideaReceiver = new MideaRecevier();

        // 开机命令ConcreteCommond
        CommandOn on = new CommandOn(mideaReceiver);
        // 关机命令ConcreteCommond
        CommandOff off = new CommandOff(mideaReceiver);
        // 温度命令ConcreteCommond
        CommandChange channel = new CommandChange(mideaReceiver, 26);
        // 命令控制对象Invoker
        RemoteInvoker control = new RemoteInvoker(on, off, channel);

        // 开机
        control.turnOn();
        // 切换频道
        control.changeTemp();
        // 关机
        control.turnOff();
    }
}
