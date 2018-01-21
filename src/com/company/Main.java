package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Main {
    public static int slowCount(int[] a)
    {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N-3; i++)
            for (int j = i+1; j < N-2; j++)
                for (int k = j+1; k < N-1; k++)
                    for (int l = k+1; l < N; l++)
                        if (a[i] + a[j] + a[k] + a[l] == 0)
                            count++;
        return count;
    }

    public static int binarySearch(int arr[], int x, int start)
    {
        int l = start, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static int quickCount(int[] a)
    {
        Arrays.sort(a);
        int N = a.length;
        int number;
        int count = 0;
        for (int i = 0; i < N-3; i++)
            for (int j = i+1; j < N-2; j++)
                for (int k = j+1; k < N-1; k++) {
                    number = -(a[i] + a[j] + a[k]);
                    if (binarySearch(a, number, k+1) != -1 && ((a[i] < a[j]) && (a[j] < a[k])) )
                        count++;
                }
        return count;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch time = new Stopwatch();
        double startTime;
        double endTime;
        //1Kints.txt
        startTime = time.elapsedTime();
        StdOut.println(slowCount(a));
        endTime = time.elapsedTime();
        StdOut.println("slowCount() = " + (endTime-startTime));
        startTime = time.elapsedTime();
        StdOut.println(quickCount(a));
        endTime = time.elapsedTime();
        StdOut.println("quickCount() = " + (endTime-startTime));

        //2Kints.txt
        a = In.readInts(args[1]);
        startTime = time.elapsedTime();
        StdOut.println(slowCount(a));
        endTime = time.elapsedTime();
        StdOut.println("slowCount() = " + (endTime-startTime));
        startTime = time.elapsedTime();
        StdOut.println(quickCount(a));
        endTime = time.elapsedTime();
        StdOut.println("quickCount() = " + (endTime-startTime));

        //4Kints.txt
        a = In.readInts(args[2]);
        startTime = time.elapsedTime();
        StdOut.println(slowCount(a));
        endTime = time.elapsedTime();
        StdOut.println("slowCount() = " + (endTime-startTime));
        startTime = time.elapsedTime();
        StdOut.println(quickCount(a));
        endTime = time.elapsedTime();
        StdOut.println("quickCount() = " + (endTime-startTime));
    }
}
