import java.util.Scanner;

/**
 * main class, which take quantity of Lucas numbers
 * @author pyroz
 */
public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter value for n (n>0):");
            n = scan.nextInt();
        } while (n < 0);

        show(n);
    }

    /**
     *
     * @param n, n is quantity of Lucas numbers(size of the array)
     * @return arr, array of Lucas numbers
     */
    public static int[] create_array(int n) {
        int[] arr = new int[n];
        if (n >= 1) {
            arr[0] = 2;
        }
        if (n >= 2){
            arr[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * @param n, n is quantity of Lucas numbers(size of the array)
     * function used for showing input and output
     */
    public static void show(int n) {
        int[] arr1 = array_check(n);
        int[] arr2 = create_array(n);
        System.out.println("Input values:");
        System.out.println("n = " + n);
        System.out.println("Lucas numbers:");
        for (int el : arr2){
            System.out.print(el + " ");
        }
        System.out.println("\nYour array:");
        for (int el : arr1) {
            if (el != 0) {
                System.out.print(el);
            }
        }
    }

    /**
     *
     * @param n,  n is quantity of Lucas numbers(size of the array)
     * @return result, sorted array of Lucas numbers
     */
    public static int[] array_check(int n) {
        int[] arr = create_array(n);
        int[] arr2 = new int[n];
        int index = 0;

        for (int el : arr) {
            double temp = Math.cbrt(el + 1);
            if (temp % 1 == 0) {
                arr2[index++] = el;
            }
        }

        int[] result = new int[index];
        System.arraycopy(arr2, 0, result, 0, index);

        return result;
    }
}
