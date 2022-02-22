import java.util.Scanner;

//Leap year or not
public class leapOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int a = sc.nextInt();
        if (a%4==0 && a%100!=0 || a%400==0){
            System.out.println("It is a Leap year");
        }
        else{
            System.out.println("Oops! It is not a Leap year");
        }
    }
}
