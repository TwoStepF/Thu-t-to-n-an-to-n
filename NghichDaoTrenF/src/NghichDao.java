

import java.util.Scanner;

public class NghichDao {
    public static int nghichDao(int a, int p){
        int u, v, Q, r, x1, x2, x;
        u = a;
        v = p;
        x1 = 1;
        x2 = 0;
        while(u != 1){
            Q = v/u;
            r = v%u;
            v = u;
            u = r;
            x = x2 - Q*x1;
            x2 = x1;
            x1 = x;
        }return x1%p;
    }

    public static void main(String[] args) {
        int a, p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so A");
        a = sc.nextInt();
        System.out.println("Nhap so p");
        p = sc.nextInt();
        System.out.println(nghichDao(a, p));
    }
}
