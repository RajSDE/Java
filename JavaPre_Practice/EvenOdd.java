import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        if (a%2==0){
            System.out.println("Given number is Even");
        }
        else{
            System.out.println("Given number is Odd");
        }
    }
}
