import java.util.Scanner;

public class CongPP {
    public static int e;
    public static double logarit(int p, int k) {
        return (Math.log(p)/Math.log(k));
    }
    public static int LamTronSo(double N){
        return (int)(N+0.5);
    }
    public static void printtt(int[] arr){
        System.out.println(e);
        for(int i=0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    public static void ChuyenSoThanhMang(int[] arr, int a, int t, int w) {
        for (int i = t - 1; i >= 0; i--) {
            arr[i] = a/(int)Math.pow(2, i*w);
            a %= Math.pow(2, i*w);
        }
    }
    public static void CongP(int[] arr1, int[] arr2, int[] arrKQ, int w){
        e = 0;
        int temp;
        int pw = (int)Math.pow(2, w);
        for(int i = 0; i < arr1.length; i++){
            temp = arr1[i] + arr2[i] + e ;
            if(temp>pw){
                temp %= pw;
                e = 1;
            }else{
                e = 0;
            }
            arrKQ[i] = temp;
        }
    }
    public static void main(String[] args) {
        int w, p, m, t, A, B;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so w");
        w = sc.nextInt();
        System.out.println("Nhap so p");
        p = sc.nextInt();
        m = LamTronSo(logarit(p, 2));
        t = LamTronSo((double)m/w);
        int[] arr1 = new int[t];
        int[] arr2 = new int[t];
        int[] arrKQ = new int[t];
        System.out.println("Nhap So A: ");
        A = sc.nextInt();
        System.out.println("Nhap So B: ");
        B = sc.nextInt();
        ChuyenSoThanhMang(arr1, A, t, w);
        ChuyenSoThanhMang(arr2, B, t, w);
        CongP(arr1, arr2, arrKQ, w);
        printtt(arrKQ);
    }
}

