package com.base.polymorphism_a;

public class Test {
    public static void main(String[] args) {
        // 1、父类引用指向子类对象
        // 声明类型决定调用
        Animal animal = new Dog();
        animal.sound(); // 狗叫：汪汪
        // animal.guard(); // 编译报错，只有 Dog 声明了 guard()

        // 改变指向
        animal = new Cat();
        animal.sound(); // 猫叫：喵喵


        // 2、声明父类类型 ，子类对象作为：参数、数组成员、返回值
        // (1) 作为参数，一个方法服务于多个对象
        makeSound(new Dog()); // 狗叫：汪汪
        makeSound(new Cat()); // 猫叫：喵喵

        // (2) 作为数组成员，统一管理遍历多个对象
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal item : animals) {
            item.sound(); // 分别输出狗叫、猫叫。
        }
        // (3) 作为返回值：同一个方法按条件返回不同子类对象，调用者统一用 Animal 接收。
        Animal adoptedDog = adopt(true); // true 表示想领养狗，返回的是 Dog 对象的引用。
        Animal adoptedCat = adopt(false); // false 表示想领养猫，返回的是 Cat 对象的引用。
        adoptedDog.sound(); // 狗叫：汪汪，执行实际对象 Dog 的实现。
        adoptedCat.sound(); // 猫叫：喵喵，执行实际对象 Cat 的实现。


        // 3、向上转型和向下转型
        // 向上转型，自动完成
        Dog dog = new Dog();
        Animal animalForCast = dog; // Dog -> Animal，不需要写 (Animal)。
        animalForCast.sound(); // 狗叫：汪汪，实际对象仍然是 Dog。
        // animalForCast.guard(); // 编译错误：Animal 中没有声明 guard()。

        // 向下转型，显示声明
        // Dog restoredDog = animalForCast; // 编译错误：需要显式写出 (Dog)。
        Dog restoredDog = (Dog) animalForCast; // 当前实际对象是 Dog，因此转型成功。
        restoredDog.guard(); // 狗在看家
        System.out.println("向下转型后仍是原来的狗 -> " + (restoredDog == dog)); // true


        System.out.println("\n【3-3、使用场景：参数统一接收 Animal，再按实际类型处理】");
        performAction(new Dog()); // 狗叫：汪汪；狗在看家
        performAction(new Cat()); // 猫叫：喵喵；猫在抓老鼠
        // 传参时发生向上转型；方法内部判断类型后再向下转型。

        System.out.println("\n【3-4、错误转型：实际是猫，不能强转为狗】");
        Animal catAnimal = new Cat();
        System.out.println("catAnimal instanceof Dog -> " + (catAnimal instanceof Dog)); // false
        try {
            // Animal 与 Dog 存在继承关系，编译允许；运行时检查实际对象，发现是 Cat。
            Dog wrongDog = (Dog) catAnimal;
            wrongDog.guard();
        } catch (ClassCastException exception) {
            // 为了让演示继续运行，这里捕获异常；正常使用时先做 instanceof 判断。
            System.out.println("捕获 ClassCastException：猫对象无法转为 Dog");
        }

        System.out.println("\n【3-5、父类引用重新赋值后，要重新判断实际类型】");
        Animal current = new Dog();
        current = new Cat(); // 此时指向猫对象，后续不能再按狗处理。
        if (current instanceof Cat) {
            Cat cat = (Cat) current;
            cat.catchMouse(); // 猫在抓老鼠
        }

        System.out.println("\n【3-6、null 的判断与转型】");
        Animal emptyAnimal = null;
        System.out.println("null instanceof Dog -> " + (emptyAnimal instanceof Dog)); // false
        Dog emptyDog = (Dog) emptyAnimal; // null 可以转型，结果仍是 null。
        System.out.println("转型结果仍为 null -> " + (emptyDog == null)); // true
        // emptyDog.guard(); // 此时调用实例方法会抛出 NullPointerException。
    }

    public static void makeSound(Animal animal) {
        animal.sound();
    }

    // 声明返回类型为 Animal，允许返回 Dog 或 Cat；返回时自动向上转型。
    public static Animal adopt(boolean wantDog) {
        if (wantDog) {
            return new Dog(); // 返回狗对象的引用，不会把狗对象变成另一个 Animal 对象。
        }
        return new Cat();
    }

    public static void performAction(Animal animal) {
        animal.sound(); // 共同的行为，通过多态直接调用。

        // Java 8 写法：先判断，再显式转型，最后调用子类特有的方法。
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.guard();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }
}
