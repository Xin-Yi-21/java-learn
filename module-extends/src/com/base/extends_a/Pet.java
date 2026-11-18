package com.base.extends_a;

public abstract class Pet extends Animal {
    protected Pet(String name) {
        super(name); // Animal 没有无参构造，必须传入名字。
        System.out.println("Pet 构造：" + getName());
    }

    public String homeDescription() {
        return "居住地：" + home; // Pet 和 Animal 在同一个包。
    }

    // 抽象方法留给子类实现，不能加 private、static 或 final。
    public abstract String sound();

    public abstract Pet companion();
}
