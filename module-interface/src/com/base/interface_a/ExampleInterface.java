package com.base.interface_a;

// 接口体的组成：成员声明（常量字段、方法、成员类型）。
// 接口没有构造方法、实例字段、实例初始化块或静态初始化块。
public interface ExampleInterface {
    // 1、静态字段：隐含 public static final，必须初始化，不能二次赋值。
    int CONSTANT_FIELD = 1;

    // 2、抽象实例方法：隐含 public abstract，没有方法体。
    void abstractInstanceMethod();

    // 3、默认实例方法：default，隐含 public，有方法体。
    // 默认方法就是实例方法，通过对象调用，实现类可以直接使用或重写。
    default void defaultInstanceMethod() {
        System.out.println("接口的默认实例方法：接口提供的实现");
    }

    // 4、静态方法：隐含 public，通过声明它的接口名调用。
    static void staticMethod() {
        System.out.println("接口的静态方法：通过接口名调用");
    }

}
