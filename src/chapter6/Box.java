package chapter6;

public class Box {
    double width;
    double height;
    double depth;

    void volume(){
        System.out.print("Объем равен ");
        System.out.println(width * height * depth);
    }

    double volume2(){
        return width * height * depth;
    }
}
