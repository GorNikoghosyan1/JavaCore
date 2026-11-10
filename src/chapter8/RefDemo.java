package chapter8;

public class RefDemo {
    public static void main(String[] args) {
        BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
        Box plainBox = new Box();

        System.out.println("Объем weigthBpx равен " + weightBox.volume());
        System.out.println("Вес weightBox равен " + weightBox.weight);
        System.out.println();

        plainBox = weightBox;
        System.out.println("Объем plainBox равен " + plainBox.volume());
    }
}
