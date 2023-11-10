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
            pilihan = input.nextLine();

            switch(pilihan){
                case "1":
                    cView.getAll();
                    break;
                case "2":
                    cView.detailBarang();
                    break;
                case "3":
                    cView.cariData();
                    break;
                case "4":
                    cView.tambahData();
                    break;
                case "5":
                    cView.updateData();
                    break;
                case "0":
                    System.out.println("\nExit");
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