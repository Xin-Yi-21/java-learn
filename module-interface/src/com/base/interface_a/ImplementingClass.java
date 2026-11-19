package com.base.interface_a;

// 类通过 implements 实现接口。
// 非抽象实现类必须实现所有尚未实现的抽象方法，否则也必须声明为 abstract。
public class ImplementingClass implements ExampleInterface {
    // 接口抽象方法隐含 public，实现时不能缩小访问权限，必须写 public。
    @Override
    public void abstractInstanceMethod() {
        System.out.println("实现类的实例方法：补全接口的抽象实例方法");
    }

    // 不重写 defaultInstanceMethod()，直接使用接口的默认实现。

    // 对比：普通类可以直接声明有方法体的实例方法，不需要 default。
    public void classInstanceMethod() {
        System.out.println("类自己的实例方法：不需要 default");
    }
}
