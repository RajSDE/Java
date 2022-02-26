## Escape the Forbidden Forest 
Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get them. But Penelope has magical powers that can build bridges across the dangerous river and take her friends to safety. The only bridges that can withstand the Devil's wrath are the ones built between two similar trees in the forest. 
Given str1 and str2 denoting the order of trees on either side of the river, find the maximum number of bridges that Penelope can build and save everyone from the Devil.
 
**Note:** Each tree in the forest belongs to one of the 3 categories represented by * or # or @ [🔗Goto](https://practice.geeksforgeeks.org/problems/a4f19ea532cee502aabec77c07e0d0a45b76ecf9/1#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        }
    }
}
```
</details>

```java
class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++){
            for(int j=0; j<=n2; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }
}
```