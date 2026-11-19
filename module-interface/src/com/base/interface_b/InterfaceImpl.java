package com.base.interface_b;

// 2、类可以使用 implements 直接实现多个接口。
public class InterfaceImpl implements InterfaceB, InterfaceC {
    // 抽象方法：相同要求，实现一次。前提是返回类型兼容。
    @Override
    public void abstractInstanceMethod() {
        System.out.println("多接口实现类：一次实现，同时满足 B、C 的抽象要求");
    }

    // 默认方法：两个无继承关系的接口各有实现，必须重写来解决冲突。
    @Override
    public void defaultInstanceMethod() {
        System.out.println("多接口实现类：重写默认方法，选择 C");
        InterfaceC.super.defaultInstanceMethod();
        // 可以改为 InterfaceB.super.defaultInstanceMethod()，或者完全自己写实现。
        // 不能写 InterfaceC.defaultInstanceMethod()：它不是静态方法。
    }
}
