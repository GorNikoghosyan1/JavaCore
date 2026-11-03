package chapter7;

public class OverloadCons {
    public static void main(String[] args) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box();
        Box myBox3 = new Box(7);
        System.out.println("Объем myBox1 равен " + myBox1.volume());
        System.out.println("Объем myBox2 равен " + myBox2.volume());
        System.out.println("Объем myBox3 равен " + myBox3.volume());
    }
}
