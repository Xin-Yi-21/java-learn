package com.base.extends_b;

// super案例
public class Test {
    public static void main(String[] args) {
        System.out.println("【1、super(...)：调用父类构造方法】");
        Son son = new Son();
        // 父类构造方法：收到参数 父类的 name 字段
        // 子类构造方法：父类构造方法执行完，再执行这里

        System.out.println("\n【2、super.字段：访问父类字段】");
        son.showNames();
        // this.name  -> 子类的 name 字段
        // super.name -> 父类的 name 字段

        System.out.println("\n【3、super.方法()：调用父类实现】");
        son.show();
        // 父类 show()：父类的实现
        // 子类 show()：子类增加的逻辑
    }
}
