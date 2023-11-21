import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
// import javax.swing.JTextField;
// import javax.swing.JPasswordField;
// import javax.swing.JTextArea;
import javax.swing.JScrollPane;
// import javax.swing.JRadioButton;
// import javax.swing.ButtonGroup;
// import javax.swing.JCheckBox;
// import javax.swing.JComboBox;
// import javax.swing.JList;
// import javax.swing.JButton;
// import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

public class Table {
    public static void main(String[] args) throws Exception {
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
        content.setBounds(200, 70, 938, 570);
        content.setLayout(null);

        // component
        JLabel title = new JLabel("Data User");
        title.setBounds(20, 20, 300, 30);
        title.setFont(new Font("Times New Roman Bold", Font.PLAIN, 30));

        String[] dataUserHeader = {"Nama", "Username", "Umur"};
        String[][] dataUser = {
            {"Muhammad Luthfi", "ZeeroXc", "19"},
            {"Rifqi Jabrah Rhae", "fortyche", "19"}
        };

        DefaultTableModel dmUser = new DefaultTableModel(dataUser, dataUserHeader);

        JTable tblUser = new JTable(dmUser){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tblUser.getTableHeader().setFont(new Font("Times New Roman Medium", Font.PLAIN, 20));
        tblUser.getTableHeader().setBackground(new Color(45, 149, 150));
        tblUser.getTableHeader().setForeground(Color.WHITE);
        tblUser.setRowHeight(25);
        tblUser.getTableHeader().setReorderingAllowed(false);
        tblUser.setShowVerticalLines(false);

        dmUser.addRow(new Object[]{"Ibra Rizqy Siregar", "hyohoyh", "19"});

        JScrollPane scrollTblUser = new JScrollPane(tblUser);
        scrollTblUser.setBounds(20, (int) title.getLocation().getY() + 45, 600, 300);
        scrollTblUser.getViewport().setBackground(new Color(236, 244, 214));
        
        // finally
        content.add(title);
        content.add(scrollTblUser);
        mainWindow.add(sidebar);
        mainWindow.add(header);
        mainWindow.add(content);
        mainWindow.setVisible(true);
    }
}