package com.base.extends_a;

// 抽象类可以没有抽象方法。即便如此，也不能直接 new Animal(...)。
public abstract class Animal {
    public final String category = "动物";
    protected String role = "动物";
    protected String species = "哺乳动物";
    String home = "家庭"; // 包访问权限，供同包的 Pet 直接访问。
    private String name;

    protected Animal(String name) {
        setName(name);
        System.out.println("Animal 构造：" + getName());
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    protected String describe() {
        return formatName();
    }

    private String formatName() {
        // 私有方法没有被继承，由 Animal 自己调用。
        return "名字：" + name;
    }

    public static String kingdom() {
        // 可访问的静态方法可以被子类继承，同签名声明属于隐藏。
        return "动物界";
    }
}
