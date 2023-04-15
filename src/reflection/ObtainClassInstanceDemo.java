package reflection;

/**
 * 如何获取Class类对象
 */
public class ObtainClassInstanceDemo {
    public static void main(String[] args) {
        // 以String类为例

        // 方法1: .class
        Class<String> stringClazz1 = String.class;
        Class<Animal> animalClazz1 = Animal.class;
        System.out.println("String clazz 1: " + stringClazz1);
        System.out.println("Animal clazz 1: " + animalClazz1);

        // 方法2：通过对象的getClass()
        String s = "hello world";
        Animal animal = new Animal("sss");
        Class<? extends String> stringClazz2 = s.getClass();
        Class animalClazz2 = animal.getClass();
        System.out.println("String clazz 2: " + stringClazz2);
        System.out.println("Animal clazz 2: " + animalClazz2);

        // 方法3：Class.forName()
        try {
            Class stringClazz3 = Class.forName("java.lang.String");
            Class animalClazz3 =  Class.forName("reflection.Animal");
            System.out.println("String clazz 3: " + stringClazz3);
            System.out.println("Animal clazz 3: " + animalClazz3);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Class not found.", ex);
        }

        //（了解）方法4：利用classLoader
        ClassLoader classLoader = ObtainClassInstanceDemo.class.getClassLoader();
        try {
            Class stringClazz4 = classLoader.loadClass("java.lang.String");
            Class animalClazz4 = classLoader.loadClass("reflection.Animal");
            System.out.println("String clazz 4: " + stringClazz4);
            System.out.println("Animal clazz 4: " + animalClazz4);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //特殊获取Class对象（只能用于基本类型的包装类）
        Class<Integer> intClazz = Integer.TYPE;
        Class<Boolean> booleanClazz = Boolean.TYPE;
        System.out.println("Integer clazz: " + intClazz);
        System.out.println("Boolean clazz: " + booleanClazz);


        String s1 = "Java";
        String s2 = "World";
        Class s1Clazz = s1.getClass();
        Class s2Clazz = s2.getClass();
        System.out.println("== : " + (s1Clazz == s2Clazz));
        System.out.println("Equals : " + (s1Clazz.equals(s2Clazz)));


    }
}
