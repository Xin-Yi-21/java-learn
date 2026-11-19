package com.base.interface_b;

// 实现子接口 A，也就需要满足它继承的 B、C 的要求。
public class CombinedInterfaceImpl implements InterfaceA {
    @Override
    public void abstractInstanceMethod() {
        System.out.println("组合接口实现类：一次实现，同时满足 B、C 的抽象要求");
    }

    // 默认方法的冲突已经由子接口 A 解决，这里直接使用 A 的实现。
}
