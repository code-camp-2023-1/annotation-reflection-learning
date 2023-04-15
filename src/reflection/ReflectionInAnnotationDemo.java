package reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionInAnnotationDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;
        Markable markable = birdClass.getAnnotation(Markable.class);

        System.out.println("Get annotation: " + markable);
        System.out.println("Annotation value: " + markable.value());

        //属性上的注解
        try {
            Field field = birdClass.getDeclaredField("age");
            Markable markableInField = field.getAnnotation(Markable.class);
            System.out.println("Get annotation in age field: " + markableInField);
            System.out.println("Annotation value in agefield: " + markableInField.value());

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        Class<Target> targetClass = Target.class;
        Annotation[] annotations = targetClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation in Target: " + annotation);
            if (annotation instanceof Target) {
                Target target = (Target) annotation;
                System.out.println("Target value: " + Arrays.toString(target.value()));
            }
        }

    }
}
