import java.util.*;

public class BFSinJava
{
	
    static class pair
    {
    	int first, second;
    	
    	public pair(int first, int second)
    	{
    		this.first = first;
    		this.second = second;
    	}
    }

    static int x4[] = { -1, 0, 1, 0 };
    static int y4[] = { 0, 1, 0, -1 };
    static int r;
    static int c;
    static int a[][];
    // static boolean vis[][];

    static int BFS(int si, int sj)
    {
        int count=0;
    	Queue<pair > q = new LinkedList<>();
    	q.add(new pair(si,sj));
    	while (!q.isEmpty())
    	{
    		pair p = q.peek();
    		int i = p.first;
    		int j = p.second;
    		count++;
    		a[i][j]=0;
    		q.remove();
    		for(int d = 0; d < 4; d++)
    		{
    			int ni = i + x4[d];
    			int nj = j + y4[d];
    			if ( (ni >= 0 && nj >= 0 && ni < r && nj < c) && (a[ni][nj]==1) )
    			{
    				q.add(new pair(ni,nj));
    			}
    		}
    	}
    	return count;
    }


    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	r=sc.nextInt();
    	c=sc.nextInt();
    	a=new int[r][c];
    	for(int i=0;i<r;i++)
    	{
    	    for(int j=0;j<c;j++)
    	    {
    	        a[i][j]=sc.nextInt();
    	    }
    	}
    	ArrayList<Integer> choices=new ArrayList<Integer>();
    	for(int i=0;i<r;i++)
    	{
    	    for(int j=0;j<c;j++)
    	    {
    	        if(a[i][j]==1)
    	        {
    	            int count=BFS(i, j);
    	            choices.add(count);
    	        }
    	    }
    	}
    	System.out.println(choices);
    	Collections.sort(choices, Collections.reverseOrder());
    	System.out.println(choices);
    	int ans=0;
    	for(int i=1;i<choices.size();i+=2)
    	{
    	    ans+=choices.get(i);
    	}
    	System.out.println(ans);
    }
}

