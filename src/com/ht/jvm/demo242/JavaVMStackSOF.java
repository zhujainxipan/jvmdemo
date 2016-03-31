package com.ht.jvm.demo242;

/**
 * Created by annuoaichengzhang on 16/3/31.
 * 2.4.2虚拟机栈和本地方法栈OOM测试
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF com = new JavaVMStackSOF();
        try {
            com.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + com.stackLength);
            throw e;
        }
    }

}
