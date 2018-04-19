package com.androidaddicts.javabase.constructor;

/**
 * @author feilang-liuyansong
 * @date 2018/4/18 11:09
 * @description
 */

/**

 A 的静态代码块
 B 的静态代码块
 A 的构造代码块
 A 的构造方法
 B 的构造代码块
 B 的构造方法

 */
public class ExtendsRun {
    public static void main(String[] args) {
        new B();
    }

}

class A {
    static {
        System.out.println("A 的静态代码块");
    }

    {
        System.out.println("A 的构造代码块");
    }

    A(){
        System.out.println("A 的构造方法");
    }
}

class B extends A{
    static {
        System.out.println("B 的静态代码块");
    }

    {
        System.out.println("B 的构造代码块");
    }

    B(){
        System.out.println("B 的构造方法");
    }
}
