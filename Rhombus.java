import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nilai n : ");
        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = n; j >= i ; j--){
                System.out.print("* ");
            }

            for(int k = 1; k <= (2 * (i - 1) - 1); k++){
                System.out.print("  ");
            }

            if(i == 1){
                for(int m = n - 1; m >= i; m--){
                    System.out.print("* ");
                }
            }else{
                for(int l = n; l >= i; l--){
                    System.out.print("* ");
                }
            }

            System.out.println();
        }

        for(int i = 1; i < n; i++){
            for(int j = (n - i - 1); j < n; j++){
                System.out.print("* ");
            }

            for(int k = (2 * (n - 1) - 1); k >= (i * 2 + 1); k--){
                System.out.print("  ");
            }

            if(i == n - 1){
                for(int m = 1; m <= n - 1 ; m++){
                    System.out.print("* ");
                }
            }else{
                for(int l = (n - i - 1); l < n; l++){
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
        
        scan.close();
    }
}