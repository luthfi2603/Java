import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai n : ");
        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = n; j > i; j--){
                System.out.print("  ");
            }
            for(int k = 1; k <= (2 * i - 1); k++){
                System.out.print("x ");
            }
            System.out.println();
        }

        scan.close();
    }
}