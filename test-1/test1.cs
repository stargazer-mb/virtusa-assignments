using System;

public class Program
{
    public static void Main()
    {
        // int n=Convert.ToInt32(Console.ReadLine());  
        var stringArray = Console.ReadLine().Split(' ');
        int n=stringArray.Length;
        int[] a=new int[n];
        for (var i = 0; i < n; i++)
        {
            a[i] = int.Parse(stringArray[i]);
        }
        int currMax=a[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>currMax)
            {
                Console.Write(a[i]+" ");
                currMax=a[i];
            }
        }
    }
}