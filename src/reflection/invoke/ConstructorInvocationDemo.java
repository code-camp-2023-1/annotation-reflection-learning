package reflection.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorInvocationDemo {
    public static void main(String[] args) {
        // 动态调用构造器初始化对象
        Class<Person> personClazz = Person.class;
        try {
            // 获取对应要调用的构造器
            Constructor<Person> constructor = personClazz.getDeclaredConstructor(String.class, int.class);
            // 设置可访问性为true
            constructor.setAccessible(true);
            // 利用newInstance初始化对象，注意参数需要和构造器传入参数对应
            Person person = constructor.newInstance("ZHANGSAN", 1000);

            System.out.println(person);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
