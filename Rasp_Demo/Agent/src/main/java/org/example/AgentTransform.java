package org.example;

/**
 * @author gk0d
 */
import org.objectweb.asm.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
public class AgentTransform implements ClassFileTransformer {

    /**
     * @param loader
     * @param className
     * @param classBeingRedefined
     * @param protectionDomain
     * @param classfileBuffer
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        className = className.replace("/", ".");

        try {
            if (className.contains("ProcessBuilder")) {
                System.out.println("Load class: " + className);

                ClassReader classReader  = new ClassReader(classfileBuffer);
                ClassWriter  classWriter  = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
                ClassVisitor classVisitor = new TestClassVisitor(classWriter);

                classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES);

                classfileBuffer = classWriter.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classfileBuffer;
    }

}

