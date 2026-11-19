package com.base.class_a;

// 单独运行 Test，集中观察输出；Player 负责定义字段、方法和构造方法。
public class Test {
    public static void main(String[] args) {
        System.out.println("【1、还没创建对象，也能访问静态字段、调用静态方法】");
        System.out.println("Player.playerCount -> " + Player.playerCount);       // 0
        System.out.println("Player.getPlayerCount() -> " + Player.getPlayerCount()); // 0

        System.out.println("\n【2、new 创建对象，构造方法初始化字段】");
        // Player 是类；new Player(...) 创建对象；player1 是保存对象引用的局部变量。
        // Java 的字符串使用双引号，不能写成 '对象1的 name 字段'。
        Player player1 = new Player("对象1的 name 字段");
        Player player2 = new Player("对象2的 name 字段");
        System.out.println("player1.name -> " + player1.name); // 对象1的 name 字段
        System.out.println("player2.name -> " + player2.name); // 对象2的 name 字段

        System.out.println("\n【3、没有显式赋值的实例字段有默认值】");
        System.out.println("player1.score -> " + player1.score);   // 0
        System.out.println("player1.active -> " + player1.active); // false
        // name 在调用构造方法前默认是 null，随后被构造方法赋值。

        System.out.println("\n【4、实例字段每个对象各有一份】");
        player1.score = 10;
        System.out.println("player1.score -> " + player1.score); // 10
        System.out.println("player2.score -> " + player2.score); // 0，不受影响

        System.out.println("\n【5、实例方法操作当前对象】");
        player1.rename("对象1修改后的 name 字段");
        System.out.println("player1.name -> " + player1.name); // 对象1修改后的 name 字段
        System.out.println("player2.name -> " + player2.name); // 对象2的 name 字段，不受影响

        System.out.println("\n【6、静态字段属于类，所有对象共享一份】");
        System.out.println("Player.playerCount -> " + Player.playerCount); // 2，两次构造都修改同一个计数
        System.out.println("Player.getPlayerCount() -> " + Player.getPlayerCount()); // 2
    }
}
