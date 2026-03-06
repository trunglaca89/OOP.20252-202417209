import java.util.Arrays;
import java.util.Scanner;

public class Ex6_5{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
        // Enter Array Size
        System.out.print("Enter the number of elements in the array: ");
        int n = keyboard.nextInt();
        
        // Int Array
        int[] my_array = new int[n];
        
        // Enter each element
        for (int i = 0; i < n; i++){
            my_array[i] = keyboard.nextInt();
        }
        
        System.out.println("\nOriginal array: " + Arrays.toString(my_array));
        
        // Sort Array
        Arrays.sort(my_array);
        System.out.println("Sorted array: " + Arrays.toString(my_array));
        
        // Array Sum
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += my_array[i];
        }
        
        // Tính trung bình
        double average = (double) sum / n;
        
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
        
        keyboard.close();
    }
}
