using System;

public class Program
{
    public static int Main()
    {
        int n=Convert.ToInt32(Console.ReadLine());  
        var stringArray = Console.ReadLine().Split(' ');
        int[] a=new int[n];
        int key=Convert.ToInt32(Console.ReadLine()); 
        for (var i = 0; i < n; i++)
        {
            a[i] = int.Parse(stringArray[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]==key) Console.Write("Element found at : "+i);
        }
        return 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        } 
        int l=0,h=n-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(key==a[mid])
            {
                Console.Write("Element found at : "+i);
                return 0;
            }
            else if(key<a[mid])
            {
                h=mid-1;
            }
            else if(key>a[mid])
            {
                l=mid+1;
            }
        }
        Console.Write("Key element not found");
        return 0;
    }
}