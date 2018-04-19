package com.androidaddicts.javabase.constructor;

/**
 * @author feilang-liuyansong
 * @date 2018/4/18 11:04
 * @description
 */

public class CodeBlock {
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public CodeBlock() {
        System.out.println("构造方法");
    }

    public void run() {
        System.out.println("方法代码块");
    }
}
