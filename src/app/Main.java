package app;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int evenRowSum = 0;
        int oddRowSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }
        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowSum);

        long evenColProduct = 1;
        long oddColProduct = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    evenColProduct *= matrix[i][j];
                } else {
                    oddColProduct *= matrix[i][j];
                }
            }
        }
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColProduct);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColProduct);

        boolean isMagicSquare = checkMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static boolean checkMagicSquare(int[][] matrix) {
        int magicSum = 0;
        for (int j = 0; j < 4; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 1; i < 4; i++) {
            int rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < 4; j++) {
            int colSum = 0;
            for (int i = 0; i < 4; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < 4; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][3 - i];
        }

        if (diag1Sum != magicSum || diag2Sum != magicSum) {
            return false;
        }

        return true;
    }
}
