import javax.sound.sampled.Line;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class FibPair
{
    private int first;
    private int second;

    FibPair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
    FibPair(FibPair fibPair)
    {
        this.first = fibPair.getFirst();
        this.second = fibPair.getSecond();
    }

    public int getFirst()
    {
        return first;
    }

    public int getSecond()
    {
        return second;
    }
}

public class Main
{
    public static int BinaryFib(int n)
    {
        if (n <= 1 )
            return n;
        else
            return (BinaryFib(n-1) + BinaryFib(n-2));
    }

    public static FibPair LinearFibonacci(int n)
    {

        if (n <= 1)
        {
            return new FibPair(n,0);
        }

        else
        {
            FibPair result = LinearFibonacci(n-1);
            return new FibPair(result.getFirst()+result.getSecond(),result.getSecond());
        }

    }

    public static void main(String[] args)
    {
        long binaryFibStartTime;
        long binaryFibEndTime;
        long binaryFibElapsedTime;

        long linearFibonacciStartTime;
        long linearFibonacciEndTime;
        long linearFibonacciElapsedTime;

        long binaryFibResult;
        FibPair linearFibonacciResult;

        PrintWriter outWriter = null;
        FileWriter fileWriter;
        try
        {
            fileWriter = new FileWriter("out.txt");
            outWriter = new PrintWriter(fileWriter);
        }
        catch (IOException e)
        {
            System.out.println("Can't create out.txt. Program will now close");
            System.exit(1);
        }

        int count = 1;
        while(count <= 5)
        {
            binaryFibStartTime = System.currentTimeMillis();
            binaryFibResult = BinaryFib(count);
            binaryFibEndTime = System.currentTimeMillis();
            binaryFibElapsedTime = binaryFibEndTime - binaryFibStartTime;
            outWriter.printf("[BinaryFib(%d)] Result: %d\nTime elapsed: %d ms\n\n", count, binaryFibResult, binaryFibElapsedTime);

            linearFibonacciStartTime = System.currentTimeMillis();
            linearFibonacciResult = LinearFibonacci(count);
            linearFibonacciEndTime = System.currentTimeMillis();
            linearFibonacciElapsedTime = linearFibonacciEndTime - linearFibonacciStartTime;
            outWriter.printf("[LinearFibonacci(%d)] Result: %d\nTime elapsed: %d ms\n\n\n", count, linearFibonacciResult.getFirst(), linearFibonacciElapsedTime);

            count += 1;
        }
        outWriter.close();
    }
}