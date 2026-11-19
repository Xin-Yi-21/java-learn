package com.base.polymorphism_a;

public class Dog extends Animal {
    // 同名字段属于隐藏，访问哪个字段由引用的声明类型决定。
    public String type = "狗";

    @Override
    public void sound() {
        System.out.println("狗叫：汪汪");
    }

    public void guard() {
        System.out.println("狗在看家");
    }
}
