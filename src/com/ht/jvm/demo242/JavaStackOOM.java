package com.ht.jvm.demo242;

/**
 * Created by annuoaichengzhang on 16/3/31.
 * 创建线程导致内存溢出异常
 */
public class JavaStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }


    public static void main(String[] args) {
        JavaStackOOM oom = new JavaStackOOM();
        oom.stackLeakByThread();
    }
}
