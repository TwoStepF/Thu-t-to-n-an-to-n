import java.util.Scanner;

public class eludie {
    public static int x, y, d;
    public static void ecludie(int a, int b){
        int x2 = 1, x1 = 0, y2 = 0, y1 = 1, q, r;
        if(b == 0){
            d = a;
            x = 1;
            y = 0;
        }else{
            while(b>0){
                q = a/b;
                r = a%b;
                a = b;
                b = r;
                x = x2 - q*x1;
                y = y2 = q*y1;
                x2 = x1; x1 = x;
                y2 = y1; y1 = y;
            }
            d = a;
            x = x2;
            y = y2;
        }
    }
    public static void main(String[] args){
       int a, b;
       Scanner sc = new Scanner(System.in);
       System.out.println("Nhap so a");
       a = sc.nextInt();
       System.out.println("Nhap so b");
       b = sc.nextInt();
        ecludie(a, b);
        System.out.println(d);
        System.out.println(x);
        System.out.println(y);
    }
}
