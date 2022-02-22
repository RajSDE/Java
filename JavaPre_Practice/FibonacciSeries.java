import java.util.Scanner;

//Fibonacci Series up to nth term
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value of n: ");
        int a = sc.nextInt();
        int b=0,c=1,z=0;
        System.out.print(b+", "+c+", ");
        if(a>0) {
            while (z <= a) {
                z = b + c;
                b = c;
                c = z;
                if (z<=a) {
                    System.out.print(z + ", ");
                }
            }
        }else
            System.out.print("Input Error");
    }
}
