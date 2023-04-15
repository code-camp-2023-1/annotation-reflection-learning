package annotations.customize;


@SingleParameterAnnotation
public class SingleParameterAnnotationDemo {
    public void doSomething(@SingleParameterAnnotation("name") String s) {

    }
}
