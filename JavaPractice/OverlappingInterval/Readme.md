## Overlapping Problem
Given a collection of Intervals, the task is to merge all of the overlapping Intervals. [🔗Goto](https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Microsoft&category[]=Arrays&category[]=Strings&sortBy=accuracy#) 

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
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
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
    public int[][] overlappedInterval(int[][] Intervals)
    {
        //sort according the first element
        Arrays.sort(Intervals, new Comparator<int []>(){
            public int compare(int []arr1,int []arr2){
                return arr1[0] - arr2[0];
            }
        });
        
        Stack<int[]> st = new Stack<>();
        //Iterate for each eleemnt and push into stack
        
        for(int[] arr:Intervals){
            //if stack is empty then push first element
            if(st.empty()){
                st.push(arr);
            }
            else{
                int [] temp = st.peek();
                
                //for a different range add the new range
                if(temp[1]<arr[0]){
                    st.push(arr);
                }
                
                // If range overlapps then modify the 2nd element
                else if(temp[1]>=arr[0] && temp[1] < arr[1]){
                    int []popped = st.pop();
                    popped[1] = arr[1];
                    st.push(popped);
                }
            }
        }
        int ans[][]=new int[st.size()][2];
        int i = 0;
        
        // Convert Stack Element into Array
        for(int[]arr : st){
            ans[i] = arr;
            i++;
        }
        return ans;
    }
}
```