
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers would you like sorted?(Please Enter an Integer) ");
        int size = in.nextInt();
        //System.out.println(size);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("\n Give us a value for the " + (i + 1) + " number in the sort (Integers only): ");
            array[i] = in.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("Given numbers: " + array[i]);
            } else {
                System.out.print(" " + array[i]);
            }

        }

        for (int i = 0; i < (size - 1); i++) {
            for (int j = 1; j <= (size - i - 1); j++) {
                if (array[(j - 1)] > array[j]) {
                    int temp = array[j];
                    array[j] = array[(j - 1)];
                    array[(j - 1)] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("\n Sorted: " + array[i]);
            } else {
                System.out.print(" " + array[i]);
            }

        }
    }
}
