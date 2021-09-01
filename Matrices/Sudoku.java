package Matrices;

public class Sudoku {

    public static Matrix shuffleRows(Matrix sudokuBoard) {
        for (int i = 1; i < 9; i = i + 3) {
            for (int j = 0; j < sudokuBoard.cols; j++) {
                sudokuBoard.newMatrix[i][j] = sudokuBoard.newMatrix[i - 1][j] + 3;
                sudokuBoard.newMatrix[i + 1][j] = sudokuBoard.newMatrix[i][j] + 3;
                if (sudokuBoard.newMatrix[i][j] > sudokuBoard.rows) {
                    sudokuBoard.newMatrix[i][j] %= sudokuBoard.rows;
                }
                if (sudokuBoard.newMatrix[i + 1][j] > sudokuBoard.rows) {
                    sudokuBoard.newMatrix[i + 1][j] %= sudokuBoard.rows;
                }
            }
        }
        return sudokuBoard;
    }

    public static boolean validateSudoku(Matrix sudokuBoard) {
        int[] numberCounts = new int[9];
        int sum = 45;
        for (int i : numberCounts) {
            i = 0;
        }

        for (int i = 0; i < sudokuBoard.rows; ++i) {
            int rowCount = 0, colCount = 0;
            for (int j = 0; j < sudokuBoard.cols; ++j) {
                // Keeps count of how many times the numbers occur in the netire sudoku, ideally
                // should be 9
                numberCounts[sudokuBoard.newMatrix[i][j] - 1] += 1;
                rowCount += sudokuBoard.newMatrix[i][j];
                colCount += sudokuBoard.newMatrix[i][j];
            }
            // Takes care of ensuring sum is equal. But this leaves out cases where number
            // increase and decrease by an equivalent value
            if (rowCount != sum || colCount != sum) {
                return false;
            }
        }
        for (int i : numberCounts) {
            if (i != 9)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Sudoku");
        Matrix sudokuBoard = new Matrix(9);
        sudokuBoard.setToValue(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        System.out.println("");
        sudokuBoard = shuffleRows(sudokuBoard);
        sudokuBoard.newMatrix[0][0] = 9;
        sudokuBoard.printMatrix();
        // Test condition for if the sudoku has repeated rows/columns
        System.out.println(validateSudoku(sudokuBoard));
    }
}