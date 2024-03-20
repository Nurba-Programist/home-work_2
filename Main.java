import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array, 10);
        print(array);
        heapSort(array);
        print(array);
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);

        }

    }

    public static void randomizeArray(int[] array, int max) {
        for (int i = 0; i < array.length; i++)
            array[i] = new Random().nextInt(max);
    }

    public static void print(int[] array) {

        for (int i : array)
            System.out.print(i + " ");
        System.out.println();

    }

}