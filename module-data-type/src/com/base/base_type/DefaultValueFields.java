package com.base.base_type;

// 基本类型字段没有显式赋值时，由 JVM 提供默认值。
// 此处使用实例字段观察；静态字段、数组元素也有相应的默认值。
// 方法中的局部变量不同：必须先赋值才能读取。
public class DefaultValueFields {
    public byte byteField;
    public short shortField;
    public int intField;
    public long longField;
    public float floatField;
    public double doubleField;
    public char charField;
    public boolean booleanField;
}
