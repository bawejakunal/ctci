/**
 *
 * A bucket paint fill tool
 *
 **/

import java.util.*;

enum Color {
    WHITE, BLACK
}

class Cell {
    int row;
    int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class PaintFill {
    
    static boolean isValid(int row, int col, Color [][]board) {
        return (row >= 0 && row < board.length && col >= 0 &&
                col < board[row].length);
    }

    static void fillPaint(Color [][]board, int row, int col, Color ocolor,
                          Color ncolor) {
        
        // BFS way to fill paint
        Queue<Cell> q = new LinkedList<Cell>();
        if (board[row][col] == ocolor)
            q.add(new Cell(row, col));

        while (!q.isEmpty()) {
            Cell cell = q.poll();
            board[cell.row][cell.col] = ncolor;
            for (int r = cell.row - 1; r < (cell.row + 2); r++) {
                for (int c = cell.col - 1; c < (cell.col + 2); c++) {
                    if (isValid(r, c, board) && board[r][c] == ocolor)
                        q.add(new Cell(r, c));
                }
            }
        }
    }

    public static void main(String []args) {
        Color board[][] = new Color[10][10];
        for (int r = 0;r < board.length;r++)
            for (int c = 0; c < board[r].length; c++)
                board[r][c] = Color.WHITE;

        fillPaint(board, 4, 4, Color.WHITE, Color.BLACK);
        
        for (int r = 0;r < board.length;r++)
            for (int c = 0; c < board[r].length; c++)
                if (board[r][c] == Color.WHITE)
                    System.out.println("FAILED");
        
        System.out.println("FINISHED");
    }
}