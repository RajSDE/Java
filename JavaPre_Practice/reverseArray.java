import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an Array: ");
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i<a; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i<a; i++){
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i<a/2; i++){
        int temp;
        temp = arr[i];
        arr[i] = arr[a-1-i];
        arr[a-1-i] = temp;
        }
        System.out.println();
        for (int i = 0; i<a; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
