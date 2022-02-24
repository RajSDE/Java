## Express as sum of power of natural numbers
Given two numbers n and x, find out the total number of ways n can be expressed as sum of xth power of unique natural numbers.As total number of ways can be very large ,so return the number of ways modulo 109 + 7.  [🔗Goto](https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1/?problemStatus=unsolved&difficulty[]=1&page=1&category[]=Recursion&query=problemStatusunsolveddifficulty[]1page1category[]Recursion#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
import java.io.*;
class ExpressSumPower
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
```
</details>

```java
class Solution
{
    static int MOD = (int)(1e9 + 7);
    static int res = 0;
    static int numOfWays(int x, int n){
        return (checkRecursive(x, x, 0, n)%MOD);
    }
    static int checkRecursive(int num, int x, int k, int n){
        if (x == 0)
            res++;
         
        int r = (int)Math.floor(Math.pow(num, 1.0 / n));
 
        for (int i = k + 1; i <= r; i++) {
            int a = x - (int)Math.pow(i, n);
            if (a >= 0)
                checkRecursive(num,x - (int)Math.pow(i, n), i, n);
        }
        return (res%MOD);
    }
}
```