package com.base.extends_a;

//
public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        Father fatherRef = son; // 和 son 指向同一个对象，只是引用的声明类型不同。

        // 为了对比规则，这里故意通过引用访问静态成员。
        // 平时建议通过类名访问，例如 Father.staticField、Son.staticMethod()。
        System.out.println("【1、静态字段：看引用的声明类型】");
        System.out.println("father.staticField    -> " + father.staticField);    // 父类的静态字段
        System.out.println("son.staticField       -> " + son.staticField);       // 子类的静态字段
        System.out.println("fatherRef.staticField -> " + fatherRef.staticField); // 父类的静态字段

        System.out.println("\n【2、实例字段：也看引用的声明类型】");
        System.out.println("father.instanceField    -> " + father.instanceField);    // 父类的实例字段
        System.out.println("son.instanceField       -> " + son.instanceField);       // 子类的实例字段
        System.out.println("fatherRef.instanceField -> " + fatherRef.instanceField); // 父类的实例字段

        System.out.println("\n【3、静态方法：看引用的声明类型】");
        System.out.println("father.staticMethod()    -> " + father.staticMethod());    // 父类的静态方法
        System.out.println("son.staticMethod()       -> " + son.staticMethod());       // 子类的静态方法
        System.out.println("fatherRef.staticMethod() -> " + fatherRef.staticMethod()); // 父类的静态方法

        System.out.println("\n【4、实例方法：重写后，看对象的实际类型】");
        System.out.println("father.instanceMethod()    -> " + father.instanceMethod());    // 父类的实例方法
        System.out.println("son.instanceMethod()       -> " + son.instanceMethod());       // 子类的实例方法
        System.out.println("fatherRef.instanceMethod() -> " + fatherRef.instanceMethod()); // 子类的实例方法
    }
}
