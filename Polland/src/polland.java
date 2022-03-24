import java.util.Scanner;

public class polland {
    public static int gcd(long a, long b){
        long r;
        while(b>0){
            r = a%b;
            a = b;
            b = r;
        }
        return (int)a;
    }
    public static int poland(int n){
        long a = 2, b = 2;
        int d = 0;
        while(d!=n) {
            a = ((long) Math.pow(a, 2) + 1) % n;
            b = ((long) Math.pow(b, 2) + 1) % n;
            b = ((long) Math.pow(b, 2) + 1) % n;
            d = gcd(Math.abs(a-b), n);
            System.out.print(a + " ");
            System.out.println(b);
            if(1 < d && d < n)
                return d;
        }return d;
    }
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so n");
        n = sc.nextInt();
        int d = poland(n);
        if(d == n){
            System.out.println("that bai");
        }else{
            System.out.println("d = " + d);
        }
    }
}
