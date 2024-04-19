import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Завдання 1: Зміна місцями найбільшого і найменшого елементів масиву
        int[] array1 = {3, 1, 5, 2, 4}; // Приклад масиву
        swapMinMax(array1);
        System.out.println("Завдання 1: " + Arrays.toString(array1));

        // Завдання 2: Переставлення елементів масиву 0-1-2
        int[] array2 = {2, 1, 0, 1, 2, 0, 1}; // Приклад масиву
        sort012(array2);
        System.out.println("Завдання 2: " + Arrays.toString(array2));

        // Завдання 3: Обчислення суми додатніх елементів масиву
        double[] array3 = {1.5, -2.7, 3.8, -4.2, 5.0}; // Приклад масиву
        double sumPositive = sumOfPositive(array3);
        System.out.println("Завдання 3: " + sumPositive);

        // Завдання 4: Добуток елементів масиву між максимальним і мінімальним за модулем
        double[] array4 = {1.5, -2.7, 3.8, -4.2, 5.0}; // Приклад масиву
        double product = productBetweenMaxAndMin(array4);
        System.out.println("Завдання 4: " + product);

        // Завдання 5: Номер мінімального за модулем елемента та сума модулів елементів після першого від'ємного
        double[] array5 = {1.5, -2.7, 3.8, -4.2, 5.0}; // Приклад масиву
        int minModulusIndex = indexOfMinModulus(array5);
        double sumAfterNegative = sumAfterFirstNegative(array5);
        System.out.println("Завдання 5: Номер мінімального елемента: " + minModulusIndex + ", Сума після першого від'ємного: " + sumAfterNegative);

        // Завдання 6: Кількість елементів більших за 3 та добуток елементів після максимального за модулем
        double[] array6 = {1.5, -2.7, 3.8, -4.2, 5.0}; // Приклад масиву
        int countGreaterThan3 = countGreaterThan3(array6);
        double productAfterMaxModulus = productAfterMaxModulus(array6);
        System.out.println("Завдання 6: Кількість більших за 3: " + countGreaterThan3 + ", Добуток після максимального за модулем: " + productAfterMaxModulus);

        // Перетворення масиву таким чином, щоб спочатку розташовувалися всі від’ємні елементи, а потім − усі додатні
        rearrangeArray(array6);
        System.out.println("Результат перетворення: " + Arrays.toString(array6));
    }

    // Завдання 1: Зміна місцями найбільшого і найменшого елементів масиву
    public static void swapMinMax(int[] array) {
        if (array.length < 2) {
            return; // Нічого робити, якщо масив має менше двох елементів
        }
        int minIndex = 0;
        int maxIndex = 0;
        // Знаходимо індекси найменшого та найбільшого елементів масиву
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        // Заміна місцями найбільшого і найменшого елементів
        int temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;
    }

    // Завдання 2: Переставлення елементів масиву 0-1-2
    public static void sort012(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(array, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(array, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Завдання 3: Обчислення суми додатніх елементів масиву
    public static double sumOfPositive(double[] array) {
        double sum = 0;
        for (double num : array) {
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Завдання 4: Добуток елементів масиву між максимальним і мінімальним за модулем
    public static double productBetweenMaxAndMin(double[] array) {
        if (array.length < 2) {
            return 0; // Немає достатньо елементів для обчислення
        }
        int minIndex = 0;
        int maxIndex = 0;
        // Знаходимо індекси найменшого та найбільшого елементів за модулем
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(array[minIndex])) {
                minIndex = i;
            }
            if (Math.abs(array[i]) > Math.abs(array[maxIndex])) {
                maxIndex = i;
            }
        }
        // Визначаємо початковий та кінцевий індекси для обчислення добутку
        int start = Math.min(minIndex, maxIndex) + 1;
        int end = Math.max(minIndex, maxIndex) - 1;
        double product = 1;
        // Обчислюємо добуток
        for (int i = start; i <= end; i++) {
            product *= array[i];
        }
        return product;
    }

    // Завдання 5: Номер мінімального за модулем елемента та сума модулів елементів після першого від'ємного
    public static int indexOfMinModulus(double[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(array[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double sumAfterFirstNegative(double[] array) {
        boolean foundNegative = false;
        double sum = 0;
        for (double num : array) {
            if (foundNegative) {
                sum += Math.abs(num);
            }
            if (num < 0) {
                foundNegative = true;
            }
        }
        return sum;
    }

    // Завдання 6: Кількість елементів більших за 3 та добуток елементів після максимального за модулем елемента
    public static int countGreaterThan3(double[] array) {
        int count = 0;
        for (double num : array) {
            if (num > 3) {
                count++;
            }
        }
        return count;
    }

    public static double productAfterMaxModulus(double[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) > Math.abs(array[maxIndex])) {
                maxIndex = i;
            }
        }
        double product = 1;
        for (int i = maxIndex + 1; i < array.length; i++) {
            product *= array[i];
        }
        return product;
    }

    // Перетворення масиву таким чином, щоб спочатку розташовувалися всі від’ємні елементи, а потім − усі додатні
    public static void rearrangeArray(double[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] < 0) {
                left++;
            } else if (array[right] >= 0) {
                right--;
            } else {
                double temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Метод для обміну значень елементів масиву
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
