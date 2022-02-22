import java.util.Scanner;

public class printFirstN {
    public static void main(String[] args) {
        System.out.print("Enter the value of N: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i=0;
        while (i<a){
            System.out.println(i+1);
            i++;
        }
    }
}
