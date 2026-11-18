package com.base.interface_a;

interface DoorOperator {
    int MAX_OPEN_COUNT = 1;  // 接口字段，public static final 隐式，常量化不能二次赋值。

    void open();  // 接口抽象方法，public abstract隐式，由实现类实现。

    default void close() {
        System.out.println("关门");
    } // 接口默认方法，可多个，实现类重写。


    static void showMaxOpenCount() {
        System.out.println("允许开门次数：" + MAX_OPEN_COUNT);
    }  // 接口静态方法，接口名调用。
}



public class DoorDemo implements DoorOperator {
    @Override
    public void open() {
        System.out.println("爸爸开门");
    }

    public static void main(String[] args) {
        DoorOperator doorOperator = new DoorDemo();
        doorOperator.open();
        doorOperator.close();
        DoorOperator.showMaxOpenCount();
    }
}

// 接口与类
// 1、接口多继承。 public interface InterfaceA extends InterfaceB,InterfaceC{}
// 2、实现类多实现接口。public class InterfaceImpl implements InterfaceA,InterfaceB{}
// 3、实现类可同时继承和实现。public class Zi extends Fu implements InterfaceA,InterfaceB{}
// 4、接口抽象方法“相同的要求，实现一次”；接口默认方法是“不同的现成实现，冲突时必须自己决定”。


