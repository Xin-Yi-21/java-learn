package com.base.interface_b;

// 接口与类：
// 1、接口继承多接口：InterfaceA extends InterfaceB, InterfaceC。
// 2、实现类实现多接口：InterfaceImpl implements InterfaceB, InterfaceC。
//    抽象方法，相同要求，实现一次（返回类型必须兼容）。
//    默认方法，不同接口的同签名实现发生冲突时，重写决定。
// 3、实现类可同时继承和实现：Son extends Father implements InterfaceB, InterfaceC。
public class Test {
    public static void main(String[] args) {
        System.out.println("【1、接口继承多个接口】");
        CombinedInterfaceImpl combined = new CombinedInterfaceImpl();
        combined.abstractInstanceMethod();
        // 组合接口实现类：一次实现，同时满足 B、C 的抽象要求
        combined.defaultInstanceMethod();
        // 子接口 A 的默认方法：解决父接口冲突，选择 B
        // 接口 B 的默认实例方法

        System.out.println("\n【2、类直接实现多个接口：相同抽象方法只实现一次】");
        InterfaceImpl impl = new InterfaceImpl();
        InterfaceB b = impl;
        InterfaceC c = impl; // 与 b 指向同一个对象。
        b.abstractInstanceMethod();
        c.abstractInstanceMethod();
        // 两次都输出：多接口实现类：一次实现，同时满足 B、C 的抽象要求

        System.out.println("\n【3、类直接实现多个接口：默认方法冲突，重写决定】");
        impl.defaultInstanceMethod();
        // 多接口实现类：重写默认方法，选择 C
        // 接口 C 的默认实例方法

        System.out.println("\n【4、类同时继承父类、实现多个接口】");
        Son son = new Son();
        son.parentInstanceMethod();   // 父类的实例方法：由子类继承
        son.abstractInstanceMethod(); // 子类：一次实现，同时满足 B、C 的抽象要求
        son.defaultInstanceMethod();  // 子类：重写默认方法，使用自己编写的实现
    }
}
