package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioDeSesion extends JFrame {
    private JPanel panel;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblClave;
    private JPasswordField txtContraseña;
    private JButton btnIngresar;
    private JLabel lblEspacio1;
    Color colorNegro = Color.BLACK;

    /**
     * Constructor para inicio de sesión.
     * Crea la panatalla de inicio de sesión.
     */
    public InicioDeSesion() {
        setTitle("SISTEMA DE FACTURACION BUHO");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        ImageIcon backgroundImg = new ImageIcon(".\\resourse\\login.jpg"); 
        Image img = backgroundImg.getImage();
        Image scaledImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImg = new ImageIcon(scaledImg);
        JLabel background = new JLabel(scaledBackgroundImg);
        background.setBounds(0, 0, 500, 500);
        add(background);

    
        panel = new JPanel();
        panel.setOpaque(false); 
        panel.setLayout(new GridLayout(4,2));

        lblUsuario = new JLabel("Usuario :");
        lblUsuario.setForeground(colorNegro);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(15);
        panel.add(txtUsuario);

        lblClave = new JLabel("Contraseña :");
        lblClave.setForeground(colorNegro);
        panel.add(lblClave);

        txtContraseña = new JPasswordField(15);
        panel.add(txtContraseña);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        btnIngresar = new JButton("Login");
        panel.add(btnIngresar);

        background.setLayout(new GridBagLayout());
        background.add(panel);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contraseña = new String(txtContraseña.getPassword());

                if (usuario.equals("admin") && contraseña.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son correctas");
                }
            }
        });
    }
    /**
     * Muestra la pantalla del inicio de sesión.
     */
    public static void mostrarInicio(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InicioDeSesion().setVisible(true);
            }
        });
    }
}
