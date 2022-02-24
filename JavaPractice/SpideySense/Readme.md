## SpideSense
Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters O, B, and W where: 
O represents an open space.
B represents a bomb.
W represents a wall.
You have to replace all of the Os (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.  [🔗Goto](https://practice.geeksforgeeks.org/problems/spidey-sense5556/1#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
```
</details>

```java
class Solution
{
    public static int[][] findDistance(char mat[][], int n,int m)
    {
        // Your code goes here
        int a[][] = new int [n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j]=='O'){
                    a[i][j]=Integer.MAX_VALUE;
                }
                else if(mat[i][j]=='W'){
                    a[i][j]=-1;
                }
                else{
                    a[i][j] = 0;
                }
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(a[i][j]==0){
                    dfs(a,i+1,j,i,j,n,m);
                    dfs(a,i-1,j,i,j,n,m);
                    dfs(a,i,j+1,i,j,n,m);
                    dfs(a,i,j-1,i,j,n,m);
                }
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(a[i][j]==Integer.MAX_VALUE){
                    a[i][j]=-1;
                }
            }
        }
        return a;
    }
    
    public static void dfs(int [][] a,int i ,int j ,int x,int y,int n,int m){
        if(i<0 || i>=n || j < 0 || j>=m){
            return;
        }
        if(a[i][j] > a[x][y]){
            a[i][j] = Math.min(a[i][j],a[x][y]+1);
            dfs(a,i+1,j,i,j,n,m);
            dfs(a,i-1,j,i,j,n,m);
            dfs(a,i,j+1,i,j,n,m);
            dfs(a,i,j-1,i,j,n,m);
        }
    }
}
```