
import java.util.Scanner;

public class boyomo {
    public static int c;
    public  static int seek(String chuoiP, char s){
        int a = chuoiP.length();
        for(int i=a-1; i>=0; i--){
            if(chuoiP.charAt(i)==s)
                return i;
        }
        return -1;
    }
    public static int boyomo(String chuoiT, String chuoiP){
        c=0;
        int m = chuoiP.length(), j = m-1, i = j, H;
        char kytu1, kytu2;
        while(i<chuoiT.length()) {
            c++;
            H = seek(chuoiP, chuoiT.charAt(i));
            while(true) {
                kytu1 = chuoiP.charAt(j);
                kytu2 = chuoiT.charAt(i);
                i--;
                j--;
                if (kytu1 != kytu2 || j < 0){
                    if(j<0)
                        return i + 1;
                    break;
                }
                c++;
            }
            i += m- Math.min(j,1 + H);
            j = m-1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String chuoiT, chuoiP;
        System.out.println("Nhap chuoi T: ");
        chuoiT = sc.nextLine();
        System.out.println("Nhap chuoi P: ");
        chuoiP = sc.nextLine();
        int vitri = boyomo(chuoiT, chuoiP);
        if(vitri == 0)
            System.out.println("Chuoi p khong ton tai trong chuoi T");
        else {
            System.out.print("chuoi p co vi tri tu " + vitri + " den ");
            System.out.println(vitri + chuoiP.length() - 1);
            System.out.println("So lan lap tinh toan la: " + c);
        }
    }
}
