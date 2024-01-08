package layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Layouts {

    public static void main(String[] args) {
        start();
    }
    
    static void start(){
        int width=640, height=420;
        Ventana v=new Ventana("Eventos", width/2, height, JFrame.EXIT_ON_CLOSE);
        Lámina l=new Lámina(Color.CYAN);
        Ventana v2=new Ventana("Mini", width, height, JFrame.DISPOSE_ON_CLOSE);
        Lámina l2=new Lámina(Color.RED), l3=new Lámina(Color.MAGENTA);
        v.add(l);
        v2.add(l2);
        l2.setLayout(new BorderLayout(10, 10));
        l2.add(l3, BorderLayout.CENTER);
        
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                v.secondWindow(v2);
            }
        });
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me){
                l.print("Press it, do it!!!");
            }
        });
        l.addButton(start);


        
        JButton helloThere=new JButton("Hello there");
        helloThere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                l3.darkAndBright();
            }
        });
        helloThere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me){
                l.print("Press it, do it!!!");
            }
        });
        l3.add(helloThere);
        
        String pathIcon="src/res/a.jpg";
        
        JButton orange=new JButton("Orange");
        orange.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                l3.setBackgroundColor(Color.ORANGE);
            }
        });
        orange.setAction(new ActionIDK("Pintar panel naranja", new ImageIcon(pathIcon), Color.ORANGE));
        l2.add(orange, BorderLayout.WEST);
        
        JButton green=new JButton("Green");
        green.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                l3.setBackgroundColor(Color.GREEN);
            }
        });
        green.setAction(new ActionIDK("Pintar panel verde", new ImageIcon(pathIcon), Color.GREEN));
        l2.add(green, BorderLayout.EAST);
        
        JTextField field1=new JTextField(), field2=new JTextField();
        
        field1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke){
                if(isAlphanumeric(ke)){
                    field2.setText(field1.getText()+ke.getKeyChar());
                }
            }
        });
        field1.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                l2.print("Welcome to this field");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                l2.print("Be back soon");
            }
        });
        field1.setPreferredSize(new java.awt.Dimension(100, 26));
        field1.setHorizontalAlignment(JTextField.CENTER);
        l3.add(field1);
        
        field2.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke){
                if(isAlphanumeric(ke)){
                    field2.setText(field1.getText()+ke.getKeyChar());
                }
            }
        });
        field2.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                l2.print("Welcome to this field");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                l2.print("Be back soon");
            }
        });
        field2.setPreferredSize(new java.awt.Dimension(100, 26));
        field2.setHorizontalAlignment(JTextField.CENTER);
        l3.add(field2);
        
        v.setVisible(true);
    }
    
    private static boolean isAlphanumeric(KeyEvent ke){
        int code=ke.getKeyCode();
        return code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9 || code>=KeyEvent.VK_A && code<=KeyEvent.VK_Z
            || code>=KeyEvent.VK_NUMPAD0 && code<=KeyEvent.VK_NUMPAD9;
    }
}