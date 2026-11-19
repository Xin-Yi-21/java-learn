package com.base.extends_b;

public class Son extends Father {
    // 与父类字段同名，隐藏父类的 name；两个字段都存在。
    public String name = "子类的 name 字段";

    public Son() {
        // 1、super(...)：调用父类构造方法，传入父类 name 字段的初始值。
        // Java 8 中，必须写在构造方法的第一句。
        super("父类的 name 字段");
        System.out.println("子类构造方法：父类构造方法执行完，再执行这里");
    }

    public void showNames() {
        // 2、super.字段：明确访问父类被隐藏的字段。
        System.out.println("this.name  -> " + this.name);  // 子类的 name 字段
        System.out.println("super.name -> " + super.name); // 父类的 name 字段
    }

    @Override
    public void show() {
        // 3、super.方法()：明确调用父类实现，再添加子类自己的行为。
        super.show();
        System.out.println("子类 show()：子类增加的逻辑");
        // 不能在这里改成 this.show()，否则会反复调用当前方法，造成无限递归。
    }
}
