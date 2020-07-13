package com.shijingfeng.base.util;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 用于解决下面代码这种对象创建问题
 * 具体请看: https://wanandroid.com/wenda/show/13785
 *
 * public class Student  {
 *     private Student() {
 *         throw new IllegalArgumentException("can not create.");
 *     }
 *     public String name;
 * }
 *
 * 缺点:
 * 1. 不能直接创建接口对象；
 * 2. 不能直接创建抽象类对象；
 * 3. 会绕过构造方法，初始化的工作，就要自己手动去做
 *
 * 建议:
 * 如果只是私有构造方法，里面并没有抛异常，那么就可以使用反射的方式
 *
 * Date: 2020/7/9 13:19
 * Description:
 *
 * @author ShiJingFeng
 */
public abstract class UnsafeAllocator {

    public abstract <T> T newInstance(Class<T> c) throws Exception;

    public static UnsafeAllocator create() {
        // try JVM
        // public class Unsafe {
        //   public Object allocateInstance(Class<?> type);
        // }
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            final Object unsafe = f.get(null);
            final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            return new UnsafeAllocator() {
                @Override
                @SuppressWarnings("unchecked")
                public <T> T newInstance(Class<T> c) throws Exception {
                    assertInstantiable(c);
                    return (T) allocateInstance.invoke(unsafe, c);
                }
            };
        } catch (Exception ignored) {
        }

        // try dalvikvm, post-gingerbread
        // public class ObjectStreamClass {
        //   private static native int getConstructorId(Class<?> c);
        //   private static native Object newInstance(Class<?> instantiationClass, int methodId);
        // }
        try {
            Method getConstructorId = ObjectStreamClass.class
                    .getDeclaredMethod("getConstructorId", Class.class);
            getConstructorId.setAccessible(true);
            final int constructorId = (Integer) getConstructorId.invoke(null, Object.class);
            final Method newInstance = ObjectStreamClass.class
                    .getDeclaredMethod("newInstance", Class.class, int.class);
            newInstance.setAccessible(true);
            return new UnsafeAllocator() {
                @Override
                @SuppressWarnings("unchecked")
                public <T> T newInstance(Class<T> c) throws Exception {
                    assertInstantiable(c);
                    return (T) newInstance.invoke(null, c, constructorId);
                }
            };
        } catch (Exception ignored) {
        }

        // try dalvikvm, pre-gingerbread
        // public class ObjectInputStream {
        //   private static native Object newInstance(
        //     Class<?> instantiationClass, Class<?> constructorClass);
        // }
        try {
            final Method newInstance = ObjectInputStream.class
                    .getDeclaredMethod("newInstance", Class.class, Class.class);
            newInstance.setAccessible(true);
            return new UnsafeAllocator() {
                @Override
                @SuppressWarnings("unchecked")
                public <T> T newInstance(Class<T> c) throws Exception {
                    assertInstantiable(c);
                    return (T) newInstance.invoke(null, c, Object.class);
                }
            };
        } catch (Exception ignored) {
        }

        // give up
        return new UnsafeAllocator() {
            @Override
            public <T> T newInstance(Class<T> c) {
                throw new UnsupportedOperationException("Cannot allocate " + c);
            }
        };
    }

    /**
     * Check if the class can be instantiated by unsafe allocator. If the instance has interface or abstract modifiers
     * throw an {@link java.lang.UnsupportedOperationException}
     *
     * @param c instance of the class to be checked
     */
    static void assertInstantiable(Class<?> c) {
        int modifiers = c.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + c.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + c.getName());
        }
    }
}

