package homeworks;

public class ArrayHomework {
    public static void main(String[] args) {
//      Խնդիր 1 — Հաշվել տվյալ թվի հանդիպումների քանակը
        int[] numbers = {6, 3, 8, 6, 1, 9, 6, 4, 2, 6};
        int n = 6;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                count++;
            }
        }
        System.out.println("Count of 6: " + count);

        System.out.println();
//      Խնդիր 2 — Շրջել զանգվածի էլեմենտների հերթականությունը
        int[] nums = {1, 5, 8, 3, 9, 2, 7, 4, 6, 10};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
        System.out.println();

//      Խնդիր 3 — Հաշվել կրկնվող թվերի քանակը
        int[] numbers2 = {3, 6, 8, 3, 9, 6, 2, 3, 5, 6};
        int totalRepeated = 0;
        for (int i = 0; i < numbers2.length; i++) {
            boolean before = false;
            for (int j = 0; j < i; j++) {
                if (numbers2[j] == numbers2[i]) {
                    before = true;
                }
            }
            if (before) {
                continue;
            }
            int countNumbers2 = 0;
            for (int k = 0; k < numbers2.length; k++) {
                if (numbers2[k] == numbers2[i]) {
                    countNumbers2++;
                }
            }
            if (countNumbers2 > 1) {
                totalRepeated++;
            }
        }
        System.out.println("Repeated numbers count: " + totalRepeated);

        System.out.println();

//      Խնդիր 4 — Հաշվել ձայնավորների քանակը
        char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        char[] vowels = {'ա', 'ե', 'է', 'ը', 'ի', 'ո', 'օ'};
        int vowelsCount = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (chars[i] == vowels[j]) {
                    vowelsCount++;
                }
            }
        }
        System.out.println("Vowels count: " + vowelsCount);

        System.out.println();

//      Bonus 1 — Գտնել երկրորդ ամենամեծ թիվը
        int[] numbersBonus1 = {4, 9, 2, 15, 7, 15, 3, 11, 6, 8};
        int max1 = numbersBonus1[0];
        for (int i = 0; i < numbersBonus1.length; i++) {
            if (numbersBonus1[i] > max1) {
                max1 = numbersBonus1[i];
            }
        }
        int max2 = 0;
        for (int i = 0; i < numbersBonus1.length; i++) {
            if (numbersBonus1[i] > max2 && numbersBonus1[i] < max1) {
                max2 = numbersBonus1[i];
            }
        }
        System.out.println("Second maximum: " + max2);

        System.out.println();

//      Bonus 2 — Հեռացնել կրկնվող թվերը
        int[] numbersBonus2 = {3, 6, 3, 8, 9, 6, 2, 3, 5, 6};
        for (int i = 0; i < numbersBonus2.length; i++) {
            boolean beforeBonus2 = false;
            for (int j = 0; j < i; j++) {
                if (numbersBonus2[i] == numbersBonus2[j]) {
                    beforeBonus2 = true;
                }
            }
            if (beforeBonus2) {
                continue;
            }
            System.out.print(numbersBonus2[i] + " ");
        }

        System.out.println();
        System.out.println();

//          Bonus 3 — Գտնել ամենաշատ կրկնվող թիվը
        int[] numbersBonus3 = {3, 6, 3, 8, 9, 6, 2, 3, 5, 3};
        int maxCount = 0;
        int mostFrequent = 0;
        for (int i = 0; i < numbersBonus3.length; i++) {
            int currentCount = 0;
            for (int j = 0; j < numbersBonus3.length; j++) {
                if (numbersBonus3[i] == numbersBonus3[j]){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                mostFrequent = numbersBonus3[i];
            }
        }
        System.out.println("Most frequent number: " + mostFrequent);
        System.out.println("Count: " + maxCount);
    }
}
