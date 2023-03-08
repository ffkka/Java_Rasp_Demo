package org.example;

/**
 * @author gk0d
 */
public class ClassUtils {

    /**
     * 打印调用链信息
     */
    public static void printStackTrace() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();

        for (StackTraceElement element : elements) {
            System.err.println(element);
        }

        System.err.println("--------------------------------------------------------------------------");
    }

}
