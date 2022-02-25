## Minimum number of jumps
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
**Note:** Return -1 if you can't reach the end of the array.  [🔗Goto](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Amazon&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
```
</details>

```java
class Solution{
    static int minJumps(int[] arr){
        int i=0;
        int n = arr.length;
        int jumps = 0;
        if(n==1){
            return 0;
        }
        while(i<n-1){
            if(arr[i]==0){
                return -1;
            }
            int maxIdx = i+1;
            if(i+arr[i]>=n-1){
                return jumps+1;
            }
            for(int j=i+1; j<n && j<=i+arr[i]; j++){
                if(arr[maxIdx]+maxIdx<arr[j]+j){
                    maxIdx=j;
                }
            }
            i = maxIdx;
            jumps++;
        }
        return jumps;
    }
}
```