## Maximum Product SubArray
Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray. [🔗Goto](https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/0/?page=1&difficulty[]=1&status[]=unsolved&company[]=Amazon&sortBy=submissions) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
```
</details>

```java
class Solution {
    long maxProduct(int[] arr, int n) {
        long min = arr[0];
        long max = arr[0];
        long ans = arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]<0){
                long temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(arr[i], max*arr[i]);
            min = Math.min(arr[i], min*arr[i]);
            
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
```