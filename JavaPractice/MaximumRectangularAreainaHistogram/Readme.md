## Maximum Rectangular Area in a Histogram
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr. [🔗Goto](https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1/?page=3&difficulty[]=1&status[]=unsolved&sortBy=submissions) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}
```
</details>

```java
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long maxAns = 0;
        int ps[] = previousSmaller(hist);
        int ns[] = nextSmaller(hist);
        for(int i=0; i<hist.length; i++){
            long cur = ((ns[i]-ps[i])-1)*hist[i];
            maxAns = Math.max(cur,maxAns);
        }
        return maxAns;
    }
    public static int[] previousSmaller(long hist[]){
        int[] ps = new int[hist.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<hist.length; i++){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i] = -1;
            }else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }
    public static int[] nextSmaller(long hist[]){
        int[] ns = new int[hist.length];
        Stack<Integer> s = new Stack<>();
        for(int i=hist.length-1; i>=0; i--){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ns[i] = hist.length;
            }else{
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;
    }   
}
```