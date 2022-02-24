## Next Permutation
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N. [🔗Goto](https://practice.geeksforgeeks.org/problems/next-permutation5226/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Infosys&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class NextPermutation{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
```
</details>

```java
class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        int i=N-2;
        while(i>=0)
        {
            // get index of larger value
            if(arr[i]<arr[i+1])
            break;
            i--;
        }
        if(i>=0)
        {
            
            int j=N-1;
            while(arr[i]>=arr[j])
            j--;
            swap(i,j,arr);
        }
        reverse(i+1,arr);
        ArrayList<Integer> al=new ArrayList<>();
        for(int a:arr)
        al.add(a);
        
        return al;
    }
    static void swap(int i,int j,int arr[])
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void reverse(int i,int arr[])
    {
        int start=i;
        int end=arr.length-1;
        while(start<end)
        {
            swap(start,end,arr);
            start++;
            end--;
        }
    }
}
```