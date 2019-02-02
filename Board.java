package eightqueenspuzzle;

/**
 *
 * @author Dimitri Liska
 */
public class Board {

    private char[][] chestBoard;

    public static final char QUEEN = 'Q';
    public static final char EMPTY_SPOT = 'X';
    private int numberOfQueensExpected;
    private int numberOfQueens;

    public Board() {
        this(8);
    }

    public Board(int size) {
        this.chestBoard = new char[size][size];
        this.numberOfQueensExpected = size;

        for (int row = 0; row < chestBoard.length; row++) {
            for (int col = 0; col < chestBoard[row].length; col++) {
                chestBoard[row][col] = Board.EMPTY_SPOT;
            }
        }
    }
    
    public boolean solve() {
//        System.out.println("number of queens: "+ numberOfQueens );
        if (numberOfQueens == numberOfQueensExpected) {
            return true;
        }
        
        for (int row = chestBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < chestBoard.length; col++) {
                if (isSquareSafe(row, col)) {
                    placeQueen(row, col);
                    if (solve()) {
                        return true;
                    } else {
                        removeQueen(row, col);
                    }
                }
            }
        }
        return false;
    }

    private boolean isSquareSafe(int rowQueen, int colQueen) {
    //    System.out.println("isSquareSafe");
        boolean goodSoFar = true;
        while (goodSoFar) {

            //Checking row & col Imput & empty_spot
            if (rowQueen >= 0 && colQueen >= 0 && rowQueen < chestBoard.length
                    && colQueen < chestBoard[rowQueen].length
                    && chestBoard[rowQueen][colQueen] == Board.EMPTY_SPOT) {
                goodSoFar = true;
            } else {
                goodSoFar = false;
            }

            //Checking Column
            for (int row = 0; row < chestBoard.length; row++) {
                if (chestBoard[row][colQueen] == Board.QUEEN) {
                    goodSoFar = false;
                }
            }

            //Checking row
            for (int col = 0; col < chestBoard.length; col++) {
                if (chestBoard[rowQueen][col] == Board.QUEEN) {
                    goodSoFar = false;
                }
            }

            //Diagonal Top-Right
            int row = rowQueen;
            int col = colQueen;
            while (row >= 0 && col < chestBoard.length) {
                if (chestBoard[row][col] == Board.QUEEN) {
                    goodSoFar = false;
                }
                row--;
                col++;
            }

            // Diagonal Top-Left
            row = rowQueen;
            col = colQueen;
            while (row >= 0 && col >= 0) {
                if (chestBoard[row][col] == Board.QUEEN) {
                    goodSoFar = false;
                }
                row--;
                col--;
            }

            // Diagonal Bottom-Right
            row = rowQueen;
            col = colQueen;
            while (row < chestBoard.length && col < chestBoard.length) {
                if (chestBoard[row][col] == Board.QUEEN) {
                    goodSoFar = false;
                }
                row++;
                col++;
            }

            // Diagonal Bottom-Left
            row = rowQueen;
            col = colQueen;
            while (row < chestBoard.length && col >= 0) {
                if (chestBoard[row][col] == Board.QUEEN) {
                    goodSoFar = false;
                }
                row++;
                col--;
            }
            break;
        }
    //    System.out.println("Is safe = " + goodSoFar);
        return goodSoFar;
    }

    private void placeQueen(int row, int col) {
    //    System.out.println("placeQueen");
        chestBoard[row][col] = Board.QUEEN;
        numberOfQueens++;
    //    System.out.println("number of queens: numberOfQueens " + numberOfQueens);
    //    printBoard();
    }

    private void removeQueen(int row, int col) {
    //    System.out.println("removeQueen");
        chestBoard[row][col] = Board.EMPTY_SPOT;
        numberOfQueens--;
    }

    public void printBoard() {
        for (int row = 0; row < chestBoard.length; row++) {
            for (int col = 0; col < chestBoard[row].length; col++) {
                System.out.print(" " + chestBoard[row][col]);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Board{" + "gameBoard=" + chestBoard + ", numberOfQueens=" + numberOfQueens + '}';
    }
}
