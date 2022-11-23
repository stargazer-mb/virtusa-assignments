using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        HashSet<int> h=new HashSet<int>();
        int n1=Convert.ToInt32(Console.ReadLine());  
        var stringArray = Console.ReadLine().Split(' ');
        int[] a=new int[n1]; 
        for (var i = 0; i < n1; i++)
        {
            a[i] = int.Parse(stringArray[i]);
            h.Add(a[i]);
        }
        int n2=Convert.ToInt32(Console.ReadLine());  
        stringArray = Console.ReadLine().Split(' ');
        int[] b=new int[n2]; 
        for (var i = 0; i < n2; i++)
        {
            b[i] = int.Parse(stringArray[i]);
            h.Add(b[i]);
        }
        foreach(int x in h)
        {
            Console.Write(x+" ");
        }
    }
}