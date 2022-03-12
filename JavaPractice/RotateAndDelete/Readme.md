## Rotate And Delete
Given an array arr[] of N integers. Do the following operation n-1 times. For every Kth operation:

> Right rotate the array clockwise by 1.
> Delete the (n-k+1)th last element.
> Now, find the element which is left at last.

**Input:**

The first line of input contains an integer T denoting the number of test cases. Then T test cases follows. Each test case contains two lines. The first line of each test case contains an integer N. Then in the next line are N space separated values of the array arr[].

**Output:**

For each test case in a new line print the required result. [🔗Goto](https://practice.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1/?page=2&difficulty[]=1&status[]=unsolved&category[]=Arrays&category[]=Strings&sortBy=accuracy#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    ArrayList<Integer> arr = new ArrayList<Integer>(n);
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr.add(Integer.parseInt(inputLine[i]));
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.rotateDelete(arr, n));
		    
		}
	}
}

```
</details>

```java
class Solution{
    public static int rotateDelete(ArrayList<Integer> ar, int n){
    for(int i = 1; i < n; ++i){
        int temp = ar.get((ar.size() - 1));
        ar.add(0 , temp);
        ar.remove((ar.size() - 1));
        if((ar.size() - i) < 0)
            ar.remove(0);
        else
            ar.remove(ar.size() - i);
        }
        return ar.get(0);
    }
}
```