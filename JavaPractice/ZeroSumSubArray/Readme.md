## Zero Sum Subarrays
You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0. [🔗Goto](https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1/?page=8&difficulty[]=1&status[]=unsolved&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}
```
</details>

```java
class Solution{
    public static long findSubarray(long[] arr ,int n){
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        map.put(0,1);
        while(i<arr.length){
            sum += arr[i];
            if(map.containsKey(sum)){
                count +=map.get(sum);
                map.put(sum,map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
            }
            i++;
        }
        return count;
    }
}
```