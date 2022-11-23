using System;
using System.Collections;

class Program
{
    static void Main() 
    {
        int n=Convert.ToInt32(Console.ReadLine());
        var a=Console.ReadLine().Split(' ');
        Stack s=new Stack();
        for(int i=0;i<n;i++)
        {
            if(a[i]=="../" && s.Count!=0)
            {
                s.Pop();
            }
            else if(a[i]!="./")
            {
                s.Push(a[i]);
            }
        }
        Console.Write(s.Count);
    }
}