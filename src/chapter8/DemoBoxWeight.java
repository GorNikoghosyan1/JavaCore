package chapter8;

public class DemoBoxWeight {
    public static void main(String[] args) {
        BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);
        System.out.println("Объем myBox1 равен " + myBox1.volume());
        System.out.println("Вес myBox1 равен " + myBox1.weight);
        System.out.println();

        System.out.println("Объем myBox2 равен " + myBox2.volume());
        System.out.println("Вес myBox2 равен " + myBox2.weight);
    }
}
