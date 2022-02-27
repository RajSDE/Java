## Hit most Balloons
You are given an infinite two-dimensional grid. There are N balloons placed at certain coordinates of the grid. You have an arrow with yourself, which you will be using to shoot the balloons. You can select any point on the grid as your starting point and any point on the grid as the target point. When you fire the arrow, all ballons lying on the shortest path between the starting point and target point will be burst. Given the coordinates of the N ballons in an array arr, your task is to find out the maximum number of balloons that you can fire in one [🔗Goto](https://practice.geeksforgeeks.org/problems/4e75764f8f1638eb4f1c5478ca1986043e15e39a/1/?page=1&difficulty[]=1&sortBy=latest#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}
```
</details>

```java
class Solution {
    public int getGCD(int a, int b)
    {
        if(b==0)
            return a;
        else
            return getGCD(b,a%b);
    }
    public int mostBalloons(int N, int arr[][]) {

        if (N <= 2) {
            return N;
        }
        int maxBalloons = 2;

        for (int i = 0; i < N; i++) {
            int horizontal = 0, vertical = 0, identical = 0;
            Map<String, Integer> slope = new HashMap<>();

            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (arr[i][0] == arr[j][0] && arr[i][1] == arr[j][1]) {
                        identical++;
                    } else if (arr[i][0] == arr[j][0]) {
                        vertical++;
                    } else if (arr[i][1] == arr[j][1]) {
                        horizontal++;
                    } else {
                        int ydiff = arr[i][1] - arr[j][1];
                        int xdiff = arr[i][0] - arr[j][0];
                        int gcd = getGCD(Math.abs(ydiff), Math.abs(xdiff));
                        ydiff /= gcd;
                        xdiff /= gcd;
                        if (xdiff < 0) {
                            xdiff *= -1;
                            ydiff *= -1;
                        }
                        // Hashing the pair
                        String g = xdiff+"-"+ydiff;
                        if (slope.containsKey(g)) {
                            int value = slope.get(g);
                            value++;
                            slope.put(g, value);

                        } else {
                            slope.put(g, 1);
                        }
                    }
                }
            }
            int mostPointsOnSameLine = 1;
            for (Map.Entry<String, Integer> item : slope.entrySet()) {
                mostPointsOnSameLine =
                    Math.max(mostPointsOnSameLine, item.getValue());
            }
            maxBalloons =
                Math.max(maxBalloons, 1 + identical + mostPointsOnSameLine);
            maxBalloons = Math.max(
                maxBalloons, 1 + identical + Math.max(horizontal, vertical));
        }

        return maxBalloons;
    }
}
```