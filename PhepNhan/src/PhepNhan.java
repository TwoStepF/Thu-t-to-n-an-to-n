import java.util.Scanner;

public class PhepNhan {
    public static int U, V;
    public static int LamTronSo(double N){
        return (int)(N+0.5);
    }
    public static double logarit(int p, int k){
        return Math.log(p)/Math.log(k);
    }
    public static void SoNhiPhan(int N){
        int d, sum=0, j=0;
        for(int i = 0; i<16; i++){
            if(i==8){
                j=0;
                V=sum;
                sum=0;
            }
            d = N%2;
            N = N/2;
            sum += Math.pow(2, j)*d;
            j++;
        }U=sum;
    }
    public static void printarray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void SoThanhMang(int[] ar, int N, int t, int w){
        for(int i=t-1; i>=0; i--){
            ar[i]= N/(int)Math.pow(2, i*w);
            N %= Math.pow(2, i*w);
        }
    }
    public static void ThuatToanNhan(int[] A, int[] B, int[] C){
        int UV, t;
        C[0] = 0;
        U = 0;
        t = A.length;
        for(int i=0; i<t; i++){
            for(int j=0; j<t; j++){
                UV = C[i+j]+A[i]*B[j]+U;
                SoNhiPhan(UV);
                C[i+j] = V;
            }C[i+t] = 0;
        }
    }
    public static void main(String[] args){
        int p, w, a, b, t, m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so P:");
        p = sc.nextInt();
        System.out.println("Nhap so W");
        w = sc.nextInt();
        System.out.println("Nhap so a");
        a = sc.nextInt();
        System.out.println("Nhap so b");
        b = sc.nextInt();
        m = LamTronSo(logarit(p, 2));
        t = LamTronSo((double)m/w);
        int[] A = new int[t];
        int[] B = new int[t];
        int[] C = new int[t+t];
        SoThanhMang(A, a, t, w);
        SoThanhMang(B, b, t, w);
        ThuatToanNhan(A, B, C);
        printarray(C);
    }
}
