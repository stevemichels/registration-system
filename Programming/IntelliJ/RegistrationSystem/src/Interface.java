import javax.swing.*;

public class Interface {

    public static void LoginInterface(){
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        mainFrame.add(loginPanel);
        mainFrame.setVisible(true);
    }

}
