## Interleaved Strings 
Given strings A, B, and C, find whether C is formed by an interleaving of A and B.

An interleaving of two strings S and T is a configuration such that it creates a new string Y from the concatenation substrings of A and B and |Y| = |A + B| = |C|

**For example:**

><p>A = "XYZ"<br>
>B = "ABC"</p>

so we can make multiple interleaving string Y like, XYZABC, XAYBCZ, AXBYZC, XYAZBC and many more so here your task is to check whether you can create a string Y which can be equal to C.

Specifically, you just need to create substrings of string A and create substrings B and concatenate them and check whether it is equal to C or not.

**Note:** a + b is the concatenation of strings a and b.

Return true if C is formed by an interleaving of A and B, else return false.[🔗Goto](https://practice.geeksforgeeks.org/problems/interleaved-strings/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Amazon&category[]=Strings&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}
```
</details>

```java
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
         Boolean[][] dp = new Boolean[a.length()+1][b.length()+1];
         if(a.length() + b.length()!=c.length()){
             return false;
         }
         return helperFunc(a, b, c, 0, 0, dp);
	}
	public static boolean helperFunc(String a, String b, String c, int i, int j, Boolean[][] dp){
	    if(i==a.length() && j==b.length())
	        return true;
	    if(dp[i][j]!=null){
	        return dp[i][j];
	    }
	    if((i<a.length()) && (a.charAt(i)==c.charAt(i+j))){
	        boolean flag = helperFunc(a, b, c, i+1, j, dp);
	        dp[i][j] = flag;
	        if(flag){
	            return true;
	        }
	    }
	    if((j<b.length()) && (b.charAt(j) == c.charAt(i+j))){
	        boolean flag = helperFunc(a, b, c, i, j+1, dp);
	        dp[i][j] = flag;
	        if(flag){
	            return true;
	        }
	    }
	    return false;
	}
}
```