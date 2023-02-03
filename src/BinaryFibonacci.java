import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class implements a binary algorithm to calculate the nth fibonacci number.
 * It then calls the method while incrementing the input and calculates the amount of time it took to run the method.
 */
public class BinaryFibonacci
{
    /**
     * calculates fibonacci numbers.
     * @param n the nth fibonacci number to return.
     * @return returns the sum of the two before-last fibonacci numbers, which is equivalent to the nth fibonacci number.
     */
    public static long BinaryFib(int n)
    {
        if (n < 0)
        {
            System.out.println("Invalid input. Must be non-negative integer");
            return 0;
        }
        if (n <= 1)
            return n;
        else
            return (BinaryFib(n-1) + BinaryFib(n-2));
    }

    /**
     * The main method implements a while loop to increment calls of the BinaryFib method, in increments of 5.
     * It opens a file named "outBinaryFib.txt" to keep track of the timings for each iteration, in milliseconds.
     * @param args no arguments expected.
     */
    public static void main(String[] args)
    {
        long binaryFibStartTime;
        long binaryFibEndTime;
        double binaryFibElapsedTime;

        long binaryFibResult;

        PrintWriter outWriter = null;
        FileWriter fileWriter;
        Scanner userInput = new Scanner(System.in);

        try
        {
            fileWriter = new FileWriter("outBinaryFib.txt");
            outWriter = new PrintWriter(fileWriter);
        }
        catch (IOException e)
        {
            System.out.println("Can't create outBinaryFib.txt. Program will now close");
            System.exit(1);
        }

        System.out.println("The program will iterate through the fibonacci calculator in increments of 5.\n");
        System.out.print("Enter starting value of n: ");
        int count = userInput.nextInt();

        System.out.print("\nEnter the max value of n: ");
        int max = userInput.nextInt();

        while(count <= max)
        {
            binaryFibStartTime = System.currentTimeMillis();
            binaryFibResult = BinaryFib(count);
            binaryFibEndTime = System.currentTimeMillis();
            binaryFibElapsedTime = binaryFibEndTime - binaryFibStartTime;
            outWriter.printf("[BinaryFib(%d)]\n\tResult: %d\n\tTime elapsed: %f seconds\n\n", count, binaryFibResult, (binaryFibElapsedTime/1000));

            count += 5;
        }
        outWriter.close();
    }
}