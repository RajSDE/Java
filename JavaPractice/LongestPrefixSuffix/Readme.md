## Longest Prefix Suffix
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

**NOTE:** Prefix and suffix can be overlapping but they should not be equal to the entire string.[🔗Goto](https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1/?page=4&difficulty[]=1&status[]=unsolved&company[]=Amazon&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
```
</details>

```java
class Solution {
    int lps(String s) {
        // code here
        int n = s.length();
        int i = 0 , j = 1;
        int[] lps = new int[n];
        lps[0] = 0;
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i + 1;
                j++;
                i++;
            }else{
                if(i == 0){
                    lps[j] = 0;
                    j++;
                }else{
                    i = lps[i - 1];
                }
            }
        }
        return lps[n - 1];
    }
}
```