import java.util.Scanner;

public class CongFn {
    public static int Q = 0;
    public static int c[] = new int[100];
    public static int KQ[] = new int[100];
    public static int LamTronSo(double N){
        return (int)(N + 0.5);
    }
    public static double logarit(long p) {
        return Math.log(p)/Math.log(2);
    }
    public static void printtt(int[] arr, int t){
        System.out.print("[");
        for (int i=0 ; i < t ; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("]");
    }
    public static int SoSanh(int[] A, int[] B){
        for(int i=0; i<A.length; i++){
            if(A[i]>B[i])
                return 1;
        }
        return 0;
    }
    public static int[] BienSoThanhMang( long t, long W, long p){
        int a = (int)t;
        int b = (int)W;
        int j=a-1;
        int[] arr = new int[a];
        for(int i=a-1; i>=0; i--){
            arr[j] = (int)(p/(long)Math.pow(2, i*W));
            p = p%(long)Math.pow(2, i*W);
            j--;
        }
        return arr;
    }
    public static void CongChinhXacBoi(int[] A, int[] B, int e, int t){
        int d;
        for(int i=0; i<t; i++){
            d = A[i]+B[i]+Q%e;
            if(d>e){
                d = d%e;
                Q = 1;
            }else{
                Q = 0;
            }
            c[i] = d;
        }
    }
    public static void CongTrenFn(int[] P, int t, int e){
        int d;
        System.out.println("Mang C");
        printtt(c, 4);
        if(Q == 1) {
            Q = 0;
            for (int i = 0; i < t; i++) {
                d = c[i] - P[i] - Q;
                if (d < 0) {
                    d += e;
                    Q = 1;
                } else {
                    d = d % (int) e;
                    Q = 0;
                }
                KQ[i] = d;
            }
        }else {
            int bool = SoSanh(c, P);
            if(bool == 1){
                Q = 0;
                for (int i = 0; i < t; i++) {
                    d = c[i] - P[i] - Q;
                    if (d < 0) {
                        d += e;
                        Q = 1;
                    } else {
                        d = d % (int) e;
                        Q = 0;
                    }
                    KQ[i] = d;
                }
            }
            else
                KQ = c;
        }
    }
    public static void main(String[] args){
        int w, t, m;
        long p, a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap W: ");
        w = sc.nextInt();
        System.out.println("Nhap So p: ");
        p = sc.nextLong();
        m = LamTronSo(logarit(p));
        t = LamTronSo((double)m/w);
        int A[] = new int[t];
        int B[] = new int[t];
        int P[] = new int[t];
        int e = (int)Math.pow(2, w);
        System.out.println("Nhap So a: ");
        a = sc.nextLong();
        System.out.println("Nhap So b: ");
        b = sc.nextLong();
        System.out.println("Mang A: ");
        A = BienSoThanhMang(t, w, a);
        printtt(A, t);
        System.out.println("Mang B: ");
        B = BienSoThanhMang(t, w, b);
        printtt(B, t);
        System.out.println("Mang P: ");
        P = BienSoThanhMang(t, w, p);
        printtt(P, t);
        CongChinhXacBoi(A, B, e, t);
        CongTrenFn(P, t, e);
        System.out.println(Q);
        printtt(KQ, t);
    }
}
