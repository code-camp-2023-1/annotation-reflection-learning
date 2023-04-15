package annotations.customize;

@Animal(name = "cat")
@Animal(name = "dog")
@Animal(name = "tiger")
public class MyZoo {

    public static void main(String[] args) {
        Animal[] animals = MyZoo.class.getAnnotationsByType(Animal.class);
        for (Animal animal : animals) {
            System.out.println("Animal name: " + animal.name());
        }
        System.out.println("Hello world");
    }

}
