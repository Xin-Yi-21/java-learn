package com.base.interface_a;

public class Test {
    public static void main(String[] args) {
        System.out.println("【1、常量字段：隐含 public static final】");
        System.out.println("ExampleInterface.CONSTANT_FIELD -> " + ExampleInterface.CONSTANT_FIELD); // 1
        // ExampleInterface.CONSTANT_FIELD = 2; // 错误：不能再次赋值。

        // 创建实现类对象，不是创建接口对象。也可以写 ImplementingClass 类型的引用。
        ExampleInterface interfaceRef = new ImplementingClass();
        // new ExampleInterface(); // 错误：接口不能直接创建对象，也没有构造方法。

        System.out.println("\n【2、抽象实例方法：执行实现类补全的方法体】");
        interfaceRef.abstractInstanceMethod();
        // 实现类的实例方法：补全接口的抽象实例方法

        System.out.println("\n【3、默认实例方法：实现类不重写，直接使用接口实现】");
        interfaceRef.defaultInstanceMethod();
        // 接口的默认实例方法：接口提供的实现

        System.out.println("\n【4、默认实例方法：实现类重写，执行自己的实现】");
        ExampleInterface overridingRef = new OverridingClass();
        overridingRef.defaultInstanceMethod();
        // 实现类重写的默认实例方法：使用实现类自己的实现

        System.out.println("\n【5、静态方法：通过声明它的接口名调用】");
        ExampleInterface.staticMethod();
        // 接口的静态方法：通过接口名调用
        // ImplementingClass.staticMethod(); // 错误：实现类没有继承接口静态方法。
        // interfaceRef.staticMethod();      // 错误：接口静态方法不能通过对象调用。

        System.out.println("\n【6、类的普通实例方法：声明时不需要 default】");
        ImplementingClass classRef = new ImplementingClass();
        classRef.classInstanceMethod();
        // 类自己的实例方法：不需要 default
        // interfaceRef.classInstanceMethod(); // 错误：接口类型没有声明这个方法。
    }
}
