import java.util.Scanner;

//Armstrong number
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check Armstrong: ");
        int a = sc.nextInt();
        int number=a;
        int len = String.valueOf(a).length();
        int b,c=0;
        while (a!=0){
            b=a%10;
            c+=(int) Math.pow(b,len);
            a=a/10;
        }
        if (number==c){
            System.out.println("It is an Armstrong number");
        }
        else
            System.out.println("It is not an Armstrong number");
    }
}
