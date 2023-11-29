import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.
         */
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));

        System.out.println(Arrays.toString(sumOfTwo(numbers, 9)));

    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if((j != i) && ((numbers[i] + numbers[j]) == target)) {
                    solution[0] = j;
                    solution[1] = i;
                    return solution;
                }
            }
        }
        return null;
    }
    //this is brute force, the solution O(n²)
    public static int[] sumOfTwo(int[] numbers, int target) {
        for(int i = 0; i < numbers.length - 1; i++) {
            int complement = target - numbers[i];
            int complementIndex = binarySearch(numbers, complement, i + 1, numbers.length-1);

            if(complementIndex!= -1) {
                return new int[]{i, complementIndex};
            }
        }
        return new int[]{-1, -1};
    }
    public static int binarySearch(int[] numbers, int target, int low, int high) {
        if(high >= low) {
            int mid = low + (high - low) / 2;
            if(numbers[mid] == target) {
                return mid;
            } if(numbers[mid] < target) {
                return binarySearch(numbers, target, mid+1, high);
            } else {
                return binarySearch(numbers, target, low, mid-1);
            }
        }
        return -1;
    }
}