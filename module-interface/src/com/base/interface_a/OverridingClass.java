package com.base.interface_a;

// 第二个实现类：对比默认方法“可以直接使用，也可以重写”。
public class OverridingClass implements ExampleInterface {
    @Override
    public void abstractInstanceMethod() {
        System.out.println("重写默认方法的实现类：同样需要补全抽象实例方法");
    }

    @Override
    public void defaultInstanceMethod() {
        System.out.println("实现类重写的默认实例方法：使用实现类自己的实现");
    }
}
