using System;

class Program
{
    
    static string reverse(string num)
    {
        char[] k=num.ToCharArray();
        Array.Reverse(k);
        return new string(k);
    }
    
    static void Main() 
    {
        string num=Console.ReadLine();
        int n=num.Length;
        if(n%2==0)
        {
            int l=n/2;
            Console.Write(reverse(num.Substring(0,l)));
            Console.Write(reverse(num.Substring(l)));
        }
        else
        {
            Console.Write(reverse(num));
        }
    }
}