package com.test3;

//协调者接口类
interface Mediator {
    void notice(String content, Colleague colleague);
}

//具体协调者类
class ConcreteMediator implements Mediator {
    protected Colleague employA;
    protected Colleague employB;
    protected String mediatorName;

    public void setEmploy(Colleague employA, Colleague employB) {
        this.employA = employA;
        this.employB = employB;
    }

    @Override
    public void notice(String message, Colleague colleague) {
        System.out.println(colleague.colleagueName+message);
        if (colleague instanceof Boss)
        {
            employA.work();
        }
        else if (colleague instanceof Client)
        {
            employB.work();
        }
    }

    public ConcreteMediator(String mediatorName) {
        this.mediatorName = mediatorName;
    }
}

//普通员工抽象类
abstract class Colleague {
    protected String colleagueName;
    private final ConcreteMediator mediator;
    // 定义ConcreteMediator类而不简单定义为String的mediatorName
    // 是为了便于后期colleague通过往mediator写入方法去联系其它对象

    abstract void work();

    public String getMediator() {
        return mediator.mediatorName;
    }

    //构造函数
    public Colleague(String colleagueName, ConcreteMediator mediator) {
        this.colleagueName = colleagueName;
        this.mediator = mediator;
        this.mediator.mediatorName = mediator.mediatorName;
    }
}

//客户类
class Client extends Colleague{
    @Override
    void work() { }//预留了该方法功能

    Client(String colleagueName, ConcreteMediator mediator) {
        super(colleagueName, mediator);
    }
}

//上司类
class Boss extends Colleague{
    @Override
    void work() { }//预留了该方法功能

    Boss(String colleagueName, ConcreteMediator mediator) {
        super(colleagueName, mediator);
    }
}

//员工类
class Employ extends Colleague {
    private final String workThings;

    @Override
    void work(){
        System.out.println(colleagueName+workThings);
    }

    //构造函数
    Employ(String colleagueName, ConcreteMediator mediator, String workThings) {
        super(colleagueName, mediator);
        this.workThings = workThings;
    }
}

public class Test3_1 {
    public static void main(String[] args){
        //类定义及初始化
        ConcreteMediator concreteMediator = new ConcreteMediator("中介");

        Colleague employA = new Employ("员工A", concreteMediator, "努力写代码");
        Colleague employB = new Employ("员工B", concreteMediator, "汇报工作");

        Colleague boss = new Boss("上司", concreteMediator);
        Colleague client = new Client("客户", concreteMediator);

        //方法调用
        concreteMediator.setEmploy(employA, employB);// 分配中介
//        如果concreteMediator定义为Mediator类的多态，则须((ConcreteMediator)concreteMediator).setEmploy(employA, employB);

        concreteMediator.notice("来了",boss);// 中介联系员工A
//        System.out.println(employA.colleagueName + "的中介是" + employA.mediator.mediatorName);
//        如果将mediatorName私有化，就不能这么实现了，应采用下面的方法
        concreteMediator.notice("来了",client);// 中介联系员工B
//        System.out.println(employB.colleagueName + "的中介是" + employB.getMediator());
    }
}
