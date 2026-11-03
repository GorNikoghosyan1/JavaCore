package chapter7;

public class OverloadCons2 {
    public static void main(String[] args) {
        Box2 myBox1 = new Box2(10, 20, 15);
        Box2 myBox2 = new Box2();
        Box2 myCube = new Box2(7);
        Box2 myClone = new Box2(myBox1);
        System.out.println("Объем myBox1 равен " + myBox1.volume());
        System.out.println("Объем myBox2 равен " + myBox2.volume());
        System.out.println("Объем куба равен " + myCube.volume());
        System.out.println("Объем клона равен " + myClone.volume());
    }
}
