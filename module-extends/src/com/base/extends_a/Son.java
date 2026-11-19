package com.base.extends_a;

public class Son extends Father {
    // 同名字段属于隐藏，静态字段和实例字段都是如此。
    public static String staticField = "子类的静态字段";
    public String instanceField = "子类的实例字段";

    // 同签名静态方法属于隐藏。
    public static String staticMethod() {
        return "子类的静态方法";
    }

    // 同签名实例方法属于重写。
    @Override
    public String instanceMethod() {
        return "子类的实例方法";
    }
}
