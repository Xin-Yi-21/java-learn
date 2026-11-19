package com.base.polymorphism_a;

// 按顺序运行，观察同一种 Animal 引用如何调用不同对象的方法。
public class Test {
    public static void main(String[] args) {
        System.out.println("【1、父类引用指向子类对象】");
        // 左边是引用的声明类型，右边创建实际对象，这也是自动向上转型。
        Animal animal = new Dog();
        animal.sound(); // 狗叫：汪汪

        // 改变同一个变量指向的对象，接下来的方法调用就执行 Cat 的实现。
        animal = new Cat();
        animal.sound(); // 猫叫：喵喵

        System.out.println("\n【2、同一个参数接收不同的子类对象】");
        makeSound(new Dog()); // 狗叫：汪汪
        makeSound(new Cat()); // 猫叫：喵喵

        System.out.println("\n【3、父类数组统一存放不同子类对象】");
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal item : animals) {
            item.sound(); // 分别输出狗叫、猫叫。
        }

        System.out.println("\n【4、编译看声明类型，重写的实例方法运行看实际对象】");
        Dog dog = new Dog();
        Animal dogRef = dog; // 两个引用指向同一个 Dog 对象。
        dogRef.sound(); // Animal 声明了 sound()，实际调用 Dog.sound()。
        // dogRef.guard(); // 编译报错：Animal 中没有 guard()。
        System.out.println("dog.type -> " + dog.type);       // 狗
        System.out.println("dogRef.type -> " + dogRef.type); // 动物
        // 字段看引用的声明类型；静态方法在编译时确定，建议通过类名调用。
        // 重载也在编译时选择，区别于这里演示的方法重写。

        System.out.println("\n【5、先判断实际类型，再向下转型】");
        if (dogRef instanceof Dog) {
            Dog originalDog = (Dog) dogRef;
            originalDog.guard(); // 狗在看家
            System.out.println("转型前后是同一个对象 -> " + (originalDog == dog)); // true
        }

        Animal catRef = new Cat();
        System.out.println("猫对象能转为 Dog -> " + (catRef instanceof Dog)); // false
        // Dog wrong = (Dog) catRef; // 编译通过，运行会抛出 ClassCastException。
        if (catRef instanceof Cat) {
            Cat cat = (Cat) catRef;
            cat.catchMouse(); // 猫在抓老鼠
        }
        // instanceof 对 null 的判断结果为 false。
    }

    public static void makeSound(Animal animal) {
        // 形参统一写 Animal，调用哪个实现由传入的实际对象决定。
        animal.sound();
    }
}
