package com.base.array_type;

import java.util.Arrays;

// 数组本身是引用类型，即使元素是 int 等基本类型。
// 同一个数组的元素类型固定、创建后长度固定；引用变量可以改为指向另一个数组。
public class Test {
    public static void main(String[] args) {
        System.out.println("【1、数组的创建方式】");
        int[] defaultArray = new int[3];         // 指定长度，元素使用默认值
        int[] initializedArray = {10, 20, 30};   // 声明时简写初始化
        int[] explicitArray = new int[]{40, 50}; // 完整的带初值写法，不同时指定长度
        // int[] invalid = new int[2]{40, 50}; // 编译错误：不能同时指定长度和元素初值。
        System.out.println("指定长度 -> " + Arrays.toString(defaultArray)); // [0, 0, 0]
        System.out.println("简写初始化 -> " + Arrays.toString(initializedArray)); // [10, 20, 30]
        System.out.println("完整初始化 -> " + Arrays.toString(explicitArray)); // [40, 50]
        // Arrays.toString() 用来查看一维数组元素，直接打印数组引用不会列出元素。

        System.out.println("\n【2、数组元素的默认值】");
        System.out.println("int[] -> " + Arrays.toString(new int[2]));         // [0, 0]
        System.out.println("double[] -> " + Arrays.toString(new double[2]));   // [0.0, 0.0]
        System.out.println("boolean[] -> " + Arrays.toString(new boolean[2])); // [false, false]
        System.out.println("String[] -> " + Arrays.toString(new String[2]));   // [null, null]
        char[] chars = new char[2];
        System.out.println("char 元素默认编码 -> " + (int) chars[0]); // 0，空字符

        System.out.println("\n【3、长度、下标、读取和修改】");
        System.out.println("initializedArray.length -> " + initializedArray.length); // 3，是字段，不是 length()
        System.out.println("下标 0 的元素 -> " + initializedArray[0]); // 10，下标从 0 开始
        initializedArray[1] = 99;
        System.out.println("修改下标 1 后 -> " + Arrays.toString(initializedArray)); // [10, 99, 30]
        // initializedArray[3] = 1; // 运行时数组越界：有效下标为 0 到 length - 1。
        // int[] empty = new int[0]; // 合法，但没有任何有效元素下标。

        System.out.println("\n【4、遍历：普通 for 可以使用下标】");
        for (int index = 0; index < initializedArray.length; index++) {
            System.out.println("下标 " + index + " -> " + initializedArray[index]);
        }
        // 依次输出下标 0 -> 10、下标 1 -> 99、下标 2 -> 30。
        System.out.println("增强 for：依次读取元素");
        for (int element : initializedArray) {
            System.out.println(element); // 依次输出 10、99、30
        }

        System.out.println("\n【5、数组赋值：复制引用，两个变量指向同一个数组】");
        int[] original = {1, 2};
        int[] shared = original;
        shared[0] = 100;
        System.out.println("original -> " + Arrays.toString(original)); // [100, 2]
        System.out.println("shared -> " + Arrays.toString(shared));     // [100, 2]
        System.out.println("original == shared -> " + (original == shared)); // true，比较是否为同一对象

        System.out.println("\n【6、复制基本类型数组：得到独立的新数组】");
        int[] copied = Arrays.copyOf(original, original.length);
        copied[0] = 200;
        System.out.println("original -> " + Arrays.toString(original)); // [100, 2]
        System.out.println("copied -> " + Arrays.toString(copied));     // [200, 2]
        System.out.println("original == copied -> " + (original == copied)); // false
        System.out.println("内容相同比较 -> " + Arrays.equals(original, new int[]{100, 2})); // true
        // 引用类型元素的数组复制只复制元素中的引用，不会自动复制其引用的对象。

        System.out.println("\n【7、二维数组：数组的元素也是数组】");
        int[][] matrix = {{1, 2}, {3, 4, 5}}; // 每个内部数组的长度可以不同
        System.out.println("二维数组 -> " + Arrays.deepToString(matrix)); // [[1, 2], [3, 4, 5]]
        System.out.println("外层长度 -> " + matrix.length);    // 2
        System.out.println("第一个内部数组长度 -> " + matrix[0].length); // 2
        System.out.println("matrix[1][2] -> " + matrix[1][2]); // 5

        // 数组变量也可能为 null，此时访问 length 或元素会抛出 NullPointerException。
        // int[] nullArray = null;
        // System.out.println(nullArray.length);
    }
}
