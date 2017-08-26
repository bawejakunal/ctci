/**
 *
 * Rotate a given square matrix by 90 degrees clockwise in place
 *
 **/

import java.util.*;

public class RotateMatrix {

    private static void printMatrix(int matrix[][]) {
        char separator = ' ';

        for (int r = 0; r < matrix.length; r++) {
            StringBuilder builder = new StringBuilder();
            for (int c = 0; c < matrix[0].length; c++) {
                builder.append(Integer.toString(matrix[r][c]));
                builder.append(separator);
            }
            System.out.println(builder.toString().trim());
        }
    }

    private static void rotateMatrix(int matrix[][]) {
        int last = matrix.length - 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r; c < last - r; c++) {
                int top = matrix[r][c];
                matrix[r][c] = matrix[last - c][r];
                matrix[last - c][r] = matrix[last - r][last - c];
                matrix[last - r][last - c] = matrix[c][last - r];
                matrix[c][last - r] = top;
            }
        }
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                matrix[r][c] = sc.nextInt();
        sc.close();
        rotateMatrix(matrix);
        printMatrix(matrix);
    }
}
