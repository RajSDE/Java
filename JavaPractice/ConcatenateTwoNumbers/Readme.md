## Concatenate two numbers
Given an array numbers[] of N positive integers and a positive integer X, The task is to find the number of ways that X can be obtained by writing pair of integers in the array numbers[] next to each other. In other words, find the number of ordered pairs (i,j) such that i != j and X is the concatenation of numbers[i] and numbers[j]. [🔗Goto](https://practice.geeksforgeeks.org/problems/1df2447c003940512562d766cf0583bbdc7a75ed/1#) 


<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
}
```
</details>

```java
class Solution 
{ 
    long countPairs(int N, int X, int numbers[]) 
    { 
        Map<String, Integer> map = new HashMap<>();
        for(int i:numbers){
            map.put(Integer.toString(i), map.getOrDefault(Integer.toString(i),0)+1);
        }
        String st =  Integer.toString(X);
        long count=0;
        
        for(int i=1; i<st.length(); i++){
            String fs = st.substring(0,i);
            String ss = st.substring(i);
            if(map.containsKey(fs) && map.containsKey(ss)){
                if(fs.equals(ss)){
                    int k = map.get(fs);
                    count+=(long)(k*(k-1));
                }else{
                    count+=(long)(map.get(fs)*map.get(ss));
                }
            }
        }
        return count;
    }
} 
```