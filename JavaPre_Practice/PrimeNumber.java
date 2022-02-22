import java.util.Scanner;

public class PrimeNumber {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        int count = 0;
        for (int i = 1; i<=a; i++){
            if (a%i==0){
                count+=1;
            }
        }
        if (count==2) {
            System.out.println("It is a Prime number");
        }
        else{
            System.out.println("It is not a prime number");
        }
    }

}
