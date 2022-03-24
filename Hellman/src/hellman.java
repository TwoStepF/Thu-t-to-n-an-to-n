import java.util.Scanner;

public class hellman {
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
        }if(x1%p<0)
            return x1%p+p;
        return x1%p;
    }
    public static int MaHoa(int[] dst, int[] pi, int n, int M, int W, int[] m) {
        int c = 0;
        for (int i = 0; i < n; i++){
            c += ((W * dst[pi[i]-1]) % M) * m[i];
        }
        return c;
    }
    public static void DichMa(int[] dst, int[] pi, int n, int M, int W, int c){
        int sum;
        sum = (nghichDao(W, M)*c)%M;
        int[] v = new int[100];
        for(int i=0; i<n; i++){
            if(sum>=dst[i]) {
                sum -= dst[i];
                v[i] = 1;
            } else
                v[i] = 0;
        }
        System.out.println();
        for(int i=0; i<n; i++)
            System.out.print(v[pi[i]-1]);
    }
    public static void Menu(){
        System.out.println("1.Ma hoa");
        System.out.println("2.Dich ma");
    }
    public static void inputArray(int[] n, int L){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<L; i++)
            n[i] = sc.nextInt();
    }
    public static void main(String[] args) {
        int ch;
        Menu();
        Scanner sc = new Scanner(System.in);
        ch = sc.nextInt();
        int n, M, W;
        int[] dst = new int[100];
        int[] pi = new int[100];
        int[] m = new int[100];
        switch(ch){
            case 1:
                System.out.println("Nhap do dai n: ");
                n = sc.nextInt();
                System.out.println("Nhap day sieu tang:");
                inputArray(dst, n);
                System.out.println("Nhap day pi: ");
                inputArray(pi, n);
                System.out.println("Nhap ban ro m: ");
                inputArray(m, n);
                System.out.println("Nhap M: ");
                M = sc.nextInt();
                System.out.println("Nhap W: ");
                W = sc.nextInt();
                System.out.println(MaHoa(dst, pi, n, M, W, m));
                break;
            case 2:
                int c;
                System.out.println("Nhap do dai n: ");
                n = sc.nextInt();
                System.out.println("Nhap day sieu tang:");
                inputArray(dst, n);
                System.out.println("Nhap day pi: ");
                inputArray(pi, n);
                System.out.println("Nhap ban Ma hoa ");
                c = sc.nextInt();
                System.out.println("Nhap M: ");
                M = sc.nextInt();
                System.out.println("Nhap W: ");
                W = sc.nextInt();
                DichMa(dst, pi, n, M, W, c);
                break;
        }
    }
}
