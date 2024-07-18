import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Array  example given in question:
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        //The getSmallestNonOccuringInteger method is called with each array and printed out
        System.out.println("The smallest non-occuring integer in array1:" + getSmallestNonOccuringInteger(array1));
        System.out.println("The smallest non-occuring integer in array2:" + getSmallestNonOccuringInteger(array2));
    }



    public static int getSmallestNonOccuringInteger(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : array) {
            if (num > 0) {
                numbers.add(num);
            }
        }
        /* to find the smallest non occuring integer, we start with 1 and if 1 occurs we check 2 and keep
         going until we find a positive integer that is not in the set and return it */

            int smallestNonOccuringInteger = 1;
            while (numbers.contains(smallestNonOccuringInteger)) {
                smallestNonOccuringInteger++;
            }
            return smallestNonOccuringInteger;
        }
}

