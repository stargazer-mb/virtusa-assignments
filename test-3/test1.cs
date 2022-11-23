using System;
using System.Collections;

class Program
{
    static void Main() 
    {
        string a=Console.ReadLine();
        Stack s=new Stack();
        bool flag=true;
        for(int i=0;i<a.Length;i++)
        {
            if(a[i]=='(' || a[i]=='{' || a[i]=='[')
            {
                s.Push(a[i]);
            }
            else
            {
                char top=(char)s.Peek();
                if((top=='(' && a[i]==')') && (top=='{' && a[i]=='}') && (top=='[' && a[i]==']') )
                {
                    s.Pop();
                }
                else
                {
                    flag=false;
                    break;
                }
            }
        }
        if(flag) Console.Write("balanced");
        else Console.Write("unbalanced");
    }
}