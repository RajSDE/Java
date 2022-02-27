## Smallest window containing 0, 1 and 2
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1. [🔗Goto](https://practice.geeksforgeeks.org/problems/d6e88f06b273a60ae83992314ac514f71841a27d/1#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
```
</details>

```java
class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int len = S.length();
        int zero = -1;
        int one = -1;
        int two = -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<len;i++){
            char ch = S.charAt(i);
            if(ch=='0'){
                zero = i;
            }
            if(ch == '1'){
                one = i;
            }
            if(ch == '2'){
                two = i;
            }
            if(zero>=0 && one>=0 && two>=0){
                
                int minpos = -1,maxpos = -1;
                if(zero<=one && zero <= two){
                    minpos = zero;
                }
                else if(one <= two && one <= two){
                    minpos = one;
                }else{
                    minpos = two;
                }
                
                if(zero>=one && zero >= two){
                    maxpos = zero;
                }
                else if(one >= two && one >= two){
                    maxpos = one;
                }else{
                    maxpos = two;
                }
                
                int y = (Math.abs(maxpos-minpos))+1;
                min = Math.min(min,y);
            }
        }
        
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        return min;
    }
};
```