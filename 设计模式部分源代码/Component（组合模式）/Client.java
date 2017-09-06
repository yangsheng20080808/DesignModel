package designModel.J2EE.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangsheng
 * 组合模式
 */
//总店
abstract class Market {
    String name;

    public abstract void add(Market m);

    public abstract void remove(Market m);

    public abstract void PayByCard();
}

// 分店 下面可以有加盟店
class MarketBranch extends Market {
    // 加盟店列表
    List<Market> list = new ArrayList<Market>();

    public MarketBranch(String s) {
        this.name = s;
    }

    @Override
    public void add(Market m) {
        // TODO Auto-generated method stub
        list.add(m);
    }

    @Override
    public void remove(Market m) {
        // TODO Auto-generated method stub
        list.remove(m);
    }

    // 消费之后，该分店下的加盟店自动累加积分
    @Override
    public void PayByCard() {
        // TODO Auto-generated method stub
        System.out.println(name + "消费,积分已累加入该会员卡");
        for (Market m : list) {
            m.PayByCard();
        }
    }
}

// 加盟店 下面不在有分店和加盟店，最底层
class MarketJoin extends Market {
    public MarketJoin(String s) {
        this.name = s;
    }

    @Override
    public void add(Market m) {
        // 空方法或者抛异常
    }

    @Override
    public void remove(Market m) {
        // 空方法或者抛异常
    }

    @Override
    public void PayByCard() {
        System.out.println(name + "消费,积分已累加入该会员卡");
    }
}

public class Client {
    public static void main(String[] args) {
        MarketBranch rootBranch = new MarketBranch("广东总店");
        MarketBranch qhdBranch = new MarketBranch("深圳市分店");
        MarketJoin hgqJoin = new MarketJoin("南山前海加盟店");
        MarketJoin btlJoin = new MarketJoin("南山后海加盟店");

        qhdBranch.add(hgqJoin);
        qhdBranch.add(btlJoin);
        rootBranch.add(qhdBranch);
        rootBranch.PayByCard();
    }
}
