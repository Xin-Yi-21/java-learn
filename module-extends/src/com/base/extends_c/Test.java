package com.base.extends_c;

// 抽象案例
public class Test {
    public static void main(String[] args) {
        // Father father = new Father(); // 编译错误：抽象类不能直接创建对象。

        // 创建的是具体子类对象，抽象父类可以作为引用类型。
        Father father = new Son();

        System.out.println("【1、普通方法：继承父类已有实现】");
        father.commonMethod();
        // 输出：父类的普通方法：子类直接继承使用

        System.out.println("\n【2、抽象方法：执行子类提供的实现】");
        father.show();
        // 输出：子类的 show()：实现父类规定的抽象方法
    }
}
