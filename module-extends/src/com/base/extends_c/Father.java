package com.base.extends_c;

// 抽象类：可以包含抽象方法，也可以包含已经实现的普通方法。
// 有抽象方法就必须声明为抽象类；抽象类也可以没有抽象方法。
public abstract class Father {
    // 抽象方法：只声明要求，不提供方法体，用分号结束。
    // 留给子类重写，不能加 private、static 或 final。
    public abstract void show();

    // 普通方法：公共行为已经实现，子类可以直接继承使用。
    public void commonMethod() {
        System.out.println("父类的普通方法：子类直接继承使用");
    }
}
