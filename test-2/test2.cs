using System;

class Program
{
    static void Main() 
    {
        string s=Console.ReadLine();
        char[] k= s.ToCharArray();
        for(int i=0;i<k.Length;i++)
        {
            int d=(int)k[i];
            d%=97;
            // Console.Write(d+" ");
            d+=3;
            d%=26;
            d+=97;
            // Console.WriteLine(d);
            k[i]=(char)d;
        }
        string x=new string(k);
        Console.Write(x);
    }
}