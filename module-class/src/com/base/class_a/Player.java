package com.base.class_a;

// 类：定义对象具有哪些数据（字段），以及可以执行哪些操作（方法）。
public class Player {
    // 1、实例字段：声明在类中、方法外，不加 static，每个对象各有一份。
    // 没有显式初始化时，引用类型默认 null，int 默认 0，boolean 默认 false。
    public String name;
    public int score;
    public boolean active;

    // 2、静态字段（类变量）：加 static，属于类；本例的所有 Player 对象共享一份。
    // int 默认值为 0，不需要先创建对象就可以通过 Player.playerCount 访问。
    public static int playerCount;

    // 3、构造方法：与类同名，没有返回类型，连 void 也不能写。
    // new Player(...) 时调用，用于初始化新对象；不是普通实例方法。
    // 构造方法不能继承、不能重写；子类可以通过 super(...) 调用父类构造方法。
    public Player(String name) {
        // this 表示当前对象；左边是当前对象的字段，右边是构造方法的参数。
        this.name = name;
        playerCount++;
        // 没有给 score 和 active 赋值，它们保留默认值。
    }

    // 4、实例方法：通过对象调用，操作当前对象的数据，可以使用 this。
    public void rename(String newName) {
        this.name = newName;
    }

    // 5、静态方法：通过类名调用，没有当前对象 this。
    public static int getPlayerCount() {
        return playerCount;
        // 这里不能直接使用 this.name 或直接访问实例字段 name。
    }

    // 6、成员类型：类体中也可以声明类和接口；这里只认识声明位置。
    // 它们是类型声明，不是字段，也不会自动创建对象，具体用法以后单独学习。
    public static class MemberClass {
    }

    public interface MemberInterface {
    }

    // 生命周期笔记：
    // 实例字段随对象存在，对象在堆中分配；对象不再可达后才有机会被垃圾回收。
    // 静态字段由 JVM 随类管理，具体存储位置取决于 JVM 实现。
    // 类准备阶段为静态字段分配存储并赋默认值，显式初始化通常在类初始化阶段执行。
    // 本例 playerCount 统计构造方法执行次数，不代表当前还存活的对象数量。
}
