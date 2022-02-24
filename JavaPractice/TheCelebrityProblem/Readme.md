## The Celebrity Problem
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.  [🔗Goto](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1/?page=2&difficulty[]=1&status[]=unsolved&company[]=Amazon&company[]=Infosys&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
}
```
</details>

```java
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	for(int i =0;i<n;i++){
    	    st.push(i);
    	}
    	while(st.size() >= 2 ){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(arr[i][j] == 1){
    	        st.push(j);
    	    }
    	    else{
    	        st.push(i);
    	    }
    	}
    	
    	int pot = st.pop();
    	for(int i =0;i<n;i++){
    	    if(i != pot){
    	        if(arr[i][pot] == 0 || arr[pot][i]==1){
    	            return -1;
    	        }
    	    }
    	}
    	return pot;
    }
}
```