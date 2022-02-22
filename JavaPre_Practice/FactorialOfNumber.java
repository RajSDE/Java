import java.util.Scanner;

//Factorial of a number
public class FactorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        System.out.print("Factorial of " +a+ " is ");
        int fact=1;
        if (a>0) {
            for (int i = a; i > 0; i--) {
                fact = fact * i;
                System.out.print(i);
                if (i!=1)
                System.out.print("x");
                else
                    System.out.print(" = ");
            }
            System.out.println(fact);
        }
        else if (a==0)
            System.out.println("1");
        else
            System.out.println("Invalid Input");
    }
}
