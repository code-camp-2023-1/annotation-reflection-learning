package annotations.customize;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Animals.class)
public @interface Animal {
    String name();
}
