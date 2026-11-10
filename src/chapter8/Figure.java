package chapter8;

public abstract class Figure {
    public double dim1;
    public double dim2;

    public Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    public abstract double area();
}
