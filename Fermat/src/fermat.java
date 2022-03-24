import java.util.Random;
import java.util.Scanner;

public class fermat {
    public static int NhiPhan(int[] arr, int k){
        int i;
        for(i=0; k>0; i++){
            arr[i] = k%2;
            k/=2;
        }return i;
    }
    public static int BinhPhuongCoLap(int a, int k, int n){
        int b = 1, s, A = a;
        int[] c = new int[100];
        if(k==0)
            return b;
        s = NhiPhan(c, k);
        if(c[0] ==  1)
            b = a;
        for(int i=1; i<s; i++){
            A = (int)Math.pow(A, 2) % n;
            if(c[i] == 1)
                b = (A*b)%n;
        }
        return b;
    }
    public static int Fermat(int n){
        int a, r;
        Random rand = new Random();
        for(int i=0; i<4; i++){
            a = rand.nextInt(n-2)+2;
            r = BinhPhuongCoLap(a, n-1, n);
            if(r!=1)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("NHap so n");
        n = sc.nextInt();
        if(Fermat(n) != 1)
            System.out.println("La so Nguyen To");
        else
            System.out.println("ko la so nguyen to");
    }
}
