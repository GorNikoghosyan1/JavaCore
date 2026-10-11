package homeworks;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

//        Խնդիր 1 — Տպել զանգվածի բոլոր էլեմենտները
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
//        Խնդիր 2 — Տպել առաջին էլեմենտը
        System.out.println("First element: " + numbers[0]);

        System.out.println();
//        Խնդիր 3 — Տպել վերջին էլեմենտը
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        System.out.println();
//        Խնդիր 4 — Տպել զանգվածի երկարությունը
        System.out.println("Array length: " + numbers.length);

        System.out.println();
//        Խնդիր 5 — Գտնել ամենափոքր թիվը
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum number: " + min);

        System.out.println();
//        Խնդիր 6 — Տպել զանգվածի մեջտեղի էլեմենտը կամ էլեմենտները
        if (numbers.length <= 2) {
            System.out.println("Can't print middle values");
        } else if (numbers.length % 2 != 0) {
            System.out.println("Middle element: " + numbers[numbers.length / 2]);
        } else if (numbers.length % 2 == 0) {
            System.out.println("Middle elements: " + numbers[numbers.length / 2 - 1] + " " + numbers[numbers.length / 2]);
        }

        System.out.println();
//        Խնդիր 7 — Հաշվել զույգ թվերի քանակը
        int evens = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evens++;
            }
        }
        System.out.println("Even numbers count: " + evens);

        System.out.println();
//        Խնդիր 8 — Հաշվել կենտ թվերի քանակը
        int odds = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                odds++;
            }
        }
        System.out.println("Odd numbers count: " + odds);

        System.out.println();
//        Խնդիր 9 — Հաշվել զանգվածի էլեմենտների գումարը
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Sum: " + sum);

        System.out.println();
//        Խնդիր 10 — Հաշվել միջին թվաբանականը
        double sumAll = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumAll += numbers[i];
        }
        double average = sumAll / numbers.length;
        System.out.println("Average: " + average);

        System.out.println();

//        Լրացուցիչ առաջադրանքներ (Bonus)

//        Bonus 1 — Գտնել ամենամեծ թիվը
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Max: " + max);

        System.out.println();

//        Bonus 2 — Հաշվել դրական և բացասական թվերը
//        Քանի դրական թիվ կա զանգվածում։
        int positive = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positive++;
            }
        }
        System.out.println("Positive: " + positive);

        System.out.println();
//        Քանի բացասական թիվ կա զանգվածում։
        int negative = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negative++;
            }
        }
        System.out.println("Negative: " + negative);

        System.out.println();

//        Քանի զրո կա զանգվածում։
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                zero++;
            }
        }
        System.out.println("Zero: " + zero);

        System.out.println();
//        Bonus 3 — Տպել զանգվածը հակառակ հերթականությամբ
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
