package reflection;

public class Animal {
    public String type;

    public Animal() {}

    public Animal(String type) {
        this.type = type;
    }

    public void doSomething() {
        System.out.println("do something.");
    }
}
