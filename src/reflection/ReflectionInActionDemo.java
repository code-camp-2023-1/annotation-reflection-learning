package reflection;

import java.lang.reflect.Constructor;

public class ReflectionInActionDemo {
    public static void main(String[] args) {
        // 获取类名
        Class<Bird> birdClass = Bird.class;
        //getName: the name of the class or interface represented by this object
        System.out.println("Class name for bird: " + birdClass.getName());
        //getSimple: the simple name of the underlying class
        System.out.println("Class simple name for bird: " + birdClass.getSimpleName());

        // 获取包名
        Package birdClassPackage = birdClass.getPackage();
        System.out.println("Package name for birdClass: " + birdClassPackage);

        // 获取构造器
        // 获取当前类所有的public构造器
        Constructor<?>[] constructors = birdClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println("Public Constructor: " + c);
        }

        // 获取当前类所有的构造器
        Constructor<?>[] allConstructors = birdClass.getDeclaredConstructors();
        for (Constructor c : allConstructors) {
            System.out.println("Constructor: " + c);
        }
    }
}
