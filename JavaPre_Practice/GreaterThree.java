import java.sql.SQLOutput;
import java.util.Scanner;

//Greatest of the Three numbers
public class GreaterThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        if (a>b & a>c){
            System.out.print("First number is greatest");
        }
        else if (a < c){
            System.out.print("Third number is greater");
        }
        else if (a < b){
            System.out.println("Second number is greater");
        }
        else{
            System.out.println("All are equal");
        }
    }
}
