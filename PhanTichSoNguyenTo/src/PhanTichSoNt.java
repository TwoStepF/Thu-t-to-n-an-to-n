import java.util.Scanner;

public class PhanTichSoNt {
    public static void PhanTich(int[] arr, int n){
        int i=2;
        while(n>1){
            if(n%i!=0)
                i++;
            else{
                arr[i]+=1;
                n/=i;
            }
        }
    }
    public static void printff(int[] arr){
        System.out.print("CoSO=[");
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 1){
                System.out.print(i+" ");
            }
        }
        System.out.println("]");
        System.out.print("SoMu=[");
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 1){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so n");
        n = sc.nextInt();
        int[] arr = new int[n+1];
        PhanTich(arr, n);
        printff(arr);
    }
}

