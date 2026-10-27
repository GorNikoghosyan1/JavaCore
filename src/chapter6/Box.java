package chapter6;

public class Box {
    double width;
    double height;
    double depth;

    Box() {
        System.out.println("Koнcтpyиpoвaниe объекта Вох");
        width = 10;
        height = 10;
        depth = 10;
    }

    void volume(){
        System.out.print("Объем равен ");
        System.out.println(width * height * depth);
    }

    double volume2(){
        return width * height * depth;
    }

    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
