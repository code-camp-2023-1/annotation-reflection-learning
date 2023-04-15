package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionInMethodDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;

        // 获取该类以及其父类(superclasses)的所有public方法
        Method[] methods = birdClass.getMethods();
        for (Method m : methods) {
            System.out.println("Public method: " + m);
            // 注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Public method annotation: " + annotation);
                System.out.println(annotation.annotationType());
            }

            // 方法信息
            System.out.println("Public method name: " + m.getName());
            System.out.println("Public method return type: " + m.getReturnType());

            Parameter[] parameters = m.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Public method parameter: " + parameter);
            }

            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class exType : exceptionTypes) {
                System.out.println("public ex type: " + exType);
            }
            System.out.println("Public method modifier: " + Modifier.toString(m.getModifiers()));



        }

        // 获取该类的所有方法
        Method[] classMethods = birdClass.getDeclaredMethods();
        for (Method m : classMethods) {
            System.out.println("Method: " + m);
            // 注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Method annotation: " + annotation);
                if (annotation instanceof Markable) {
                    Markable markableAnnotation = (Markable) annotation;
                    System.out.println("Markable value: " + markableAnnotation.value());
                }
                System.out.println(annotation.annotationType());
            }

            // 方法信息
            System.out.println("Method name: " + m.getName());
            System.out.println("Method return type: " + m.getReturnType());

            Parameter[] parameters = m.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method parameter: " + parameter);
            }

            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class exType : exceptionTypes) {
                System.out.println("Ex type: " + exType);
            }
            System.out.println("Method modifier: " + Modifier.toString(m.getModifiers()));



        }
    }
}
