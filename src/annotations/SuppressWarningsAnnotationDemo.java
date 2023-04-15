package annotations;

import java.util.ArrayList;
import java.util.List;

// @SuppressWarnings({"deprecation", "rawtypes", "unused"})
@SuppressWarnings("deprecation")
public class SuppressWarningsAnnotationDemo {

    public void suppressUncheckedWarnings() {
        @SuppressWarnings("rawtypes")
        List list = new ArrayList();
    }

    @SuppressWarnings("unused")
    public void suppressUnusedWarning() {
        int a = 5;
        int b = 10;
    }

    public void suppressDeprecationWarning() {
        DeprecatedClass deprecatedClass = new DeprecatedClass();
        deprecatedClass.doSomething("Hello World");
    }
    public static void main(String[] args) {

    }
}
