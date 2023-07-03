package UI;

import javax.swing.*;
import java.awt.*;


public class Splash extends JWindow {
    private JWindow jw;
    private final String strPath = "resourse\\splash3.gif";

    public Splash() {
        jw = new JWindow();
        var image = new ImageIcon(strPath);
        jw.getContentPane().add(new JLabel("", image, SwingConstants.CENTER));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jw.setBounds(  (int) ((screenSize.getWidth() - image.getIconWidth()) / 2),
        (int) ((screenSize.getHeight() - image.getIconHeight()) / 2),
        image.getIconWidth(),       image.getIconHeight());


    }

    public void showSplash(int elapsedTime) {
        jw.setVisible(true);
        try {
            Thread.sleep(elapsedTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jw.setVisible(false);
        jw.dispose();
    }



}
