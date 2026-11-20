package chapter9.mypack;

public class Balance {
    private String name;
    private double bal;

    public Balance(String n, double b) {
        name = n;
        bal = b;
    }

    public void show() {
        if (bal < 0) {
            System.out.print("--> ");
        }
        System.out.println(name + ": $ " + bal);
    }
}
