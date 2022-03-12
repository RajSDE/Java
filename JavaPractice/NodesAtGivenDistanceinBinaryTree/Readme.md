## Nodes at given distance in binary tree 

Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available. [🔗Goto](https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1#) 


<details>
<summary>Full Code</summary>

```java
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}
```
</details>

```java
class Solution
{

    public static ArrayList<Integer>v = new ArrayList<Integer>();

    public static void findKDistanceDownNode(Node root, int k)
    /* Recursive function to find all the nodes at distance k in the
       tree (or subtree) rooted with given root. See  */
    {
        // Base Case
        if (root == null || k < 0)  return;
    
        // If we reach a k distant node, add to vector
        if (k==0)
        {
            v.add(root.data);
            return;
        }
    
        // Recur for left and right subtrees
        findKDistanceDownNode(root.left, k-1);
        findKDistanceDownNode(root.right, k-1);
    }
    
    public static int findKDistanceNode(Node root, int target , int k)
    // Finds all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.  This function
    // Returns distance of root from target node, it returns -1 if target
    // node is not present in tree rooted with root.
    {
        // Base Case 1: If tree is empty, return -1
        if (root == null) return -1;
        
        // If target is same as root.  Use the downward function
        // to find all nodes at distance k in subtree rooted with
        // target or root
        if (root.data == target)
        {
            findKDistanceDownNode(root, k);
            return 0;
        }
        
        // Recur for left subtree
        int dl = findKDistanceNode(root.left, target, k);
        
        // Check if target node was found in left subtree
        if (dl != -1)
        {
             // If root is at distance k from target, add root value to vector
             // Note that dl is Distance of root's left child from target
             if (dl + 1 == k)
                v.add(root.data);
            
             // Else go to right subtree and print all k-dl-2 distant nodes
             // Note that the right child is 2 edges away from left child
             else
                findKDistanceDownNode(root.right, k-dl-2);
            
             // Add 1 to the distance and return value for parent calls
             return 1 + dl;
        }
        
        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left subtree
        int dr = findKDistanceNode(root.right, target, k);
        if (dr != -1)
        {
             if (dr + 1 == k)
                v.add(root.data);
             else
                findKDistanceDownNode(root.left, k-dr-2);
             return 1 + dr;
        }
        
        // If target was neither present in left nor in right subtree
        return -1;
    }



    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        v.clear();
        
        findKDistanceNode(root, target, k);
        
        Collections.sort(v);
        
        return v;
    }
};
```