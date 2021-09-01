package Matrices;

import java.util.*;

public class MatrixOperations {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3);
        Matrix m2 = new Matrix(3);
        m1.setValues();
        m2.setValues();
        System.out.println("");
        m1.printMatrix();
        System.out.println("");
        m2.printMatrix();
        System.out.println("");
        m1.addMatrix(m2);
        Matrix result = m1.multiplyMatrix(m2);
        result.printMatrix();
    }
}

class Matrix {
    int[][] newMatrix = new int[3][];
    int rows, cols;

    Matrix(int row, int col) {
        this.newMatrix = new int[row][col];
        this.rows = row;
        this.cols = col;
    }

    Matrix(int order) {
        this.newMatrix = new int[order][order];
        this.rows = order;
        this.cols = order;
    }

    public void setToValue(int value) {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                this.newMatrix[i][j] = value;
            }
        }
    }

    public void setToValue(int[] values) {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                if (i < 3) {
                    this.newMatrix[i][j] = values[j];
                } else if (i < 6) {
                    if (values[j] + 1 <= 9) {
                        this.newMatrix[i][j] = values[j] + 1;
                    } else {
                        this.newMatrix[i][j] = (values[j] + 1) % 9;
                    }
                } else if (i < 9) {
                    if (values[j] + 2 <= 9) {
                        this.newMatrix[i][j] = values[j] + 2;
                    } else {
                        this.newMatrix[i][j] = (values[j] + 2) % 9;
                    }
                }

            }
        }
    }

    public void setValues() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                System.out.println("Row: " + i + " Col: " + j);
                this.newMatrix[i][j] = sc.nextInt();
            }
        }
    }

    public void cycleRowValues(int rowNumber) {
        int[] row = new int[this.cols];
        for (int i = 0; i < rowNumber; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                if (j + 3 < this.cols) {
                    row[j + 3] = this.newMatrix[i][j];
                } else {
                    row[this.cols - j] = this.newMatrix[i][j];
                }
                this.newMatrix[i] = row;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                System.out.print(this.newMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void addMatrix(Matrix m2) {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                this.newMatrix[i][j] += m2.newMatrix[i][j];
            }
        }
        this.printMatrix();
    }

    public Matrix multiplyMatrix(Matrix m2) {
        Matrix result = new Matrix(this.rows, m2.cols);
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                for (int k = 0; k < this.cols; ++k) {
                    result.newMatrix[i][j] += this.newMatrix[i][j] * m2.newMatrix[k][j];
                }
            }
        }
        return result;
    }
}