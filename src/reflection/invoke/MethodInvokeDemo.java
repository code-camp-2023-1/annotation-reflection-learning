package reflection.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeDemo {
    public static void main(String[] args) {
        // 1. 最简单：调用public无参数无返回值方法

        // (1) 获取目标类的class对象
        MyClass obj = new MyClass(10);
        Class clazz = obj.getClass();

        try {
            // (2) 获取目标方法的Method对象
            Method doNothingMethod = clazz.getMethod("doNothing");
            // (3) 调用Method中的invoke
            // Expected: null
            Object doNothingResult  = doNothingMethod.invoke(obj);
            System.out.println("doNothingResult: " + doNothingResult);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 2. 调用public有参数有返回值方法

        try {
            // (2) 获取目标方法的Method对象
            Method sumMethod = clazz.getMethod("sum", int.class, String.class);
            // (3) 调用Method中的invoke，参数对应method对象
            // Expected: sumResult -> 30
            Object sumResult  = sumMethod.invoke(obj, 10, "10");
            System.out.println("sumResult: " + sumResult);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 3. 调用private有参数有返回值的方法
        // (1) 获取目标类的class对象
        MyClass obj2 = new MyClass();

        try {
            // (2) 获取目标方法的Method对象
            Method sumMethod2 = clazz.getDeclaredMethod("sum", String.class, String.class);
            // (3) 调用private方法需要设置accessible属性
            sumMethod2.setAccessible(true);
            // (4) 调用Method中的invoke，参数对应method对象
            Object sumMethod2Result = sumMethod2.invoke(obj2, "15", "15");
            System.out.println("sumMethod2Result: " + sumMethod2Result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 4. 调用static方法
        try {
            // (2) 获取目标方法的Method对象
            Method sumMethod3 = clazz.getDeclaredMethod("sum", String.class);
            // (3) 调用private方法需要设置accessible属性
            sumMethod3.setAccessible(true);
            // (4) 调用Method中的invoke，参数对应method对象，把obj设为null
            Object sumMethod3Result = sumMethod3.invoke(null, "15"); //推荐把obj设为null
            System.out.println("sumMethod3Result: " + sumMethod3Result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }
}
