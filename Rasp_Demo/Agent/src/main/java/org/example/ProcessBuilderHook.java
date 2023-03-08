package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gk0d
 */
public class ProcessBuilderHook {

    public static boolean start(List<String> commands) {
        String[] commandArr = commands.toArray(new String[commands.size()]);
        System.out.println(Arrays.toString(commandArr));
        ClassUtils.printStackTrace();
        return false;

    }
}
