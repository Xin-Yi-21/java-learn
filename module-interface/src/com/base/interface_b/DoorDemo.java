package com.base.interface_b;

interface DoorOperatorA {
    void open();

    default void close() {
        System.out.println("A 的关门方式");
    }
}

interface DoorOperatorB {
    void open();

    default void close() {
        System.out.println("B 的关门方式");
    }
}

public class DoorDemo implements DoorOperatorA, DoorOperatorB {
    // 1、两个接口的抽象方法同名同参，且返回类型兼容，实现一次即可同时满足两个接口。
    @Override
    public void open() {
        System.out.println("统一的开门方式，同时实现两个接口的 open()");
    }

    // 2、两个没有继承关系的接口提供了同名同参的默认方法，必须重写来解决冲突。
    // 如果删掉这个 close() 方法，编译器就会报错，因为无法决定使用哪个默认实现。
    @Override
    public void close() {
        // 可以选择 A 的默认实现；也可以改成 DoorOperatorB.super.close()。
        // 还可以不调用接口的默认实现，直接在这里编写自己的关门逻辑。
        DoorOperatorA.super.close();
    }

    public static void main(String[] args) {
        DoorDemo door = new DoorDemo();
        DoorOperatorA operatorA = door;
        DoorOperatorB operatorB = door;

        // 两个接口引用指向同一个对象，调用的是同一个 open() 实现。
        operatorA.open();
        operatorB.open();

        // 两个接口引用调用的都是类重写后的 close()，本例中选择了 A 的默认实现。
        operatorA.close();
        operatorB.close();
    }
}
