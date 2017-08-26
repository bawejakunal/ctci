/**
 *
 * Zero the column and row of a matrix for a zero item
 *
 **/

import java.util.*;

public class ZeroMatrix {

    private static void nullifyRow(int matrix[][], int row) {
        if (matrix == null || row < 0 || row >= matrix.length)
            return;

        for (int c = 0; c < matrix[row].length; c++)
            matrix[row][c] = 0;
    }

    private static void nullifyColumn(int matrix[][], int col) {
        if (matrix == null || col < 0 || col >= matrix[0].length)
            return;

        for (int r = 0; r < matrix.length; r++)
            matrix[r][col] = 0;
    }

    private static void nullifyMatrix(int matrix[][]) {

        if (matrix == null)
            return;

        boolean colHasZero = false;
        boolean rowHasZero = false;

        // check if zeroth row has a zero
        for (int c = 0; c < matrix[0].length; c++)
            if (matrix[0][c] == 0) {
                rowHasZero = true;
                break;
            }

        // check zeroth col for zero
        for (int r = 0; r < matrix.length; r++)
            if (matrix[r][0] == 0) {
                colHasZero = true;
                break;
            }

        // mark other rows and cols for zeroes
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;   // mark col for zero
                    matrix[r][0] = 0;   // mark row for zero
                }
            }
        }

        // nullify rows
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0)
                nullifyRow(matrix, r);
        }

        // nullify cols
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0)
                nullifyColumn(matrix, c);
        }

        // nullify zeroth col
        if (rowHasZero)
            nullifyRow(matrix, 0);

        // nullify zeroth row
        if (colHasZero)
            nullifyRow(matrix, 0);
    }

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

    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();   //matrix size
        
        int matrix[][] = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = in.nextInt();
            }
        }

        nullifyMatrix(matrix);

        printMatrix(matrix);
    }
}