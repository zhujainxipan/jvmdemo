package com.ht.jvm.Chaptere7;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by annuoaichengzhang on 16/4/1.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw  new ClassNotFoundException(name);
                }
            }
        };


        Object obj = myClassLoader.loadClass("com.ht.jvm.Chaptere7.Test1").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.ht.jvm.Chaptere7.Test1);
    }
}
