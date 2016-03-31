package com.ht.jvm.demo241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annuoaichengzhang on 16/3/31.
 * JAVA堆内存溢出异常测试
 */
public class HeapOOM {

    static class OOMobject {

    }

    public static void main(String[] args) {
        List<OOMobject> list = new ArrayList<OOMobject>();
        while (true) {
            list.add(new OOMobject());
        }
    }
}
