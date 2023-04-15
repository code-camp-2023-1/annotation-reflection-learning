package reflection;

import java.io.IOException;

@Markable("main-bird")
public class Bird extends Animal implements Flying, Comparable<Bird> {
    @Markable("age")
    private int age;

    public boolean canEat;

    public Bird() {
    }

    private Bird(int age) {
        this.age = age;
    }

    Bird(String type, int age) {
        super(type);
        this.age = age;
    }

    protected Bird(String type, int age, int size) {
        super(type);
        this.age = age;
        System.out.println("size: " + size);
    }

    public Bird(String type, int age, boolean canEat) {
        super(type);
        this.age = age;
        this.canEat = canEat;
    }


    private boolean canEat(String name) {
        return true;
    }

    @Markable("walk")
    public static void walk(int speed, String msg) throws IOException, NoSuchMethodException {
        System.out.println("The bird is walking: " + speed + " " + msg);

        if (speed > 100) {
            throw new IOException("Speed is overload");
        }



    }

    @Override
    public void fly() {
        System.out.println("The bird is flying quickly");
    }

    @Override
    public int compareTo(Bird o) {
        return this.age - o.age;
    }
}
