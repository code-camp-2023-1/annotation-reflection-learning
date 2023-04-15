package reflection;

public class ReflectionInSuperClassDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;
        Class superClazz = birdClass.getSuperclass();
        System.out.println("Super class: " + superClazz);
    }
}
