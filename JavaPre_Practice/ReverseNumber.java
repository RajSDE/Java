import java.util.Scanner;

//Reverse of a number
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to  find the reverse: ");
        int a = sc.nextInt();
        int b = String.valueOf(a).length();
        int reverse=0;
        while (a!=0){
            int c=a%10;
            b--;
            int d= (int) Math.pow(10,b);
            reverse+=c*d;
            a= a/10;

        }
        System.out.println("Reverse of the number is "+reverse);

    }
}
