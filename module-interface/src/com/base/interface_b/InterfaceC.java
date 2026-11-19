package com.base.interface_b;

public interface InterfaceC {
    // 与接口 B 同名同参、返回类型相同。
    void abstractInstanceMethod();

    default void defaultInstanceMethod() {
        System.out.println("接口 C 的默认实例方法");
    }
}
