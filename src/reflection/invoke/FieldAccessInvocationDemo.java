package reflection.invoke;

import java.lang.reflect.Field;

public class FieldAccessInvocationDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);

        // 需求：获取age字段，将age更改为60
        try {
            Field ageField = person.getClass().getDeclaredField("age");
            //将访问权限设为true
            ageField.setAccessible(true);
            // set属性
            ageField.set(person, 60);

            Field nameField = person.getClass().getField("name");
            nameField.set(person, "xiaoming");

            System.out.println("Person after reflection: " + person);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
