## Robots
There are two kinds of bots A and B in a 1-D array. A bot can only move left while B can only move right. There are also empty spaces in between represented by #. But its also given that the bots cannot cross over each other.

Given the initial state and final state, we should tell if the transformation is possible.

**NOTE:** There can be many bots of the same type in a particular array. [🔗Goto](https://practice.geeksforgeeks.org/problems/d35adfbe367861ec1e67bea6e0efebe0a0ee3550/1#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class Solution{
    public static String moveRobots(String s1, String s2){
        int i=0, j=0, n=s1.length();
        while(i<n && j<n){
            if(s1.charAt(i)=='#'){
                i++;    // increment till we get the char
            }
            else if(s2.charAt(j)=='#'){
                j++;    // increment till we get the char
            }
            // now comparing both char are same or not
            else if(s1.charAt(i)!=s2.charAt(j)){
                return "No";    // if not same, return "No"
            }else if(s1.charAt(i)=='B' && i>j){
                return "No";    // if same B in both, but i greater than j
                                // that means, i is a left position than j
                                // and B can't move left or back
                                // So, return "No"
            }else if(s1.charAt(i)=='A' && i<j){
                return "No";    // if same A in both, but i smaller than j
                                // that means, i is a right position than j
                                // and A can't move right or forward
                                // So, return "No"
            }
            // increment for next match
            else{
                i++;
                j++;
            }
        }
        return "Yes";
    }
}

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}
```
</details>

```java
class Solution{
    public static String moveRobots(String s1, String s2){
        int i=0, j=0, n=s1.length();
        while(i<n && j<n){
            if(s1.charAt(i)=='#'){
                i++;    // increment till we get the char
            }
            else if(s2.charAt(j)=='#'){
                j++;    // increment till we get the char
            }
            // now comparing both char are same or not
            else if(s1.charAt(i)!=s2.charAt(j)){
                return "No";    // if not same, return "No"
            }else if(s1.charAt(i)=='B' && i>j){
                return "No";    // if same B in both, but i greater than j
                                // that means, i is a left position than j
                                // and B can't move left or back
                                // So, return "No"
            }else if(s1.charAt(i)=='A' && i<j){
                return "No";    // if same A in both, but i smaller than j
                                // that means, i is a right position than j
                                // and A can't move right or forward
                                // So, return "No"
            }
            // increment for next match
            else{
                i++;
                j++;
            }
        }
        return "Yes";
    }
}
```