package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionInFieldDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;

        // 获取所有的自身public属性以及父类的public属性
        Field[] fields = birdClass.getFields();

        for (Field field : fields) {
            System.out.println("Public field: " + field);
            // 变量名
            System.out.println("Field name: " + field.getName());
            // 访问修饰符
            System.out.println("Field modifier: " + Modifier.toString(field.getModifiers()));

            // 数据类型
            System.out.println("Field type: " + field.getType());
        }

        // 获取所有的自身属性
        Field[] classFields = birdClass.getDeclaredFields();

        for (Field field : classFields) {
            System.out.println("Field: " + field);
            // 变量名
            System.out.println("Field name: " + field.getName());
            // 访问修饰符
            System.out.println("Field modifier: " + Modifier.toString(field.getModifiers()));

            // 数据类型
            System.out.println("Field type: " + field.getType());
        }

        try {
            Field ageField = birdClass.getDeclaredField("age");
            System.out.println("age field: " + ageField);
            Field canEatField = birdClass.getField("canEat");
            System.out.println("can eat field: " + canEatField);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
