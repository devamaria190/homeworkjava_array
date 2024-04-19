import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        int[][] matrix = {
                {1, -2, 3},
                {-4, 5, -6},
                {7, 8, -9}
        };
        printNegativeSum(matrix);

        int minAbs = minAbsolute(matrix);
        System.out.println("Мінімальний по модулю елемент матриці: " + minAbs);

        int[][] squareMatrix = generateRandomMatrix(3);
        printMatrix(squareMatrix);
        double averageFirstColumn = averageFirstColumn(squareMatrix);
        int countAboveAverage = countAboveAverage(squareMatrix, averageFirstColumn);
        System.out.println("Середнє арифметичне першого стовпця: " + averageFirstColumn);
        System.out.println("Кількість елементів матриці, що перевищують середнє арифметичне першого стовпця: " + countAboveAverage);
    }

    public static void printNegativeSum(int[][] matrix) {
        for (int[] row : matrix) {
            int sumNegative = 0;
            for (int num : row) {
                if (num < 0) {
                    sumNegative += num;
                }
            }
            System.out.println("Сума від'ємних елементів: " + sumNegative);
        }
    }

    public static int minAbsolute(int[][] matrix) {
        int minAbs = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                int absNum = Math.abs(num);
                if (absNum < minAbs) {
                    minAbs = absNum;
                }
            }
        }
        return minAbs;
    }

    public static int[][] generateRandomMatrix(int size) {
        Random random = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static double averageFirstColumn(int[][] matrix) {
        double sum = 0;
        int rowCount = matrix.length;
        for (int[] row : matrix) {
            sum += row[0];
        }
        return sum / rowCount;
    }

    public static int countAboveAverage(int[][] matrix, double value) {
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > value) {
                    count++;
                }
            }
        }
        return count;
    }
}
