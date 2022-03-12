## LCS of three strings
Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences [🔗Goto](https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1/?page=4&difficulty[]=1&status[]=unsolved&category[]=Arrays&category[]=Strings&sortBy=accuracy#) 

**Example 1:**

><p>Input:
>A = "geeks", B = "geeksfor", <br>
>C = "geeksforgeeks"<br>
>Output: 5</p>

Explanation: "geeks"is the longest common
subsequence with length 5.

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
}
```
</details>

```java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int [][][]dp = new int[n1+1][n2+1][n3+1];
        for(int i = 1;i<=n1;i++){
            for(int j = 1;j<=n2;j++){
                for(int k =1;k<=n3;k++){
                    if(A.charAt(i-1)==B.charAt(j-1) && B.charAt(j-1)==C.charAt(k-1)){
                        dp[i][j][k]=1+dp[i-1][j-1][k-1];
                    }
                    else{
                        dp[i][j][k]=Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}
```