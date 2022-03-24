import java.util.Scanner;

public class BinhPhuongLap {
    public static int NhiPhan(int[] arr, int k){
        int i;
        for(i=0; k>0; i++){
            arr[i] = k%2;
            k/=2;
        }
        return i;
    }
    public static int BinhPhuongCoLap(int a, int k, int n){
        int b = 1, A = a, s;
        int[] c = new int[100];
        if(k == 0)
            return b;
        s = NhiPhan(c, k);
        if(c[0] == 1)
            b = a;
        for(int i=1; i<s; i++){
            A = ((int)Math.pow(A, 2))%n;
            if(c[i] == 1)
                b = (b*A)%n;
        }
        return b;
    }
    public static void main(String[] args){
        int a, k, n;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so a, bam -1 de thoat");
            a = sc.nextInt();
            if(a == -1)
                break;
            System.out.println("Nhap so k");
            k = sc.nextInt();
            System.out.println("Nhap so n");
            n = sc.nextInt();
            System.out.println(BinhPhuongCoLap(a, k, n));
        }
    }
}
