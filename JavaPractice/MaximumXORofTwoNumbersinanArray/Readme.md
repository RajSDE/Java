## Maximum XOR of two numbers in an array 
Given an array of non-negative integers of size N. Find the maximum possible XOR between two numbers present in the array. [🔗Goto](https://practice.geeksforgeeks.org/problems/maximum-xor-of-two-numbers-in-an-array/1/?page=2&difficulty[]=1&status[]=unsolved&sortBy=accuracy#) 

**Example 1:**

><p>Input:<br>
>Arr = {25, 10, 2, 8, 5, 3}<br>
>Output: 28<br>
>Explanation:<br>
>The maximum result is 5 ^ 25 = 28.
</p>

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[n];
            for(int i = 0; i < n; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
           System.out.println(ob.max_xor(v, n));
            
        }
    }
}

```
</details>

```java
class Solution
{
    public static int max_xor(int arr[], int n)
    {
        int maxXor = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int xor = arr[i]^arr[j];
                maxXor = Math.max(maxXor,xor);
            }
        }
        return maxXor;
    }
}
```