import java.util.Scanner;

//Palindrome number
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Palindrome number: ");
        String a = sc.next();
        int len = a.length();
        int c=0;
        for (int i= 0; i<=len/2; i++){
            if (a.charAt(i) == a.charAt(len-1-i)){
                c+=1;
            }
            else
                break;
        }
        if (c == len/2+1) {
            System.out.println("Yes! It is a Palindrome number");
        } else {
            System.out.println("No, It is not a Palindrome");
        }
    }
}
