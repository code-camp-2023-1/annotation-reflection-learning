package reflection.invoke;

public class MyClass {
    private int count;
    public MyClass() {
    }

    public MyClass(int count) {
        this.count = count;
    }

    public void doNothing() {
        System.out.println("Do nothing");
    }

    public int sum(int num1, String strNum) {
        return num1 + Integer.parseInt(strNum) + this.count;
    }

    private String sum(String strNum1, String strNum2) {
        return "" + Integer.parseInt(strNum1) + Integer.parseInt(strNum2) + this.count;
    }

    private static String sum(String str) {
        return str + " World";
    }
}
