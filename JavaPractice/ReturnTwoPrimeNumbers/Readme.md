## Return two prime numbers
Given an even number N (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only the pair whose minimum value is the smallest among all the minimum values of pairs and print the minimum element first.

**NOTE:** A solution will always exist, read Goldbachs conjecture. [🔗Goto](https://practice.geeksforgeeks.org/problems/return-two-prime-numbers2509/1#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
```
</details>

```java
class Solution{
    static List<Integer> primeDivision(int N){
        int i = 2;
        int j = N-1;
        List<Integer> list = new ArrayList<>();
        
        while(j>=i){
            int sum=i+j;
            if(sum==N){
                if(isPrime(i) && isPrime(j)){
                    list.add(i);
                    list.add(j);
                    return list;
                }else{
                    i++;
                    j--;
                }
            }
            else if(sum>N){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }
    static boolean isPrime(int N){
        for(int i=2; i<=Math.sqrt(N); i++){
            if(N%i==0){
                return false;
            }
        }
        return true;
    }
}
```