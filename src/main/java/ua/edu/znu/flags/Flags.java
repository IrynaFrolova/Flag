package ua.edu.znu.flags;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flags extends JFrame implements ActionListener {
    JTextField jtf;
    JLabel isCorrect;
    JLabel prompt;

    public Flags() {

        setSize(400,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon france = new ImageIcon("src/main/resources/images/france.gif");
        JButton jb = new JButton(france);
        jb.setActionCommand("Франция");
        jb.addActionListener(this);
        add(jb);

        ImageIcon germany = new ImageIcon("src/main/resources/images/germany.gif");
        jb = new JButton(germany);
        jb.setActionCommand("Германия");
        jb.addActionListener(this);
        add(jb);

        ImageIcon italy = new ImageIcon("src/main/resources/images/sweden.gif");
        jb = new JButton(italy);
        jb.setActionCommand("Швеция");
        jb.addActionListener(this);
        add(jb);

        ImageIcon japan = new ImageIcon("src/main/resources/images/belgium.gif");
        jb = new JButton(japan);
        jb.setActionCommand("Бельгия");
        jb.addActionListener(this);
        add(jb);

        jtf = new JTextField(15);
        add(jtf);

        prompt = new JLabel("<html>Введите название страны в текстовое поле и выполните <BR>щелчок на ее флаге</html>");
        add(prompt);

        isCorrect = new JLabel();
        add(isCorrect);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equalsIgnoreCase(jtf.getText())) {
            isCorrect.setText("Правильно");
        } else {
            isCorrect.setText("Неправильно");
        }
    }

    public static void main(String[] args) {
        new Flags();
    }
}
