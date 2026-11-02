package homeworks.dynamicarray;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

//  Խնդիր 1
    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size] = value;
        size++;
    }

//  Խնդիր 2
    private void extend() {
        int[] temp = array;
        array = new int[array.length + 10];
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

//  Խնդիր 3
    public int getByIndex(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            return -1;
        }
    }

//  Խնդիր 4
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public int getSize() {
        return size;
    }
}
