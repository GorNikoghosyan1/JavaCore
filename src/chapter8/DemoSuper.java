package chapter8;

public class DemoSuper {
    public static void main(String[] args) {
        BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);
        BoxWeight myBox3 = new BoxWeight();
        BoxWeight myCube = new BoxWeight(3, 2);
        BoxWeight myClone = new BoxWeight(myBox1);
        System.out.println("Объем myBox1 равен " + myBox1.volume());
        System.out.println("Вес myBox1 равен " + myBox1.weight);
        System.out.println("Объем myBox2 равен " + myBox2.volume());
        System.out.println("Вес myBox2 равен " + myBox2.weight);
        System.out.println("Объем myBox3 равен " + myBox3.volume());
        System.out.println("Вес myBox3 равен " + myBox3.weight);
        System.out.println("Объем myClone равен " + myClone.volume());
        System.out.println("Вес myClone равен " + myClone.weight);
        System.out.println("Объем myCube равен " + myCube.volume());
        System.out.println("Вес myCube равен " + myCube.weight);
    }
}
