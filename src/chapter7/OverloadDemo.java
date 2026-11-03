package chapter7;

public class OverloadDemo {
    void test() {
        System.out.println("параметры отсуствуют");
    }

//    void test(int a) {
//        System.out.println("a: " + a);
//    }

    void test(int a, int b) {
        System.out.println("a и b: " + a + " " + b);
    }

//    double test(double a) {
//        System.out.println("double a: " + a);
//        return a * a;
//    }

    void test(double a) {
        System.out.println("Внрутренно преобразавание при вызове " + " test(double) a: " + a);
    }
}
