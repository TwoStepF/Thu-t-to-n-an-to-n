import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

public class elgamal {
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
    public static void MaHoa(int x, int alpha, int a, int p, int k){
        int KCK, y1, y2;
        KCK = BinhPhuongCoLap(alpha, a, p);
        System.out.printf("Khoa cong khai la: %d, %d, %d\n", p, alpha, KCK);
        y1 = BinhPhuongCoLap(alpha, k, p);
        y2 = (x*BinhPhuongCoLap(KCK, k, p))%p;
        System.out.printf("Ban ma hoa y = (y1 = %d, y2 = %d)", y1, y2);
    }
    public static void DichMa(int y1, int y2, int a, int p){
       System.out.printf("Dich Ma: %d", y2*BinhPhuongCoLap(y1, p-1-a, p)%p);
    }
    public static void Menu(){
        System.out.println("1.Ma hoa");
        System.out.println("2.Dich ma");
    }
    public static void main(String[] args) {
        int ch;
        Menu();
        Scanner sc = new Scanner(System.in);
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                int alpha, a, p, k, x;
                System.out.println("Nhap ban ro");
                x = sc.nextInt();
                System.out.println("Nhap phan tu sinh alpha");
                alpha = sc.nextInt();
                System.out.println("Nhap khoa bi mat a");
                a = sc.nextInt();
                System.out.println("Nhap p(Z*p)");
                p = sc.nextInt();
                System.out.println("Nhap k");
                k = sc.nextInt();
                MaHoa(x, alpha, a, p, k);
                break;
            case 2:
                int y1, y2;
                System.out.println("Nhap y1");
                y1 = sc.nextInt();
                System.out.println("Nhap y2");
                y2 = sc.nextInt();
                System.out.println("Nhap a");
                a = sc.nextInt();
                System.out.println("Nhap p");
                p = sc.nextInt();
                DichMa(y1, y2, a, p);
                break;
            case 4:
                System.out.println("Ko co chuc nang nay");
                break;
        }
    }
}
