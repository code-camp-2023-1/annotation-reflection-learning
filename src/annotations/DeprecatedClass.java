package annotations;

@Deprecated
public class DeprecatedClass {
    @Deprecated
    public void doSomething(String s) {
        System.out.println("String: " + s);
    }

    public void doSomethingV2(String s) {
        System.out.println("New String: " + s);
    }
}
