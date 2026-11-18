package com.base.extends_a;

// Java 的类只能直接继承一个父类。这里是 Animal → Pet → Dog。
public class Dog extends Pet {
    private final String role = "看家犬";

    public Dog() {
        this("小白"); // this(...) 与 super(...) 都要求在 Java 8 构造方法的第一句。
    }

    public Dog(String name) {
        // 构造方法不能继承或重写。父类初始化完成后才执行下面的打印。
        super(name);
        System.out.println("Dog 构造：" + getName());
    }

    @Override
    public String describe() {
        // 重写可以把 protected 扩大为 public，访问权限不能缩小。
        return super.describe() + "，父类字段：" + super.role + "，子类字段：" + role;
    }

    @Override
    public String sound() {
        return "汪汪";
    }

    @Override
    public Dog companion() {
        // Pet 的引用返回类型可以原样保留，也可以缩小为 Dog。
        return new Dog("小黑");
    }

    public String patrol() {
        return getName() + "在巡逻";
    }

    public String inheritedSpecies(Pet anotherPet) {
        // 同包可以通过 Pet 引用读取 Animal 的 protected 字段。
        return anotherPet.species;
    }
}
