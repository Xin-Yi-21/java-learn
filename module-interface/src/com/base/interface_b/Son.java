package com.base.interface_b;

// 3、类可以同时继承父类、实现多个接口。extends 在前，implements 在后。
// 类只能直接继承一个父类，但可以实现多个接口。
public class Son extends Father implements InterfaceB, InterfaceC {
    @Override
    public void abstractInstanceMethod() {
        System.out.println("子类：一次实现，同时满足 B、C 的抽象要求");
    }

    @Override
    public void defaultInstanceMethod() {
        System.out.println("子类：重写默认方法，使用自己编写的实现");
        // 解决冲突不要求一定调用接口的默认实现，完全自己实现也可以。
    }
}
