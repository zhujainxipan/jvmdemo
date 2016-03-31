package com.ht.jvm.demo242;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.StringHolder;

import java.util.ArrayList;

/**
 * Created by annuoaichengzhang on 16/3/31.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
