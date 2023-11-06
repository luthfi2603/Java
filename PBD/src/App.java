import java.util.Scanner;
import com.view.cView;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String pilihan;

        while(true){
            System.out.print("\n========== MENU ==========\n"
            + "1. Lihat Semua Data Barang\n"
            + "2. Detail Data Barang\n"
            + "3. Cari Data Barang\n"
            + "4. Tambah Data Barang\n"
            + "5. Update Data Barang\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5/0] : ");
            pilihan = input.next();

            switch(pilihan){
                case "1":
                    cView.getAll();
                    break;
                case "2":
                    System.out.println("Detail Data Barang");
                    break;
                case "3":
                    System.out.println("Cari Data Barang");
                    break;
                case "4":
                    System.out.println("Tambah Data Barang");
                    break;
                case "5":
                    System.out.println("Update Data Barang");
                    break;
                case "0":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Pilihan anda salah!");
                    break;
            }

            if(pilihan.equalsIgnoreCase("0")){
                break;
            }
        }

        input.close();
    }
}