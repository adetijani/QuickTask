import java.util.HashSet;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};
        System.out.println("The smallest non-occuring integer in array1:" + findSmallestNonOccuringInteger(array1));
        System.out.println("The smallest non-occuring integer in array2:" + findSmallestNonOccuringInteger(array2));
    }



    public static int findSmallestNonOccuringInteger(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : array) {
            if (num > 0) {
                numbers.add(num);
            }
        }
            int smallestNonOccuringInteger = 1;
            while (numbers.contains(smallestNonOccuringInteger)) {
                smallestNonOccuringInteger++;
            }
            return smallestNonOccuringInteger;
        }
}

