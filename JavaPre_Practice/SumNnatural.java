import java.util.Scanner;

public class SumNnatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int a = sc.nextInt();
        int i = 0;
        int y=0;
        do {
            y+=i;
            i++;
        }
        while (i<a+1);
        System.out.println("Sum of First " +a+ " natural number is "+y);
    }
}
