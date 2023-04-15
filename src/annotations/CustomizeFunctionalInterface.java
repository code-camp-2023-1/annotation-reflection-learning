package annotations;

@FunctionalInterface
public interface CustomizeFunctionalInterface {
    void doSomething();

    default void doAnotherThing() {

    }
}
