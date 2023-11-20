import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class App {
    public static void main(String[] args) throws Exception {
        /* MainFrame myFrame = new MainFrame();
        myFrame.initialize(); */
        // mainWindow.setSize(853, 480);
        // card.setSize(500, 600);
        // card.setLocation(100, 50);
        // 1280 x 720 aslinya 1280 x 696, 24px untuk title bar
        // mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); untuk langsung fullscreen ketika dijalankan

        // frame
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(1138, 640);
        mainWindow.setTitle("Frame Utama");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        
        // panel
        JPanel sidebar = new JPanel();
        sidebar.setSize(200, 616);
        sidebar.setBackground(new Color(38, 80, 115));
        sidebar.setLayout(null);
        
        JPanel header = new JPanel();
        header.setBounds(200, 0, 938, 70);
        header.setBackground(new Color(45, 149, 150));
        header.setLayout(null);

        JPanel content = new JPanel();
        content.setBounds(200, 70, 938, 570);
        content.setBackground(new Color(236, 244, 214));
        content.setLayout(null);

        // component
        JLabel title = new JLabel("Isi Data User");
        title.setBounds(20, 20, 300, 30);
        title.setFont(new Font("Times New Roman Bold", Font.PLAIN, 30));
        
        JLabel nama = new JLabel("Nama");
        nama.setBounds(20, 70, 300, 24);
        nama.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        JTextField txtNama = new JTextField();
        txtNama.setBounds(20, (int) nama.getLocation().getY() + 29, 500, 30);
        txtNama.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel password = new JLabel("Password");
        password.setBounds(20, (int) txtNama.getLocation().getY() + 50, 300, 24);
        password.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(20, (int) password.getLocation().getY() + 29, 500, 30);
        txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel alamat = new JLabel("Alamat");
        alamat.setBounds(20, (int) txtPassword.getLocation().getY() + 50, 300, 24);
        alamat.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JTextArea txtAlamat = new JTextArea();
        txtAlamat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);

        JScrollPane scrollTxtAlamat = new JScrollPane(txtAlamat);
        scrollTxtAlamat.setBounds(20, (int) alamat.getLocation().getY() + 29, 500, 150);

        // finally
        content.add(title);
        content.add(nama);
        content.add(txtNama);
        content.add(password);
        content.add(txtPassword);
        content.add(alamat);
        content.add(scrollTxtAlamat);
        mainWindow.add(sidebar);
        mainWindow.add(header);
        mainWindow.add(content);
        mainWindow.setVisible(true);
    }
}