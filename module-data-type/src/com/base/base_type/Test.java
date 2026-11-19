package com.base.base_type;

public class Test {
    public static void main(String[] args) {
        System.out.println("【1、八种基本类型：声明与赋值】");
        byte byteValue = 10;       // 8 位有符号整数：-128 到 127
        short shortValue = 1000;  // 16 位有符号整数：-32768 到 32767
        int intValue = 100000;    // 32 位有符号整数，整数常用类型
        long longValue = 3000000000L; // 64 位有符号整数，使用 L 表示 long 字面量
        float floatValue = 1.5F;  // 32 位浮点数，使用 F 表示 float 字面量
        double doubleValue = 2.5; // 64 位浮点数，小数字面量默认是 double
        char charValue = 'A';     // 16 位无符号值，一个 UTF-16 代码单元，使用单引号
        boolean booleanValue = true; // 只有 true、false，不能用 0、1 代替
        System.out.println("byte -> " + byteValue);       // 10
        System.out.println("short -> " + shortValue);     // 1000
        System.out.println("int -> " + intValue);         // 100000
        System.out.println("long -> " + longValue);       // 3000000000
        System.out.println("float -> " + floatValue);     // 1.5
        System.out.println("double -> " + doubleValue);   // 2.5
        System.out.println("char -> " + charValue);       // A
        System.out.println("boolean -> " + booleanValue); // true
        // String text = "A"; // String 是引用类型，不是基本类型；双引号表示字符串。

        System.out.println("\n【2、基本类型字段的默认值】");
        DefaultValueFields fields = new DefaultValueFields();
        System.out.println("byte 默认值 -> " + fields.byteField);       // 0
        System.out.println("short 默认值 -> " + fields.shortField);     // 0
        System.out.println("int 默认值 -> " + fields.intField);         // 0
        System.out.println("long 默认值 -> " + fields.longField);       // 0
        System.out.println("float 默认值 -> " + fields.floatField);     // 0.0
        System.out.println("double 默认值 -> " + fields.doubleField);   // 0.0
        // 空字符直接输出不可见，转成 int 观察编码值；不是空格，也不是字符 '0'。
        System.out.println("char 默认值的编码 -> " + (int) fields.charField); // 0
        System.out.println("boolean 默认值 -> " + fields.booleanField); // false
        int localValue;
        // System.out.println(localValue); // 编译错误：局部变量使用前必须赋值。
        localValue = 10;
        System.out.println("赋值后的局部变量 -> " + localValue); // 10

        System.out.println("\n【3、类型转换：自动转换与强制转换】");
        int sourceInt = 10;
        long widenedLong = sourceInt; // int -> long，自动拓宽转换
        double widenedDouble = sourceInt; // int -> double，自动转换
        System.out.println("int 自动转 long -> " + widenedLong);     // 10
        System.out.println("int 自动转 double -> " + widenedDouble); // 10.0
        double sourceDouble = 3.9;
        int narrowedInt = (int) sourceDouble; // 强制转换，丢掉小数部分，不是四舍五入
        System.out.println("double 强制转 int -> " + narrowedInt); // 3
        int outOfByteRange = 128;
        System.out.println("128 强制转 byte -> " + (byte) outOfByteRange); // -128，超范围导致值改变
        System.out.println("char A 的编码 -> " + (int) charValue); // 65
        // boolean 不参与数字类型转换。
        // 自动转换也不代表永远没有精度损失，例如较大的 long 转 float。

        System.out.println("\n【4、运算：整数除法与数值提升】");
        System.out.println("5 / 2 -> " + (5 / 2));     // 2，两个整数相除得到整数
        System.out.println("5 / 2.0 -> " + (5 / 2.0)); // 2.5，有 double 参与
        byte firstByte = 10;
        byte secondByte = 20;
        int sum = firstByte + secondByte; // byte、short、char 参与这种加法时提升为 int
        System.out.println("byte + byte 得到 int -> " + sum); // 30
        System.out.println("0.1 + 0.2 -> " + (0.1 + 0.2)); // 0.30000000000000004，二进制浮点精度限制

        System.out.println("\n【5、基本类型赋值：复制值，修改后互不影响】");
        int original = 10;
        int copied = original;
        copied = 20;
        System.out.println("original -> " + original); // 10
        System.out.println("copied -> " + copied);     // 20
    }
}
