import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class App {
    public static void main(String[] args) throws Exception {
        /* MainFrame myFrame = new MainFrame();
        myFrame.initialize(); */

        // frame
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(650, 650);
        // mainWindow.setSize(853, 480);
        mainWindow.setTitle("Frame Utama");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setResizable(false);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // panel
        JPanel bg = new JPanel();
        bg.setSize(1280, 696);
        bg.setBackground(Color.BLUE);
        bg.setLayout(null);

        JPanel card = new JPanel();
        // card.setSize(500, 600);
        // card.setLocation(100, 50);
        // 1280 x 720 aslinya 1280 x 696, 24px untuk title bar
        card.setBounds(400, 108, 480, 480);
        card.setBackground(Color.WHITE);
        card.setLayout(null);

        // finally
        bg.add(card);
        mainWindow.add(bg);
        mainWindow.setVisible(true);
    }
}