package designModel.J2EE.DutyLine;

/**
 * @author Yangsheng 责任链模式例子
 */

/**
 * 程序猿抽象接口
 * @author Yangsheng
 *
 */
abstract class ProgramApes {
    /**
     * 获取程序员具体的差旅费用
     * @return 要多少钱
     */
    public abstract int getExpenses();

    /**
     * 获取差旅费申请
     * @return Just a request
     */
    public abstract String getApply();
}

class JavaApes extends ProgramApes {
    private int expenses;// 声明整型成员变量表示出差费用
    private String apply = "爹要点钱出差";// 声明字符串型成员变量表示差旅申请

    public JavaApes(int expenses, String apply){
        this.expenses = expenses;
        this.apply = apply;
    }

    @Override
    public int getExpenses() {
        return this.expenses;
    }

    @Override
    public String getApply() {
        return this.apply;
    }
}

/**
 * 老大们的审批接口
 * @author Yangsheng
 *
 */
interface IPower {
    /**
     * 处理请求
     *
     * @param ape 具体的猿
     */
    public void handleRequest(ProgramApes ape);
}

/**
 * 领导人抽象类
 * @author Yangsheng
 *
 */
abstract class Leader {
    private int expenses;// 当前领导能批复的金额
    private Leader mSuperiorLeader;// 上级领导
    /**
     * 含参构造方法
     * @param expenses 当前领导能批复的金额
     */
    public Leader(int expenses) {
        this.expenses = expenses;
    }
    /**
     * 回应程序猿
     * @param ape 具体的程序猿
     */
    protected abstract void reply(ProgramApes ape);
    /**
     * 处理请求
     * @param ape 具体的程序猿
     */
    public void handleRequest(ProgramApes ape) {
		 //如果说程序猿申请的money在当前领导的批复范围内
        if (ape.getExpenses() <= expenses) {
            // 那么就由当前领导批复即可
            reply(ape);
        } else {
			 //否则看看当前领导有木有上级
            if (null != mSuperiorLeader) {
                // 有的话简单撒直接扔给上级处理即可
                mSuperiorLeader.handleRequest(ape);
            } else {
                // 没有上级的话就批复不了老……不过在这个场景中总会有领导批复的淡定
                System.out.println("Goodbye my money......");
            }
        }
    }
    /**
     * 为当前领导设置一个上级领导
     * @param superiorLeader 上级领导
     */
    public void setLeader(Leader superiorLeader) {
        this.mSuperiorLeader = superiorLeader;}
}

/**
 * 小组长类
 */
class GroupLeader extends Leader {

    //小组长默认审批小于1000块的申请
    public GroupLeader() {
        super(1000);
    }

    @Override
    protected void reply(ProgramApes ape) {
        System.out.println(ape.getApply());
        System.out.println("GroupLeader: "+ ape.getExpenses()+" Of course Yes!");
    }
}

/**
 * 项目主管类
 */
class Director extends Leader {
    //项目主管默认审批小于5000的申请
    public Director() {
        super(5000);
    }
    @Override
    protected void reply(ProgramApes ape) {
        System.out.println(ape.getApply());
        System.out.println("Director: "+ ape.getExpenses()+" Of course Yes!");
    }
}

/**
 * 部门经理类
 */
class Manager extends Leader {
    //默认审批小于1w的申请
    public Manager() {
        super(10000);
    }

    @Override
    protected void reply(ProgramApes ape) {
        System.out.println(ape.getApply());
        System.out.println("Manager: "+ ape.getExpenses()+" Of course Yes!");
    }
}

public class Client {
    public static void main(String[] args) {
		/*
		 * 先来一个程序猿 这里给他一个三万以内的随机值表示需要申请的差旅费
		 */
        ProgramApes ape = new JavaApes((int) (Math.random() * 20000), "爹要点钱出差");

		/*
		 * 再来三个老大
		 */
        Leader leader = new GroupLeader();
        Leader director = new Director();
        Leader manager = new Manager();

		/*
		 * 设置老大的上一个老大
		 */
        leader.setLeader(director);
        director.setLeader(manager);

        // 处理申请
        leader.handleRequest(ape);
    }
}
