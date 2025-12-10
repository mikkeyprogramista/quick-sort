package pl.gornik;

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Podaj rozmiar tablicy: ");
        int size = Integer.parseInt(SC.nextLine());
        System.out.println("Podaj minimalną wartość jaka może się w niej znaleźć: ");
        int min = Integer.parseInt(SC.nextLine());
        System.out.println("Podaj maksymalną wartość jaka może się w niej znaleźć: ");
        int max = Integer.parseInt(SC.nextLine());

        int[] numbers = generateArray(size, min, max);
        System.out.println("Nieposortowana tablica: ");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }

        System.out.println();

        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("Posortowana tablica: ");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
    }

    private static int[] generateArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        return arr;
    }

    private static void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[(left + right) / 2];
        int temp;

        do {
            while (numbers[i] < pivot) i++;
            while (numbers[j] > pivot) j--;

            if (i <= j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) quickSort(numbers, left, j);
        if (right > i) quickSort(numbers, i, right);
    }
}
