import javax.swing.SwingUtilities;

import UI.LoginApp;
import UI.Splash;

public class App {
    public static void main(String[] args) throws Exception {
       
        var splash = new Splash();
        splash.showSplash(5000);

        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginApp().setVisible(true);
            }
        });
    }
}
