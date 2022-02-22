import java.util.Scanner;
public class kthMaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }
        for(int j = 0; j < n-1; j++) {
            for (int i = 0; i < n - 1; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Position of Kth Smallest Element: ");
        int k = sc.nextInt();
        System.out.println(arr[k-1]);
    }
}
