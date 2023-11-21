import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

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
        content.setBackground(new Color(236, 244, 214));
        content.setMaximumSize(new Dimension(938, Integer.MAX_VALUE));
        content.setPreferredSize(new Dimension(938, 1000));
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

        JLabel jenisKelamin = new JLabel("Jenis Kelamin");
        jenisKelamin.setBounds(20, (int) scrollTxtAlamat.getLocation().getY() + 170, 300, 24);
        jenisKelamin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        JRadioButton rdPria = new JRadioButton("Pria");
        rdPria.setBounds(20, (int) jenisKelamin.getLocation().getY() + 29, 100, 30);
        rdPria.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rdPria.setBackground(new Color(236, 244, 214));
        
        JRadioButton rdPerempuan = new JRadioButton("Perempuan");
        rdPerempuan.setBounds(120, (int) jenisKelamin.getLocation().getY() + 29, 130, 30);
        rdPerempuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rdPerempuan.setBackground(new Color(236, 244, 214));

        ButtonGroup groupJenisKelamin = new ButtonGroup();
        groupJenisKelamin.add(rdPria);
        groupJenisKelamin.add(rdPerempuan);

        JLabel hobi = new JLabel("Hobi");
        hobi.setBounds(20, (int) rdPerempuan.getLocation().getY() + 50, 300, 24);
        hobi.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JCheckBox chMancing = new JCheckBox("Mancing");
        chMancing.setBounds(20, (int) hobi.getLocation().getY() + 29, 130, 30);
        chMancing.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        chMancing.setBackground(new Color(236, 244, 214));
        
        JCheckBox chGame = new JCheckBox("Ngegame");
        chGame.setBounds(150, (int) hobi.getLocation().getY() + 29, 130, 30);
        chGame.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        chGame.setBackground(new Color(236, 244, 214));
        
        JCheckBox chTouring = new JCheckBox("Touring");
        chTouring.setBounds(280, (int) hobi.getLocation().getY() + 29, 130, 30);
        chTouring.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        chTouring.setBackground(new Color(236, 244, 214));

        JScrollPane scrollContent = new JScrollPane(content);
        scrollContent.setBounds(200, 70, 938, 570);

        JLabel agama = new JLabel("Agama");
        agama.setBounds(20, (int) chTouring.getLocation().getY() + 50, 300, 30);
        agama.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        String[] pilihanAgama = {"Islam", "Kristen", "Hindu", "Buddha"};
        JComboBox<String> cmbAgama = new JComboBox<String>(pilihanAgama);
        cmbAgama.setBounds(20, (int) agama.getLocation().getY() + 29, 400, 30);
        cmbAgama.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cmbAgama.setBackground(Color.WHITE);
        cmbAgama.addItem("Katholik");

        JLabel pekerjaan = new JLabel("Pekerjaan");
        pekerjaan.setBounds(20, (int) cmbAgama.getLocation().getY() + 50, 300, 24);
        pekerjaan.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        String[] listPekerjaan = {"Programmer", "Designer", "Data Analyst", "Influencer", "Youtuber"};
        JList<String> lsPekerjaan = new JList<String>(listPekerjaan);
        lsPekerjaan.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        int[] seleksi = {1, 3};
        lsPekerjaan.setSelectedIndices(seleksi);
        
        JScrollPane scrollLsPekerjaan = new JScrollPane(lsPekerjaan);
        scrollLsPekerjaan.setBounds(20, (int) pekerjaan.getLocation().getY() + 29, 400, 100);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(20, (int) scrollLsPekerjaan.getLocation().getY() + 120, 120, 40);
        btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        btnSubmit.setBackground(new Color(45, 149, 150));
        btnSubmit.setForeground(new Color(236, 244, 214));

        // finally
        content.add(title);
        content.add(nama);
        content.add(txtNama);
        content.add(password);
        content.add(txtPassword);
        content.add(alamat);
        content.add(scrollTxtAlamat);
        content.add(jenisKelamin);
        content.add(rdPria);
        content.add(rdPerempuan);
        content.add(hobi);
        content.add(chMancing);
        content.add(chGame);
        content.add(chTouring);
        content.add(agama);
        content.add(cmbAgama);
        content.add(pekerjaan);
        content.add(scrollLsPekerjaan);
        content.add(btnSubmit);
        mainWindow.add(sidebar);
        mainWindow.add(header);
        mainWindow.add(scrollContent);
        mainWindow.setVisible(true);

        JOptionPane.showMessageDialog(mainWindow, "Anda berhasil membuka aplikasi", "Informasi berhasil", JOptionPane.INFORMATION_MESSAGE);
        
        // int konfirmasi = JOptionPane.showConfirmDialog(mainWindow, "Yakin ingin membuka aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        // System.out.println(konfirmasi);

        // String inputValue = JOptionPane.showInputDialog("Please input a value");
        // System.out.println(inputValue);

        // Object[] possibleValues = {"First", "Second", "Third"};
        // Object selectedValues = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        // System.out.println(selectedValues);
        
        /* Object[] possibleValues = {"First", "Second", "Third"};
        Object selectedValues = JOptionPane.showOptionDialog(null, "Choose one", "Input", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[2]);
        System.out.println(selectedValues); */
    }
}