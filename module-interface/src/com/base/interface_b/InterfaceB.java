package com.base.interface_b;

public interface InterfaceB {
    void abstractInstanceMethod();

    default void defaultInstanceMethod() {
        System.out.println("接口 B 的默认实例方法");
    }
}
