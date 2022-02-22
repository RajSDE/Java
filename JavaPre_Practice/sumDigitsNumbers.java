import java.util.Scanner;

//Sum of digits of a number
public class sumDigitsNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to find the sum of its digits: ");
        int a = sc.nextInt();
        int b=0;
        while (a!=0){
            int c = a%10;
            b+=c;
            a=a/10;
        }
        System.out.println("Reverse of the number is " + b);

    }

}
