import java.util.Scanner;

//Prime number within a given range
public class primeNumberRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lower range: ");
        int a = sc.nextInt();
        System.out.print("Enter upper range: ");
        int b = sc.nextInt();
        for (int i = a; i <=b; i++){
            int count = 0;
            for (int j=1; j<=i;j++ ){
                if (i%j==0){
                    count+=1;
                }
            }
            if (count==2)
            System.out.print( i+ ", " );
        }
    }
}
