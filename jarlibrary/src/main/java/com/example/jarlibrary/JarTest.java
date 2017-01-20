package com.example.jarlibrary;

/**
 * Created by ${邱伟中} on 2017/1/20 0020.上午 10:30
 */
public class JarTest {

    public static JarTest getInstance() {
        return new JarTest();
    }

    public String getString() {
        return "这是一个生成jar包的测试";
    }
}
