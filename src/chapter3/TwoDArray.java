package chapter3;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] twoD = new int[4][5];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                twoD[i][j] = k;
                k++;
            }
        }

            for (int j = 0; j < 4; j++) {
                for (int l = 0; l < 5; l++) {
                    System.out.print(twoD[j][l] + " ");
                }
                System.out.println();
            }
    }
}
