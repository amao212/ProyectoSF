package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BuLabel extends JLabel{
    private String label = "";
    private Color color  = Color.blue;
    private int alignment= SwingConstants.LEFT;
    private Font font    = new Font("MesloLGL Nerd Font", Font.BOLD | Font.LAYOUT_LEFT_TO_RIGHT | Font.PLAIN, 12);
    public BuLabel(){
        CustomizerControl();
    }
    public BuLabel(String label){
        this.label = label;
        CustomizerControl();
    }
    public BuLabel(String label, Color color){
        this.label = label;
        this.color = color;
        CustomizerControl();
    }

    public BuLabel(String label, Color color, Font font){
        this.label = label;
        this.color = color;
        this.font  = font;
        CustomizerControl();
    }
    /**
     * @param <br>alignment</br>  SwingConstants: LEFT, CENTER, RIGHT, LEADING or TRAILING 
     */
    public BuLabel(String label, int alignment){
        this.label = label;
        this.alignment = alignment;
        CustomizerControl();
    }
    private void CustomizerControl(){
        setFont(font);
        setText(label);
        setForeground(color);
        setHorizontalAlignment(alignment);
        setOpaque(false);
        setBackground(null);
        //setIcon(new ImageIcon(iconPath));
    }
}
