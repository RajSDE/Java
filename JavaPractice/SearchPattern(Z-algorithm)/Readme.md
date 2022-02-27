## Search Pattern (Z-algorithm)
Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1. [🔗Goto](https://practice.geeksforgeeks.org/problems/8dcd25918295847b4ced54055eae35a8501181c1/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Microsoft&category[]=Arrays&category[]=Strings&sortBy=accuracy#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
```
</details>

```java
class Solution
{
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        String str = "";
        int len = pat.length();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<=S.length()-len;i++){
            if(S.charAt(i)==pat.charAt(0)){
                str = S.substring(i,i+len);
                if(str.equals(pat)){
                   list.add(i+1);
                }
            }
        }
        return list;
    }
}
```