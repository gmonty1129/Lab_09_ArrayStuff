import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random random = new Random();
        int sum = 0;
        double average = 0;


        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
            sum += dataPoints[i];
        }


        for (int i = 0; i < dataPoints.length; i++) {
            if (i < dataPoints.length - 1) {
                System.out.print(dataPoints[i] + " | ");
            } else {
                System.out.print(dataPoints[i]);
            }
        }
        System.out.println();


        average = getAverage(dataPoints);
        System.out.println("The average of dataPoints is: " + average);


        int minValue = dataPoints[0];
        int maxValue = dataPoints[0];
        for (int num : dataPoints) {
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }
        System.out.println("The minimum value is: " + minValue);
        System.out.println("The maximum value is: " + maxValue);


        int userValue = getRangedInt("Please enter a number between 1 and 100: ", 1, 100);
        int count = 0;
        for (int num : dataPoints) {
            if (num == userValue) {
                count++;
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " times in the array.");
        System.out.println();


        int userValue2 = getRangedInt("Please enter another number between 1 and 100: ", 1, 100);
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue2) {
                System.out.println("The value " + userValue2 + " was found at array index " + i + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The value " + userValue2 + " was not found in the array.");
        }
    }


    public static double getAverage(int values[]) {
        int sum = 0;
        for (int num : values) {
            sum += num;
        }
        return (double) sum / values.length;
    }


    public static int getRangedInt(String prompt, int low, int high) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= low && input <= high) {
                    return input;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }
}
