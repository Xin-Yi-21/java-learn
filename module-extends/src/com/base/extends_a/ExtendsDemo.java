package com.base.extends_a;

public class ExtendsDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("旺财"); // 通过 Animal 的 public 方法修改其 private 字段。
        System.out.println(dog.describe());
        System.out.println("类别：" + dog.category);
        System.out.println(dog.homeDescription());
        System.out.println("分类：" + Dog.kingdom());
        System.out.println(dog.patrol());

        Pet pet = dog;
        System.out.println("叫声：" + pet.sound()); // 通过父类引用调用，执行 Dog 的实现。
        Dog companion = dog.companion(); // 协变返回值，可以直接赋给 Dog。
        System.out.println("伙伴：" + companion.getName());
        System.out.println("伙伴的物种分类：" + dog.inheritedSpecies(companion));
    }
}
