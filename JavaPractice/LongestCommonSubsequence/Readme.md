## Longest Common Subsequence 

Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase. [🔗Goto](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1/?page=2&difficulty[]=1&status[]=unsolved&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
```
</details>

```java
class Solution
{
   static int lcs(int x, int y, String s1, String s2)
   {
       int[][]dp = new int[x+1][y+1];
       
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
           
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1]+1;
               }
                else{
                   dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
               }
               
           }
       }
      
      return dp[x][y]; 
   }
   
}
```