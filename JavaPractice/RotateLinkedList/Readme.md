## Rotate Linked List
Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list. [🔗Goto](https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1/?page=1&difficulty[]=1&status[]=unsolved&company[]=Amazon&company[]=Infosys&sortBy=submissions#) 

<details>
<summary>Full Code</summary>

```java
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
```
</details>

```java
class Solution{
   public Node rotate(Node head, int k) {
       if(head == null) return null;
       
       int n = 0;
       Node t = head;
       Node lastNode = head;
       while(t!=null){
           n++;
           t = t.next;
           // move to the last node
           if(lastNode.next!= null)
                lastNode = lastNode.next;
       }
       if(k >= n){
           return head;
       }
       Node temp = head;
       Node Head = head;
       int i = 0;
       while(i<(k-1)){
           i++;
           temp = temp.next;
       }
       
       Node newHead = temp.next;
       temp.next = null;
       lastNode.next = Head;
       return newHead;
   }
}
```