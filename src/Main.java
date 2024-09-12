import java.util.Scanner;

/**
 * Клас для представлення чисел Люка або Фібоначчі
 */
class NumberSequence {
    private int index;
    private int value;

    public NumberSequence(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public void show() {
        System.out.println("Index: " + index + ", Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter value for n (n>0):");
            n = scan.nextInt();
        } while (n < 0);

        showLucasNumbers(n);
    }

    /**
     * Створює масив чисел Люка
     * @param n кількість чисел Люка
     * @return масив об'єктів NumberSequence
     */
    public static NumberSequence[] createLucasArray(int n) {
        NumberSequence[] arr = new NumberSequence[n];
        if (n >= 1) {
            arr[0] = new NumberSequence(0, 2);
        }
        if (n >= 2) {
            arr[1] = new NumberSequence(1, 1);
        }
        for (int i = 2; i < n; i++) {
            int value = arr[i - 1].getValue() + arr[i - 2].getValue();
            arr[i] = new NumberSequence(i, value);
        }
        return arr;
    }

    /**
     * Показує числа Люка та фільтрує їх за певним критерієм
     * @param n кількість чисел Люка
     */
    public static void showLucasNumbers(int n) {
        NumberSequence[] allLucasNumbers = createLucasArray(n);
        NumberSequence[] filteredNumbers = filterLucasNumbers(allLucasNumbers);

        System.out.println("Input values:");
        System.out.println("n = " + n);
        System.out.println("Lucas numbers:");
        for (NumberSequence num : allLucasNumbers) {
            System.out.print(num.getValue() + " ");
        }
        System.out.println("\nFiltered Lucas numbers:");
        for (NumberSequence num : filteredNumbers) {
            num.show();
        }
    }

    /**
     * Фільтрує числа Люка, залишаючи лише ті, що задовольняють певний критерій (корінь кубічний з (число + 1) є цілим)
     * @param numbers масив чисел Люка
     * @return відфільтрований масив чисел
     */
    public static NumberSequence[] filterLucasNumbers(NumberSequence[] numbers) {
        NumberSequence[] tempArray = new NumberSequence[numbers.length];
        int index = 0;

        for (NumberSequence num : numbers) {
            double temp = Math.cbrt(num.getValue() + 1);
            if (temp % 1 == 0) {
                tempArray[index++] = num;
            }
        }

        NumberSequence[] result = new NumberSequence[index];
        System.arraycopy(tempArray, 0, result, 0, index);

        return result;
    }
}
