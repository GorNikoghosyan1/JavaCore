package homeworks.dynamicarray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        da.print();

        System.out.println();

        da.add(6);
        da.add(7);
        da.add(8);
        da.add(9);
        da.add(10);
        da.add(11);
        da.add(12);
        da.add(13);
        da.add(14);
        da.add(15);
        da.print();

        System.out.println();

        da.add(16);
        da.add(17);
        da.add(18);
        da.add(19);
        da.add(20);
        da.add(21);
        da.add(22);
        da.add(23);
        da.add(24);
        da.add(25);
        da.print();

        System.out.println();

        System.out.println(da.getByIndex(0));
        System.out.println(da.getByIndex(da.getSize() - 1));
        System.out.println(da.getByIndex(-1));
        System.out.println(da.getByIndex(30));
        DynamicArray emptyDa = new DynamicArray();
        System.out.println(emptyDa.getByIndex(0));
    }
}
