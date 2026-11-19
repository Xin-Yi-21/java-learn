package com.base.extends_c;

// 非抽象子类必须实现继承来的、尚未实现的所有抽象方法。
// 如果不实现完整，子类也必须声明为 abstract，继续留给后代实现。
public class Son extends Father {
    @Override
    public void show() {
        System.out.println("子类的 show()：实现父类规定的抽象方法");
    }
}
