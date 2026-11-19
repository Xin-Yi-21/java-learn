package com.base.polymorphism_a;

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("猫叫：喵喵");
    }

    public void catchMouse() {
        System.out.println("猫在抓老鼠");
    }
}
