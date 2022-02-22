import java.util.Scanner;

//Sum of numbers in a given range:
public class SumInGivenRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower range: ");
        int a = sc.nextInt();
        System.out.print("Enter the upper range: ");
        int b = sc.nextInt();
        int sum=0;
        for (int i=a; i<b+1; i++)
        {
            sum+=i;
        }
        System.out.println("Sum of numbers between " +a+ " and " +b+ " is " +sum);
    }
}
