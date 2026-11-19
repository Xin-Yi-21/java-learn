package com.base.interface_b;

// 1、接口可以使用 extends 继承多个接口。
public interface InterfaceA extends InterfaceB, InterfaceC {
    // 两个父接口的抽象要求相同，不必重复声明 abstractInstanceMethod()。

    // 两个父接口提供了同签名的默认实现，子接口也必须解决这个冲突。
    @Override
    default void defaultInstanceMethod() {
        System.out.println("子接口 A 的默认方法：解决父接口冲突，选择 B");
        InterfaceB.super.defaultInstanceMethod();
    }
}
