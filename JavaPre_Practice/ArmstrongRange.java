import java.util.Scanner;

//Armstrong number in a given range
public class ArmstrongRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Lower Range: ");
        int l = sc.nextInt();
        System.out.print("Enter the Upper Range: ");
        int u = sc.nextInt();
        for (int i = l; i<= u; i++){
            int a =i;
            int len= String.valueOf(a).length();
            int b,c=0;
            while (a!=0){
                b=a%10;
                c+=(int)Math.pow(b,len);
                a=a/10;
            }
            if (i==c)
            System.out.print(c+", ");
        }
    }
}
