package com.base.extends_b;

public class Father {
    public String name;

    public Father(String name) {
        this.name = name;
        System.out.println("父类构造方法：收到参数 " + name);
    }

    public void show() {
        System.out.println("父类 show()：父类的实现");
    }
}
