## Clone a stack without using extra space
Given elements of a stack, clone the stack without using extra space. [🔗Goto](https://practice.geeksforgeeks.org/problems/clone-a-stack-without-usinig-extra-space/1/?page=1&difficulty[]=1&status[]=unsolved&sortBy=accuracy#) 

**Example 1:**

><p>Input:<br>
>N = 10<br>
>st[] = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7}<br>
>Output:<br>
>1 </p>

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
            int N = Integer.parseInt(read.readLine());
    
            String S[] = read.readLine().split(" ");
            
            Stack<Integer> st = new Stack<Integer>();
            ArrayList<Integer> copy = new ArrayList<>();
            
            for(int i=0; i<N; i++)
            {
                st.push(Integer.parseInt(S[i]));
                copy.add(Integer.parseInt(S[i]));
            }
            
            Collections.reverse(copy);
            
            Stack<Integer> cloned = new Stack<Integer>();
            
            Solution ob = new Solution();
            
            ob.clonestack(st,cloned);
            
            ArrayList<Integer> check = new ArrayList<>();
            while(cloned.size() != 0)
                check.add(cloned.pop());
            
            int flag = 0;
            
            if(copy.equals(check))
                flag = 0;
            else
                flag = 1;
            
            System.out.println(1-flag);
        }
    }
}
```
</details>

```java
class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        // // approach 1:
        // if(st.isEmpty())
        //     return;
        // int top = st.peek();
        //     st.pop();
        // clonestack(st,cloned);
        // cloned.push(top);
        
        // // approach 2:
        cloned.addAll(st);
        
        // // approach 3:
        // if(st.isEmpty())
        //     return;
        // int top = st.pop();
        // clonestack(st,cloned);
        // cloned.push(top);
        
        // // approach 4:
        // for(int i=0; i<st.size(); i++){
        //     cloned.push(st.get(i));
        // }
    }
}
```