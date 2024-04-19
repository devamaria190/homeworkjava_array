import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = generateArray(120, -70, 70);
        printArray(array);
        double averageLength = calculateAverageLength(array);
        System.out.println("\nСередня довжина неперервних додатних послідовностей: " + averageLength);
    }

    public static int[] generateArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static double calculateAverageLength(int[] array) {
        int sumLength = 0;
        int countSequences = 0;
        int length = 0;

        for (int num : array) {
            if (num > 0) {
                length++;
            } else {
                if (length > 0) {
                    sumLength += length;
                    countSequences++;
                    System.out.println("Послідовність додатних чисел: " + length);
                    length = 0;
                }
            }
        }

        if (length > 0) {
            sumLength += length;
            countSequences++;
            System.out.println("Послідовність додатних чисел: " + length);
        }

        return countSequences > 0 ? (double) sumLength / countSequences : 0;
    }
}
