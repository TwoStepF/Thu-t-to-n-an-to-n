import java.util.Scanner;

public class CongTrenFp {
    public static int e;
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
    public static void BienSoThanhMang(int[] arr, int N, int t, int w){
        for(int i=t-1; i>=0; i--){
            arr[i] = N/(int)Math.pow(2, i*w);
            N %= Math.pow(2, i*w);
        }
    }
    public static void CongChinhXacBoi(int[] A, int[] B, int[] C, int w){
        int temp;
        e = 0;
        int pw = (int)Math.pow(2, w);
        for(int i=0; i<A.length; i++){
            temp = A[i]+B[i]+e%pw;
            if(temp >= pw){
                temp %= pw;
                e = 1;
            }else
                e = 0;
            C[i] = temp;
        }
    }
    public static void TruChinhXacBoi(int[] A, int[] B, int[] C, int w){
        int temp;
        e = 0;
        int pw = (int)Math.pow(2, w);
        for(int i=0; i<A.length; i++){
            temp = A[i] - B[i] - e;
            if(temp<0){
                temp += pw;
                e = 1;
            }else {
                temp = temp % (int) pw;
                e = 0;
            }
            C[i] = temp;
        }
    }
    public static void CongTrenFn(int[] A,int[] B, int[] P, int[] C, int[] KQ, int w){
        CongChinhXacBoi(A, B, C, w);
        if(e == 1)
            TruChinhXacBoi(C, P, KQ, w);
        else {
            int bool = SoSanh(C, P);
            if(bool == 0)
                KQ = C;
            else
                TruChinhXacBoi(C, P, KQ, w);
        }
    }
    public static void main(String[] args){
        int w, t, m;
        int p, a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap W: ");
        w = sc.nextInt();
        System.out.println("Nhap So p: ");
        p = sc.nextInt();
        m = LamTronSo(logarit(p));
        t = LamTronSo((double)m/w);
        int A[] = new int[t];
        int B[] = new int[t];
        int P[] = new int[t];
        int C[] = new int[t];
        int KQ[] = new int[t];
        System.out.println("Nhap So a: ");
        a = sc.nextInt();
        System.out.println("Nhap So b: ");
        b = sc.nextInt();
        BienSoThanhMang(A, a, t, w);
        BienSoThanhMang(B, b, t, w);
        BienSoThanhMang(P, p, t, w);
        CongTrenFn(A, B, P, C, KQ, w);
        printtt(KQ, t);
    }
}
