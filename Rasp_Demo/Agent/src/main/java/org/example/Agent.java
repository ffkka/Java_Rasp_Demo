package org.example;


import java.lang.instrument.Instrumentation;
/**
 * @author gk0d
 */
public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new AgentTransform());
    }
}